package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    Calculator() {
        setSize(300,200);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button;
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3,4));
        for (int i=0; i<10; i++) {
            button = new JButton(Integer.toString(i));
            final int numberb = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setNumber(numberb);
                }
            });
            p1.add(button);
        }
        button = new JButton("+");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperation("+");
            }
        });
        p1.add(button);
        button = new JButton("-");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperation("-");
            }
        });
        p1.add(button);
        button = new JButton("=");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doOperation();
            }
        });
        p1.add(button);

        label = new JLabel("0");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        setLayout(new BorderLayout());
        getContentPane().add(label,BorderLayout.NORTH);
        getContentPane().add(p1,BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.SOUTH);
        setVisible(true);
    }
    void setNumber(int number) {
        if (clear) {
            a = b = 0;
            text = "";
            operation = "";
            clear = false;
        }
        text += number;

        if (operation != null) {
            b *= 10;
            b += number;
        }
        else {
            a *= 10;
            a += number;
        }
        label.setText(text);
    }
    void setOperation(String op) {
        if (op == "+"){
            text += "+";
            operation = "+";
        }
        if (op == "-") {
            text += "-";
            operation = "-";
        }
        else
            text += "";
        label.setText(text);
    }
    void doOperation() {
        int result = 0;
        if (operation == "+")
            result = a+b;
        if (operation == "-")
            result = a-b;
        String Tresult = Integer.toString(result);
        label.setText(Tresult);
        clear = true;
    }
    private boolean clear = false;
    private int a,b;
    private String operation;
    private JLabel label;
    private String text;
}
