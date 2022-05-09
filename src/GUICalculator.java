import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

public class GUICalculator extends JFrame {
    JFrame frame = new JFrame("科学计算器");
    JTextField display = new JTextField("0");
    Font font_display = new Font("Consolas", Font.BOLD, 42);       //设置字体样式
    Font font_button = new Font("Consolas", Font.BOLD, 21);
    Image iconImage = (new ImageIcon("img/图标.jpeg")).getImage();//设置图标
    actionlistener al = new actionlistener();//创建监听器action listener的对象

    //设置计算器按键
    JButton button_clear = new JButton("C");
    JButton button_delete = new JButton("←");
    JButton button_plus = new JButton("+");
    JButton button_minus = new JButton("-");
    JButton button_multiply = new JButton("*");
    JButton button_divide = new JButton("/");
    JButton button_spot = new JButton(".");
    JButton button_equal = new JButton("=");
    JButton button_sin = new JButton("sin");
    JButton button_cos = new JButton("cos");
    JButton button_tan = new JButton("tan");
    JButton button_ln = new JButton("ln");
    JButton button_bracket_r = new JButton("(");
    JButton button_bracket_l = new JButton(")");
    JButton button_mod = new JButton("%");
    JButton button_lg = new JButton("lg");
    JButton button_pow = new JButton("^");
    JButton button_pi = new JButton("Π");
    JButton[] button = new JButton[10];

    public GUICalculator() {
        super();

        //设置按钮颜色字体和监听器
        for (int i = 0; i < 10; i++) {
            button[i] = new JButton("" + i);
            button[i].setBackground(Color.white);
            button[i].setFont(font_button);
            button[i].addActionListener(al);
            button[i].setOpaque(false);
        }
        //设置按钮颜色
        button_plus.setBackground(Color.white);
        button_equal.setBackground(Color.cyan);
        button_minus.setBackground(Color.white);
        button_multiply.setBackground(Color.white);
        button_divide.setBackground(Color.white);
        button_spot.setBackground(Color.white);
        button_clear.setBackground(Color.white);
        button_delete.setBackground(Color.white);
        button_sin.setBackground(Color.white);
        button_cos.setBackground(Color.white);
        button_tan.setBackground(Color.white);
        button_ln.setBackground(Color.white);
        button_bracket_r.setBackground(Color.white);
        button_bracket_l.setBackground(Color.white);
        button_mod.setBackground(Color.white);
        button_lg.setBackground(Color.white);
        button_pi.setBackground(Color.white);
        button_pow.setBackground(Color.white);

        //设置按键透明度
        button_sin.setOpaque(false);
        button_cos.setOpaque(false);
        button_lg.setOpaque(false);
        button_tan.setOpaque(false);
        button_plus.setOpaque(false);
        button_minus.setOpaque(false);
        button_multiply.setOpaque(false);
        button_divide.setOpaque(false);
        button_clear.setOpaque(false);
        button_delete.setOpaque(false);
        button_bracket_l.setOpaque(false);
        button_bracket_r.setOpaque(false);
        button_ln.setOpaque(false);
        button_pow.setOpaque(false);
        button_mod.setOpaque(false);
        button_pi.setOpaque(false);
        button_spot.setOpaque(false);
        button_equal.setOpaque(false);
        //设置按钮字体
        button_plus.setFont(font_button);
        button_equal.setFont(font_button);
        button_minus.setFont(font_button);
        button_multiply.setFont(font_button);
        button_divide.setFont(font_button);
        button_spot.setFont(font_button);
        button_clear.setFont(font_button);
        button_delete.setFont(font_button);
        button_sin.setFont(font_button);
        button_cos.setFont(font_button);
        button_tan.setFont(font_button);
        button_ln.setFont(font_button);
        button_bracket_r.setFont(font_button);
        button_bracket_l.setFont(font_button);
        button_mod.setFont(font_button);
        button_lg.setFont(font_button);
        button_pi.setFont(font_button);
        button_pow.setFont(font_button);

        //计算器界面布局
        frame.setIconImage(iconImage);
        display.setHorizontalAlignment(JTextField.RIGHT);//文本框从右到左显示
        display.setFont(font_display);
        display.setBackground(Color.white);
        display.setEditable(false);          //设置文本框可编辑

        JPanel pan1 = new JPanel();                       //设置文本框布局
        pan1.setLayout(new GridLayout(1, 1, 5, 5));
        pan1.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        pan1.add(display);
        NewPanel panBody = new NewPanel();                    //将按键加入panBody中

        frame.getContentPane().add(panBody);//将含画板的面板加入

        panBody.setLayout(new GridLayout(7, 4));
        panBody.add(button_clear);
        panBody.add(button_delete);
        panBody.add(button_bracket_r);
        panBody.add(button_bracket_l);//第一行 C ← ( )
        panBody.add(button_sin);
        panBody.add(button_cos);
        panBody.add(button_tan);
        panBody.add(button_lg);//第二行 sin cos tan lg
        panBody.add(button_ln);
        panBody.add(button_pow);
        panBody.add(button_mod);
        panBody.add(button_plus);//第三行 ln ^ % +
        panBody.add(button[7]);
        panBody.add(button[8]);
        panBody.add(button[9]);
        panBody.add(button_minus);//第四行 7 8 9 -
        panBody.add(button[4]);
        panBody.add(button[5]);
        panBody.add(button[6]);
        panBody.add(button_multiply);//第五行 4 5 6 *
        panBody.add(button[1]);
        panBody.add(button[2]);
        panBody.add(button[3]);
        panBody.add(button_divide);//第六行 1 2 3 /
        panBody.add(button_pi);
        panBody.add(button[0]);
        panBody.add(button_spot);
        panBody.add(button_equal);//第七行 Π 0 . =
        panBody.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));


        //创建框架窗口
        frame.setLayout(new BorderLayout());       //布局
        frame.add(pan1, BorderLayout.NORTH);
        frame.add(panBody, BorderLayout.CENTER);
        frame.setSize(540, 440);                   //大小
        frame.setLocation(460, 150);               //位置
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //注册监听器
        button_plus.addActionListener(al);
        button_minus.addActionListener(al);
        button_multiply.addActionListener(al);
        button_divide.addActionListener(al);
        button_equal.addActionListener(al);
        button_spot.addActionListener(al);
        button_clear.addActionListener(al);
        button_delete.addActionListener(al);
        button_sin.addActionListener(al);
        button_cos.addActionListener(al);
        button_tan.addActionListener(al);
        button_ln.addActionListener(al);
        button_bracket_r.addActionListener(al);
        button_bracket_l.addActionListener(al);
        button_mod.addActionListener(al);
        button_lg.addActionListener(al);
        button_pi.addActionListener(al);
        button_pow.addActionListener(al);

        //设置快捷键
        /*button[0].setMnemonic(KeyEvent.VK_0);
        button[1].setMnemonic(KeyEvent.VK_1);
        button[2].setMnemonic(KeyEvent.VK_2);
        button[3].setMnemonic(KeyEvent.VK_3);
        button[4].setMnemonic(KeyEvent.VK_4);
        button[5].setMnemonic(KeyEvent.VK_5);
        button[6].setMnemonic(KeyEvent.VK_6);
        button[7].setMnemonic(KeyEvent.VK_7);
        button[8].setMnemonic(KeyEvent.VK_8);
        button[9].setMnemonic(KeyEvent.VK_9);
        button_delete.setMnemonic(KeyEvent.VK_BACK_SPACE);
        button_clear.setMnemonic(KeyEvent.VK_A);
        button_spot.setMnemonic(KeyEvent.VK_P);
        button_equal.setMnemonic(KeyEvent.VK_EQUALS);
        button_plus.setMnemonic(KeyEvent.VK_ADD);
        button_minus.setMnemonic(KeyEvent.VK_SUBTRACT);
        button_multiply.setMnemonic(KeyEvent.VK_MULTIPLY);
        button_divide.setMnemonic(KeyEvent.VK_DIVIDE);
        button_sin.setMnemonic(KeyEvent.VK_S);
        button_cos.setMnemonic(KeyEvent.VK_C);
        button_tan.setMnemonic(KeyEvent.VK_T);
        button_lg.setMnemonic(KeyEvent.VK_G);
        button_ln.setMnemonic(KeyEvent.VK_N);*/
    }


    //定义处理事件的类
    public class actionlistener implements ActionListener {
        Algorithm algorithm;
        public String pre_display = "";

        public void actionPerformed(ActionEvent e) {
            Object click1 = e.getSource();             //获得组件名称
            String click2 = e.getActionCommand();      //获得组件标签
            if (click1 == button_clear)                 //初始化文本框
            {
                pre_display = "";
                display.setText("0");
            } else if (click1 == button_delete)           //用handleClear()方法处理delete
            {
                if (!pre_display.equals(""))
                    display.setText(handleDelete(pre_display));
                else
                    display.setText(handleDelete(display.getText()));
            } else if (click2.equals("=")) {
                //计算表达式
                algorithm = new Algorithm(display.getText());
                algorithm.ListPreExpressionToListExpression();
                if (algorithm.Calculate_ListExpression().equals("ILLEGAL!"))
                    display.setText("ILLEGAL!");
                else if (algorithm.Calculate_ListExpression().equals("NON-EXISTENT!"))
                    display.setText("NON-EXISTENT!");
                else {
                    double result = Double.parseDouble(algorithm.Calculate_ListExpression());
                    //数据类型转换
                    long value = (long) result;
                    double d_value = result - value;
                    //去掉无意义的0
                    if (d_value == 0)
                        display.setText(String.valueOf(value));
                    else
                        display.setText(String.valueOf(result));
                }

                pre_display = "";
            } else {
                switch (click2) {
                    case "tan":
                        click2 = "tan(";
                        break;
                    case "sin":
                        click2 = "sin(";
                        break;
                    case "cos":
                        click2 = "cos(";
                        break;
                    case "ln":
                        click2 = "ln(";
                        break;
                    case "lg":
                        click2 = "lg(";
                        break;
                }
                pre_display += click2;
                display.setText(pre_display);
            }
        }


        //删除操作
        public String handleDelete(String text) {
            int textLength = text.length();
            if (textLength > 0) {
                text = text.substring(0, textLength - 1);     //去掉最后一个字符
                if (text.length() == 0)                     //若文本框为空，则初始化为“0”
                {
                    text = "";
                }
                pre_display = text;
                return text;
            } else
                return "";
        }

    }

    public static void main(String[] args) {
        GUICalculator mycalculator = new GUICalculator();
        mycalculator.setResizable(true);
    }

    static class NewPanel extends JPanel {
        public NewPanel() {
        }

        @Override
        public void paintComponent(Graphics g) {
            int x = 0, y = 0;
            ImageIcon icon = new ImageIcon("img/背景2.jpeg");
            g.drawImage(icon.getImage(), x, y, getSize().width, getSize().height, this);// 使图片自动缩放
        }
    }
}