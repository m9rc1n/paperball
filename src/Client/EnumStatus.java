package Client;

public enum EnumStatus
{
	WAITING_TO_BEING_CHOOSED("w"), CHOOSING("c"), UNAVAILABLE("u"), GAMING_MOVING(
			"m"), GAMING_NOT_MOVING("n");

	private String	value;

	private EnumStatus(String value)
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

	public static EnumStatus getEnum(String m)
	{
		if (m == EnumStatus.WAITING_TO_BEING_CHOOSED.getValue())
		{
			return EnumStatus.WAITING_TO_BEING_CHOOSED;
		}
		else if (m == EnumStatus.CHOOSING.getValue())
		{
			return EnumStatus.CHOOSING;
		}
		else if (m == EnumStatus.GAMING_MOVING.getValue())
		{
			return EnumStatus.GAMING_MOVING;
		}
		else if (m == EnumStatus.GAMING_NOT_MOVING.getValue())
		{
			return EnumStatus.GAMING_NOT_MOVING;
		}
		else if (m == EnumStatus.UNAVAILABLE.getValue()) 
		{ 
			return EnumStatus.UNAVAILABLE; 
		}
		return null;
	}
}
