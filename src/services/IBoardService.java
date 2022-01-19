package services;

import model.Board;
import model.Player;

public interface IBoardService {

	public Board createBoard();

	public void addSnakeAndLadder(Board board);

	public void addPlayers(Board board);

	public Player nextPlayer(Board board);

	public boolean rollTheDice(Player player, Board board); 
}
