public class Pawn implements Piece{
    int x;
    int y;
    int color;
    int moveTiles[][] = new int [8][8];
    int attDefTiles[][] = new int [8][8];

    public Pawn(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public void setLegalTiles(Tile board[][]) {
        if (color == 0) {
            if (y == 1) {
                if (board[x][y+1].getPiece() == null) {
                    moveTiles[x][y+1] = 1;
                    if (board[x][y+2].getPiece() == null) {
                        moveTiles[x][y+2] = 1;
                    }
                }
            }
            else if (y < 7) {
                if (board[x][y+1].getPiece() == null) {
                    moveTiles[x][y+1] = 1;
                }
            }
            if (x > 0 && y < 7) {
                if (board[x-1][y+1].getPiece() != null) {
                    attDefTiles[x-1][y+1] = 1;
                }
            }
            if (x < 7 && y < 7) {
                if (board[x+1][y+1].getPiece() != null) {
                    attDefTiles[x+1][y+1] = 1;
                }
            }
        }
        else if (color == 1) {
            if (y == 6) {
                if (board[x][y-1].getPiece() == null) {
                    moveTiles[x][y-1] = 1;
                    if (board[x][y-2].getPiece() == null) {
                        moveTiles[x][y-2] = 1;
                    }
                }
            }
            else if (y > 0) {
                if (board[x][y-1].getPiece() == null)
                    moveTiles[x][y-1] = 1;
            }
            if (x > 0 && y > 0) {
                if (board[x-1][y-1].getPiece() != null) {
                    attDefTiles[x-1][y-1] = 1;
                }
            }
            if (x < 7 && y > 0) {
                if (board[x+1][y-1].getPiece() != null) {
                    attDefTiles[x+1][y-1] = 1;
                }
            }
        }
    }




    public boolean isLegalMove(int a, int b, Tile board[][]) {
        if(moveTiles[a][b] == 1 || attDefTiles[a][b] == 1)
            return true;
        return false;
        
    }

    public char getPieceChar()  {
        return 'P';
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setColor(int color) {
        this.color = color;
    }
    public int getColor()   {
        return color;
    }
    public int[][] getMoveTiles() {
        return moveTiles;
    }
    public int[][] getAttDefTiles() {
        return attDefTiles;
    }
    public int[][] getAllTiles() {
        int [][] allTiles = new int [8][8];
        for (int i = 0; i < 8; i++)    {
            for (int j = 0; j < 8; j++)    {
                if (getMoveTiles()[i][j] == 1 || getAttDefTiles()[i][j] == 1) {
                    allTiles[i][j] = 1;
                }
            }
        }
        return allTiles;
    }

    public void setLegalTiles(Tile[][] board, int[][] whiteMoves, int[][] blackMoves) {
    }

}