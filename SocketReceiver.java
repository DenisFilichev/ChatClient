/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import static chatclient.ClientMain.mainForm;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class SocketReceiver{
    
    public void receiver (ObjectInputStream ois){
        String line;
        while(true) {
            try {
                Object[] o = (Object[]) ois.readObject();
                Message message = new Message(o[0].toString(), o[1].toString(), o[2].toString());
                line = (o[0]).toString();
                mainForm.printToForm(message.toString());
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(SocketReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
    }
}
