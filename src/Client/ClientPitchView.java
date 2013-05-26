package Client;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class ClientPitchView extends JPanel
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -956314591416511808L;
	private ClientBallView		ballView;
	private ClientModel			model;
	private ClientController	controller;

	public ClientPitchView(ClientModel model, ClientController controller,
			int width, int heigth)
	{
		setSize(width, heigth);
		setBallView(new ClientBallView(model, controller, width, heigth));
		setBackground(new Color(EnumColor.BACKGROUND.getValue()));
	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		Graphics b = ballView.getGraphics();
		ballView.paintPitch(b);
		paintImage(g, false);
	}

	public void paintImage(Graphics g, boolean reset)
	{
		if (reset == false)
		{
			Graphics b = ballView.getGraphics();
			ballView.paintLine(b);
			ballView.paintNextBall(b);
			g.drawImage(ballView, 0, 0, null);
		}
		else
		{
			Graphics b = ballView.getGraphics();
			ballView.resetPitch(b);
			g.drawImage(ballView, 0, 0, null);
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

	/**
	 * @return the ballView
	 */
	protected ClientBallView getBallView()
	{
		return ballView;
	}

	/**
	 * @param ballView
	 *           the ballView to set
	 */
	protected void setBallView(ClientBallView ballView)
	{
		this.ballView = ballView;
	}

}
