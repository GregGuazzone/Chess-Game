public class Rook implements Piece{
    int x;
    int y;

    public Rook(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
        System.out.println("Rook");
        if ( (a == x) || (b == y) ) {
            if(!board[x][y].isOccupied())   {
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
        return 'R';
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

}