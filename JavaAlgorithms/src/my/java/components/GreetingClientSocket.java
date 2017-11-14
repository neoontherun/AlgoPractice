package my.java.components;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class GreetingClientSocket {

	public static void main(String[] args) {

		Executor exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			Client cl = new Client();
			exec.execute(cl);
		}

	}

	static class Client implements Runnable {

		@Override
		public void run() {
			String serverName = "localhost";
			int port = Integer.parseInt("9090");
			try {
				System.out.println("Connecting to " + serverName + " on port " + port);
				Socket client = new Socket(serverName, port);

				System.out.println("Just connected to " + client.getRemoteSocketAddress() + " Thread ID " + Thread.currentThread().getId());
				OutputStream outToServer = client.getOutputStream();
				DataOutputStream out = new DataOutputStream(outToServer);

				out.writeUTF("Hello from " + client.getLocalSocketAddress());
				InputStream inFromServer = client.getInputStream();
				DataInputStream in = new DataInputStream(inFromServer);

				System.out.println("Server says " + in.readUTF());
				client.close();
			} catch (IOException e) {
				System.out.println("Thread : " + Thread.currentThread().getId());
				e.printStackTrace();
			}
		}

	}
}