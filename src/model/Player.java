package model;

public class Player {

	private int id;
	private String name="";
	private int pos= 0;
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public Player(int id, String name) {
		this.id = id;
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
