package devops.tddtesting.vintonat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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

    @Test
    public void testGameOverWhenAllFieldsTakenNoWinner() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0, 'X');
        game.makeMove(0, 1, 'O');
        game.makeMove(0, 2, 'X');
        game.makeMove(1, 0, 'X');
        game.makeMove(1, 1, 'O');
        game.makeMove(1, 2, 'O');
        game.makeMove(2, 0, 'O');
        game.makeMove(2, 1, 'X');
        game.makeMove(2, 2, 'X');
        assertTrue(game.isGameOver());
    }


    @Test
    public void testPlayerCanEndAndRestartGame() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0, 'X');
        game.makeMove(0, 1, 'O');
        game.makeMove(0, 2, 'X');
        game.makeMove(1, 0, 'O');
        game.makeMove(1, 1, 'X');
        game.makeMove(1, 2, 'O');
        game.makeMove(2, 0, 'X');
        game.makeMove(2, 1, 'O');
        game.makeMove(2, 2, 'X');

        assertTrue(game.isGameOver());
        game.restartGame();

        // Überprüfen, ob das Spielbrett zurückgesetzt wurde
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board[i][j]);
            }
        }

        // Überprüfen, ob das Spiel wieder läuft
        assertFalse(game.isGameOver());
    }

    @Test
    public void testPiecePlacedOutsideXAxisThrowsException() {
        TicTacToe game = new TicTacToe();
        Assertions.assertThrows(RuntimeException.class, () -> {
        game.placePiece(4, 2);
    });
}
}
