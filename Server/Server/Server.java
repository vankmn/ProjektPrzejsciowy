package Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private ICalculate calculate;

	
	public Server(ICalculate calculate) {
		this.calculate = calculate;
	}

	public void start(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("Server started");
		String input=" ";
		while(!input.equalsIgnoreCase("finish")) {
			clientSocket = serverSocket.accept();
			System.out.println("Text recived");
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			input = in.readLine();
			
			Double result = calculate.calculate(input);
			
			out.println(result);
		}
	
	}

	public void stop() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
		serverSocket.close();
	}
	

	public static void main(String[] args) throws IOException {
		Server server = new Server(new JShellResult());
		server.start(6666);
		System.out.println("Server ended");
	}
}