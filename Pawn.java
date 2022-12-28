public class Pawn implements Piece{
    int x;
    int y;
    int color;

    public Pawn(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public boolean isLegalMove(int a, int b, Tile board[][]) {
        System.out.print("Pawn");
        if(color == 0)
            System.out.println(" White");
        else
            System.out.println(" Black");
        System.out.println("x: " + x + " y: " + y + " a: " + a + " b: " + b + "");
        if((y == b) || (x != a)) {
            return false;
        }
        if (color == 0) {
            if(b == y+1)    {
                if(board[a][b].isEmpty())   {
                    return true;
                }
                else    {
                    return false;
                }
            }
            else if ((b == y+2))  {
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
        else if (color == 1)    {
            if(b == y-1)    {
                if(board[a][b].isEmpty())   {
                    return true;
                }
                else    {
                    return false;
                }
            }
            else if ((b == y-1))  {
                if(board[a][b].isEmpty() && board[a][b+1].isEmpty())   {
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
        else    {
            return false;
        }
        
    }

    public char getPieceChar()  {
        return 'P';
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