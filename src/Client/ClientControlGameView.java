package Client;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 */

/**
 * @author marcinn
 * 
 */
public class ClientControlGameView extends JPanel implements ActionListener
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

	public ClientControlGameView(ClientModel model, ClientController controller,
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
		getModel().getControlGame().getUserLogin().setOpaque(true);
		getModel().getControlGame().getUserLogin().setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		if (getModel().getGame().isUserStartedGame())
		{
			getModel().getControlGame().getUserLogin().setBackground(new Color(EnumColor.PLAYER.getValue()));
		}
		else
		{
			getModel().getControlGame().getUserLogin().setBackground(new Color(EnumColor.OPPONENT.getValue()));
		}
		getModel().getControlGame().getUserLogin()
				.setHorizontalAlignment(SwingConstants.CENTER);
		add(getModel().getControlGame().getUserLogin(), c);

		c.gridx = 0;
		c.gridy = 1;
		getModel().getControlGame().getOppLogin().setOpaque(true);
		getModel().getControlGame().getOppLogin().setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		if (getModel().getGame().isUserStartedGame())
		{
			getModel().getControlGame().getOppLogin().setBackground(new Color(EnumColor.OPPONENT.getValue()));
		}
		else
		{
			getModel().getControlGame().getOppLogin().setBackground(new Color(EnumColor.PLAYER.getValue()));
		}
		getModel().getControlGame().getOppLogin()
				.setHorizontalAlignment(SwingConstants.CENTER);
		add(getModel().getControlGame().getOppLogin(), c);

		c.gridx = 0;
		c.gridy = 2;
		getModel().getControlGame().getUserStatus().setOpaque(true);
		getModel().getControlGame().getUserStatus()
				.setHorizontalAlignment(SwingConstants.CENTER);
		add(getModel().getControlGame().getUserStatus(), c);

		c.gridx = 0;
		c.gridy = 3;
		getModel().getControlGame().getInfo().setOpaque(true);
		getModel().getControlGame().getInfo()
				.setHorizontalAlignment(SwingConstants.CENTER);
		add(getModel().getControlGame().getInfo(), c);

		c.gridx = 0;
		c.gridy = 4;
		getModel().getControlGame().getQuitGame().setMnemonic(KeyEvent.VK_D);
		getModel().getControlGame().getQuitGame().setActionCommand("quit_game");
		getModel().getControlGame().getQuitGame().addActionListener(this);
		add(getModel().getControlGame().getQuitGame(), c);

		c.gridx = 0;
		c.gridy = 5;
		getModel().getControlGame().getCloseConnection()
				.setMnemonic(KeyEvent.VK_D);
		getModel().getControlGame().getCloseConnection()
				.setActionCommand("close_connection");
		getModel().getControlGame().getCloseConnection().addActionListener(this);
		add(getModel().getControlGame().getCloseConnection(), c);

		c.gridx = 0;
		c.gridy = 6;
		getModel().getControlGame().getQuitProgram().setMnemonic(KeyEvent.VK_D);
		getModel().getControlGame().getQuitProgram()
				.setActionCommand("quit_program");
		getModel().getControlGame().getQuitProgram().addActionListener(this);
		add(getModel().getControlGame().getQuitProgram(), c);

	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if ("quit_game".equals(event.getActionCommand()))
		{
			// send quit game
			// return to the settings
			ClientUpdate infoView = new ClientUpdate(EnumUpdate.RESET_GAME);
			getModel().refreshUpdate(infoView);
			getController().getControlSet().stopGame();
		}
		if ("close_connection".equals(event.getActionCommand()))
		{
			// return to the init
			ClientUpdate infoView = new ClientUpdate(EnumUpdate.RESET_GAME);
			getModel().refreshUpdate(infoView);
			getController().getConnection().closeConnection();
		}
		if ("quit_program".equals(event.getActionCommand()))
		{	
			// close program
			getController().getConnection().closeConnection();
			System.exit(0);
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
