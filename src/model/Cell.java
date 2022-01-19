package model;

public class Cell {

	private int id;
	boolean hasTransporter = false;
	int serialNumber;
	Transporter transpoter = null;
	public Cell(int id, int serialNumber) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isHasTransporter() {
		return hasTransporter;
	}
	public void setHasTransporter(boolean hasTransporter) {
		this.hasTransporter = hasTransporter;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public Transporter getTranspoter() {
		return transpoter;
	}
	public void setTranspoter(Transporter transpoter) {
		this.transpoter = transpoter;
	} 
	
}
