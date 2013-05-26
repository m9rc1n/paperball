package Client;

public class ClientControlGameController
{
	private ClientModel						model;
	private ClientConnectionController	connection;
	private ClientGameController			game;

	public ClientControlGameController(ClientModel model,
			ClientConnectionController connection, ClientGameController game)
	{
		setConnection(connection);
		setModel(model);
		setGame(game);
	}

	/**
	 * 
	 * Sets the model for this controller.
	 * 
	 * @param opponent
	 * 
	 */

	public void startGame(String opponent)
	{
		getConnection().sendMessage(
				EnumProtocol.GAME_WITH.toString() + opponent + "-"
						+ getModel().getPitch().getWidth() + ":"
						+ getModel().getPitch().getLength() + "/");

		if (getConnection().readMessage().contains(
				EnumProtocol.DONE_GAME_CREATING.toString()))
		{
			getModel().getGame().setOpponent(opponent);
			getModel().getInit().setUserStatus(EnumStatus.GAMING_MOVING);
			getModel().getGame().setUserStartedGame(true);
			ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
					EnumUpdate.GAME_VIEW_MOVING);
			getModel().refreshUpdate(infoView);
		}
		else
		{
			ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
					EnumUpdate.SETTINGS_VIEW);
			getModel().refreshUpdate(infoView);
		}
	}

	/**
	 * @return the model
	 */
	public ClientModel getModel()
	{
		return model;
	}

	/**
	 * @param model
	 *           the model to set
	 */
	public void setModel(ClientModel model)
	{
		this.model = model;
	}

	/**
	 * @return the connection
	 */
	public ClientConnectionController getConnection()
	{
		return connection;
	}

	/**
	 * @param connection
	 *           the connection to set
	 */
	public void setConnection(ClientConnectionController connection)
	{
		this.connection = connection;
	}

	public void changeStatus(String status)
	{

		ClientWaitingThread waitingThread = new ClientWaitingThread(
				getConnection(), getModel(), getGame());

		if (status.equals("WAITING FOR GAME"))
		{
			getModel().getInit()
					.setUserStatus(EnumStatus.WAITING_TO_BEING_CHOOSED);
			getConnection().sendMessage(
					EnumProtocol.SET_STATUS_WAITING.toString() + '/');
			waitingThread.start();
		}
		if (status.equals("CHOOSING"))
		{
			getModel().getInit().setUserStatus(EnumStatus.CHOOSING);
			getConnection().sendMessage(
					EnumProtocol.SET_STATUS_CHOOSING.toString() + '/');
		}
		if (status.equals("UNAVAILABLE"))
		{
			getModel().getInit().setUserStatus(EnumStatus.CHOOSING);
			getConnection().sendMessage(
					EnumProtocol.SET_STATUS_UNAVAILABLE.toString() + '/');
		}
	}

	/**
	 * @return the game
	 */
	public ClientGameController getGame()
	{
		return game;
	}

	/**
	 * @param game
	 *           the game to set
	 */
	public void setGame(ClientGameController game)
	{
		this.game = game;
	}

	public void changeWidth(Integer selectedItem)
	{
		int width = selectedItem.intValue();
		getModel().getPitch().setWidth(width);
		getModel().getBall().setX(width / 2);
		getModel().getBall().setOldX(width / 2);
	}

	public void changeLength(Integer selectedItem)
	{
		int length = selectedItem.intValue();
		getModel().getPitch().setLength(length);
		getModel().getBall().setY(length / 2);
		getModel().getBall().setOldY(length / 2);
	}
}
