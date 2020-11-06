package PaulCoder;

public class Board {
    public static final int BOARD_SIZE = 10;

    private Field[][] fields = new Field[BOARD_SIZE][BOARD_SIZE];

    public Board(){
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                fields[y][x] = new Field( x, y, State.EMPTY );
            }
        }
    }

    public void fillBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                fields[i][j].setState(getRandomShip(Math.random()));
            }
        }
    }

    private static State getRandomShip(double random) {
        if (random < 0.2){
            return State.HIT;
        }else if(random > 0.8) {
            return State.EMPTY;
        }else {
            return State.MISS;
        }
    }

    private static void printLetters(){
        System.out.print("  ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((char)('A' +i) );

        }
        System.out.print('\n');
    }

    public void printBoard(){
        printLetters();
        for (int i = 0; i < 10; i++) {
            int numberToPrint = i + 1;
            if (numberToPrint < 10){
                System.out.print('0');
            }
            System.out.print(numberToPrint);
            for (int j = 0; j < 10; j++) {
                char shipValue = fields[i][j].stateToChar();
                System.out.print(shipValue);

            }
            System.out.print('\n');
        }
    }

}
