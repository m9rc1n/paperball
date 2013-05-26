package Server;

public enum EnumNode
{
	GOAL_FIRST(1),
	GOAL_SECOND(1),
	VERTICAL_LINE(4),
	HORIZONTAL_LINE(4),
	CORNER(1),
	MIDDLE_LINE(6),
	NORMAL(8);
	;
	
	final private int value;

	private EnumNode( int value )
	{
		this.value = value;
	}
	
	/**
	 * @return the value
	 */
	public int getValue()
	{
		return value;
	}
	
}
