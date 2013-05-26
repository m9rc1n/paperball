package Client;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ClientControlSetModel
{
	private JButton				startGame;
	private JButton				quitProgram;
	private JButton				userRefresh;
	private JButton				closeConnection;
	private JLabel					info;
	private JLabel					userLogin;
	private JComboBox<String>	userStatus;
	private JComboBox<Integer>	pitchWidth;
	private JComboBox<Integer>	pitchLength;
	private TitledBorder 		loginBor;
	private TitledBorder 		statusBor;
	private TitledBorder 		widthBor;
	private TitledBorder 		lengthBor;
	private TitledBorder 		infoBor;

	public ClientControlSetModel()
	{
		Integer[] pitchWidth =
		{ 5, 7, 9, 11, 13, 15, 17 };
		Integer[] pitchLength =
		{ 5, 7, 9, 11, 13, 15, 17, 19, 21 };
		String[] status =
		{ "CHOOSING", "WAITING FOR GAME", "UNAVAILABLE" };

		startGame = new JButton("Start Game");
		quitProgram = new JButton("Quit Program");
		userRefresh = new JButton("Refresh Users");
		closeConnection = new JButton("Close Connection");		

		startGame.setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		quitProgram.setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		userRefresh.setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		closeConnection.setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		
		startGame.setBackground(new Color(EnumColor.BUTTON.getValue()));
		quitProgram.setBackground(new Color(EnumColor.BUTTON.getValue()));
		userRefresh.setBackground(new Color(EnumColor.BUTTON.getValue()));
		closeConnection.setBackground(new Color(EnumColor.BUTTON.getValue()));
		
		setInfo(new JLabel("Welcome"));
		setUserStatus(new JComboBox<String>(status));
		setPitchWidth(new JComboBox<Integer>(pitchWidth));
		setPitchLength(new JComboBox<Integer>(pitchLength));
		setUserLogin(new JLabel(""));
		

		getPitchLength().setBackground(new Color(EnumColor.LABEL.getValue()));
		getPitchWidth().setBackground(new Color(EnumColor.LABEL.getValue()));
		getUserLogin().setBackground(new Color(EnumColor.LABEL.getValue()));
		getUserStatus().setBackground(new Color(EnumColor.LABEL.getValue()));
		getInfo().setBackground(new Color(EnumColor.INFO.getValue()));
		
		getInfo().setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		getUserStatus().setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		getPitchLength().setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		getPitchWidth().setForeground((new Color(EnumColor.FOREGROUND.getValue())));
		getUserLogin().setForeground((new Color(EnumColor.FOREGROUND.getValue())));
		
		setStatusBor(BorderFactory.createTitledBorder("STATUS"));
		setInfoBor(BorderFactory.createTitledBorder("INFO"));
		setLoginBor(BorderFactory.createTitledBorder("LOGIN"));
		setWidthBor(BorderFactory.createTitledBorder("PITCH WIDTH"));
		setLengthBor(BorderFactory.createTitledBorder("PITCH LENGTH"));
		
		getInfo().setBorder(getInfoBor());
		getPitchLength().setBorder(getLengthBor());
		getPitchWidth().setBorder(getWidthBor());
		getUserStatus().setBorder(getStatusBor());
		getUserLogin().setBorder(getLoginBor());

	}

	/**
	 * @return the startGame
	 */
	public JButton getStartGame()
	{
		return startGame;
	}

	/**
	 * @param startGame
	 *           the startGame to set
	 */
	public void setStartGame(JButton startGame)
	{
		this.startGame = startGame;
	}

	/**
	 * @return the quitProgram
	 */
	public JButton getQuitProgram()
	{
		return quitProgram;
	}

	/**
	 * @param quitProgram
	 *           the quitProgram to set
	 */
	public void setQuitProgram(JButton quitProgram)
	{
		this.quitProgram = quitProgram;
	}

	/**
	 * @return the userRefresh
	 */
	public JButton getUserRefresh()
	{
		return userRefresh;
	}

	/**
	 * @param userRefresh
	 *           the userRefresh to set
	 */
	public void setUserRefresh(JButton userRefresh)
	{
		this.userRefresh = userRefresh;
	}

	/**
	 * @return the closeConnection
	 */
	public JButton getCloseConnection()
	{
		return closeConnection;
	}

	/**
	 * @param closeConnection
	 *           the closeConnection to set
	 */
	public void setCloseConnection(JButton closeConnection)
	{
		this.closeConnection = closeConnection;
	}


	/**
	 * @return the info
	 */
	public JLabel getInfo()
	{
		return info;
	}

	/**
	 * @param info
	 *           the info to set
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
	 * @param userLogin
	 *           the userLogin to set
	 */
	public void setUserLogin(JLabel userLogin)
	{
		this.userLogin = userLogin;
	}

	/**
	 * @return the pitchWidth
	 */
	public JComboBox<Integer> getPitchWidth()
	{
		return pitchWidth;
	}

	/**
	 * @param pitchWidth
	 *           the pitchWidth to set
	 */
	public void setPitchWidth(JComboBox<Integer> pitchWidth)
	{
		this.pitchWidth = pitchWidth;
	}

	/**
	 * @return the pitchLength
	 */
	public JComboBox<Integer> getPitchLength()
	{
		return pitchLength;
	}

	/**
	 * @param pitchLength
	 *           the pitchLength to set
	 */
	public void setPitchLength(JComboBox<Integer> pitchLength)
	{
		this.pitchLength = pitchLength;
	}

	/**
	 * @return the userStatus
	 */
	public JComboBox<String> getUserStatus()
	{
		return userStatus;
	}

	/**
	 * @param jComboBox
	 *           the userStatus to set
	 */
	public void setUserStatus(JComboBox<String> jComboBox)
	{
		this.userStatus = jComboBox;
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
	 * @return the lengthBor
	 */
	public TitledBorder getLengthBor()
	{
		return lengthBor;
	}

	/**
	 * @param lengthBor the lengthBor to set
	 */
	public void setLengthBor(TitledBorder lengthBor)
	{
		this.lengthBor = lengthBor;
	}

	/**
	 * @return the withBor
	 */
	public TitledBorder getWidthBor()
	{
		return widthBor;
	}

	/**
	 * @param withBor the withBor to set
	 */
	public void setWidthBor(TitledBorder widthBor)
	{
		this.widthBor = widthBor;
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

}
