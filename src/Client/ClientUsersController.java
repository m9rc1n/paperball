package Client;

import Server.EnumProtocol;

public class ClientUsersController
{
	private ClientModel						model;
	private ClientConnectionController	connect;

	public ClientUsersController(ClientModel model,
			ClientConnectionController connect)
	{
		setModel(model);
		setConnect(connect);
	}

	public void refreshUserList()
	{
		getConnect().sendMessage(EnumProtocol.USERS_REFRESH.toString() + '/');
		getModel().getUsers().getListOfUsers().clear();
		readUserList(getConnect().readMessage());
		ClientUpdate infoView = new ClientUpdate(
				EnumUpdate.LIST_OF_USERS_CHANGED, getModel().getUsers()
						.getListOfUsers());
		getModel().refreshUpdate(infoView);
	}

	public void readUserList(String readMessage)
	{
		System.out.println("Reading message from Server: " + readMessage);
		readMessage = readMessage.substring(1);
		if (readMessage.isEmpty()) return;
		String subMessage = new String(readMessage.substring(0, 2));
		int iter2 = readMessage.indexOf("/");
		if (iter2 != -1)
		{
			System.out.println(iter2);
			String login = new String(readMessage.substring(2, iter2));

			if (subMessage.contains(EnumProtocol.USERS_REFRESH.toString()))
			{
				getModel().getUsers().getListOfUsers().add(login);
				readUserList(readMessage.substring(iter2));
			}
		}
	}

	/**
	 * @return the model
	 */
	public ClientModel getModel()
	{
		return model;
	}

	/**
	 * @param model
	 *           the model to set
	 */
	public void setModel(ClientModel model)
	{
		this.model = model;
	}

	/**
	 * @return the connect
	 */
	protected ClientConnectionController getConnect()
	{
		return connect;
	}

	/**
	 * @param connect
	 *           the connect to set
	 */
	protected void setConnect(ClientConnectionController connect)
	{
		this.connect = connect;
	}

}
