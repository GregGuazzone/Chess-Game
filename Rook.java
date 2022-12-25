public class Rook implements Piece{
    int x;
    int y;

    public Rook(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
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

}