public class Bishop implements Piece{
    int x;
    int y;
    int color = -1;

    Bishop(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
        
    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
        System.out.println("Bishop");
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
        if (i == 0 || j == 0)   {
            return false;
        }
        s = s + i;
        t = t + j;
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
            return true;
        }
        else    {
            return false;
        }
    }
    public char getPieceChar()  {
        return 'B';
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