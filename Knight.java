import java.lang.Math;

public class Knight implements Piece{
    int x;
    int y;
    public Knight(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
        System.out.println("Knight");
        if ( (Math.abs(x-a) == 2 && Math.abs(y-b) == 1) || (Math.abs(x-a) == 1 && Math.abs(y-b) == 2) ) {
            if(board[a][b].isEmpty())   {
                return true;
            }
            else    {
                return false;
            }
        }
        else    {
            return false;
        }
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
}