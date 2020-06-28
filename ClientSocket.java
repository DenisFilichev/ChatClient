/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import static chatclient.ClientMain.clientMain;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author denis
 */
public class ClientSocket {
    public void run (){
        try(Socket s = new Socket(InetAddress.getByName(clientMain.getHost()), clientMain.getPort())) {
            try(ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    ObjectInputStream ois = new ObjectInputStream(s.getInputStream())){
                System.out.println("Начало");
                //SocketTransmitter st = new SocketTransmitter(oos);
                Thread stThread = new Thread(new SocketTransmitter(oos));
                stThread.start();
                System.out.println("Step 1");
                SocketReceiver sr = new SocketReceiver();
                sr.receiver(ois);
                System.out.println("Step 2");
            }
        }   catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Сервер не доступен", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
