/**
 * Created by mr.elliot on 20.02.2018.
 */
/**
 * Created by mr.elliot on 19.02.2018.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
class FindRoot extends JFrame  implements ActionListener {

    JTextField jt,jt1,jt2,jt3,jt4,jt6,jt7;
    JButton findRoot,clear;
    JLabel jl,jl1,jl2,jl3,jl4,jl6,jl7,title;


    FindRoot(){

        JFrame jf=new JFrame("Home Work #3");
        jf.getContentPane().setBackground( Color.DARK_GRAY);
        jt = new JTextField(20);
        jt.setBounds(100,60,120,25); jf.add(jt);
        jt1 = new JTextField(20);
        jt1.setBounds(100,95,120,25); jf.add(jt1);
        jt2 = new JTextField(20);
        jt2.setBounds(100,130,120,25); jf.add(jt2);
        jt3 = new JTextField(20);
        jt3.setBounds(100,165,120,25);jf.add(jt3);
        jt4 = new JTextField(20);
        jt4.setBounds(100,200,120,25);jf.add(jt4);
        jt6 = new JTextField(20);
        jt6.setBounds(100,235,120,25);jf.add(jt6);
        jt7 = new JTextField(20);
        jt7.setBounds(100,270,120,25);jf.add(jt7);
        title = new JLabel("Программа для нахождения корня,методом Newton-Raphson");
        title.setBounds(300,50,350,20); jf.add(title);
        title.setBackground(Color.white);
           jl=new JLabel("a=");
        jl.setForeground(Color.white);
        jl.setBounds(70,60,120,25);jf.add(jl);
        jl1 =new JLabel("b=");
        jl1.setForeground(Color.white);
        jl1.setBounds(70,95,120,25);jf.add(jl1);
        jl2=new JLabel("c=");
        jl2.setForeground(Color.white);
        jl2.setBounds(70,130,120,25);jf.add(jl2);
        jl3=new JLabel("d=");
        jl3.setForeground(Color.white);
        jl3.setBounds(70,165,120,25);jf.add(jl3);
        jl4=new JLabel("x0=");
        jl4.setForeground(Color.white);
        jl4.setBounds(70,200,120,25);jf.add(jl4);
        jl6=new JLabel("e=");
        jl6.setForeground(Color.white);
        jl6.setBounds(70,235,120,25);jf.add(jl6);
        jl7=new JLabel("root= ");
        jl7.setForeground(Color.white);
        jl7.setBounds(70,270,120,25);jf.add(jl7);
        findRoot = new JButton("find root");
        findRoot.setBounds(100,305,120,25);jf.add(findRoot);
        clear = new JButton("clear");
        clear.setBounds(100,340,120,25);jf.add(clear);

        findRoot.addActionListener(this);
        findRoot.setToolTipText("Find Root");
        clear.addActionListener(this);
        clear.setToolTipText("Clear");

        jf.setLayout(null);
        jf.setVisible(true);
        jf.setSize(1200,600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == findRoot) {

            Newton();
        }
        else if (event.getSource() == clear) {
            clear();
        }
    }


    public void Newton() {

        String s1=jt.getText();
        String s2=jt1.getText();
        String s3=jt2.getText();
        String s4=jt3.getText();
        String s5=jt4.getText();
        String s7=jt6.getText();

        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty() && s4.isEmpty() && s5.isEmpty() && s7.isEmpty()) {
            JOptionPane.showMessageDialog(null, " Вы ввели  пустые значения");
            return;
        }

        double a=Double.parseDouble(s1);
        double b=Double.parseDouble(s2);
        double c=Double.parseDouble(s3);
        double d=Double.parseDouble(s4);
        double x0=Double.parseDouble(s5);
        double eps=Double.parseDouble(s7);
        double root=0;


            double h = func(  x0 , a,  b,  c,  d) / deriv(  x0 , a, b,  c);
            while (Math.abs(h) >= eps)
            {
                h = func(  x0, a,  b,  c,  d) / deriv( x0,  a,  b,  c);

                // x(i+1) = x(i) - f(x) / f'(x)
              x0= x0 - h;
              root=x0;
            }
            String res=String.valueOf(Math.round(root*100.0)/100.0);
            res =new DecimalFormat("#0.0000").format(root);

            jt7.setText(res);
    }

    public double func(double x , double a, double b, double c, double d)    {

        return a*x*x*x+b*x*x+c*x+d;
    }



    public double deriv(double x, double a, double b, double c)  {

        return 3*a*x*x+2*b*x+c;
    }

    public void clear(){

        jt.setText("");
        jt1.setText("");
        jt2.setText("");
        jt3.setText("");
        jt4.setText("");
        jt6.setText("");
        jt7.setText("");

    }
}

public class Home {

    public static void main(String[] args)
    {
        FindRoot hm = new FindRoot ();

    }
}