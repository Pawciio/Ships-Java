package PaulCoder;

public interface Ship {

    int getDecksCount();

    void hit();

    boolean isSunk();

    void setOnField (Field field, int decNum);

}
