package PaulCoder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void shouldAddSubmarine() throws Exception {
        //arrange
        //act
        board.addShip(0, 0, new Submarine());
        //assert
        assertEquals(1, board.getShipsCount());
    }

    @Test
    public void shouldAddSubmarineOnField() throws Exception {
        //arrange
        //act
        board.addShip(0, 0, new Submarine());
        //assert
        Field field = board.getField(0,0);
        assertEquals(State.SHIP, field.getState());
    }

    @Test
    public void shouldAddDestroyerOnFields() throws Exception {
        //arrange
        //act
        board.addShip(0, 0, new Destoyer(WarShip.Orientation.HORIZONTAL));
        //assert
        Field field = board.getField(1,0);
        assertEquals(State.SHIP, field.getState());
    }

    @Test(expected = IllegalMoveException.class)
    public void shouldNotBeAbleToGetOutside() throws Exception {
        //arrange
        //act
        board.addShip(9, 0, new Destoyer(WarShip.Orientation.HORIZONTAL));

    }

    @Test(expected = IllegalMoveException.class)
    public void shouldNotBeAbleToBeClose() throws Exception {
        //arrange
        board.addShip(0,0, new Destoyer(WarShip.Orientation.HORIZONTAL));
        //act
        board.addShip(2,0, new Destoyer(WarShip.Orientation.HORIZONTAL));
    }

    //assert
    @Test(expected = IllegalMoveException.class)
    public void shouldNotBeAbleToAddFiveSubmarines() throws Exception {
        //arrange
        board.addShip(1, 1, new Submarine());
        board.addShip(3, 3, new Submarine());
        board.addShip(5, 5, new Submarine());
        board.addShip(7, 7, new Submarine());
        //act
        board.addShip(9, 9, new Submarine());
    }

    //assert
    @Test(expected = IllegalMoveException.class)
    public void shouldNotBeAbleToAddTwoBattleships() throws Exception {
        //arrange
        board.addShip(0,0, new BattleShip(WarShip.Orientation.HORIZONTAL));
        //act
        board.addShip(6,0, new BattleShip(WarShip.Orientation.HORIZONTAL));
    }

    //assert
    @Test(expected = IllegalMoveException.class)
    public void shouldFailToAddOutsideX() throws Exception {
        //arrange
        //act
        board.addShip(-1, 0, new Submarine());
    }

    @Test(expected = IllegalMoveException.class)
    public void shouldFailToAddOutsideY() throws Exception {
        //arrange
        //act
        board.addShip(0, 11, new Submarine());
    }

    @Test
    public void shouldMarkMiss() throws Exception {
        //arrange
        //act
        board.shoot(0,0);
        //assert
        assertEquals(State.MISS, board.getField(0, 0).getState());

    }

    @Test
    public void shouldMarkAsHit() throws Exception {
        //arrange
        board.addShip(0,0, new Destoyer(WarShip.Orientation.HORIZONTAL));
        //act
        board.shoot(0, 0);
        //assert
        assertEquals(State.HIT, board.getField(0,0).getState());

    }

    @Test
    public void shouldMarkAsSunk() throws Exception {
        //arrange
        board.addShip(0, 0, new Destoyer(WarShip.Orientation.HORIZONTAL));
        board.shoot(0, 0);
        //act
        board.shoot(1, 0);
        //assert
        assertEquals(State.SUNK, board.getField(0,0).getState());
        assertEquals(State.SUNK, board.getField(1,0).getState());

    }

    @Test
    public void shouldDecreaseShipsOnBoard() throws Exception {
        //arrange
        board.addShip(0,0, new Submarine());
        //act
        board.shoot(0,0);
        //assert
        assertEquals(0, board.getShipsCount());

    }

    //assert
    @Test(expected = IllegalMoveException.class)
    public void shouldNotBeAbleToShootTwice() throws Exception {
        //arrange
        board.shoot(0,0);
        //act
        board.shoot(0,0);
    }

    @Test
    public void shouldHaveAllShipsGenerated() throws Exception {
        //arrange
        //act
        board.fillBoard();
        //assert
        assertEquals(10, board.getShipsCount());


    }
}