package Client;

public enum EnumProtocol
{
	// user - server
	USERS_REFRESH("ur"),
	USERS_STATUS("us"),
	
	ERROR_SET_LOGIN("el"),
	ERROR_SET_CONNECTION("ec"),
	ERROR_OUT_BALL("eo"),
	ERROR_MOVING_BALL("em"),
	ERROR_GAME_CREATING("eg"),
	
	DONE_SET_LOGIN("dl"),
	DONE_GAME_CREATING("dg"),
	
	GAME_MOVE("gm"),
	GAME_GOAL("gg"),
	GAME_LOSE("gl"),
	GAME_OVER_MOVE("go"),
	GAME_WIN("gw"),
	
	SET_STATUS_UNAVAILABLE("su"),
	SET_STATUS_CHOOSING("sc"),
	SET_STATUS_WAITING("sw"),
	SET_STATUS_GAMING("sg"),
	
	SET_LOGIN("sl"),

	// game - server
	
	MOVE_ME("mm"),
	MOVE_OPPONENT("mo"),
	
	MOVE_UP("8m"),
	MOVE_DOWN("2m"),
	MOVE_LEFT("4m"),
	MOVE_RIGHT("6m"),
	MOVE_DOWNLEFT("1m"),
	MOVE_DOWNRIGHT("3m"),
	MOVE_UPLEFT("7m"),
	MOVE_UPRIGHT("9m"),
	
	GAME_WITH("gw"),
	GAME_QUIT("gq"),
	
	CLOSE_CONNECTION("**"),
	CLOSE_GAME("*+");
	
	// server - move

	private final String	value;

	private EnumProtocol(final String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return this.value;
	}

	@Override
	public String toString()
	{
		return getValue();
	}

}
