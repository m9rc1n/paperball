package Server;
import java.io.IOException;
import java.net.ServerSocket;


public class ServerMainController
{

	ServerMainModel	model;

	public ServerMainController(ServerMainModel serverModel)
	{
		model = serverModel;
	}
	
	public void initServerConnection()
	{
		boolean listening = true;

		try
		{
			model.setServerSocket(new ServerSocket(model.getPort()));
			System.out.println("Connection on port: " + model.getPort());
		} catch (IOException e)
		{
			System.err.println("Could not listen on port: " + model.getPort());
			System.exit(-1);
		}

		while (listening)
			try
			{
				ServerPlayer tempolary = new ServerPlayer(model.getServerSocket().accept(), model);
				tempolary.start();
				model.getListPlayers().add(tempolary);
				int index = model.getListPlayers().indexOf(tempolary);
				model.getListPlayers().get(index).getModel().setIdPlayer(index);
				model.getListPlayers().get(index).getModel().setMe(tempolary);
			} catch (IOException e1)
			{
				System.err.println("Could not connect on port: " + model.getPort());
				e1.printStackTrace();
			}
	}
	
	public void closeServerConnection() 
	{
		try
		{
			model.getServerSocket().close();
			System.out.println("Closing connection with all users");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}