import java.lang.Math;

public class Knight implements Piece{
    int x;
    int y;
    public Knight(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
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
}