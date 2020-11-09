package PaulCoder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();
        board.fillBoard();

        Scanner scanner = new Scanner(System.in);
        while (board.getShipsCount() > 0){

            board.printBoard();
            String move = scanner.nextLine();
            move = move.toUpperCase();

            int x = move.charAt(0) - 'A';
            int y = move.charAt(1) - '0';

            try {
                board.shoot(x, y);
            }catch (IllegalMoveException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }

        System.out.println("Game over!");

    }





}
