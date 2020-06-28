/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author denis
 */
public class MainClientForm extends JFrame{
    
    private static String line;
    private boolean okPressed = false;
    static JTextArea jta1;
    static JTextField jtf2;
    static JButton send;
    
    public MainClientForm (){
        super("Chat");
        setSize(900, 600);
        
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
            
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
        
        jta1 = new JTextArea();
        jta1.setEditable(false);
        jtf2 = new JTextField();
        jtf2.setEditable(true);
        JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(jta1), new JScrollPane(jtf2));
        jsp.setDividerLocation(400);
        add(jsp);
        
        JPanel jp = new JPanel();
        add(jp, BorderLayout.SOUTH);
        JButton send = new JButton("Send");
        jp.add(send);
        send.setVisible(true);
        send.addActionListener((e) -> {
            line = jtf2.getText();
            okPressed = true;
        });
    }
    
    public void printToForm (String string){
        SwingUtilities.invokeLater(() -> {
            jta1.append(string);
            jta1.append("\n");
        });
    }
    
    public String getLine (){
        okPressed = false;
        jtf2.setText("");
        return line;
    }
    
    public boolean isSucccess(){
        return okPressed;
    }
}
