package Client;

import javax.swing.JFrame;

public class Client extends JFrame
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -772838243865458318L;
	ClientModel			model;
	ClientController	controller;
	ClientView			view;
	
	Client() {
		model = new ClientModel();
		controller = new ClientController(model);
		view = new ClientView(model, controller);
	}
	
	public void init() {
		view.getFrame(this);
	}
	
	public static void main(String[] args){
		Client client = new Client();
		client.init();
	}
}
