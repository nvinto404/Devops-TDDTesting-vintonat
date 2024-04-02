package devops.tddtesting.vintonat;

public class TicTacToe {
    private char[][] board;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    public char[][] getBoard() {
        return board;
    }

    public void makeMove(int row, int col, char playerSymbol) {
        if (board[row][col] == ' ') {
            board[row][col] = playerSymbol;
        } else {
            throw new IllegalArgumentException("Field already taken");
        }
    }

    public boolean isGameOver() {
        return isRowTaken() || isColumnTaken() || isDiagonalTaken() || isBoardFull();
    }

    private boolean isRowTaken() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }
}



