package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
	private Map<Integer,Cell> allCells=new HashMap<>();
	private Board() {}
	private static Board board = null;
	private List<Player> allPlayers = new ArrayList<>();
	private int nextPlayer = 0;
	public static Board getInstant()
	{
		if (board != null)
		{
			return board;
		}
		board = new Board();
		return board;
	}
	public Map<Integer, Cell> getAllCells() {
		return allCells;
	}
	public void setAllCells(Map<Integer, Cell> allCells) {
		this.allCells = allCells;
	}
	public List<Player> getAllPlayers() {
		return allPlayers;
	}
	public void setAllPlayers(List<Player> allPlayers) {
		this.allPlayers = allPlayers;
	}
	public int getNextPlayer() {
		return nextPlayer;
	}
	public void setNextPlayer(int nextPlayer) {
		this.nextPlayer = nextPlayer;
	}
	
}
