package Client;

import Server.EnumProtocol;

public class ClientGameController
{

	private ClientModel						model;
	private ClientConnectionController	connect;

	public ClientGameController(ClientModel model,
			ClientConnectionController connect)
	{
		setModel(model);
		setConnect(connect);
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

	public void updateCoo(int xm, int ym)
	{
		int x = getModel().getBall().getX();
		int y = getModel().getBall().getY();

		getModel().getBall().setOldX(x);
		getModel().getBall().setOldY(y);
		getModel().getBall().setX(x + xm);
		getModel().getBall().setY(y + ym);

		ClientUpdate infoView = new ClientUpdate(EnumUpdate.BALL_CO);
		getModel().refreshUpdate(infoView);
	}

	public void updateStatus(EnumUpdate status)
	{
		ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED, status);
		getModel().refreshUpdate(infoView);
	}

	public void moveUpRight()
	{
		move(1, -1, EnumProtocol.MOVE_UPRIGHT);
	}

	public void moveUpLeft()
	{
		move(-1, -1, EnumProtocol.MOVE_UPLEFT);
	}

	public void moveDownRight()
	{
		move(1, 1, EnumProtocol.MOVE_DOWNRIGHT);
	}

	public void moveDownLeft()
	{
		move(-1, 1, EnumProtocol.MOVE_DOWNLEFT);
	}

	public void moveRight()
	{
		move(1, 0, EnumProtocol.MOVE_RIGHT);
	}

	public void moveLeft()
	{
		move(-1, 0, EnumProtocol.MOVE_LEFT);
	}

	public void moveUp()
	{
		move(0, -1, EnumProtocol.MOVE_UP);
	}

	public void moveDown()
	{
		move(0, 1, EnumProtocol.MOVE_DOWN);
	}

	public void move(int xm, int ym, EnumProtocol move)
	{
		EnumStatus userStatus = getModel().getInit().getUserStatus();
		int x = getModel().getBall().getX();
		int y = getModel().getBall().getY();

		if (userStatus == EnumStatus.GAMING_NOT_MOVING)
		{
			updateCoo(xm, ym);
		}
		else if (userStatus == EnumStatus.GAMING_MOVING)
		{
			getConnect().sendMessage(
					move.toString() + x + ":" + y + ":" + (x + xm) + ":" + (y + ym)
							+ '/');

			String message = getConnect().readMessage();

			if (message.contains(EnumProtocol.MOVE_OPPONENT.toString()))
			{
				getModel().getControlGame().getUserStatus().setText("OPPONENT MOVE");
				getModel().getControlGame().getInfo().setText("Wait fo the opponent move");
				
				updateCoo(xm, ym);
				getModel().getInit().setUserStatus(EnumStatus.GAMING_NOT_MOVING);
				updateStatus(EnumUpdate.NOT_MOVING);
				// create thread to get move from opponent
				// TODO check it please

				ClientWaitingThread wait = new ClientWaitingThread(getConnect(),
						getModel(), this);
				wait.start();
			}
			else if (message.contains(EnumProtocol.MOVE_ME.toString()))
			{
				if (message.contains(EnumProtocol.ERROR_MOVING_BALL.toString()))
				{
					getModel().getControlGame().getUserStatus().setText("YOUR MOVE");
					getModel().getControlGame().getInfo().setText("Incorrect move, try again!");
				} else {
					getModel().getControlGame().getUserStatus().setText("YOUR MOVE");
					getModel().getControlGame().getInfo().setText("OK! Bonus move is for you!");
					updateCoo(xm, ym);
				}
					getModel().getInit().setUserStatus(EnumStatus.GAMING_MOVING);
			}
			else if (message.contains(EnumProtocol.CLOSE_GAME.toString()))
			{
				ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
						EnumUpdate.SETTINGS_VIEW);
				getModel().refreshUpdate(infoView);
			}
			
			else if (message.contains(EnumProtocol.GAME_LOSE.toString()))
			{
				getModel().getControlGame().getInfo().setText("You lost, it's your own goal!");
				updateCoo(xm, ym);
				ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
						EnumUpdate.NOT_MOVING);
				getModel().refreshUpdate(infoView);
			}
			
			else if (message.contains(EnumProtocol.GAME_GOAL.toString()))
			{
				getModel().getControlGame().getInfo().setText("You win! Great goal!");
				updateCoo(xm, ym);
				ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
						EnumUpdate.NOT_MOVING);
				getModel().refreshUpdate(infoView);
			}
			
			else if (message.contains(EnumProtocol.GAME_OVER_MOVE.toString()))
			{
				getModel().getControlGame().getInfo().setText("You lose, you have no more moves");
				updateCoo(xm, ym);
				ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED,
						EnumUpdate.NOT_MOVING);
				getModel().refreshUpdate(infoView);
			}
		}
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

}
