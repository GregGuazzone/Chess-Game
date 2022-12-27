public class Board extends Chess {
    Tile[][] board = new Tile[8][8];

    /*
     * Initializes the board with empty tiles
     */

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[j][i] = new Tile(j, i);
            }
        }
    }

    /**
     * Sets up the board with the pieces in their starting positions
     */

    public void newChessBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0) {
                    if (j == 0 || j == 7) {
                        board[j][i].setPiece(new Rook(j, i));
                    } else if (j == 1 || j == 6) {
                        board[j][i].setPiece(new Knight(j, i));
                    } else if (j == 2 || j == 5) {
                        board[j][i].setPiece(new Bishop(j, i));
                    } else if (j == 3) {
                        board[j][i].setPiece(new Queen(j, i));
                    } else {
                        board[j][i].setPiece(new King(j, i));
                    }
                } else if (i == 1) {
                    board[j][i].setPiece(new Pawn(j, i));
                } else if (i == 6) {
                    board[j][i].setPiece(new Pawn(j, i));
                } else if (i == 7) {
                    if (j == 0 || j == 7) {
                        board[j][i].setPiece(new Rook(j, i));
                    } else if (j == 1 || j == 6) {
                        board[j][i].setPiece(new Knight(j, i));
                    } else if (j == 2 || j == 5) {
                        board[j][i].setPiece(new Bishop(j, i));
                    } else if (j == 3) {
                        board[j][i].setPiece(new Queen(j, i));
                    } else {
                        board[j][i].setPiece(new King(j, i));
                    }
                }
            }
        }
    }

    /*
     * Prints the board
     */

    public void printBoard() {
        for (int j = 0; j < 8; j++) {
            System.out.print(" " + (7 - j) + "| ");
            for (int i = 0; i < 8; i++) {
                if (board[i][7 - j].isOccupied()) {
                    System.out.print(board[i][7 - j].getPiece().getPieceChar() + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println("   -----------------");
        System.out.println("    a b c d e f g h");
    }

    /**
     * Moves a piece from one tile to another
     * 
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @param a x coordinate of the destination
     * @param b y coordinate of the destination
     */

    public void move(int x, int y, int a, int b) {
        if (board[x][y].isOccupied()) {
            System.out.println("Piece Char: " + board[x][y].getPiece().getPieceChar());
            if (!board[x][y].getPiece().isLegalMove(a, b, board)) {
                System.out.println("Invalid move");
            } else {
                board[a][b].setPiece(board[x][y].getPiece());
                board[a][b].getPiece().setX(a);
                board[a][b].getPiece().setY(b);
                board[x][y] = new Tile(x, y);
            }
            if (board[a][b].getPiece().getPieceChar() == 'P' && (b == 7)) {
                board[a][b].setPiece(new Queen(a, b));
            }
        } else {
            System.out.println("No piece at this location");
        }
    }
}
