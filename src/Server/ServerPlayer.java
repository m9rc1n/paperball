package Server;

import java.net.Socket;



public class ServerPlayer extends Thread
{
	private ServerPlayerModel			model;
	private ServerPlayerController	control;
	
	public ServerPlayer(Socket socket, ServerMainModel mainModel)
	{
		super("ServerPlayerModel");
		setModel(new ServerPlayerModel(mainModel, socket, this));
		control = new ServerPlayerController(getModel());
	}

	public void run()
	{	
		control.readSocket();
	}

	public ServerPlayerModel getModel()
	{
		return model;
	}

	public void setModel(ServerPlayerModel model)
	{
		this.model = model;
	}
	/**
	 * @return the control
	 */
	public ServerPlayerController getControl()
	{
		return control;
	}

	/**
	 * @param control the control to set
	 */
	public void setControl(ServerPlayerController control)
	{
		this.control = control;
	}
}
