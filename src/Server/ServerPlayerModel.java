package Server;

import java.net.Socket;

public class ServerPlayerModel
{
	private Socket							connection;
	private ServerPlayerController	control;

	private int								idPlayer;
	private int								idGame;

	private String							login;
	private EnumStatus						status;
	
	private String							returnCode;
	private ServerMainModel				mainModel;
	
	private ServerPlayer					me;
	private ServerPlayer					opponent;
	private ServerGame					myGame;
	
	private boolean						iStartedGame;


	public ServerPlayerModel(ServerMainModel mainModel, Socket socket, ServerPlayer me)
	{
		this.setConnection(socket);
		idPlayer = -1;
		setIdGame(-1);
		setMainModel(mainModel);
		setReturnCode(new String(""));
		setLogin(new String(""));
		setStatus(EnumStatus.CHOOSING);
	}


	/**
	 * @return the connection
	 */
	public Socket getConnection()
	{
		return connection;
	}


	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Socket connection)
	{
		this.connection = connection;
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


	/**
	 * @return the idPlayer
	 */
	public int getIdPlayer()
	{
		return idPlayer;
	}


	/**
	 * @param idPlayer the idPlayer to set
	 */
	public void setIdPlayer(int idPlayer)
	{
		this.idPlayer = idPlayer;
	}


	/**
	 * @return the idGame
	 */
	public int getIdGame()
	{
		return idGame;
	}


	/**
	 * @param idGame the idGame to set
	 */
	public void setIdGame(int idGame)
	{
		this.idGame = idGame;
	}


	/**
	 * @return the login
	 */
	public String getLogin()
	{
		return login;
	}


	/**
	 * @param login the login to set
	 */
	public void setLogin(String login)
	{
		this.login = login;
	}


	/**
	 * @return the status
	 */
	public EnumStatus getStatus()
	{
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(EnumStatus status)
	{
		this.status = status;
	}


	/**
	 * @return the returnCode
	 */
	public String getReturnCode()
	{
		return returnCode;
	}


	/**
	 * @param returnCode the returnCode to set
	 */
	public void setReturnCode(String returnCode)
	{
		this.returnCode = returnCode;
	}


	/**
	 * @return the mainModel
	 */
	public ServerMainModel getMainModel()
	{
		return mainModel;
	}


	/**
	 * @param mainModel the mainModel to set
	 */
	public void setMainModel(ServerMainModel mainModel)
	{
		this.mainModel = mainModel;
	}


	/**
	 * @return the me
	 */
	public ServerPlayer getMe()
	{
		return me;
	}


	/**
	 * @param me the me to set
	 */
	public void setMe(ServerPlayer me)
	{
		this.me = me;
	}


	/**
	 * @return the myGame
	 */
	public ServerGame getMyGame()
	{
		return myGame;
	}


	/**
	 * @param myGame the myGame to set
	 */
	public void setMyGame(ServerGame myGame)
	{
		this.myGame = myGame;
	}


	/**
	 * @return the opponent
	 */
	public ServerPlayer getOpponent()
	{
		return opponent;
	}


	/**
	 * @param opponent the opponent to set
	 */
	public void setOpponent(ServerPlayer opponent)
	{
		this.opponent = opponent;
	}


	/**
	 * @return the iStartedGame
	 */
	public boolean isiStartedGame()
	{
		return iStartedGame;
	}


	/**
	 * @param iStartedGame the iStartedGame to set
	 */
	public void setiStartedGame(boolean iStartedGame)
	{
		this.iStartedGame = iStartedGame;
	}
}