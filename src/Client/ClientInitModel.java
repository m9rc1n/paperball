package Client;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ClientInitModel
{

	private JLabel					enterLogin;
	private JTextField			textLogin;
	private JLabel					enterPort;
	private JTextField			textPort;
	private JButton				start;
	private String					userLogin;
	private EnumStatus			userStatus;
	private JLabel					info;
	
	
	/**
	 * @param enterLogin
	 * @param textLogin
	 * @param enterPort
	 * @param textPort
	 * @param start
	 */
	ClientInitModel()
	{
		enterLogin = new JLabel("Enter your login");
		textLogin = new JTextField(20);
		
		enterPort = new JLabel("Enter Server's port");
		textPort = new JTextField("9999", 6);
		
		start = new JButton("Start PaperBall Game!");
		start.setForeground(new Color(EnumColor.FOREGROUND.getValue()));
		start.setBackground(new Color(EnumColor.BUTTON.getValue()));
		
		userLogin = new String();
		
		info = new JLabel("Welcome, enter data and click Start to play the PaperBall!");
		
		setUserStatus(EnumStatus.CHOOSING);
	}
	/**
	 * @return the enterLogin
	 */
	protected JLabel getEnterLogin()
	{
		return enterLogin;
	}
	/**
	 * @return the textLogin
	 */
	protected JTextField getTextLogin()
	{
		return textLogin;
	}
	/**
	 * @return the enterPort
	 */
	protected JLabel getEnterPort()
	{
		return enterPort;
	}
	/**
	 * @return the textPort
	 */
	protected JTextField getTextPort()
	{
		return textPort;
	}
	/**
	 * @return the start
	 */
	protected JButton getStart()
	{
		return start;
	}
	/**
	 * @param enterLogin the enterLogin to set
	 */
	protected void setEnterLogin(JLabel enterLogin)
	{
		this.enterLogin = enterLogin;
	}
	/**
	 * @param textLogin the textLogin to set
	 */
	protected void setTextLogin(JTextField textLogin)
	{
		this.textLogin = textLogin;
	}
	/**
	 * @param enterPort the enterPort to set
	 */
	protected void setEnterPort(JLabel enterPort)
	{
		this.enterPort = enterPort;
	}
	/**
	 * @param textPort the textPort to set
	 */
	protected void setTextPort(JTextField textPort)
	{
		this.textPort = textPort;
	}
	/**
	 * @param start the start to set
	 */
	protected void setStart(JButton start)
	{
		this.start = start;
	}
	/**
	 * @return the userLogin
	 */
	protected String getUserLogin()
	{
		return userLogin;
	}
	/**
	 * @return the userStatus
	 */
	protected EnumStatus getUserStatus()
	{
		return userStatus;
	}
	/**
	 * @param userLogin the userLogin to set
	 */
	protected void setUserLogin(String userLogin)
	{
		this.userLogin = userLogin;
	}
	/**
	 * @param userStatus the userStatus to set
	 */
	protected void setUserStatus(EnumStatus userStatus)
	{
		this.userStatus = userStatus;
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
}
