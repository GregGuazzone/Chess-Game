import java.lang.Math;

public class King implements Piece{
    int x;
    int y;
    public King(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean isLegalMove(int a, int b, Tile board[][]) {
        if(Math.abs(x-a) <= 1 && Math.abs(y-b) <= 1) {
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
        return 'K';
    }
}
