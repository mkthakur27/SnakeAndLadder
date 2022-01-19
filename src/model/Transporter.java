package model;

public class Transporter {

	private int id;
	private int from;
	private int to;
	private TransportMode type;
	public Transporter(int id, int from, int to,TransportMode type) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.setType(type);
	}
	public TransportMode getType() {
		return type;
	}
	public void setType(TransportMode type) {
		this.type = type;
	}
	public int getTo() {
		return to;
	}
	
	
	
}
