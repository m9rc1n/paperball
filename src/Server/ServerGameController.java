package Server;

public class ServerGameController
{
	private ServerGameModel	model;

	public ServerGameController(ServerGameModel model)
	{
		this.setModel(model);
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
	 * This function is checking whether the move given by parameter "toAdd" is
	 * correct or not
	 * 
	 * @param toAdd
	 *           - parameter with info about new point
	 * @param startedGame
	 * @return
	 *         - true, if the move is correct (first move in the map)
	 *         - false, if the move has been already done
	 */

	public EnumProtocol checkMove(String toAdd, boolean startedGame)
	{
		// assume that we move again
		int xOld, yOld, x, y, index;

		index = toAdd.indexOf(':');

		xOld = Integer.parseInt(toAdd.substring(0, index));
		yOld = Integer.parseInt(toAdd.substring(index + 1,
				(index = toAdd.indexOf(':', index + 1))));

		x = Integer.parseInt(toAdd.substring(index + 1,
				(index = toAdd.indexOf(':', index + 1))));
		y = Integer.parseInt(toAdd.substring(index + 1));

		Edge e1 = new Edge(x, y, xOld, yOld);
		Edge e2 = new Edge(xOld, yOld, x, y);

		if (getModel().getMapNodesConnection().containsKey(e1.getEdge())) { return EnumProtocol.ERROR_MOVING_BALL; }
		if (getModel().getMapNodesConnection().containsKey(e2.getEdge())) { return EnumProtocol.ERROR_MOVING_BALL; }

		/**
		 * @param temp
		 *           - new coordinates of the ball
		 * */

		Node temp = getModel().getTableNodes().get(x).get(y);

		/**
		 * updating the status for the user
		 */

		if (temp.getCounter() == 0)
		{
			if (getModel().getPlayerOne().getModel().getStatus() == EnumStatus.GAMING_MOVING)
			{
				getModel().getPlayerOne().getModel()
						.setStatus(EnumStatus.GAMING_NOT_MOVING);
				getModel().getPlayerTwo().getModel()
						.setStatus(EnumStatus.GAMING_MOVING);
			}
			else if (getModel().getPlayerTwo().getModel().getStatus() == EnumStatus.GAMING_MOVING)
			{
				getModel().getPlayerTwo().getModel()
						.setStatus(EnumStatus.GAMING_NOT_MOVING);
				getModel().getPlayerOne().getModel()
						.setStatus(EnumStatus.GAMING_MOVING);
			}
		}

		if (temp.getCounter() < temp.getStatus().getValue())
		{
			temp.setCounter(temp.getCounter() + 1);
		}
		else
		{
			if (temp.getStatus() == EnumNode.GOAL_FIRST && startedGame == false)
			{
				System.out.println("i score zacz");
				return EnumProtocol.GAME_GOAL;
			}
			if (temp.getStatus() == EnumNode.GOAL_FIRST && startedGame == true)
			{
				System.out.println("i niescore niezacz");
				return EnumProtocol.GAME_LOSE;
			}
			if (temp.getStatus() == EnumNode.GOAL_SECOND && startedGame == true)
			{
				System.out.println("i score niezacz");
				return EnumProtocol.GAME_GOAL;
			}
			if (temp.getStatus() == EnumNode.GOAL_SECOND && startedGame == false)
			{
				System.out.println("i lose zacz");
				return EnumProtocol.GAME_LOSE;
			}
			return EnumProtocol.ERROR_MOVING_BALL;
		}

		temp = getModel().getTableNodes().get(xOld).get(yOld);

		if (temp.getCounter() < temp.getStatus().getValue())
		{
			temp.setCounter(temp.getCounter() + 1);
		}
		else
		{
			return EnumProtocol.ERROR_MOVING_BALL;
		}
		
		temp = getModel().getTableNodes().get(x).get(y);

		getModel().getMapNodesConnection().put(e1.getEdge(), true);
		getModel().getMapNodesConnection().put(e2.getEdge(), true);

		if (temp.getStatus().getValue() == temp.getCounter()-1) { return EnumProtocol.GAME_OVER_MOVE; }

		return EnumProtocol.GAME_MOVE;
	}
}
