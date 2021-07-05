import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
public class Algorithm
{
    private final ArrayList<String> ListPreExpression= new ArrayList<>(); //存放原始表达式
    private final ArrayList<String> ListExpression= new ArrayList<>();   //存放后缀表达式
    private final Stack<String> StackOperation=new Stack<>();   //运算数栈
    private final Stack<String> StackOperator=new Stack<>();  //运算符栈
    //分割表达式，构造方法
    public Algorithm(String PreExpression)
    {
        //以+-*/%^（）为分割符，对原始表达式进行分割，并返回分割符
        StringTokenizer stringTokenizer=new StringTokenizer(PreExpression, "^%+-*/()",true);
        //正则表达式："\\^|\\%|\\+|\\-|\\*|\\/|(|\\)"
        while(stringTokenizer.hasMoreTokens())
        {
            ListPreExpression.add(stringTokenizer.nextToken());
        }
        for (int i=0;i<ListPreExpression.size();i++){
            if(ListPreExpression.get(0).equals("-"))
                ListPreExpression.add(0,"0");          //处理表达式初始负号
            if(ListPreExpression.get(i).equals("Π")){               //替换Π
                String tmp=Double.toString(Math.PI);
                ListPreExpression.set(i,tmp);
            }
            if (ListPreExpression.get(i).equals("-")&&ListPreExpression.get(i-1).equals("("))
                ListPreExpression.add(i,"0");               //处理负数
        }
    }


    //判断是否为运算符
    public boolean isOperator(String str)
    {
        return "+-*/%^tancossinlgln()".contains(str);
    }

    //获取运算符的优先级
    public int getPriority(String str)
    {
        int a;
        switch(str)
        {
            case "+":
            case "-":a=1;break;
            case "*":
            case "/":
            case "%":a=2;break;
            case "(":a=5;break;
            case ")":a=0;break;
            case "tan":
            case "sin":
            case "cos":
            case "ln":
            case "lg":a=4;break;
            case "^":a=3;break;
            default: a=-1;break;
        }
        return a;
    }

    //比较优先级大小
    public boolean ComparePriority(String str1,String str2)
    {
        return getPriority(str1)>getPriority(str2);
    }

    //定义运算符入栈规则
    public void OperatorToStack(String str)
    {
        if(StackOperator.isEmpty())           //若栈为空，直接压栈
            StackOperator.push(str);
        else if("(".equals(str))              //若运算符为"("，压栈
            StackOperator.push(str);
        else if(")".equals(str))              //若运算符为")"，将"("和")"之间的操作符存放到ListExpression中
        {
            String tmp;
            while(!"(".equals(tmp=StackOperator.pop()))
                ListExpression.add(tmp);
        }
        else if("(".equals(StackOperator.peek()))  //若栈顶元素为"("，压栈
            StackOperator.push(str);
        else if(ComparePriority(str,StackOperator.peek()))//若str优先级大于栈顶元素则压栈
            StackOperator.push(str);
        else if(!ComparePriority(str,StackOperator.peek()))//若小于则将栈顶元素弹出，递归比较下一个元素
        {
            ListExpression.add(StackOperator.pop());
            OperatorToStack(str);
        }
    }


    //中缀表达式转换成后缀表达式
    public void ListPreExpressionToListExpression()
    {
        for(String str:ListPreExpression)         //遍历ListPreExpression，运算符加入OperatorToStack,数字加入ListExpression
        {
            if(isOperator(str))
                OperatorToStack(str);
            else
                ListExpression.add(str);
        }

        //遍历完原始表达式后，将StackOperator栈内的运算符全部添加到ListExpression中
        while(!StackOperator.isEmpty())
        {
            ListExpression.add(StackOperator.pop());
        }
    }


    //定义计算方法

    //双目运算
    public int flag =0;//判断输入格式是否正确
    public double Operation2(String str1,String str2,String str3)
    {
        double num1,num2;
        num2= Double.parseDouble(str1);
        num1= Double.parseDouble(str2);
        switch (str3) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "%":
                return num1 % num2;
            case "^":
                return Math.pow(num1, num2);
            default:
                if (num2 == 0)           //除数为零时，flag=1
                    flag = 1;
                return num1 / num2;
        }
    }

    //单目运算
    public double Operation1(String str1,String str2)
    {
        double num1;
        num1= Double.parseDouble(str1);
        switch (str2) {
            case "tan":
                if (num1 == Math.PI / 2)           //tan（π/2）不存在，flag=2
                    flag = 2;
                return Math.tan(num1);
            case "sin":
                return Math.sin(num1);
            case "cos":
                return Math.cos(num1);
            case "lg":
                return Math.log10(num1);
            default:
                return Math.log(num1);
        }
    }

    //计算后缀表达式
    public String Calculate_ListExpression()
    {
        for(String str:ListExpression)
        {
            if(str.equals("(")||str.equals(")"))      //若ListExpression中含有括号，则报错
                flag =3;
            else if(!isOperator(str))          //把数字存放进运算栈中
                StackOperation.push(str);
            else if("tansincoslgln".contains(str))    //tan、sin、cos、lg、ln进行单目运算
                StackOperation.push(String.valueOf(Operation1(StackOperation.pop(),str)));
            else
                //其它运算符进行双目运算
                StackOperation.push(String.valueOf(Operation2(StackOperation.pop(),StackOperation.pop(),str)));
        }
        if(flag ==1|| flag ==3)
        {
            flag =0;
            return "ILLEGAL!";
        }
        else if(flag ==2)
        {
            flag =0;
            return "NON-EXISTENT!";
        }
        else
            return StackOperation.pop();
    }

//命令行输入测试
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            Algorithm algorithm=new Algorithm(scanner.nextLine());
            algorithm.ListPreExpressionToListExpression();
            if(algorithm.Calculate_ListExpression().equals("ILLEGAL!"))
                System.out.println("ILLEGAL!");
            else if(algorithm.Calculate_ListExpression().equals("NON-EXISTENT!"))
                System.out.println("NON-EXISTENT!");
            else
            {
                double result= Double.parseDouble(algorithm.Calculate_ListExpression());
                //数据类型转换
                long value =(long)result;
                double d_value =result- value;
                //去掉无意义的0
                if(d_value ==0)
                    System.out.println(value);
                else
                    System.out.println(result);
            }

        }
    }
}