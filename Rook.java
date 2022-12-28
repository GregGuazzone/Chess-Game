public class Rook implements Piece{
    int x;
    int y;
    int color;

    public Rook(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
        int i = 0;
        int j = 0;
        int s = 0;
        int t = 0;
        System.out.println("x: " + x + " y: " + y + " a: " + a + " b: " + b + "");
        System.out.println("Rook");
        if (a != x) {
            if (a < x)  {
                i = -1;
            }
            else if (x < a) {
                i = 1;
            }
        }
        if (b != y) {
            if (b < y)  {
                j = -1;
            }
            else if (y < b) {
                j = 1;
            }
        }
        System.out.println("i: " + i + " j: " + j + " s: " + s + " t: " + t);
        if ((i+j == 0) || (i+j == 2) || (i+j == -2))   { //if i and j are both 0 or both 1 or both -1, meaning the move is diagonal
            return false;
        }
        s = s + i;
        t = t + j;
        System.out.println("x+s: " + (x+s) + " y+t: " + (y+t) + " a: " + a + " b: " + b);
        do  {
            if (board[x+s][y+t].isOccupied()) {
                return false;
            }
            else    {
                s = s + i;
                t = t + j;
            }
        } while ( ((x+s) != a) && ((y+t) != b) );
        return ((x+s == a) && (y+t == b));
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

}