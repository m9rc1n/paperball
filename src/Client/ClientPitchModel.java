package Client;

public class ClientPitchModel
{
	private int width;
	private int length;

	/**
	 * @param width
	 * @param length
	 * @param x
	 * @param y
	 * @param distance
	 */
	ClientPitchModel(int width, int length)
	{
		this.width = width;
		this.length = length;
	}

	/**
	 * @return the width
	 */
	protected int getWidth()
	{
		return width;
	}

	/**
	 * @return the length
	 */
	protected int getLength()
	{
		return length;
	}
	/**
	 * @param width the width to set
	 */
	protected void setWidth(int width)
	{
		this.width = width;
	}

	/**
	 * @param length the length to set
	 */
	protected void setLength(int length)
	{
		this.length = length;
	}
}