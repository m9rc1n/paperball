package Server;

public class ServerGame
{
	private ServerGameModel			model;
	private ServerGameController	control;

	public ServerGame(ServerPlayer me, ServerPlayer opponent, int width, int length)
	{
		model = new ServerGameModel(me, opponent, width, length);
		control = new ServerGameController(model);
	}

	/**
	 * @return the model
	 */
	public ServerGameModel getModel()
	{
		return model;
	}

	/**
	 * @param model
	 *           the model to set
	 */
	public void setModel(ServerGameModel model)
	{
		this.model = model;
	}

	/**
	 * @return the control
	 */
	public ServerGameController getControl()
	{
		return control;
	}

	/**
	 * @param control
	 *           the control to set
	 */
	public void setControl(ServerGameController control)
	{
		this.control = control;
	}
}
