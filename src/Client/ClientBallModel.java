package Client;

public class ClientBallModel
{
	private int x;
	private int y;
	private int oldX;
	private int oldY;

	/**
	 * @param x
	 * @param y
	 */
	ClientBallModel(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.oldX = x;
		this.oldY = y;
	}

	/**
	 * @return the x
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x)
	{
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY()
	{
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y)
	{
		this.y = y;
	}

	/**
	 * @return the oldX
	 */
	public int getOldX()
	{
		return oldX;
	}

	/**
	 * @param oldX the oldX to set
	 */
	public void setOldX(int oldX)
	{
		this.oldX = oldX;
	}

	/**
	 * @return the oldY
	 */
	public int getOldY()
	{
		return oldY;
	}

	/**
	 * @param oldY the oldY to set
	 */
	public void setOldY(int oldY)
	{
		this.oldY = oldY;
	}
}
