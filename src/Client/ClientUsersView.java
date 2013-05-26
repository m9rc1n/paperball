package Client;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 */

/**
 * @author marcinn
 * 
 */
public class ClientUsersView extends JPanel implements ListSelectionListener
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -4108289276865163600L;

	/**
	 * @param control
	 * @param model
	 * @param string
	 * @param clientMainView
	 * 
	 */
	GridBagConstraints			c;

	private ClientController	controller;
	private ClientModel			model;

	public ClientUsersView(ClientModel model, ClientController controller,
			int width, int heigth)
	{
		setModel(model);

		setBackground(new Color(EnumColor.BACKGROUND.getValue()));

		setLayout(new GridBagLayout());
		setSize(width, heigth);

		c = new GridBagConstraints();

		c.ipadx = 20;
		c.ipady = 20;
		c.gridwidth = width - 20;

		this.setAutoscrolls(true);

		c.fill = GridBagConstraints.HORIZONTAL;

		getModel().getUsers().getList().addListSelectionListener(this);
		JScrollPane listScrollPane = new JScrollPane(getModel().getUsers()
				.getList());

		c.gridx = 0;
		c.gridy = 0;

		add(getModel().getUsers().getList(), c);

		c.gridx = 1;
		c.gridy = 0;
		add(listScrollPane, c);

	}

	void addUsers(ArrayList<String> users)
	{
		getModel().getUsers().getListModel().clear();
		for (int i = 0; i < users.size(); i++)
		{
			getModel().getUsers().getListModel().addElement(users.get(i));
			revalidate();
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
	 * @param controller
	 *           the controller to set
	 */
	public void setController(ClientController controller)
	{
		this.controller = controller;
	}

	/**
	 * @return the controller
	 */
	public ClientController getController()
	{
		return controller;
	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		if (e.getValueIsAdjusting() == false)
		{

			int index = getModel().getUsers().getList().getSelectedIndex();
			getModel().getGame().setOpponent(
					getModel().getUsers().getListModel().get(index));
			if (index == -1)
			{
				getModel().getControlSet().getStartGame().setEnabled(false);

			}
			else
			{
				getModel().getControlSet().getStartGame().setEnabled(true);
			}
		}

	}
}
