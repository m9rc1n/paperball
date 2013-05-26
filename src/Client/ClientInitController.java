package Client;

public class ClientInitController
{

	private ClientModel						model;
	private ClientConnectionController	connect;
	private ClientGameController			game;

	public ClientInitController(ClientModel model,
			ClientConnectionController connect, ClientGameController game)
	{
		this.model = model;
		this.connect = connect;
		this.setGame(game);
	}

	public void startSettings(String login, String port)
	{

		connect.getModel().getConnection().setPort(Integer.parseInt(port));
		connect.initConnection();
		connect.sendMessage(EnumProtocol.SET_LOGIN.toString() + login + "/");
		String message = connect.readMessage();
		if (message.contains(EnumProtocol.DONE_SET_LOGIN.toString()))
		{
			getModel().getInit().setUserLogin(login);
			ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
					EnumUpdate.SETTINGS_VIEW);
			getModel().refreshUpdate(infoView);
		}
		else if (message.contains(EnumProtocol.ERROR_SET_LOGIN.toString()))
		{
			ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
					EnumUpdate.INIT_VIEW);
			getModel().refreshUpdate(infoView);
			getModel().getInit().getInfo()
					.setText("Login busy, choose another one!");
		}
		else if (message.contains(EnumProtocol.ERROR_SET_CONNECTION.toString()))
		{
			ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
					EnumUpdate.INIT_VIEW);
			getModel().refreshUpdate(infoView);
			getModel()
					.getInit()
					.getInfo()
					.setText(
							"Connection problem, try another Server or wait some time");
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
	 * @return the connect
	 */
	public ClientConnectionController getConnect()
	{
		return connect;
	}

	/**
	 * @param connect
	 *           the connect to set
	 */
	public void setConnect(ClientConnectionController connect)
	{
		this.connect = connect;
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

}
