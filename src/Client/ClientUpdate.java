package Client;

import java.util.ArrayList;

/**
 * @author
 * 
 */

/**
 * 
 * Update a game after receiving a data from model
 * 
 */
public class ClientUpdate
{

	private EnumUpdate			whatChanged;
	private EnumUpdate			activeView;

	private int						xBall;
	private int						yBall;
	private ArrayList<String>	listOfUsers;
	
	private String 				info;

	public ClientUpdate(EnumUpdate whatChanged, EnumUpdate activeView)
	{
		this.setWhatChanged(whatChanged);
		this.setActiveView(activeView);
	}

	public ClientUpdate(EnumUpdate whatChanged, ArrayList<String> listOfUsers)
	{
		this.setWhatChanged(whatChanged);
		this.setListOfUsers(listOfUsers);
	}
	
	public ClientUpdate(EnumUpdate whatChanged, EnumUpdate activeView, String info)
	{
		this.setWhatChanged(whatChanged);
		this.setActiveView(activeView);
		this.setInfo(info);
	}

	public ClientUpdate(EnumUpdate ballCo)
	{
		this.setWhatChanged(ballCo);
		// this.setXBall(xBall);
		// this.setYBall(yBall);
	}

	/**
	 * @return the xBall
	 */
	public int getXBall()
	{
		return xBall;
	}

	/**
	 * @param xBall
	 *           the xBall to set
	 */
	public void setXBall(int xBall)
	{
		this.xBall = xBall;
	}

	/**
	 * @return the listOfUsers
	 */
	public ArrayList<String> getListOfUsers()
	{
		return listOfUsers;
	}

	/**
	 * @param listOfUsers
	 *           the listOfUsers to set
	 */
	public void setListOfUsers(ArrayList<String> listOfUsers)
	{
		this.listOfUsers = listOfUsers;
	}

	/**
	 * @return the ysBall
	 */
	public int getYBall()
	{
		return yBall;
	}

	/**
	 * @param yBall
	 *           the yBall to set
	 */
	public void setYBall(int yBall)
	{
		this.yBall = yBall;
	}

	/**
	 * @return the whatChanged
	 */
	public EnumUpdate getWhatChanged()
	{
		return whatChanged;
	}

	/**
	 * @param whatChange
	 *           the whatChanged to set
	 */
	public void setWhatChanged(EnumUpdate whatChange)
	{
		this.whatChanged = whatChange;
	}

	/**
	 * @return the activeView
	 */
	public EnumUpdate getActiveView()
	{
		return activeView;
	}

	/**
	 * @param activeView
	 *           the activeView to set
	 */
	public void setActiveView(EnumUpdate activeView)
	{
		this.activeView = activeView;
	}

	/**
	 * @return the info
	 */
	public String getInfo()
	{
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info)
	{
		this.info = info;
	}

}
