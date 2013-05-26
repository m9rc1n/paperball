package Client;

import java.net.InetAddress;
import java.net.Socket;

public class ClientConnectionModel
{
	private int				port;
	private String			host;

	private InetAddress	address;
	private Socket			socket;

	/**
	 * @param port
	 * @param host
	 * @param address
	 * @param socket
	 */

	ClientConnectionModel(int port, String host, InetAddress address,
			Socket socket)
	{
		this.port = port;
		this.host = host;
		this.address = address;
		this.socket = socket;
	}

	/**
	 * @return the port
	 */
	protected int getPort()
	{
		return port;
	}

	/**
	 * @return the host
	 */
	protected String getHost()
	{
		return host;
	}

	/**
	 * @return the address
	 */
	protected InetAddress getAddress()
	{
		return address;
	}

	/**
	 * @return the socket
	 */
	protected Socket getSocket()
	{
		return socket;
	}

	/**
	 * @param port
	 *           the port to set
	 */
	protected void setPort(int port)
	{
		this.port = port;
	}

	/**
	 * @param host
	 *           the host to set
	 */
	protected void setHost(String host)
	{
		this.host = host;
	}

	/**
	 * @param address
	 *           the address to set
	 */
	protected void setAddress(InetAddress address)
	{
		this.address = address;
	}

	/**
	 * @param connection
	 *           the connection to set
	 */
	protected void setSocket(Socket socket)
	{
		this.socket = socket;
	}
}
