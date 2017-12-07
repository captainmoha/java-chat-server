package Client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	
	private static final int BUFFER_SIZE = 1024;
	
	private String ip;
	private int port;
	
	TCPClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public static void main(String[] args) {
		new TCPClient("localhost", 8844).run();

	}
	
	public void run() {
		
		try {
			Socket socket = new Socket(ip, port);
			OutputStream out = socket.getOutputStream();
			out.write("Client Sent Masssage".getBytes());
			out.flush();
			socket.close();
			
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}