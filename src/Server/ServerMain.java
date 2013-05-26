package Server;
import java.io.IOException;


public class ServerMain
{

	private ServerMainModel			model;
	private ServerMainController	control;

	public ServerMain(String port)
	{
		model = new ServerMainModel(control, Integer.parseInt(port));
		control = new ServerMainController(model);
	}
	
	public static void main(String[] args) throws IOException
	{
		ServerMain server = new ServerMain(args[0]);
		server.control.initServerConnection();
		server.control.closeServerConnection();
	}
}