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

    private boolean isColumnTaken() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalTaken() {
        return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void restartGame() {
        // Spielfeld zurücksetzen, indem  alle Felder auf leere Zeichen gesetztwerden
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void placePiece(int x, int y) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
            throw new RuntimeException("Piece placed outside the game board");
        }

        if (board[x][y] != ' ') {
            throw new RuntimeException("Piece already placed at this position");
        }

        board[x][y] = 'X'; // Hier nehmen ich an, dass 'X' das Symbol für den Spieler ist
    }

}



