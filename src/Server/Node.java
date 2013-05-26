package Server;

public class Node
{
	private EnumNode status;
	private int counter;
	
	public Node()
	{
		status = EnumNode.NORMAL;
		counter = 0;
	}

	/**
	 * @return the status
	 */
	public EnumNode getStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(EnumNode status)
	{
		this.status = status;
	}

	/**
	 * @return the counter
	 */
	public int getCounter()
	{
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int counter)
	{
		this.counter = counter;
	}
}
