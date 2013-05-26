package Client;

/**
 * @author marcinn
 * 
 */
public class ClientController
{

	/**
	 * 
	 */
	private ClientModel						model;
	private ClientGameController			game;
	private ClientConnectionController	connection;
	private ClientInitController			init;
	private ClientUsersController			users;
	private ClientControlSetController	controlSet;
	private ClientControlGameController	controlGame;

	/**
	 * Constructor
	 * 
	 * @param model
	 *           The model this controller's view is observing
	 */

	public ClientController(ClientModel model)
	{
		setModel(model);
		connection = new ClientConnectionController(model);
		game = new ClientGameController(model, connection);
		init = new ClientInitController(model, connection, game);
		setUsers(new ClientUsersController(model, connection));
		setControlSet(new ClientControlSetController(model, connection, game));
		setControlGame(new ClientControlGameController(model, connection, game));
	}

	/**
	 * Stops the game.
	 */

	public void stopGame()
	{
		getModel().stop();
	}

	/**
	 * Resets the the game to midpoint.
	 */

	public void resetGame()
	{}

	public void setModel(ClientModel model)
	{
		this.model = model;
	}

	/**
	 * Returns the model for this controller.
	 */

	public ClientModel getModel()
	{
		return model;
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

	/**
	 * @return the init
	 */
	protected ClientInitController getInit()
	{
		return init;
	}

	/**
	 * @return the users
	 */
	protected ClientUsersController getUsers()
	{
		return users;
	}

	/**
	 * @param init
	 *           the init to set
	 */
	protected void setInit(ClientInitController init)
	{
		this.init = init;
	}

	/**
	 * @param users
	 *           the users to set
	 */
	protected void setUsers(ClientUsersController users)
	{
		this.users = users;
	}

	/**
	 * @return the controlSet
	 */
	public ClientControlSetController getControlSet()
	{
		return controlSet;
	}

	/**
	 * @param controlSet
	 *           the controlSet to set
	 */
	public void setControlSet(ClientControlSetController controlSet)
	{
		this.controlSet = controlSet;
	}

	/**
	 * @return the controlGame
	 */
	public ClientControlGameController getControlGame()
	{
		return controlGame;
	}

	/**
	 * @param controlGame the controlGame to set
	 */
	public void setControlGame(ClientControlGameController controlGame)
	{
		this.controlGame = controlGame;
	}
}
