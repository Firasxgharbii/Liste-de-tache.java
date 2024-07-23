package examin.example.listedetaches;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
      
        JFrame frame = new JFrame("Liste de Tâches");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        
        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Tâche:");
        JTextField textField = new JTextField(20);
        JTextArea textArea = new JTextArea();
        JButton addButton = new JButton("Ajouter");

        textArea.setEditable(false); 
        textArea.setLineWrap(true); 
        textArea.setWrapStyleWord(true); 

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(label);
        inputPanel.add(textField);
        inputPanel.add(addButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);

        frame.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = textField.getText();
                if (!task.isEmpty()) {
                    textArea.append(task + "\n");
                    textField.setText("");
                }
            }
        });
    }
}
