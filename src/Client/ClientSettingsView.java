package Client;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

/**
 * @author marcinn
 * 
 */
public class ClientSettingsView extends JPanel
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -4108289276865163600L;

	private ClientUsersView		usersView;
	private ClientControlSetView	controlView;
	
	private ClientModel model;
	private ClientController controller;

	public ClientSettingsView(ClientModel model, ClientController controller, int width, int heigth)
	{
		
		this.controller = controller;
		this.model = model;
		controlView = new ClientControlSetView(model, controller, width/2, heigth);
		usersView = new ClientUsersView(model, controller, width/2, heigth);
		
		setLayout(new GridBagLayout());
		setBackground(new Color(EnumColor.BACKGROUND.getValue()));
		
		this.setSize(width, heigth);

		GridBagConstraints c = new GridBagConstraints();

		c.ipadx = 20;
		c.ipady = 20;
		
		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 0;
		c.gridy = 0;
		this.add(controlView, c);
		
		c.gridx = 1;
		c.gridy = 0;
		this.add(usersView, c);


	}

	/**
	 * @return the usersView
	 */
	protected ClientUsersView getUsersView()
	{
		return usersView;
	}

	/**
	 * @return the controlView
	 */
	protected ClientControlSetView getControlView()
	{
		return controlView;
	}

	/**
	 * @param usersView the usersView to set
	 */
	protected void setUsersView(ClientUsersView usersView)
	{
		this.usersView = usersView;
	}

	/**
	 * @param controlView the controlView to set
	 */
	protected void setControlView(ClientControlSetView controlView)
	{
		this.controlView = controlView;
	}

	/**
	 * @return the model
	 */
	public ClientModel getModel()
	{
		return model;
	}

	/**
	 * @param model the model to set
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
	 * @param controller the controller to set
	 */
	public void setController(ClientController controller)
	{
		this.controller = controller;
	}
}
