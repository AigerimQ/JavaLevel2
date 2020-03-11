package lesson4;

import javax.swing.*;
import java.awt.event.*;

public class Messenger extends JFrame {
    private JPanel panel1;
    private JList<String> listItems;
    private JTextField customInputText;
    private JButton sendMessage;
    private JLabel label;

    private Messenger() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listItems.setModel(listModel);
        listItems.addListSelectionListener(e -> {
//                int firstIndex = e.getFirstIndex();
//                String selectedValue = listModel.get(firstIndex);
            String selectedValue = listItems.getSelectedValue();
//            label.setText(selectedValue);

        });

        customInputText.addActionListener(event -> {
            listModel.addElement(customInputText.getText());
            customInputText.setText("");
        });

        sendMessage.addActionListener(event -> {
            listModel.addElement(customInputText.getText());
            customInputText.setText("");
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
