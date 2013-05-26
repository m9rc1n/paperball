package Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 */

/**
 * @author marcinn
 * 
 */
public class ClientControlSetView extends JPanel implements ActionListener
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 6095717070826865522L;

	/**
	 * @param control
	 * @param model
	 */

	private ClientModel			model;
	private ClientController	controller;

	public ClientControlSetView(ClientModel model, ClientController controller,
			int width, int heigth)
	{

		setBackground(new Color(EnumColor.BACKGROUND.getValue()));

		this.setModel(model);
		this.setController(controller);

		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		setSize(width, heigth);

		c.ipadx = 40;
		c.ipady = 40;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		getModel().getControlSet().getStartGame().setMnemonic(KeyEvent.VK_D);
		getModel().getControlSet().getStartGame().setActionCommand("start_game");
		getModel().getControlSet().getStartGame().addActionListener(this);
		add(getModel().getControlSet().getStartGame(), c);

		c.gridx = 0;
		c.gridy = 1;
		getModel().getControlSet().getUserRefresh().setMnemonic(KeyEvent.VK_D);
		getModel().getControlSet().getUserRefresh()
				.setActionCommand("refresh_users");
		getModel().getControlSet().getUserRefresh().addActionListener(this);
		add(getModel().getControlSet().getUserRefresh(), c);

		c.gridx = 0;
		c.gridy = 2;
		getModel().getControlSet().getCloseConnection()
				.setMnemonic(KeyEvent.VK_D);
		getModel().getControlSet().getCloseConnection()
				.setActionCommand("close_connection");
		getModel().getControlSet().getCloseConnection().addActionListener(this);
		add(getModel().getControlSet().getCloseConnection(), c);

		c.gridx = 0;
		c.gridy = 3;
		getModel().getControlSet().getQuitProgram().setMnemonic(KeyEvent.VK_D);
		getModel().getControlSet().getQuitProgram()
				.setActionCommand("quit_program");
		getModel().getControlSet().getQuitProgram().addActionListener(this);
		add(getModel().getControlSet().getQuitProgram(), c);

		c.gridx = 1;
		c.gridy = 0;

		getModel().getControlSet().getUserLogin().setOpaque(true);
		getModel().getControlSet().getUserLogin()
				.setBackground(new Color(EnumColor.INFO.getValue()));
		getModel().getControlSet().getUserLogin()
				.setHorizontalAlignment(SwingConstants.CENTER);
		add(getModel().getControlSet().getUserLogin(), c);

		c.gridx = 1;
		c.gridy = 1;

		getModel().getControlSet().getUserStatus().addActionListener(this);
		getModel().getControlSet().getUserStatus().setSelectedIndex(0);
		getModel().getControlSet().getUserStatus().setActionCommand("set_status");
		add(getModel().getControlSet().getUserStatus(), c);

		c.gridx = 1;
		c.gridy = 2;

		getModel().getControlSet().getPitchWidth().addActionListener(this);
		setSelectedWidth(1);
		getModel().getControlSet().getPitchWidth().setActionCommand("set_width");
		add(getModel().getControlSet().getPitchWidth(), c);

		c.gridx = 1;
		c.gridy = 3;

		getModel().getControlSet().getPitchLength().addActionListener(this);
		setSelectedLength(1);
		getModel().getControlSet().getPitchLength()
				.setActionCommand("set_length");
		add(getModel().getControlSet().getPitchLength(), c);

		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		getModel().getControlSet().getInfo().setOpaque(true);
		getModel().getControlSet().getInfo()
				.setBackground(new Color(EnumColor.INFO.getValue()));
		getModel().getControlSet().getInfo()
				.setHorizontalAlignment(SwingConstants.CENTER);
		add(getModel().getControlSet().getInfo(), c);

	}

	public void setSelectedLength(int i)
	{

		getModel().getControlSet().getPitchLength().setSelectedIndex(4);
		getController().getControlSet().changeLength(
				(Integer) getModel().getControlSet().getPitchLength()
						.getSelectedItem());
	}

	public void setSelectedWidth(int i)
	{
		getModel().getControlSet().getPitchWidth().setSelectedIndex(i);
		getController().getControlSet().changeWidth(
				(Integer) getModel().getControlSet().getPitchWidth()
						.getSelectedItem());	
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if ("start_game".equals(event.getActionCommand()))
		{
			getController().getControlSet().startGame(
					getModel().getGame().getOpponent());
		}
		if ("close_connection".equals(event.getActionCommand()))
		{
			getController().getConnection().closeConnection();
		}
		if ("refresh_users".equals(event.getActionCommand()))
		{
			getController().getUsers().refreshUserList();
		}
		if ("quit_program".equals(event.getActionCommand()))
		{
			getController().getConnection().closeConnection();
			System.exit(0);
		}
		if ("set_status".equals(event.getActionCommand()))
		{
			@SuppressWarnings("unchecked") JComboBox<String> cb = (JComboBox<String>) event
					.getSource();
			getController().getControlSet().changeStatus(
					(String) cb.getSelectedItem());
		}
		if ("set_width".equals(event.getActionCommand()))
		{
			@SuppressWarnings("unchecked") JComboBox<Integer> cb = (JComboBox<Integer>) event
					.getSource();
			getController().getControlSet().changeWidth(
					(Integer) cb.getSelectedItem());
		}
		if ("set_length".equals(event.getActionCommand()))
		{
			@SuppressWarnings("unchecked") JComboBox<Integer> cb = (JComboBox<Integer>) event
					.getSource();
			getController().getControlSet().changeLength(
					(Integer) cb.getSelectedItem());
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
	 * @return the controller
	 */
	public ClientController getController()
	{
		return controller;
	}

	/**
	 * @param controller
	 *           the controller to set
	 */
	public void setController(ClientController controller)
	{
		this.controller = controller;
	}
}
