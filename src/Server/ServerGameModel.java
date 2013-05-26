package Server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * 
 */

/**
 * @author marcinn
 * 
 */
public class ServerGameModel extends Observable
{

	/**
	 * @param args
	 */

	private int									width;
	private int									length;

	private ServerPlayer						playerOne;
	private ServerPlayer						playerTwo;

	private Map<String, Boolean>			mapNodesConnection;
	private ArrayList<ArrayList<Node>>	tableNodes;

	private String								returnCode;

	ServerGameModel(ServerPlayer playerOne, ServerPlayer playerTwo, int width, int length)
	{
		setPlayerOne(playerOne);
		setPlayerTwo(playerTwo);

		setLength(length);
		setWidth(width);
		
		tableNodes = new ArrayList<ArrayList<Node>>();

		mapNodesConnection = new HashMap<String, Boolean>(width * length);

		for (int i = 0; i < width; i++)
		{
			ArrayList<Node> list = new ArrayList<Node>();
			tableNodes.add(list);
			for (int j = 0; j < length; j++)
			{
				list.add(new Node());
			}
		}
		initNodes();
	}

	public void initNodes()
	{
		int halfWidth = getWidth() / 2;

		for (int i = 0; i < getWidth(); i++)
		{
			for (int j = 0; j < getLength(); j++)
			{
				if (j == 0 || j == getLength() - 1)
				{
					if (i == 0 || i == getWidth() - 1)
					{
						tableNodes.get(i).get(j).setStatus(EnumNode.CORNER);
					}
					else
					{
						tableNodes.get(i).get(j).setCounter(1);
						tableNodes.get(i).get(j).setStatus(EnumNode.HORIZONTAL_LINE);
					}
				}
				if (i == 0 || i == getWidth() - 1)
				{
					if (j == 0 || j == getLength() - 1)
					{
						tableNodes.get(i).get(j).setStatus(EnumNode.CORNER);
					}
					else
					{
						tableNodes.get(i).get(j).setCounter(1);
						tableNodes.get(i).get(j).setStatus(EnumNode.VERTICAL_LINE);
					}
				}

				if (i == halfWidth && j == 0)
				{
					tableNodes.get(i).get(j).setCounter(1);
					tableNodes.get(i).get(j).setStatus(EnumNode.GOAL_FIRST);
				}

				if (i == halfWidth && j == getLength() - 1)
				{
					tableNodes.get(i).get(j).setCounter(1);
					tableNodes.get(i).get(j).setStatus(EnumNode.GOAL_SECOND);
				}

				System.out.print(tableNodes.get(i).get(j).getStatus().getValue()
						+ " ");
			}
			System.out.println();
		}
	}

	/**
	 * @return the mapNodesConnection
	 */
	public Map<String, Boolean> getMapNodesConnection()
	{
		return mapNodesConnection;
	}

	public void fds()
	{

		setChanged();
		notifyObservers();
	}

	/**
	 * @return the width
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * @param width
	 *           the width to set
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}

	/**
	 * @return the length
	 */
	public int getLength()
	{
		return length;
	}

	/**
	 * @param length
	 *           the length to set
	 */
	public void setLength(int length)
	{
		this.length = length;
	}

	public String getReturnCode()
	{
		return returnCode;
	}

	/**
	 * @return the playerOne
	 */
	public ServerPlayer getPlayerOne()
	{
		return playerOne;
	}

	/**
	 * @param playerOne
	 *           the playerOne to set
	 */
	public void setPlayerOne(ServerPlayer playerOne)
	{
		this.playerOne = playerOne;
	}

	/**
	 * @return the playerTwo
	 */
	public ServerPlayer getPlayerTwo()
	{
		return playerTwo;
	}

	/**
	 * @param playerTwo
	 *           the playerTwo to set
	 */
	public void setPlayerTwo(ServerPlayer playerTwo)
	{
		this.playerTwo = playerTwo;
	}

	/**
	 * @return the tableNodes
	 */
	public ArrayList<ArrayList<Node>> getTableNodes()
	{
		return tableNodes;
	}

	/**
	 * @param tableNodes
	 *           the tableNodes to set
	 */
	public void setTableNodes(ArrayList<ArrayList<Node>> tableNodes)
	{
		this.tableNodes = tableNodes;
	}

}
