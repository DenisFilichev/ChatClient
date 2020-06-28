/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import static chatclient.ClientMain.mainForm;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class SocketTransmitter implements Runnable{
    static String line;
    ObjectOutputStream oos;
    public SocketTransmitter(ObjectOutputStream oos){
        this.oos = oos;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(200);
                if (mainForm.isSucccess()){
                    line = mainForm.getLine();
                    oos.writeObject(line);
                }
            } catch (InterruptedException | IOException ex) {
                Logger.getLogger(SocketTransmitter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

