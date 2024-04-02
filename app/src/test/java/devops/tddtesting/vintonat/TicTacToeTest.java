package devops.tddtesting.vintonat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
}
