package lesson4;

import javax.swing.*;
import java.awt.event.*;

public class Messenger extends JFrame {
    private JPanel panel1;
    private JList<String> listItems;
    private JTextField customInputText;
    private JButton sendMessage;
    private JLabel label;
    private JList<String> contactList;
    private JLabel contacts;
    private JLabel сorrespondence;
    private String selectedContact = "Я";


    private Messenger() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listItems.setModel(listModel);
        listItems.addListSelectionListener(e -> listItems.getSelectedValue());

        DefaultListModel<String> listModel1 = new DefaultListModel<>();
        listModel1.addElement("Андрей Чумаков");
        listModel1.addElement("Ксения Новожилова");
        listModel1.addElement("Максим Гребенюк");
        listModel1.addElement("Евгений Иванов");
        contactList.setModel(listModel1);

        contactList.addListSelectionListener(e -> selectedContact = contactList.getSelectedValue());

        customInputText.addActionListener(event -> {
            listModel.addElement(selectedContact + ": " + customInputText.getText());
            customInputText.setText("");
            contactList.clearSelection();
            selectedContact = "Я";
        });

        sendMessage.addActionListener(event -> {
            listModel.addElement(selectedContact + ": " + customInputText.getText());
            customInputText.setText("");
            contactList.clearSelection();
            selectedContact = "Я";
        });


    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("BestMessenger");
        frame.setContentPane(new Messenger().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("");


        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> {
            System.out.println("Bye from menu!");
            frame.dispose();
        });

        menu.add(exitMenuItem);

        menuBar.add(menu);

        frame.setJMenuBar(menuBar);


        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Bye!");
            }
        });

        frame.pack();
        frame.setVisible(true);
    }



}
