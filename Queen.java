public class Queen implements Piece{
    int x;
    int y;
    int color;

    public Queen(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
        System.out.println("Queen");
        int s = 0;
        int t = 0;
        int i = 0;
        int j = 0;
        if (a != x) {
            if (a < x)  {
                i = -1;
            }
            else if (x < a) {
                i = 1;
            }
        }
        if(b != y)  {
            if (b < y)  {
                j = -1;
            }
            else if (y < b) {
                j = 1;
            }
        }
        s = s + i;
        t = t + j;
        if( s == 0 && t == 0)   {
            return false;
        }
        while ( ((x+s) != a) && ((y+t) != b) ) {
            if (board[x+s][y+t].isOccupied()) {
                return false;
            }
                s = s + i;
                t = t + j;
        }
        return ((s == a) && (t == b));
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