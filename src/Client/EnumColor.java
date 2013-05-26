package Client;

public enum EnumColor
{
	BACKGROUND(0xA7DBD8),
	FOREGROUND(0x0),
	BUTTON(0x69D2E7),
	INFO(0xF38630),
	PLAYER(0xFF6B6B),
	PITCH(0xC7F464),
	OPPONENT(0x4ECDC4),
	BALL(0xFA6900),
	LABEL(0xE0E4CC),
	BORDER(0x0),
	NODES(0x0);
	
	private int value;

	/**
	 * @param value
	 */
	private EnumColor(int value)
	{
		this.value = value;
	}

	/**
	 * @return the value
	 */
	protected int getValue()
	{
		return value;
	}

	/**
	 * @param value the value to set
	 */
	protected void setValue(int value)
	{
		this.value = value;
	}
}
