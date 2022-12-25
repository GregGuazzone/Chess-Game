public class Bishop implements Piece{
    int x;
    int y;
    Bishop(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
        int s = 0;
        int t = 0;
        int i = 0;
        int j = 0;
        if (x < a)    {
            i = 1;
        }
        else if(a < x)   {
            i = -1;
        }
        if (y < b)    {
            j = 1;
        }
        else if (b < y)    {
            j = -1;
        }
        while ( ((x+s) != a) && ((y+t) != b) ) {
            if (board[x+s][y+t].isOccupied()) {
                return false;
            }
            else   {
                s = s + i;
                t = t + j;
            }
        }
        if ((s == a) && (t == b))   {
            x = a;
            t = b;
            return true;
        }
        else    {
            return false;
        }
    }
    public char getPieceChar()  {
        return 'B';
    }
}