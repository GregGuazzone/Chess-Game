public class Rook implements Piece{
    int x;
    int y;
    int color;
    int moveTiles[][] = new int [8][8];
    int attDefTiles[][] = new int [8][8];

    public Rook(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
        
    }
    public void setLegalTiles(Tile[][] board)   {
        int s = 0;  int t = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i+j == 0 || i-j == 0)   {
                    continue;
                }
                s = i;  t = j;
                while ( ((x+s) < 8 && (x+s) >= 0) && ( (y+t) < 8 && (y+t) >= 0) ) {
                    if (board[x+s][y+t].isEmpty()) {
                        moveTiles[x+s][y+t] = 1;
                    }
                    else {
                        attDefTiles[x+s][y+t] = 1;
                        break;
                    }
                  s = s + i;
                  t = t + j;
                }
                continue;
              }
        }
        
    }


    public boolean isLegalMove(int a, int b, Tile board[][]) {
        if(moveTiles[a][b] == 1 || attDefTiles[a][b] == 1)
            return true;
        return false;
    }

    public char getPieceChar()  {
        return 'R';
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setColor(int color)  {
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