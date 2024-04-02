package devops.tddtesting.vintonat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;

public class TicTacToeTest {

@Test
public void testCreateEmptyBoard() {
    TicTacToe game = new TicTacToe();
    char[][] expectedBoard = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    assertArrayEquals(expectedBoard, game.getBoard());
}

@Test
public void testPlayerCanMakeMoveIfFieldNotTaken() {
    TicTacToe game = new TicTacToe();
    char[][] expectedBoard = {
        {' ', ' ', ' '},
        {' ', 'X', ' '},
        {' ', ' ', ' '}
    };
    game.makeMove(1, 1, 'X');
    assertArrayEquals(expectedBoard, game.getBoard());
}

@Test
public void testGameOverWhenAllFieldsInRowTaken() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0, 'X');
        game.makeMove(0, 1, 'X');
        game.makeMove(0, 2, 'X');
        assertTrue(game.isGameOver());
    }

@Test
public void testGameOverWhenAllFieldsInColumnTaken() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0, 'O');
        game.makeMove(1, 0, 'O');
        game.makeMove(2, 0, 'O');
        assertTrue(game.isGameOver());
    }

    @Test
    public void testGameOverWhenAllFieldsInDiagonalTaken() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0, 'X');
        game.makeMove(1, 1, 'X');
        game.makeMove(2, 2, 'X');
        assertTrue(game.isGameOver());
    }

}
