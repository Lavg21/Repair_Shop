package mysql.views;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtelierView extends JFrame {

    private JTextArea resultTextArea;

    private JScrollPane scroll;

    private JButton button3a;
    private JButton button3b;
    private JButton button4a;
    private JButton button4b;
    private JButton button5a;
    private JButton button5b;
    private JButton button6a;
    private JButton button6b;

    public AtelierView() {
        this.setBounds(100, 100, 400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titlteLabel = new JLabel("Atelier de Reparatii");
        titlteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        titlteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlteLabel.setBounds(0, 10, 400, 49);
        this.getContentPane().add(titlteLabel);

        button3a = new JButton("Cerinta 3a)");
        button3a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button3a.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        button3a.setBounds(20, 69, 141, 49);
        this.getContentPane().add(button3a);

        /*resultTextArea = new JTextArea();
        resultTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        //resultTextArea.setBounds(424, 69, 361, 374);
        resultTextArea.setLineWrap(true);
        resultTextArea.setColumns(10);*/

        /*this.scroll = new JScrollPane (resultTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.scroll.setBounds(424, 69, 361, 374);
        this.getContentPane().add(this.scroll);*/

        button4a = new JButton("Cerinta 4a)");
        button4a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button4a.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        button4a.setBounds(20, 159, 141, 49);
        this.getContentPane().add(button4a);

        button5a = new JButton("Cerinta 5a)");
        button5a.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        button5a.setBounds(20, 249, 141, 49);
        this.getContentPane().add(button5a);

        button6a = new JButton("Cerinta 6a)");
        button6a.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        button6a.setBounds(20, 339, 141, 49);
        this.getContentPane().add(button6a);

        button3b = new JButton("Cerinta 3b)");
        button3b.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        button3b.setBounds(207, 69, 141, 49);
        this.getContentPane().add(button3b);

        button4b = new JButton("Cerinta 4b)");
        button4b.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        button4b.setBounds(207, 159, 141, 49);
        this.getContentPane().add(button4b);

        button5b = new JButton("Cerinta 5b)");
        button5b.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        button5b.setBounds(207, 249, 141, 49);
        this.getContentPane().add(button5b);

        button6b = new JButton("Cerinta 6b)");
        button6b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        button6b.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        button6b.setBounds(207, 339, 141, 49);
        this.getContentPane().add(button6b);

        this.setVisible(true);

    }

    public void add3aListener(ActionListener action) {

        this.button3a.addActionListener(action);
    }

    public void add3bListener(ActionListener action) {

        this.button3b.addActionListener(action);
    }

    public void add4aListener(ActionListener action) {

        this.button4a.addActionListener(action);
    }

    public void add4bListener(ActionListener action) {

        this.button4b.addActionListener(action);
    }

    public void add5aListener(ActionListener action) {

        this.button5a.addActionListener(action);
    }

    public void add5bListener(ActionListener action) {

        this.button5b.addActionListener(action);
    }

    public void add6aListener(ActionListener action) {

        this.button6a.addActionListener(action);
    }

    public void add6bListener(ActionListener action) {

        this.button6b.addActionListener(action);
    }

    public void setResultTextAreaValue(String text) {

        this.resultTextArea.setText(text);
    }

}