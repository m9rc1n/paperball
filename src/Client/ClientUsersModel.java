package Client;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

public class ClientUsersModel
{
	private ArrayList<String>			listOfUsers;
	private JList<String>				list;
	private DefaultListModel<String>	listModel;
	private TitledBorder					usersInfo;

	ClientUsersModel()
	{
		setListOfUsers(new ArrayList<String>());
		setListModel(new DefaultListModel<String>());
		setList(new JList<String>(getListModel()));
		getList().setAutoscrolls(true);

		getList().setBackground(new Color(EnumColor.LABEL.getValue()));
		getList().setForeground(new Color(EnumColor.FOREGROUND.getValue()));

		getList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getList().setSelectedIndex(0);
		list.setVisibleRowCount(5);
		
		setUsersInfo(BorderFactory.createTitledBorder("USERS WAITING FOR THE GAME"));
		list.setBorder(getUsersInfo());
	}

	/**
	 * @return the listOfUsers
	 */
	protected ArrayList<String> getListOfUsers()
	{
		return listOfUsers;
	}

	/**
	 * @param listOfUsers
	 *           the listOfUsers to set
	 */
	protected void setListOfUsers(ArrayList<String> listOfUsers)
	{
		this.listOfUsers = listOfUsers;
	}

	/**
	 * @return the list
	 */
	public JList<String> getList()
	{
		return list;
	}

	/**
	 * @param list
	 *           the list to set
	 */
	public void setList(JList<String> list)
	{
		this.list = list;
	}

	/**
	 * @return the listModel
	 */
	public DefaultListModel<String> getListModel()
	{
		return listModel;
	}

	/**
	 * @param listModel
	 *           the listModel to set
	 */
	public void setListModel(DefaultListModel<String> listModel)
	{
		this.listModel = listModel;
	}

	/**
	 * @return the usersInfo
	 */
	public TitledBorder getUsersInfo()
	{
		return usersInfo;
	}

	/**
	 * @param usersInfo the usersInfo to set
	 */
	public void setUsersInfo(TitledBorder usersInfo)
	{
		this.usersInfo = usersInfo;
	}

}
