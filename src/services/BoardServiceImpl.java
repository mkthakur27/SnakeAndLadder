package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import constant.GameContant;
import model.Board;
import model.Cell;
import model.Player;
import model.TransportMode;
import model.Transporter;

public class BoardServiceImpl implements IBoardService {

	@Override
	public Board createBoard() {
		Board board = Board.getInstant();
		for (int i = GameContant.START_CELL; i <= GameContant.END_CELL; i++) {
			Cell cell = new Cell(i, i);
			board.getAllCells().put(i, cell);
		}
		return board;
	}

	private void addTransporter(TransportMode mode, Board board, int numOfInput) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < numOfInput; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			Transporter transporter = new Transporter(i, start, end, mode);
			board.getAllCells().get(start).setHasTransporter(true);
			board.getAllCells().get(start).setTranspoter(transporter);
		}
	}

	@Override
	public void addSnakeAndLadder(Board board) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Snake");
		int snakes = sc.nextInt();
		addTransporter(TransportMode.SNAKE, board, snakes);

		System.out.println("Enter Number of Ladder");
		int ladders = sc.nextInt();
		addTransporter(TransportMode.LADDER, board, ladders);

	}

	@Override
	public void addPlayers(Board board) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Player");
		int numOfPlayer = sc.nextInt();
		List<Player> allPlayer = new ArrayList<>();

		for (int i = 0; i < numOfPlayer; i++) {
			String name = sc.next();
			Player player = new Player(i, name);
			allPlayer.add(player);
		}
		board.setAllPlayers(allPlayer);

	}

	@Override
	public Player nextPlayer(Board board) {
		int nextPlayer = board.getNextPlayer();
		Player player = board.getAllPlayers().get(nextPlayer);
		nextPlayer += 1;
		if (nextPlayer >= board.getAllPlayers().size()) {
			nextPlayer = 0;
		}
		board.setNextPlayer(nextPlayer);
		return player;
	}

	private int rollDice() {
		Random rand = new Random();;
		int randomNum = rand.nextInt((GameContant.DICE_MAX - GameContant.DICE_MIN) + 1) + GameContant.DICE_MIN;
		return randomNum;
	}

	@Override
	public boolean rollTheDice(Player player, Board board) {

		int diceVal = rollDice();
		int currPos = player.getPos();
		if (currPos + diceVal <= GameContant.END_CELL) {
			currPos = currPos + diceVal; // move the player to new position
		}
		while (board.getAllCells().get(currPos).isHasTransporter()) // if this cell is having snake or ladder
		{
			currPos = board.getAllCells().get(currPos).getTranspoter().getTo();
		}

		System.out.println("Player " + player.getName() + " rolled a " + diceVal + " and moved from " + player.getPos()
				+ " to " + currPos);
		player.setPos(currPos);
		if (currPos == GameContant.END_CELL) {
			return true;
		}
		return false;
	}

}
