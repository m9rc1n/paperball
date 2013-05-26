package Client;

import java.util.Observable;

/**
 * @author Marcin Urbański
 * 
 */
public class ClientModel extends Observable
{

	private ClientPitchModel			pitch;
	private ClientGameModel				game;
	private ClientBallModel				ball;
	private ClientConnectionModel		connection;
	private ClientInitModel				init;
	private ClientUsersModel			users;
	private ClientControlSetModel		controlSet;
	private ClientControlGameModel	controlGame;

	/**
	 * Constructor.
	 */
	public ClientModel()
	{
		pitch = new ClientPitchModel(7, 11);
		game = new ClientGameModel();
		ball = new ClientBallModel(pitch.getWidth() / 2, pitch.getLength() / 2);
		connection = new ClientConnectionModel(9999, "localhost", null, null);
		users = new ClientUsersModel();
		init = new ClientInitModel();
		setControlSet(new ClientControlSetModel());
		setControlGame(new ClientControlGameModel());
	}

	/**
	 * Stops the paper-ball.
	 */
	public void stop()
	{
		ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
				EnumUpdate.SETTINGS_VIEW);
		setChanged();
		notifyObservers(infoView);
	}

	public void refreshUpdate(ClientUpdate info)
	{
		this.setChanged();
		this.notifyObservers(info);
	}

	/**
	 * @return the pitch
	 */
	public ClientPitchModel getPitch()
	{
		return pitch;
	}

	/**
	 * @param pitch
	 *           the pitch to set
	 */
	public void setPitch(ClientPitchModel pitch)
	{
		this.pitch = pitch;
	}

	/**
	 * @return the game
	 */
	public ClientGameModel getGame()
	{
		return game;
	}

	/**
	 * @param game
	 *           the game to set
	 */
	public void setGame(ClientGameModel game)
	{
		this.game = game;
	}

	/**
	 * @return the ball
	 */
	public ClientBallModel getBall()
	{
		return ball;
	}

	/**
	 * @param ball
	 *           the ball to set
	 */
	public void setBall(ClientBallModel ball)
	{
		this.ball = ball;
	}

	/**
	 * @return the connection
	 */
	public ClientConnectionModel getConnection()
	{
		return connection;
	}

	/**
	 * @param connection
	 *           the connection to set
	 */
	public void setConnection(ClientConnectionModel connection)
	{
		this.connection = connection;
	}

	/**
	 * @return the init
	 */
	public ClientInitModel getInit()
	{
		return init;
	}

	/**
	 * @param init
	 *           the init to set
	 */
	public void setInit(ClientInitModel init)
	{
		this.init = init;
	}

	/**
	 * @return the users
	 */
	public ClientUsersModel getUsers()
	{
		return users;
	}

	/**
	 * @param users
	 *           the users to set
	 */
	public void setUsers(ClientUsersModel users)
	{
		this.users = users;
	}

	/**
	 * @return the controlSet
	 */
	public ClientControlSetModel getControlSet()
	{
		return controlSet;
	}

	/**
	 * @param controlSet
	 *           the controlSet to set
	 */
	public void setControlSet(ClientControlSetModel controlSet)
	{
		this.controlSet = controlSet;
	}

	/**
	 * @return the controlGame
	 */
	public ClientControlGameModel getControlGame()
	{
		return controlGame;
	}

	/**
	 * @param controlGame the controlGame to set
	 */
	public void setControlGame(ClientControlGameModel controlGame)
	{
		this.controlGame = controlGame;
	}
}
