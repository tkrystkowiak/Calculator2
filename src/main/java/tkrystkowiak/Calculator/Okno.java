package tkrystkowiak.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Okno {
    private Color warmYellow;
    private Color middleGray;
    private final char koma;
    private final char root;
    private char mathSymbol;
    private boolean isCalculating;
    private boolean isFormatAcceptable;
    private String screenText;
    private JFrame mainFrame;
    private ButtonListener listener;
    private JPanel screenPanel;
    private JPanel p1;
    private JTextField screen;
    private List<JButton> tButtons;
    private List<JButton> t2Buttons;
    private List<Character> screenList;
    private List<Character> n1List;
    private List<Character> n2List;
    private JButton b0;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton bdivide;
    private JButton bmulti;
    private JButton bplus;
    private JButton bminus;
    private JButton bequals;
    private JButton bkoma;
    private JButton bclear;
    private JButton bback;
    private JButton bsilnia;
    private JButton broot;

    public Okno(){
        warmYellow = new Color(241,216,79);
        middleGray = new Color(82,79,81);
        isCalculating = false;
        isFormatAcceptable = true;
        koma = new Character('.');
        root = new Character('\u221A');
        screenList = new ArrayList<Character>();
        n1List = new ArrayList<Character>();
        n2List = new ArrayList<Character>();
        mainFrame = new JFrame();
        mainFrame.setBackground(Color.darkGray);
        listener = new ButtonListener();
        screenPanel = new JPanel();
        p1 = new JPanel();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(screenPanel, BorderLayout.NORTH);
        mainFrame.add(p1, BorderLayout.CENTER);
        screenPanel.setSize(300,100);
        screenPanel.setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(5,4));
        p1.setSize(300,450);
        screen = new JTextField();
        screen.setBackground(Color.darkGray);
        screen.setForeground(warmYellow);
        screen.setHorizontalAlignment(SwingConstants.RIGHT);
        screen.setFont(new Font("Arial",Font.BOLD,40));
        screenPanel.add(screen, BorderLayout.CENTER);
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        bdivide = new JButton("/");
        bmulti = new JButton("x");
        bplus = new JButton("+");
        bminus = new JButton("-");
        bequals = new JButton("=");
        bkoma = new JButton(".");
        bclear = new JButton("C");
        bback = new JButton("\u00AB");
        bsilnia = new JButton("!");
        broot = new JButton(""+root);
        tButtons = new ArrayList<JButton>();
        tButtons.add(b0);
        tButtons.add(b1);
        tButtons.add(b2);
        tButtons.add(b3);
        tButtons.add(b4);
        tButtons.add(b5);
        tButtons.add(b6);
        tButtons.add(b7);
        tButtons.add(b8);
        tButtons.add(b9);
        tButtons.add(bkoma);

        t2Buttons = new ArrayList<JButton>();
        t2Buttons.add(bmulti);
        t2Buttons.add(bdivide);
        t2Buttons.add(bplus);
        t2Buttons.add(bminus);
        t2Buttons.add(bequals);
        t2Buttons.add(bclear);
        t2Buttons.add(bback);
        t2Buttons.add(bsilnia);
        t2Buttons.add(broot);


        b0.addActionListener(listener);
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
        b6.addActionListener(listener);
        b7.addActionListener(listener);
        b8.addActionListener(listener);
        b9.addActionListener(listener);
        bdivide.addActionListener(listener);
        bmulti.addActionListener(listener);
        bplus.addActionListener(listener);
        bminus.addActionListener(listener);
        bequals.addActionListener(listener);
        bkoma.addActionListener(listener);
        bsilnia.addActionListener(listener);
        broot.addActionListener(listener);
        bback.addActionListener(listener);
        bclear.addActionListener(listener);
        //kolorowanie przycisków działań
        for(JButton b: t2Buttons){
            b.setFont(new Font("Arial", Font.BOLD,20));
            b.setBackground(warmYellow);
            b.setForeground(Color.DARK_GRAY);
        }
        //kolorowanie przycisków liczb
        for(JButton b: tButtons){
            b.setFont(new Font("Arial", Font.BOLD,20));
            b.setBackground(middleGray);
            b.setForeground(warmYellow);
        }
        //Najpierwszy rząd przycisków
        p1.add(bclear);
        p1.add(bback);
        p1.add(bsilnia);
        p1.add(broot);

        //Pierwszy rząd przycisków
        p1.add(b7);
        p1.add(b8);
        p1.add(b9);
        p1.add(bdivide);

        //Drugi rząd przycisków
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(bmulti);

        //Trzeci rząd przycisków
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(bminus);

        //Czwarty rząd przycisków
        p1.add(bkoma);
        p1.add(b0);
        p1.add(bequals);
        p1.add(bplus);

        mainFrame.setSize(250,400);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private double numberConversion(List<Character> lista){
        try{
    	StringBuilder builder = new StringBuilder(lista.size());
        for(Character c: lista){
            builder.append(c);
        }
        String number = builder.toString();
        return Double.parseDouble(number);
        }
        catch(NumberFormatException e){
        	isFormatAcceptable = false;
        	return 0.0;
        }
    }

    public class ButtonListener implements ActionListener  {
    	
        public void actionPerformed(ActionEvent e)  {
            screenText = screen.getText();
            JButton source = (JButton)e.getSource();
            if (source == b0){
                screen.setText(screenText+"0");
                }
            else if (source == b1){
                screen.setText(screenText+"1");
            }
            else if (source == b2){
                screen.setText(screenText+"2");
            }
            else if (source == b3){
                screen.setText(screenText+"3");
            }
            else if (source == b4){
                screen.setText(screenText+"4");
            }
            else if (source == b5){
                screen.setText(screenText+"5");
            }
            else if (source == b6){
                screen.setText(screenText+"6");
            }
            else if (source == b7){
                screen.setText(screenText+"7");
            }
            else if (source == b8){
                screen.setText(screenText+"8");
            }
            else if (source == b9){
                screen.setText(screenText+"9");
            }
            else if (source == bplus){
                screen.setText(screenText+"+");
            }
            else if (source == bminus){
                screen.setText(screenText+"-");
            }
            else if (source == bdivide){
                screen.setText(screenText+"/");
            }
            else if (source == bmulti){
                screen.setText(screenText+"*");
            }
            else if (source == bkoma){
                screen.setText(screenText+".");
            }
            else if (source == bsilnia){
                screen.setText(screenText+"!");
            }
            else if (source == broot){
                screen.setText(screenText+root);
            }
            else if (source == bclear){
                screen.setText("");
            }
            else if (source == bback){
                    List<Character> backList = new ArrayList<Character>();
                for(char c: screenText.toCharArray()){
                    backList.add(c);
                }
                backList.remove(backList.size()-1);

                StringBuilder builder = new StringBuilder(backList.size());
                for(Character c: backList){
                    builder.append(c);
                }
                screen.setText(builder.toString());


            }
            else if (source == bequals){
               
            	try {
					managingEquation();
				} catch (InvalidFormatException e1) {
					System.out.println("This code is reachable 2");
					screen.setText("Error");
	                n1List.clear();
	                n2List.clear();
	                screenList.clear();
	                mathSymbol = '0';
	                isCalculating = false;
	                isFormatAcceptable = true;
				}
            }
        }
    }
    private void managingEquation() throws InvalidFormatException{
    	screen.setText(screenText+"=");
        screenText = screen.getText();
        for(char c: screenText.toCharArray()){
            screenList.add(c);
        }
        for(int i =0;i<screenList.size();i++){
            char a = screenList.get(i);
            if(Character.isDigit(a)||a==koma||a==root||a=='!'){
                if(isCalculating)
                    n2List.add(a);
                else
                    n1List.add(a);
            }
            else if(a=='+'||a=='-'||a=='*'||a=='/'){
                mathSymbol = a;
                isCalculating = true;
            }
            else if(a=='='){
            	
                double number1 = 0;
                double number2 = 0;
                if(!n1List.isEmpty()) {
                    if(n1List.get(0)==root){

                        n1List.remove(0);
                        double number1root = numberConversion(n1List);
                        number1 = Calculation.Calculate(root,number1root,number2);
                    }
                    else if(n1List.get(n1List.size()-1)=='!'){
                        n1List.remove(n1List.size()-1);
                        double number1silnia = numberConversion(n1List);
                        number1 = Calculation.Calculate('!',number1silnia,number2);
                    }
                    else {
                        number1 = numberConversion(n1List);
                    }

                }
                if(!n2List.isEmpty()) {
                    if(n2List.get(0)==root){

                        n2List.remove(0);
                        double number1root = numberConversion(n2List);

                        number2 = Calculation.Calculate(root,number1root,number2);
                    }
                    else if(n2List.get(n2List.size()-1)=='!'){
                        n2List.remove(n2List.size()-1);
                        double number1silnia = numberConversion(n2List);
                        number2 = Calculation.Calculate('!',number1silnia,number2);
                    }
                    else {
                        number2 = numberConversion(n2List);
                    }
                }

                if(isFormatAcceptable==false){
                	throw new InvalidFormatException();
                }
                else{
                screen.setText(screenText+Calculation.round(Calculation.Calculate(mathSymbol,number1,number2),5));
                }
            
                n1List.clear();
                n2List.clear();
                screenList.clear();
                mathSymbol = '0';
                isCalculating = false;
                isFormatAcceptable = true;

            }
           
        }
        
    }
}
	
