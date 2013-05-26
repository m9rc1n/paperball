package Client;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClientView implements Observer
{

	private ClientGameView		gameView;
	private ClientInitView		initView;
	private ClientSettingsView	settingsView;

	private ClientController	control;
	private ClientModel			model;
	private JFrame	frame;

	public ClientView(ClientModel model, ClientController control)
	{
		this.setControl(control);
		this.setModel(model);
		this.setGameView(new ClientGameView(model, control, 800, 600));
		this.setSettingsView(new ClientSettingsView(model, control, 800, 600));
		this.setInitView(new ClientInitView(model, control));

		model.addObserver(this);
	}

	public void initView()
	{
		frame.add(initView);
		frame.setSize(800, 600);
		frame.getContentPane().addKeyListener(initView);
		frame.getContentPane().requestFocusInWindow();
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void update(Observable o, Object arg)
	{
		ClientUpdate info = (ClientUpdate) arg;

		if (info.getWhatChanged() == EnumUpdate.FRAME_CHANGED)
		{
			
			if (info.getActiveView() == EnumUpdate.INIT_VIEW)
			{
				frame.remove(settingsView);
				frame.remove(gameView);
				frame.add(initView);
				frame.getContentPane().removeKeyListener(gameView);
				frame.getContentPane().addKeyListener(initView);
				frame.getContentPane().requestFocusInWindow();
				frame.revalidate();
				frame.pack();
			}

			if (info.getActiveView() == EnumUpdate.GAME_VIEW_MOVING)
			{
				getModel().getControlGame().getInfo().setText("Next move is yours");
				getModel().getControlGame().getUserStatus().setText("YOUR MOVE");
				getModel().getControlGame().getUserLogin().setText(getModel().getInit().getUserLogin());
				getModel().getControlGame().getOppLogin().setText(getModel().getGame().getOpponent());
				frame.remove(settingsView);
				frame.remove(initView);
				frame.add(gameView);
				frame.getContentPane().addKeyListener(gameView);
				frame.getContentPane().removeKeyListener(initView);
				frame.getContentPane().requestFocusInWindow();
				frame.revalidate();
				frame.pack();
			}
			
			if (info.getActiveView() == EnumUpdate.GAME_VIEW_NOT_MOVING)
			{
				getModel().getControlGame().getInfo().setText("Next move is opponents");
				getModel().getControlGame().getUserStatus().setText("OPPONENT MOVE");
				getModel().getControlGame().getUserLogin().setText(getModel().getInit().getUserLogin());
				getModel().getControlGame().getOppLogin().setText(getModel().getGame().getOpponent());
				frame.remove(settingsView);
				frame.remove(initView);
				frame.add(gameView);
				frame.getContentPane().removeKeyListener(gameView);
				frame.getContentPane().removeKeyListener(initView);
				frame.getContentPane().requestFocusInWindow();
				frame.revalidate();
				frame.pack();
			}
			
			if (info.getActiveView() == EnumUpdate.NOT_MOVING)
			{
				frame.getContentPane().removeKeyListener(gameView);
				frame.getContentPane().requestFocusInWindow();
				frame.validate();
			}
			
			if (info.getActiveView() == EnumUpdate.MOVING)
			{
				frame.getContentPane().addKeyListener(gameView);
				frame.getContentPane().requestFocusInWindow();
				frame.validate();
			}

			if (info.getActiveView() == EnumUpdate.SETTINGS_VIEW)
			{
				frame.remove(initView);
				frame.remove(gameView);
				frame.add(settingsView);
				frame.getContentPane().removeKeyListener(gameView);
				getModel().getControlSet().getInfo().setText("Welcome " + getModel().getInit().getUserLogin() + " !");
				getModel().getControlSet().getUserLogin().setText(getModel().getInit().getUserLogin());
				frame.revalidate();
				frame.pack();
			}

		}

		else if (info.getWhatChanged() == EnumUpdate.LIST_OF_USERS_CHANGED)
		{
			settingsView.getUsersView().addUsers(info.getListOfUsers());
			frame.validate();
		}

		else if (info.getWhatChanged() == EnumUpdate.BALL_CO)
		{
			gameView.getPitch().paintImage(gameView.getPitch().getGraphics(), false);
		}
		else if (info.getWhatChanged() == EnumUpdate.RESET_GAME)
		{
			getSettingsView().getControlView().setSelectedLength(1);
			getSettingsView().getControlView().setSelectedWidth(1);
			gameView.getPitch().paintImage(gameView.getPitch().getGraphics(), true);
		}
	}

	/**
	 * @return the initView
	 */
	public ClientInitView getInitView()
	{
		return initView;
	}

	/**
	 * @param initView
	 *           the initView to set
	 */
	public void setInitView(ClientInitView initView)
	{
		this.initView = initView;
	}

	/**
	 * @return the control
	 */
	public ClientController getControl()
	{
		return control;
	}

	/**
	 * @param control
	 *           the control to set
	 */
	public void setControl(ClientController control)
	{
		this.control = control;
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
	 * @return the settingsView
	 */
	public ClientSettingsView getSettingsView()
	{
		return settingsView;
	}

	/**
	 * @param settingsView
	 *           the settingsView to set
	 */
	public void setSettingsView(ClientSettingsView settingsView)
	{
		this.settingsView = settingsView;
	}

	/**
	 * @return the gameView
	 */
	public ClientGameView getGameView()
	{
		return gameView;
	}

	/**
	 * @param gameView
	 *           the gameView to set
	 */
	public void setGameView(ClientGameView gameView)
	{
		this.gameView = gameView;
	}

	public void getFrame(Client client)
	{
		frame = client;
		initView();
	}
}
