public class Pawn implements Piece{
    int x;
    int y;
    public Pawn(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
        System.out.println("Pawn");
        System.out.println("x: " + x + " y: " + y + " a: " + a + " b: " + b + "");
        if((y == b) || (x != a)) {
            return false;
        }
        if(b == y+1)    {
            if(board[a][b].isEmpty())   {
                return true;
            }
            else    {
                return false;
            }
        }
        else if (b == y+2)  {
            if(board[a][b].isEmpty() && board[a][b-1].isEmpty())   {
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
        return 'P';
    }
}