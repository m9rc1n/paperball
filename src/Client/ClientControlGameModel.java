package Client;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class ClientControlGameModel
{
	private JButton				quitGame;
	private JButton				closeConnection;
	private JButton				quitProgram;
	
	private JLabel					info;
	private JLabel					userLogin;
	private JLabel					oppLogin;
	private JLabel					userStatus;
	
	private TitledBorder 		loginBor;
	private TitledBorder 		opponentBor;
	private TitledBorder 		statusBor;
	private TitledBorder 		infoBor;

	public ClientControlGameModel()
	{
		
		quitGame = new JButton("Quit Game");
		quitProgram = new JButton("Quit Program");
		closeConnection = new JButton("Close Connection");
		
		quitGame.setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		quitProgram.setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		closeConnection.setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		quitGame.setBackground(new Color(EnumColor.BUTTON.getValue()));
		quitProgram.setBackground(new Color(EnumColor.BUTTON.getValue()));
		closeConnection.setBackground(new Color(EnumColor.BUTTON.getValue()));
		
		setInfo(new JLabel("Welcome!"));
		setUserLogin(new JLabel("User"));
		setUserStatus(new JLabel("Status"));
		setOppLogin(new JLabel("Opp"));
		
		getInfo().setBackground(new Color(EnumColor.INFO.getValue()));
		getInfo().setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		getUserStatus().setBackground(new Color(EnumColor.LABEL.getValue()));
		getUserStatus().setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		
		setOpponentBor(BorderFactory.createTitledBorder("OPPONENT"));
		setStatusBor(BorderFactory.createTitledBorder("STATUS"));
		setInfoBor(BorderFactory.createTitledBorder("INFO"));
		setLoginBor(BorderFactory.createTitledBorder("LOGIN"));
		
		getInfo().setBorder(getInfoBor());
		getUserStatus().setBorder(getStatusBor());
		getUserLogin().setBorder(getLoginBor());
		getOppLogin().setBorder(getOpponentBor());

	}

	/**
	 * @return the quitGame
	 */
	public JButton getQuitGame()
	{
		return quitGame;
	}

	/**
	 * @param quitGame the quitGame to set
	 */
	public void setQuitGame(JButton quitGame)
	{
		this.quitGame = quitGame;
	}

	/**
	 * @return the closeConnection
	 */
	public JButton getCloseConnection()
	{
		return closeConnection;
	}

	/**
	 * @param closeConnection the closeConnection to set
	 */
	public void setCloseConnection(JButton closeConnection)
	{
		this.closeConnection = closeConnection;
	}

	/**
	 * @return the quitProgram
	 */
	public JButton getQuitProgram()
	{
		return quitProgram;
	}

	/**
	 * @param quitProgram the quitProgram to set
	 */
	public void setQuitProgram(JButton quitProgram)
	{
		this.quitProgram = quitProgram;
	}

	/**
	 * @return the info
	 */
	public JLabel getInfo()
	{
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(JLabel info)
	{
		this.info = info;
	}

	/**
	 * @return the userLogin
	 */
	public JLabel getUserLogin()
	{
		return userLogin;
	}

	/**
	 * @param userLogin the userLogin to set
	 */
	public void setUserLogin(JLabel userLogin)
	{
		this.userLogin = userLogin;
	}

	/**
	 * @return the userStatus
	 */
	public JLabel getUserStatus()
	{
		return userStatus;
	}

	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(JLabel userStatus)
	{
		this.userStatus = userStatus;
	}

	/**
	 * @return the loginBor
	 */
	public TitledBorder getLoginBor()
	{
		return loginBor;
	}

	/**
	 * @param loginBor the loginBor to set
	 */
	public void setLoginBor(TitledBorder loginBor)
	{
		this.loginBor = loginBor;
	}

	/**
	 * @return the statusBor
	 */
	public TitledBorder getStatusBor()
	{
		return statusBor;
	}

	/**
	 * @param statusBor the statusBor to set
	 */
	public void setStatusBor(TitledBorder statusBor)
	{
		this.statusBor = statusBor;
	}

	/**
	 * @return the infoBor
	 */
	public TitledBorder getInfoBor()
	{
		return infoBor;
	}

	/**
	 * @param infoBor the infoBor to set
	 */
	public void setInfoBor(TitledBorder infoBor)
	{
		this.infoBor = infoBor;
	}

	/**
	 * @return the opponentBor
	 */
	public TitledBorder getOpponentBor()
	{
		return opponentBor;
	}

	/**
	 * @param opponentBor the opponentBor to set
	 */
	public void setOpponentBor(TitledBorder opponentBor)
	{
		this.opponentBor = opponentBor;
	}

	/**
	 * @return the oppLogin
	 */
	public JLabel getOppLogin()
	{
		return oppLogin;
	}

	/**
	 * @param oppLogin the oppLogin to set
	 */
	public void setOppLogin(JLabel oppLogin)
	{
		this.oppLogin = oppLogin;
	}

}
