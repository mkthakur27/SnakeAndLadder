package driver;

import model.Board;
import model.Player;
import services.BoardServiceImpl;
import services.IBoardService;

public class Main {

	public static void main(String args[]) throws InterruptedException
	{
		IBoardService boardService = new BoardServiceImpl();
		Board board = boardService.createBoard();
		boardService.addSnakeAndLadder(board);
		boardService.addPlayers(board);
		
		while(true)
		{
			Player player = boardService.nextPlayer(board);
			boolean isWinner = boardService.rollTheDice(player,board);
			if (isWinner)
			{
				System.out.println(player.getName() + " win the game");
				break;
			}
			Thread.sleep(1500);
		}
		
	}
}
