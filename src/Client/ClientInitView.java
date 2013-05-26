package Client;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.Keymap;

/**
 * @author marcinn
 * 
 */
public class ClientInitView extends JPanel implements ActionListener,
		KeyListener
{

	/**
	 * 
	 */

	private static final long	serialVersionUID	= -4108289276865163600L;
	private ClientModel model;
	private ClientController controller;

	public ClientInitView(ClientModel model, ClientController controller)
	{
		this.model = model;
		this.controller = controller;
		
		setLayout(new GridBagLayout());
		setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		setBackground(new Color(EnumColor.BACKGROUND.getValue()));
		
		GridBagConstraints c = new GridBagConstraints();
		
		model.getInit().getStart().setActionCommand("start");
		model.getInit().getStart().addActionListener(this);

		c.ipadx = 20;
		c.ipady = 20;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		this.add(model.getInit().getEnterLogin(), c);
		
		c.gridx = 1;
		c.gridy = 0;
		this.add(model.getInit().getTextLogin(), c);

		c.gridx = 0;
		c.gridy = 1;
		this.add(model.getInit().getEnterPort(), c);
		
		c.gridx = 1;
		c.gridy = 1;
		this.add(model.getInit().getTextPort(), c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		this.add(model.getInit().getStart(), c);

		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		c.gridheight = 2;
		
		model.getInit().getInfo().setOpaque(true);
		model.getInit().getInfo().setBackground( new Color(EnumColor.INFO.getValue()));
		model.getInit().getInfo().setHorizontalAlignment(SwingConstants.CENTER);
		this.add(model.getInit().getInfo(), c);
		
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if ("start".equals(event.getActionCommand()))
		{
			getController().getInit().startSettings(
					getModel().getInit().getTextLogin().getText(),
					getModel().getInit().getTextPort().getText());

		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		System.out.println("oki doki" + e.getKeyCode());
		if (e.getKeyCode() == EnumKeyboard.ENTER.getValue())
		{
			getController().getInit().startSettings(
					getModel().getInit().getTextLogin().getText(),
					getModel().getInit().getTextPort().getText());
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{}

	@Override
	public void keyTyped(KeyEvent e)
	{}

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
}
