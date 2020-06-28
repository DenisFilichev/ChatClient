/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class ClientMain {
    public static MainClientForm mainForm;
    public static ClientMain clientMain;
    private static String host;
    private static int port;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        clientMain = new ClientMain();
        HostPort hp = new HostPort();
        while (hp.isSucccess()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClientMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        mainForm = new MainClientForm();
        mainForm.setVisible(true);
        new ClientSocket().run();
    }

    public void setHost(String host) {
        ClientMain.host = host;
    }

    public void setPort(int port) {
        ClientMain.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
