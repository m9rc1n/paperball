package Server;

public class Edge
{
	private String edge;
	
	Edge( int x1, int y1, int x2, int y2){
		edge = new String(x1 + "-" + y1 + ":" + x2 + "-" + y2);
		System.out.println("EDGE " + edge);
	}

	/**
	 * @return the edge
	 */
	public String getEdge()
	{
		return edge;
	}

	/**
	 * @param edge the edge to set
	 */
	public void setEdge(String edge)
	{
		this.edge = edge;
	}
	
	
}
