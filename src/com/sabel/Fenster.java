package com.sabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Fenster extends JFrame {

    private JPanel jpNorth, jpSouth;
    private JButton jbtEintragen;
    private JTextField jtxtEintrag;
    private  JScrollPane jScrollPane;
    private JTextArea jTextArea;

    private Repository repository;


    public Fenster(Repository repository) {
        super("ToDoApp");
        this.repository = repository;
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.initComponents();
        this.initEvents();
        this.pack();
        this.setVisible(true);
    }

    private void initEvents() {
        jbtEintragen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eintragen();
            }
        });

        jtxtEintrag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eintragen();
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                repository.close();
                System.exit(NORMAL);
            }
        });
    }

    private void eintragen() {
        String text = jtxtEintrag.getText();
        if (text.length() > 0){
            Eintrag eintrag = new Eintrag(text);
            repository.hinzufuegen(eintrag);
            updateView();
            jtxtEintrag.setText("");
        }
    }

    private void updateView() {
        jTextArea.setText(repository.toString());
    }


    private void initComponents() {
        jTextArea = new JTextArea(20,20);
        jTextArea.setEditable(false);
        jScrollPane = new JScrollPane(jTextArea);
        this.add(jScrollPane);

        jpSouth = new JPanel();
        jtxtEintrag = new JTextField(20);
        jbtEintragen = new JButton("Eintragen");
        jpSouth.add(jtxtEintrag);
        jpSouth.add(jbtEintragen);
        this.add(jpSouth, BorderLayout.SOUTH);
        updateView();
    }

    public static void main(String[] args) {
        Repository repository = new Repository();
        new Fenster(repository);
    }
}
