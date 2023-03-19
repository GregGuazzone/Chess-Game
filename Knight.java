import java.lang.Math;

public class Knight implements Piece{
    int x;
    int y;
    int color;
    public Knight(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int[][] legalMoveTiles(Tile[][] board)   {
        int[][] legalMoveTiles = new int[8][8];
        for(int i = -2; i < 3; i++) {
            for(int j = -2; j < 3; j++) {
                if(Math.abs(i) + Math.abs(j) == 3) {
                    if(x+i >= 0 && x+i < 8 && y+j >= 0 && y+j < 8) {
                        if(board[x+i][y+j].isEmpty())   {
                            board[x+i][y+j].addAttackableByThis(board[x][y]);
                            legalMoveTiles[x+i][y+j] = 1;
                        }
                        else if(board[x+i][y+j].getPiece().getColor() != color) {
                            board[x+i][y+j].addAttackableByThis(board[x][y]);
                            legalMoveTiles[x+i][y+j] = 1;
                        }
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
}