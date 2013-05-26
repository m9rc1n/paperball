package Server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ServerPlayerController
{
	private ServerPlayerModel	model;

	public ServerPlayerController(ServerPlayerModel model)
	{
		this.model = model;
	}

	public void setReturnCode(EnumProtocol prot)
	{
		getModel().setReturnCode(
				getModel().getReturnCode() + prot.toString() + '/');
	}

	public void setReturnCode(EnumProtocol prot, String sth)
	{
		getModel().setReturnCode(
				getModel().getReturnCode() + prot.toString() + sth + '/');
	}

	public void setRefreshUsers()
	{
		String temp = new String("");
		for (ServerPlayer i : getModel().getMainModel().getListPlayers())
		{
			if (i.getModel().getStatus() == EnumStatus.WAITING_TO_BEING_CHOOSED
					&& !i.getModel().getLogin().equals(getModel().getLogin()))
			{
				temp += EnumProtocol.USERS_REFRESH.toString()
						+ i.getModel().getLogin() + "/";
			}
		}
		getModel().setReturnCode(getModel().getReturnCode() + temp);
	}

	public int readMessage(String readMessage)
	{
		readMessage = readMessage.substring(1);
		if (readMessage.isEmpty()) return -1;
		String subMessage = new String(readMessage.substring(0, 2));
		int iter2 = readMessage.indexOf("/");
		String toAdd = new String(readMessage.substring(2, iter2));

		if (subMessage.contains(EnumProtocol.SET_LOGIN.toString()))
		{
			if (setPlayerLogin(toAdd))
			{
				setReturnCode(EnumProtocol.DONE_SET_LOGIN);
				System.out.println("CREATING PLAYR ---- " + toAdd);
			}
			else
			{
				setReturnCode(EnumProtocol.ERROR_SET_LOGIN);
				System.out.println("LOGIN ERROR SG ---- " + toAdd);
				return -1;
			}
			readMessage(readMessage.substring(iter2));
		}
		if (subMessage.contains(EnumProtocol.CLOSE_CONNECTION.toString()))
		{
			if (getModel().getMyGame() != null)
			{
				getModel().getOpponent().getControl()
						.setReturnCode(EnumProtocol.CLOSE_GAME);
				getModel()
						.getOpponent()
						.getControl()
						.sendMessage(
								getModel().getOpponent().getModel().getReturnCode());
				getModel().getMainModel().getListGames()
						.remove(getModel().getMyGame());
			}
			deleteUser();

		}
		if (subMessage.contains(EnumProtocol.CLOSE_GAME.toString()))
		{
			if (getModel().getMyGame() != null)
			{
				setReturnCode(EnumProtocol.CLOSE_GAME);
				getModel().getOpponent().getControl()
						.setReturnCode(EnumProtocol.CLOSE_GAME);
				getModel()
						.getOpponent()
						.getControl()
						.sendMessage(
								getModel().getOpponent().getModel().getReturnCode());
				System.out.println(getModel().getMainModel().getListGames().remove(getModel().getMyGame()));
			}
		}
		if (subMessage.contains(EnumProtocol.USERS_REFRESH.toString()))
		{
			setRefreshUsers();
			System.out.println("SENDING USERS  ---- " + getModel().getLogin());
		}
		if (subMessage.contains(EnumProtocol.GAME_WITH.toString()))
		{
			if (setNewGame(toAdd))
			{
				System.out.println("CREATING GAME  ---- " + getModel().getLogin()
						+ " AND " + toAdd);
				setReturnCode(EnumProtocol.DONE_GAME_CREATING);
				setReturnCode(EnumProtocol.MOVE_ME);
			}
			else
			{
				System.out.println("GAME ERROR CRG ---- " + getModel().getLogin()
						+ " AND " + toAdd);
				setReturnCode(EnumProtocol.ERROR_GAME_CREATING);
			}
			readMessage(readMessage.substring(iter2));
		}
		if (subMessage.contains(EnumProtocol.SET_STATUS_CHOOSING.toString()))
		{
			setPlayerStatus(EnumStatus.CHOOSING);
			readMessage(readMessage.substring(iter2));
		}
		if (subMessage.contains(EnumProtocol.SET_STATUS_GAMING.toString()))
		{
			setPlayerStatus(EnumStatus.GAMING_NOT_MOVING);
			readMessage(readMessage.substring(iter2));
		}
		if (subMessage.contains(EnumProtocol.SET_STATUS_WAITING.toString()))
		{
			setPlayerStatus(EnumStatus.WAITING_TO_BEING_CHOOSED);
			readMessage(readMessage.substring(iter2));
		}
		if (subMessage.contains(EnumProtocol.SET_STATUS_UNAVAILABLE.toString()))
		{
			setPlayerStatus(EnumStatus.UNAVAILABLE);
			readMessage(readMessage.substring(iter2));
		}
		if (subMessage.contains(EnumProtocol.MOVE_UP.toString()))
		{
			checkMove(EnumProtocol.MOVE_UP, toAdd);
			readMessage(readMessage.substring(iter2));
		}
		if (subMessage.contains(EnumProtocol.MOVE_DOWN.toString()))
		{
			checkMove(EnumProtocol.MOVE_DOWN, toAdd);
			readMessage(readMessage.substring(iter2));
		}
		if (subMessage.contains(EnumProtocol.MOVE_DOWNLEFT.toString()))
		{
			checkMove(EnumProtocol.MOVE_DOWNLEFT, toAdd);
			readMessage(readMessage.substring(iter2));
		}
		if (subMessage.contains(EnumProtocol.MOVE_DOWNRIGHT.toString()))
		{
			checkMove(EnumProtocol.MOVE_DOWNRIGHT, toAdd);
			readMessage(readMessage.substring(iter2));
		}
		if (subMessage.contains(EnumProtocol.MOVE_RIGHT.toString()))
		{
			checkMove(EnumProtocol.MOVE_RIGHT, toAdd);
			readMessage(readMessage.substring(iter2));
		}
		if (subMessage.contains(EnumProtocol.MOVE_UPRIGHT.toString()))
		{
			checkMove(EnumProtocol.MOVE_UPRIGHT, toAdd);
			readMessage(readMessage.substring(iter2));
		}
		if (subMessage.contains(EnumProtocol.MOVE_UPLEFT.toString()))
		{
			checkMove(EnumProtocol.MOVE_UPLEFT, toAdd);
			readMessage(readMessage.substring(iter2));
		}
		if (subMessage.contains(EnumProtocol.MOVE_LEFT.toString()))
		{
			checkMove(EnumProtocol.MOVE_LEFT, toAdd);
			readMessage(readMessage.substring(iter2));
		}
		return 0;
	}

	public void setGameMessage(EnumProtocol me, EnumProtocol meStatus,
			EnumProtocol notme, EnumProtocol notmeStatus)
	{
		setReturnCode(me);
		setReturnCode(meStatus);
		getModel().getOpponent().getControl().setReturnCode(notme);
		getModel().getOpponent().getControl().setReturnCode(notmeStatus);
		getModel().getOpponent().getControl()
				.sendMessage(getModel().getOpponent().getModel().getReturnCode());
	}

	public void checkMove(EnumProtocol move, String toAdd)
	{
		EnumProtocol checkMove = getModel().getMyGame().getControl()
				.checkMove(toAdd, getModel().isiStartedGame());

		if (checkMove == EnumProtocol.ERROR_MOVING_BALL)
		{
			setGameMessage(EnumProtocol.MOVE_ME, EnumProtocol.ERROR_MOVING_BALL,
					EnumProtocol.MOVE_OPPONENT, EnumProtocol.ERROR_MOVING_BALL);
		}
		else if (checkMove == EnumProtocol.GAME_GOAL)
		{
			setGameMessage(move, EnumProtocol.GAME_GOAL, move,
					EnumProtocol.GAME_LOSE);
		}
		else if (checkMove == EnumProtocol.GAME_LOSE)
		{
			setGameMessage(move, EnumProtocol.GAME_LOSE, move,
					EnumProtocol.GAME_GOAL);
		}
		else if (checkMove == EnumProtocol.GAME_OVER_MOVE)
		{
			setGameMessage(move, EnumProtocol.GAME_OVER_MOVE, move,
					EnumProtocol.GAME_WIN);
		}
		else if (checkMove == EnumProtocol.GAME_MOVE)
		{
			if (getModel().getStatus() == EnumStatus.GAMING_MOVING)
			{
				setGameMessage(EnumProtocol.MOVE_ME, move,
						EnumProtocol.MOVE_OPPONENT, move);
			}
			else if (getModel().getStatus() == EnumStatus.GAMING_NOT_MOVING)
			{
				setGameMessage(EnumProtocol.MOVE_OPPONENT, move,
						EnumProtocol.MOVE_ME, move);
			}
		}
	}

	private void deleteUser()
	{
		getModel().setReturnCode("");
		System.out.println("LOGGING OUT    ---- " + model.getLogin());
		getModel().getMainModel().getListPlayers().remove(getModel().getMe());
	}

	private boolean setNewGame(String message)
	{
		int indexWid = message.indexOf('-');
		int indexLen = message.indexOf(':');

		String opp = message.substring(0, indexWid);

		System.out.println(opp);

		int width = Integer.parseInt(message.substring(indexWid + 1, indexLen));
		int length = Integer.parseInt(message.substring(indexLen + 1));

		for (ServerPlayer opponent : getModel().getMainModel().getListPlayers())
		{
			if (opponent.getModel().getLogin().equals(opp))
			{
				if (opponent.getModel().getStatus() == EnumStatus.WAITING_TO_BEING_CHOOSED)
				{
					ServerGame newGame = new ServerGame(getModel().getMe(), opponent, width, length);

					getModel().setOpponent(opponent);
					getModel().setMyGame(newGame);
					getModel().setiStartedGame(true);

					getModel().setStatus(EnumStatus.GAMING_MOVING);
					getModel().getOpponent().getModel()
							.setStatus(EnumStatus.GAMING_NOT_MOVING);

					getModel().getOpponent().getModel().setMyGame(newGame);
					getModel().getOpponent().getModel().setiStartedGame(false);
					getModel().getMainModel().getListGames().add(newGame);

					getModel().getOpponent().getModel()
							.setOpponent(getModel().getMe());

					getModel()
							.getOpponent()
							.getControl()
							.setReturnCode(EnumProtocol.GAME_WITH,
									getModel().getLogin() + "-" + width + ":" + length);
					getModel().getOpponent().getControl()
							.sendMessage(opponent.getModel().getReturnCode());

					return true;
				}
			}
		}
		return false;
	}

	public boolean setPlayerLogin(String login)
	{
		for (ServerPlayer i : getModel().getMainModel().getListPlayers())
		{
			if (i.getModel().getLogin().equals(login)) { return false; }
		}

		getModel().getMe().getModel().setLogin(login);
		return true;
	}

	public void setPlayerStatus(EnumStatus status)
	{
		getModel().getMe().getModel().setStatus(status);
	}

	public void sendMessage(String message)
	{
		try
		{
			BufferedOutputStream bos = new BufferedOutputStream(model
					.getConnection().getOutputStream());
			OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");

			osw.write(message + (char) 13);
			osw.flush();
			getModel().setReturnCode("");

		}
		catch (IOException f)
		{
			System.out.println("IO-EXCEPTION   ---- " + f);
		}
		catch (Exception g)
		{
			System.out.println("SEND-EXCEPTION ---- " + g);
		}
	}

	public void closeConnection()
	{
		try
		{
			getModel().setReturnCode("");
			System.out.println("LOGGING OUT    ---- " + model.getLogin());
			model.getConnection().close();
			deleteUser();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void readSocket()
	{
		StringBuffer instr = new StringBuffer();
		BufferedInputStream bis;
		try
		{
			System.out.println("READING FROM   ---- " + model.getLogin());
			bis = new BufferedInputStream(model.getConnection().getInputStream());

			InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");

			int c = '/';
			int i = 0;
			do
			{
				if (c == 13)
				{
					if (readMessage(new String(instr)) == -1)
					{

						sendMessage(getModel().getReturnCode());
					}
					if (!getModel().getReturnCode().contains(
							EnumProtocol.CLOSE_CONNECTION.toString()))
					{
						sendMessage(getModel().getReturnCode());
					}
					getModel().setReturnCode("");
					instr.delete(0, i);
					i = 0;
				}
				instr.append((char) c);
				i++;

			}
			while ((c = isr.read()) != EnumProtocol.CLOSE_CONNECTION.toString()
					.indexOf(0));

		}
		catch (IOException f)
		{
			System.out.println("IOException :::: " + f);
		}
		catch (Exception g)
		{
			System.out.println("Exception :::: " + g);
		}
	}

	/**
	 * @return the model
	 */
	protected ServerPlayerModel getModel()
	{
		return model;
	}

	/**
	 * @param model
	 *           the model to set
	 */
	protected void setModel(ServerPlayerModel model)
	{
		this.model = model;
	}
}
