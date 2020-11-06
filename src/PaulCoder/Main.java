package PaulCoder;

public class Main {

    public static void main(String[] args) {

        printLetter();
        printBoard();

    }

    static void printLetter(){
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print((char)('A' +i) );

        }
        System.out.print('\n');
    }

    static void printBoard(){
        for (int i = 1; i <= 10; i++) {
            if (i < 10){
                System.out.print('0');
            }
            System.out.print(i);
            for (int j = 0; j < 10; j++) {
                char shipValue = getRandomShip();
                System.out.print(shipValue);

            }
            System.out.print('\n');
        }
    }

    private static char getRandomShip() {
        if (Math.random() < 0.2){
            return 'O';
        }else{
            return ' ';
        }
    }
}
