import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Janela implements ActionListener{
    static JFrame jan1 = new JFrame("CALCULADORA");
    static JLabel rotRep = new JLabel("RESULTADO");
    static JTextField res = new JTextField(20);
    static JButton bot1 = new JButton("1");
    static JButton bot2 = new JButton("2");
    static JButton bot3 = new JButton("3");
    static JButton bot4 = new JButton("4");
    static JButton bot5 = new JButton("5");
    static JButton bot6 = new JButton("6");
    static JButton bot7 = new JButton("7");
    static JButton bot8 = new JButton("8");
    static JButton bot9 = new JButton("9");
    static JButton bot0 = new JButton("0");  

    static JButton botPlus = new JButton("+");
    static JButton botMinus = new JButton("-");
    static JButton botDiv = new JButton("/");
    static JButton botMult = new JButton("*");
    static JButton botResult = new JButton("=");
    static JButton botCC = new JButton("LIMPAR");
    static Janela j = new Janela();

    static float num1 = 0;
    static float num2 = 0;
    static int op = 0;

    public static void main (String[] args){
        criarJan();
    }

    public static void criarJan(){
        int largura = 270;
        int altura = 250;
        

        jan1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        

        bot1.addActionListener(j);
        bot2.addActionListener(j);
        bot3.addActionListener(j);
        bot4.addActionListener(j);
        bot5.addActionListener(j);
        bot6.addActionListener(j);
        bot7.addActionListener(j);
        bot8.addActionListener(j);
        bot9.addActionListener(j);
        bot0.addActionListener(j);
        botPlus.addActionListener(j);
        botMinus.addActionListener(j);
        botDiv.addActionListener(j);
        botMult.addActionListener(j);
        botResult.addActionListener(j);
        botCC.addActionListener(j);

        jan1.add(rotRep);
        jan1.add(res);
        jan1.add(bot1);        
        jan1.add(bot2);
        jan1.add(bot3);        
        jan1.add(bot4);
        jan1.add(bot5);        
        jan1.add(bot6);
        jan1.add(bot7);        
        jan1.add(bot8);
        jan1.add(bot9);        
        jan1.add(bot0);
        jan1.add(botPlus);        
        jan1.add(botMinus);
        jan1.add(botMult);        
        jan1.add(botDiv);
        jan1.add(botResult);
        jan1.add(botCC);


        jan1.getContentPane().setBackground(Color.GRAY);

        jan1.setSize(largura,altura);

        jan1.setLayout(new FlowLayout());

        jan1.setVisible(true);
    }

    public void fmtCalc(String ent){  
        float aux;              
        if(num1 == 0 && ent.equals("-")){
            num1 = -1;
            res.setText("-");
        } else if (ent.matches("[0-9]+")){            
            if(num1 == -1){
                num1 = num1 * Float.parseFloat(ent);
                aux = num1;
                res.setText(Float.toString(aux));
            } else {
                if(num1 < 0){
                    num1 = (num1 * 10) + (-1 * Float.parseFloat(ent));
                    aux = num1;
                    res.setText(Float.toString(aux));
                } else {
                    num1 = (num1 * 10) + Float.parseFloat(ent);
                    aux = num1;
                    res.setText(Float.toString(aux));
                }
            }
        } else if (op == 0){
            if(num2 == 0){
                if(ent.equals("+")){
                    op = 1;
                    num2 = num1;
                    num1 = 0;                        
                    res.setText(ent);  
                } else if(ent.equals("-")){
                    op = 2;
                    num2 = num1;
                    num1 = 0;                        
                    res.setText(ent);
                } else if(ent.equals("/")){
                    op = 3;
                    num2 = num1;
                    num1 = 0;                        
                    res.setText(ent);
                } else {
                    op = 4;
                    num2 = num1;
                    num1 = 0;                        
                    res.setText(ent);
                }
            } else {
                calcRes();
            }
        }           
    }

    public void calcRes(){
        float result = 0;

        if(op == 1){
           result = num2+num1;
           num1 = 0;
           num2 = 0;
           op = 0;
        } else if(op == 2){
            result = num2-num1;
            num1 = 0;
            num2 = 0;
            op = 0;
        } else if(op == 3){
            result = num2/num1;
            num1 = 0;
            num2 = 0;
            op = 0;
        } else if(op == 4){
            result = num2*num1;
            num1 = 0;
            num2 = 0;
            op = 0;
        }

        res.setText(Float.toString(result));
        
    }

    public void actionPerformed(ActionEvent evt){

        if(evt.getSource().equals(bot1)){
            fmtCalc("1");
        } else if(evt.getSource().equals(bot2)){
            fmtCalc("2");
        } else if(evt.getSource().equals(bot3)){
            fmtCalc("3");
        } else if(evt.getSource().equals(bot4)){
            fmtCalc("4");
        } else if(evt.getSource().equals(bot5)){
            fmtCalc("5");
        } else if(evt.getSource().equals(bot6)){
            fmtCalc("6");
        } else if(evt.getSource().equals(bot7)){
            fmtCalc("7");
        } else if(evt.getSource().equals(bot8)){
            fmtCalc("8");
        } else if(evt.getSource().equals(bot9)){
            fmtCalc("9");
        } else if(evt.getSource().equals(bot0)){
            fmtCalc("0");
        } else if(evt.getSource().equals(botPlus)){
            fmtCalc("+");
        } else if(evt.getSource().equals(botMinus)){
            fmtCalc("-");
        } else if(evt.getSource().equals(botMult)){
            fmtCalc("*");
        } else if(evt.getSource().equals(botDiv)){
            fmtCalc("/");
        } else if(evt.getSource().equals(botResult)){
            calcRes();
        } else if (evt.getSource().equals(botCC)){
            num1 = 0;
            res.setText("");    
        }
    }
}