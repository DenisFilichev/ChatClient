/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author denis
 */
public class Message implements Serializable {
        private String date;
	private String line;
	private String host;
	
	public Message (String line, String host, String date) {
		this.line = line;
		this.host = host;
                this.date = date;
	}

	public final String getDate() {
		return date;
	}

	public final String getLine() {
		return line;
	}

	public final String getHost() {
		return host;
	}

	@Override
	public String toString() {
		return "[host=" + host + ", date=" + date + "] message: \n"+ line;
	}
	
}
