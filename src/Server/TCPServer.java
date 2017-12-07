package Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {
	
	private static final int BUFFER_SIZE = 1024;
	
	private String ip;
	private int port;
	
	public TCPServer(int port) {
		this.port = port;
	}

	public static void main(String[] args) {
		new TCPServer(8844).run();
	}
	
	
	public void run() {
		try {
			ServerSocket socketServer = new ServerSocket(port);
			Socket socket = socketServer.accept();
			
			InputStream in = socket.getInputStream();
			byte data[] = new byte[BUFFER_SIZE];
			int r;
			while ((r = in.read(data, 0, BUFFER_SIZE)) > 0) {
				String msg = new String(data, "ISO-8859-1");
				if (!msg.equals(" ")) {
					System.out.println("S: got a message: " + msg);
					System.out.println("Bytes: " + msg.getBytes());
				}
			}
			socketServer.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}