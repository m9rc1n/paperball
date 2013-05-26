package Client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientConnectionController
{

	private ClientModel	model;

	public ClientConnectionController(ClientModel model)
	{
		setModel(model);
	}

	public void initConnection()
	{
		try
		{
			getModel().getConnection().setAddress(
					InetAddress.getByName(getModel().getConnection().getHost()));
		}
		catch (UnknownHostException e)
		{
			System.out.println("Error in getting host");
			e.printStackTrace();
		}
		try
		{
			getModel().getConnection().setSocket(
					new Socket(getModel().getConnection().getAddress(), getModel()
							.getConnection().getPort()));
			System.out.println("Socket in Client initialized");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public String sendMessage(String message)
	{
		try
		{
			BufferedOutputStream bos = new BufferedOutputStream(getModel()
					.getConnection().getSocket().getOutputStream());
			OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");

			osw.write(message + (char) 13);
			System.out.println("Message send to Server: " + message);
			osw.flush();

		}
		catch (IOException f)
		{
			System.out.println("IOException: " + f);
		}
		catch (Exception g)
		{
			System.out.println("Exception: " + g);
		}
		return message;
	}

	public String readMessage()
	{

		StringBuffer instr = new StringBuffer();
		BufferedInputStream bis;
		try
		{
			bis = new BufferedInputStream(getModel().getConnection().getSocket()
					.getInputStream());

			InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");

			int c = '/';
			do
			{
				instr.append((char) c);
			}
			while ((c = isr.read()) != 13);
		}
		catch (IOException f)
		{
			System.out.println("IOException: " + f);
		}
		catch (Exception g)
		{
			System.out.println("Exception: " + g);
		}
		return new String(instr);
	}

	public String waitingForGame()
	{

		StringBuffer instr = new StringBuffer();
		BufferedInputStream bis;
		try
		{
			bis = new BufferedInputStream(getModel().getConnection().getSocket()
					.getInputStream());

			InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");

			int c = '/';
			do
			{
				instr.append((char) c);
			}
			while ((c = isr.read()) != 13);
		}
		catch (IOException f)
		{
			System.out.println("IOException: " + f);
		}
		catch (Exception g)
		{
			System.out.println("Exception: " + g);
		}
		System.out.println(new String(instr));
		return new String(instr);
	}

	public void closeConnection()
	{
		try
		{

			ClientUpdate infoView = new ClientUpdate(EnumUpdate.FRAME_CHANGED, EnumUpdate.INIT_VIEW);
			getModel().refreshUpdate(infoView);
			sendMessage(EnumProtocol.CLOSE_CONNECTION.toString() + "/");
			getModel().getConnection().getSocket().close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
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

}
