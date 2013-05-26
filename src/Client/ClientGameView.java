package Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientGameView extends JPanel implements KeyListener
{
	/**
	 * 
	 */

	private static final long	serialVersionUID	= -4631913683903112680L;

	private ClientPitchView				pitchView;
	private ClientControlGameView		controlView;
	private ClientModel model;
	private ClientController controller;

	public ClientGameView(ClientModel model, ClientController controller, int width, int heigth)
	{
		this.controller = controller;
		this.model = model;
		setSize(width, heigth);
	
		setBackground(new Color(EnumColor.BACKGROUND.getValue()));

		setLayout(new GridLayout());
		pitchView = new ClientPitchView(model, controller, width/2, heigth);
		controlView = new ClientControlGameView(model, controller, width/2, heigth);

		add(controlView);
		add(pitchView);
	}

	public void keyTyped(KeyEvent e)
	{}

	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == EnumKeyboard.KEY_DOWN.getValue())
		{
			getController().getGame().moveDown();
		}
		else if (e.getKeyCode() == EnumKeyboard.KEY_UP.getValue())
		{
			getController().getGame().moveUp();
		}
		else if (e.getKeyCode() == EnumKeyboard.KEY_LEFT.getValue())
		{
			getController().getGame().moveLeft();
		}
		else if (e.getKeyCode() == EnumKeyboard.KEY_RIGHT.getValue())
		{
			getController().getGame().moveRight();
		}
		else if (e.getKeyCode() == EnumKeyboard.KEY_DOWNLEFT.getValue())
		{
			getController().getGame().moveDownLeft();
		}
		else if (e.getKeyCode() == EnumKeyboard.KEY_DOWNRIGHT.getValue())
		{
			getController().getGame().moveDownRight();
		}
		else if (e.getKeyCode() == EnumKeyboard.KEY_UPLEFT.getValue())
		{
			getController().getGame().moveUpLeft();
		}
		else if (e.getKeyCode() == EnumKeyboard.KEY_UPRIGHT.getValue())
		{
			getController().getGame().moveUpRight();
		}
	}

	/** Handle the key-released event from the text field. */
	public void keyReleased(KeyEvent e)
	{}

	/**
	 * @return the pitch
	 */
	public ClientPitchView getPitch()
	{
		return pitchView;
	}

	/**
	 * @param pitch
	 *           the pitch to set
	 */
	public void setPitch(ClientPitchView pitch)
	{
		this.pitchView = pitch;
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
	 * @return the controlView
	 */
	public ClientControlGameView getControlView()
	{
		return controlView;
	}

	/**
	 * @param controlView the controlView to set
	 */
	public void setControlView(ClientControlGameView controlView)
	{
		this.controlView = controlView;
	}

}
