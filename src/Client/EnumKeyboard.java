package Client;

public enum EnumKeyboard
{
	KEY_DOWN(40),
	KEY_UP(38),
	KEY_LEFT(37),
	KEY_RIGHT(39),
	KEY_DOWNLEFT(35),
	KEY_DOWNRIGHT(34),
	KEY_UPLEFT(36),
	KEY_UPRIGHT(33), 
	ENTER(10);
	
	private int value;

	/**
	 * @param value
	 */
	private EnumKeyboard(int value)
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
