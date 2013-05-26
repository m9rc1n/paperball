package Client;

public class ClientWaitingThread extends Thread
{
	private ClientConnectionController	connect;
	private ClientModel						model;
	private ClientGameController			game;

	public ClientWaitingThread(ClientConnectionController connect,
			ClientModel model, ClientGameController game)
	{
		super("Waiting for Server");
		setConnect(connect);
		setModel(model);
		setGame(game);
	}

	public void run()
	{
		EnumStatus myStatus = getModel().getInit().getUserStatus();
		while (myStatus == EnumStatus.WAITING_TO_BEING_CHOOSED
				|| myStatus == EnumStatus.GAMING_NOT_MOVING)
		{
			myStatus = getModel().getInit().getUserStatus();
			String message = connect.waitingForGame();
			if (message.contains(EnumProtocol.GAME_WITH.toString()))
			{
				int indexLog = message.indexOf('/', 1);
				int indexWid = message.indexOf('-');
				int indexLen = message.indexOf(':');

				getModel().getGame().setOpponent(message.substring(2, indexWid));
				getModel().getGame().setUserStartedGame(false);

				int width = Integer.parseInt(message.substring(indexWid + 1,
						indexLen));
				int length = Integer.parseInt(message.substring(indexLen + 1,
						indexLog));

				getModel().getPitch().setWidth(width);
				getModel().getBall().setX(width / 2);
				getModel().getBall().setOldX(width / 2);

				getModel().getPitch().setLength(length);
				getModel().getBall().setY(length / 2);
				getModel().getBall().setOldY(length / 2);

				getModel().getInit().setUserStatus(EnumStatus.GAMING_NOT_MOVING);
				ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
						EnumUpdate.GAME_VIEW_NOT_MOVING);
				getModel().refreshUpdate(infoView);
				message = "";
			}
			else if (message.contains(EnumProtocol.MOVE_UP.toString()))
			{
				getGame().moveUp();
				if (checkWhatToDo(message) == false)
				{
					break;
				}
			}
			else if (message.contains(EnumProtocol.MOVE_UPRIGHT.toString()))
			{
				getGame().moveUpRight();
				if (checkWhatToDo(message) == false)
				{
					break;
				}
			}
			else if (message.contains(EnumProtocol.MOVE_UPLEFT.toString()))
			{
				getGame().moveUpLeft();
				if (checkWhatToDo(message) == false)
				{
					break;
				}
			}
			else if (message.contains(EnumProtocol.MOVE_DOWNLEFT.toString()))
			{
				getGame().moveDownLeft();
				if (checkWhatToDo(message) == false)
				{
					break;
				}
			}
			else if (message.contains(EnumProtocol.MOVE_DOWNRIGHT.toString()))
			{
				getGame().moveDownRight();
				if (checkWhatToDo(message) == false)
				{
					break;
				}
			}
			else if (message.contains(EnumProtocol.MOVE_DOWN.toString()))
			{
				getGame().moveDown();
				if (checkWhatToDo(message) == false)
				{
					break;
				}
			}
			else if (message.contains(EnumProtocol.MOVE_LEFT.toString()))
			{
				getGame().moveLeft();
				if (checkWhatToDo(message) == false)
				{
					break;
				}
			}
			else if (message.contains(EnumProtocol.MOVE_RIGHT.toString()))
			{
				getGame().moveRight();
				if (checkWhatToDo(message) == false)
				{
					break;
				}
			}
			else if (message.contains(EnumProtocol.CLOSE_GAME.toString()))
			{
				getModel().getInit().setUserStatus(EnumStatus.CHOOSING);
				ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
						EnumUpdate.SETTINGS_VIEW);
				getModel().refreshUpdate(infoView);
				infoView = new ClientUpdate(EnumUpdate.RESET_GAME);
				getModel().refreshUpdate(infoView);
				break;
			}

		}
	}

	private boolean checkWhatToDo(String message)
	{
		if (message.contains(EnumProtocol.MOVE_ME.toString()))
		{
			startTurn();
			return false;
		}
		else if (message.contains(EnumProtocol.GAME_LOSE.toString()))
		{
			gameLose();
			return false;
		}

		else if (message.contains(EnumProtocol.GAME_GOAL.toString()))
		{
			gameGoal();
			return false;
		}

		else if (message.contains(EnumProtocol.GAME_WIN.toString()))
		{
			gameWin();
			return false;
		}
		return true;
	}

	public void startTurn()
	{
		getModel().getControlGame().getInfo().setText("Next move is yours");
		getModel().getControlGame().getUserStatus().setText("YOUR MOVE");
		getModel().getInit().setUserStatus(EnumStatus.GAMING_MOVING);
		getGame().updateStatus(EnumUpdate.MOVING);
	}

	public void gameLose()
	{
		getModel().getControlGame().getInfo()
				.setText("You lost, opponent scored goal!");
		getModel().getInit().setUserStatus(EnumStatus.CHOOSING);
		ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
				EnumUpdate.NOT_MOVING);
		getModel().refreshUpdate(infoView);
	}

	public void gameWin()
	{
		getModel().getControlGame().getInfo()
				.setText("You win, opponent get has no more moves");
		getModel().getInit().setUserStatus(EnumStatus.CHOOSING);
		ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
				EnumUpdate.NOT_MOVING);
		getModel().refreshUpdate(infoView);
	}

	public void gameGoal()
	{
		getModel().getControlGame().getInfo()
				.setText("Opponent kicks to own his goal! You win!");
		getModel().getInit().setUserStatus(EnumStatus.CHOOSING);
		ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
				EnumUpdate.NOT_MOVING);
		getModel().refreshUpdate(infoView);
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
