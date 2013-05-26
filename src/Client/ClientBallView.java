package Client;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class ClientBallView extends BufferedImage
{

	/**
	 * 
	 */

	private ClientModel	model;

	int						heigth;
	int						width;

	public ClientBallView(ClientModel model, ClientController control,
			int width, int heigth)
	{
		super(width, heigth, BufferedImage.TRANSLUCENT);

		this.width = width;
		this.heigth = heigth;
		this.model = model;
	}

	public void resetPitch(Graphics g)
	{
		g.setColor(new Color(EnumColor.PITCH.getValue()));
		g.fillRect(0, 0, width, heigth);
		paintPitch(g);
	}

	public void paintPitch(Graphics g)
	{
		int pitchWidth = getModel().getPitch().getWidth();
		int pitchLength = getModel().getPitch().getLength();
		int ballY = getModel().getBall().getY();
		int ballX = getModel().getBall().getX();
		int r = width / 40;
		int distanceWidth = (width / (pitchWidth + 5)) - r;
		int distanceLength = (heigth / (pitchLength + 5)) - r;
		int pitchY = 3 * distanceLength + 3 * r;
		int pitchX = 3 * distanceWidth + 3 * r;
		int x = pitchX + ballX * (distanceWidth + r);
		int y = pitchY + ballY * (distanceLength + r);

		/*
		g.setColor(new Color(EnumColor.PITCH.getValue()));
		g.fillRect(0, 0, width, heigth);
		*/

		g.setColor(new Color(EnumColor.NODES.getValue()));

		for (int i = 0; i < pitchWidth; i++)
			for (int j = 0; j < pitchLength; j++)
			{
				g.fillOval(pitchX + i * distanceWidth + r * i, pitchY + j
						* distanceLength + r * j, r, r);
			}

		int i = pitchWidth / 2;

		if (getModel().getGame().isUserStartedGame())
		{
			g.setColor(new Color(EnumColor.PLAYER.getValue()));
			g.drawString(getModel().getInit().getUserLogin(), i * distanceWidth
					+ r * i, pitchY / 2);
			g.setColor(new Color(EnumColor.OPPONENT.getValue()));
			g.drawString(getModel().getGame().getOpponent(), i * distanceWidth + r
					* i, 5 + pitchY + (pitchLength - 1) * distanceLength + r
					* (pitchLength - 1) + distanceLength * (pitchLength - 1));
		}
		else
		{
			g.setColor(new Color(EnumColor.OPPONENT.getValue()));
			g.drawString(getModel().getInit().getUserLogin(), pitchX + i
					* distanceWidth + r * i, 2 * pitchY + (pitchLength - 1)
					* distanceLength + r * (pitchLength - 1) + distanceLength
					* (pitchLength - 1));
			g.setColor(new Color(EnumColor.PLAYER.getValue()));
			g.drawString(getModel().getGame().getOpponent(), pitchX + i
					* distanceWidth + r * i, pitchY / 2);
		}

		g.setColor(new Color(EnumColor.PLAYER.getValue()));
		g.fillOval(pitchX + i * distanceWidth + r * i, pitchY, r, r);
		g.setColor(new Color(EnumColor.OPPONENT.getValue()));
		g.fillOval(pitchX + i * distanceWidth + r * i, pitchY + (pitchLength - 1)
				* distanceLength + r * (pitchLength - 1), r, r);

		g.setColor(new Color(EnumColor.NODES.getValue()));

		g.drawLine(pitchX + r / 2, pitchY + r / 2, pitchX + r / 2
				+ (pitchWidth / 2 - 1) * (distanceWidth + r), pitchY + r / 2);

		g.drawLine(pitchX + r / 2 + (pitchWidth / 2 + 1) * (distanceWidth + r),
				pitchY + r / 2, pitchX + r / 2 + (pitchWidth - 1)
						* (distanceWidth + r), pitchY + r / 2);

		g.drawLine(pitchX + r / 2, pitchY + (pitchLength - 1)
				* (distanceLength + r) + r / 2, pitchX + r / 2
				+ (pitchWidth / 2 - 1) * (distanceWidth + r), pitchY
				+ (pitchLength - 1) * (distanceLength + r) + r / 2);

		g.drawLine(pitchX + r / 2 + (pitchWidth / 2 + 1) * (distanceWidth + r),
				pitchY + (pitchLength - 1) * (distanceLength + r) + r / 2, pitchX
						+ r / 2 + (pitchWidth - 1) * (distanceWidth + r), pitchY
						+ (pitchLength - 1) * (distanceLength + r) + r / 2);

		g.drawLine(pitchX + r / 2, pitchY + r / 2, pitchX + r / 2, pitchY + r / 2
				+ (pitchLength - 1) * (distanceLength + r));

		g.drawLine(pitchX + (pitchWidth - 1) * (distanceWidth + r) + r / 2,
				pitchY + r / 2, pitchX + (pitchWidth - 1) * (distanceWidth + r) + r
						/ 2, pitchY + r / 2 + (pitchLength - 1)
						* (distanceLength + r));

		g.setColor(new Color(EnumColor.BALL.getValue()));
		g.fillOval(x, y, r, r);

	}

	public void paintNextBall(Graphics g)
	{
		int pitchWidth = getModel().getPitch().getWidth();
		int pitchLength = getModel().getPitch().getLength();
		int ballY = getModel().getBall().getY();
		int ballX = getModel().getBall().getX();
		int r = width / 40;
		int distanceWidth = (width / (pitchWidth + 5)) - r;
		int distanceLength = (heigth / (pitchLength + 5)) - r;
		int pitchY = 3 * distanceLength + 3 * r;
		int pitchX = 3 * distanceWidth + 3 * r;
		int x = pitchX + ballX * (distanceWidth + r);
		int y = pitchY + ballY * (distanceLength + r);
		int yOld = pitchY + getModel().getBall().getOldY() * (distanceLength + r);
		int xOld = pitchX + getModel().getBall().getOldX() * (distanceWidth + r);

		g.setColor(new Color(EnumColor.NODES.getValue()));
		g.fillOval(xOld, yOld, r, r);

		g.setColor(new Color(EnumColor.BALL.getValue()));
		g.fillOval(x, y, r, r);
	}

	public void paintLine(Graphics g)
	{
		g.setColor(new Color(EnumColor.NODES.getValue()));

		int pitchWidth = getModel().getPitch().getWidth();
		int pitchLength = getModel().getPitch().getLength();
		int ballY = getModel().getBall().getY();
		int ballX = getModel().getBall().getX();
		int r = width / 40;
		int distanceWidth = (width / (pitchWidth + 5)) - r;
		int distanceLength = (heigth / (pitchLength + 5)) - r;
		int pitchY = 3 * (distanceLength + r);
		int pitchX = 3 * (distanceWidth + r);
		int x = pitchX + ballX * (distanceWidth + r);
		int y = pitchY + ballY * (distanceLength + r);
		int yOld = pitchY + getModel().getBall().getOldY() * (distanceLength + r);
		int xOld = pitchX + getModel().getBall().getOldX() * (distanceWidth + r);

		g.drawLine(xOld + r / 2, yOld + r / 2, x + r / 2, y + r / 2);
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
}
