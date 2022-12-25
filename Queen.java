public class Queen implements Piece{
    int x;
    int y;
    public Queen(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
        int s = 1;
        int t = 1;
        int i;
        int j;
        if (x < a)    {
            i = 1;
        }
        else if (a == x)    {
            i = 0;
        }
        else    {
            i = -1;
        }
        if (y < b)    {
            j = 1;
        }
        else if (b == y)    {
            j = 0;
        }
        else    {
            j = -1;
        }
        while ( ((x+s)-a != 0) && ((y+t)-b != 0) ) {
            s = s + i;
            t = t + j;
            if (board[x+s][y+t].isOccupied()) {
                return false;
            }
            else   {
                s = s + i;
                t = t + j;
            }
        }
        if ((s == a) && (t == b))   {
            return true;
        }
        else    {
            return false;
        }
    }
    public char getPieceChar()  {
        return 'Q';
    }
}