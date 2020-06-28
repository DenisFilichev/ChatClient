/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import static chatclient.ClientMain.clientMain;
import static chatclient.ClientMain.mainForm;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.NumberFormat;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author denis
 */
public class HostPort extends JFrame{
    
    private JPanel controlsPane;
    private JTextField host;
    private JTextField port;
    private boolean okPressed = true;
    
    public HostPort (){
        super("Адрес сервера");
        
        controlsPane = new JPanel();
        controlsPane.setLayout(new BoxLayout(controlsPane, BoxLayout.Y_AXIS));
        add(controlsPane, BorderLayout.CENTER);
        setVisible(true);
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        host = new JTextField();
        host.setColumns(15);
        JLabel jbl1 = new JLabel("host");
        jbl1.setLabelFor(host);
        p.add(jbl1);
        p.add(host);
        controlsPane.add(p);
        p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        port = new JTextField();
        port.setColumns(15);
        JLabel jbl2 = new JLabel("port");
        jbl2.setLabelFor(port);
        p.add(jbl2);
        p.add(port);
        controlsPane.add(p);
        
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(bottom, BorderLayout.SOUTH);
        
        JButton btnOk = new JButton("Добавить");
        bottom.add(btnOk);
        btnOk.addActionListener(e -> {
            clientMain.setHost(host.getText());
            clientMain.setPort(Integer.parseInt(port.getText()));
            okPressed = false;
            setVisible(false);
            //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });
        
        JButton btnCancel = new JButton("Отмена");
        bottom.add(btnCancel);
        btnCancel.addActionListener(e -> {
            System.exit(0);
        });
        
        pack();
        setLocationRelativeTo(null);
    }
    
    public boolean isSucccess(){
        return okPressed;
    }
}

