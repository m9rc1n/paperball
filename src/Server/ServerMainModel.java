package Server;

import java.net.ServerSocket;
import java.util.ArrayList;

public class ServerMainModel
{
	private ArrayList<ServerPlayer>	listPlayers;
	private ArrayList<ServerGame>		listGames;

	private ServerSocket					serverSocket;
	private int								port;

	private ServerMainController		control;

	ServerMainModel(ServerMainController control, int port)
	{
		this.setListPlayers(new ArrayList<ServerPlayer>());
		this.setListGames(new ArrayList<ServerGame>());
		this.port = port;
		this.control = control;

	}

	public ArrayList<ServerPlayer> getListPlayers()
	{
		return listPlayers;
	}

	public void setListPlayers(ArrayList<ServerPlayer> listPlayers)
	{
		this.listPlayers = listPlayers;
	}

	public ArrayList<ServerGame> getListGames()
	{
		return listGames;
	}

	public void setListGames(ArrayList<ServerGame> listGames)
	{
		this.listGames = listGames;
	}

	public int getPort()
	{
		return port;
	}

	public void setPort(int port)
	{
		this.port = port;
	}

	public ServerMainController getControl()
	{
		return control;
	}

	public void setControl(ServerMainController control)
	{
		this.control = control;
	}

	public void setServerSocket(ServerSocket serverSocket)
	{
		this.serverSocket = serverSocket;
	}

	public ServerSocket getServerSocket()
	{
		return serverSocket;
	}

}
