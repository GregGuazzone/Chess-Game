public class Queen implements Piece{
    int x;
    int y;
    int color;

    public Queen(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public int[][] legalMoveTiles(Tile[][] board)   {
        int[][]legalMoveTiles = new int[8][8];
        int s = 0;  int t = 0;
        for (int i = -1; i < 2; i = i + 2) {
            for (int j = -1; j < 2; j = j + 2) {
                s = i;  t = j;
                while ( ((x+s) < 8 && (x+s) >= 0) && ( (y+t) < 8 && (y+t) >= 0) ) {
                  if (board[x+s][y+t].isEmpty()) {
                    legalMoveTiles[x+s][y+t] = 1;
                  }
                  else if (board[x+s][y+t].getPiece().getColor() != color) {
                    board[x+s][y+t].addAttackableByThis(board[x][y]);
                    legalMoveTiles[x+s][y+t] = 1;
                    break;
                  }
                  else if (board[x+s][y+t].getPiece().getColor() == color) {
                    break;
                  }
                  s = s + i;
                  t = t + j;
                }
                continue;
              }
        }
        s = 0;  t = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i+j == 0 || i-j == 0)   {
                    continue;
                }
                s = i;  t = j;
                while ( ((x+s) < 8 && (x+s) >= 0) && ( (y+t) < 8 && (y+t) >= 0) ) {
                    if (board[x+s][y+t].isEmpty()) {
                        board[x+s][y+t].addAttackableByThis(board[x][y]);
                        legalMoveTiles[x+s][y+t] = 1;
                    }
                    else if (board[x+s][y+t].getPiece().getColor() != color) {
                        board[x+s][y+t].addAttackableByThis(board[x][y]);
                        legalMoveTiles[x+s][y+t] = 1;
                        break;
                    }
                    else if (board[x+s][y+t].getPiece().getColor() == color) {
                        board[x+s][y+t].addAttackableByThis(board[x][y]);
                        break;
                    }
                  s = s + i;
                  t = t + j;
                }
                continue;
              }
        }
        return legalMoveTiles;

    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
        return legalMoveTiles(board)[a][b] == 1;
    }
        
    
    public char getPieceChar()  {
        return 'Q';
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