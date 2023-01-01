public class Pawn implements Piece{
    int x;
    int y;
    int color;

    public Pawn(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public int[][] legalMoveTiles(Tile board[][]) {
        int legalMoveTiles[][] = new int[8][8];
        if (color == 0) {
            if (y == 1) {
                if (board[x][y+1].getPiece() == null) {
                    legalMoveTiles[x][y+1] = 1;
                    if (board[x][y+2].getPiece() == null) {
                        legalMoveTiles[x][y+2] = 1;
                    }
                }
            }
            else if (y < 7) {
                if (board[x][y+1].getPiece() == null) {
                    legalMoveTiles[x][y+1] = 1;
                }
            }
            if (x > 0 && y < 7) {
                if (board[x-1][y+1].getPiece() != null) {
                    if (board[x-1][y+1].getPiece().getColor() == 1) {
                        legalMoveTiles[x-1][y+1] = 1;
                    }
                }
            }
            if (x < 7 && y < 7) {
                if (board[x+1][y+1].getPiece() != null) {
                    if (board[x+1][y+1].getPiece().getColor() == 1) {
                        legalMoveTiles[x+1][y+1] = 1;
                    }
                }
            }
        }
        else if (color == 1) {
            if (y == 6) {
                if (board[x][y-1].getPiece() == null) {
                    legalMoveTiles[x][y-1] = 1;
                    if (board[x][y-2].getPiece() == null) {
                        legalMoveTiles[x][y-2] = 1;
                    }
                }
            }
            else if (y > 0) {
                if (board[x][y-1].getPiece() == null)
                    legalMoveTiles[x][y-1] = 1;
            }
            if (x > 0 && y > 0) {
                if (board[x-1][y-1].getPiece() != null) {
                    if (board[x-1][y-1].getPiece().getColor() == 0) {
                        legalMoveTiles[x-1][y-1] = 1;
                    }
                }
            }
            if (x < 7 && y > 0) {
                if (board[x+1][y-1].getPiece() != null) {
                    if (board[x+1][y-1].getPiece().getColor() == 0) {
                        legalMoveTiles[x+1][y-1] = 1;
                    }
                }
            }
        }
        return legalMoveTiles;
    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
        return legalMoveTiles(board)[a][b] == 1;
        
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
}