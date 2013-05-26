package Client;

import javax.swing.JButton;

public class ClientGameModel
{
	private boolean	userStartedGame;
	private String		opponent;

	ClientGameModel()
	{
		userStartedGame = true;
	}

	/**
	 * @return the startedGame
	 */
	protected boolean isUserStartedGame()
	{
		return userStartedGame;
	}

	/**
	 * @param startedGame
	 *           the startedGame to set
	 */
	protected void setUserStartedGame(boolean userStartedGame)
	{
		this.userStartedGame = userStartedGame;
	}

	/**
	 * @return the opponent
	 */
	public String getOpponent()
	{
		return opponent;
	}

	/**
	 * @param opponent the opponent to set
	 */
	public void setOpponent(String opponent)
	{
		this.opponent = opponent;
	}
}
