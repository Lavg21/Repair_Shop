package mysql.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableView extends JFrame {

    private JScrollPane tableScroll;

    public JTable table;

    private AtelierView originalFrame;

    private JButton backButton;

    public TableView(AtelierView originalFrame) {

        this.originalFrame = originalFrame;

        this.setBounds(100, 100, 1200, 450);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        this.table = new JTable();

        this.tableScroll = new JScrollPane (this.table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.tableScroll.setBounds(100, 50, 1000, 300);
        this.tableScroll.setViewportView(this.table);
        this.getContentPane().add(this.tableScroll);

        this.backButton = new JButton("Inapoi");
        this.backButton.setBounds(550, 375, 100, 30);
        this.backButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        this.getContentPane().add(this.backButton);

        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                originalFrame.setVisible(true);
                setVisible(false);
            }
        });
    }

}
