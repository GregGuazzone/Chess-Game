import java.lang.Math;

public class King implements Piece{
    int x;
    int y;
    int color;
    public King(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
        System.out.println("King");
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
