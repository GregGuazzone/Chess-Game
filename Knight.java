import java.lang.Math;

public class Knight implements Piece{
    int x;
    int y;
    int color;
    int moveTiles[][] = new int [8][8];
    int attDefTiles[][] = new int [8][8];

    public Knight(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void setLegalTiles(Tile[][] board)   {
        for(int i = -2; i < 3; i++) {
            for(int j = -2; j < 3; j++) {
                if(Math.abs(i) + Math.abs(j) == 3) {
                    if(x+i >= 0 && x+i < 8 && y+j >= 0 && y+j < 8) {
                        if(board[x+i][y+j].isEmpty())   {
                            moveTiles[x+i][y+j] = 1;
                        }
                        else {
                            attDefTiles[x+i][y+j] = 1;
                        }
                    }
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
        return 'N';
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

    @Override
    public int[][] getMoveTiles() {
        return moveTiles;
    }

    @Override
    public int[][] getAttDefTiles() {
        return attDefTiles;
    }

    public int[][] getAllTiles() {
        int [][] allTiles = new int [8][8];
        for (int i = 0; i < 8; i++)    {
            for (int j = 0; j < 8; j++)    {
                if (moveTiles[i][j] == 1 || attDefTiles[i][j] == 1) {
                    allTiles[i][j] = 1;
                }
            }
        }
        return allTiles;
    }

    public void setLegalTiles(Tile[][] board, int[][] whiteMoves, int[][] blackMoves) {
    }
}