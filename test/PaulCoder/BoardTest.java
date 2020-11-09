package PaulCoder;

import org.junit.Before;
import org.junit.Test;

import java.rmi.server.ExportException;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }
    //assert - sprawdź poprawność
    @Test(expected = IllegalMoveException.class)
    public void shouldAddSubmarineOnField() throws Exception{
        //arrange - przygotuj
        board.addShip(4, 4, new Submarine());
        board.addShip(6, 6, new Submarine());
        board.addShip(2, 2, new Submarine());
        board.addShip(5, 5, new Submarine());
        //act - wykonaj
        board.addShip(9, 9, new Submarine());
    }

    @Test
    public void shouldAddDestroyerOnFields() throws Exception{
        //arrange
        //act
        board.addShip(0, 0, new Destoyer(WarShip.Orientation.HORIZONTAL));
        //assert
        Field field = board.getField(0, 0);
        assertEquals(State.SHIP , field.getState());
    }

    @Test(expected = IllegalMoveException.class)
    public void shouldNotBeAbleToGetOutside() throws Exception {
        //arrange
        //act
        board.addShip(9 , 0, new Destoyer(WarShip.Orientation.HORIZONTAL));
    }

    @Test(expected = IllegalMoveException.class)
    public void shouldNotBeAbleToBeClose() throws Exception {
        //arrange
        board.addShip(0 , 0, new Destoyer(WarShip.Orientation.HORIZONTAL));
        //act
        board.addShip(2 , 0, new Destoyer(WarShip.Orientation.HORIZONTAL));

    }

    //assert
    @Test(expected = IllegalMoveException.class)
    public void shouldNotBeAbleToAddTwoBattleship() throws Exception{
        //arrange
        board.addShip(0, 0, new BattleShip(WarShip.Orientation.HORIZONTAL));
        //act
        board.addShip(6, 0, new BattleShip(WarShip.Orientation.HORIZONTAL));
    }

    @Test
    public void shouldNotBeAbleToAddFireSubmarine() throws Exception {
        //arrange - przygotuj
        //act - wykonaj
        board.addShip(0, 0, new Submarine(WarShip.Orientation.HORIZONTAL));
    }

    //assert - sprawdź poprawność
    @Test( expected = IllegalMoveException.class)
    public void shouldFaliToAddOutsideX() throws Exception{
        //arrange - przygotuj
        //act - wykonaj
        board.addShip(-1, 0, new Submarine(WarShip.Orientation.HORIZONTAL));
    }

    //assert - sprawdź poprawność
    @Test( expected = IllegalMoveException.class)
    public void shouldFaliToAddOutsideY() throws Exception {
        //arrange - przygotuj
        //act - wykonaj
        board.addShip(0, 11, new Submarine(WarShip.Orientation.HORIZONTAL));
    }
    
}