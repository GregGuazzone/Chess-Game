public class Board extends Chess{
    Tile[][] board = new Tile[8][8];
    
    public void initialize() {
        for(int i = 0; i < 8; i++)  {
            for(int j = 0; j < 8; j++)  {
                board[j][i] = new Tile(j, i);
            }
        }
    }

    public void newChessBoard() {
        for(int i = 0; i < 8; i++)  {
            for(int j = 0; j < 8; j++)  {
                if(i == 0)  {
                    if(j == 0 || j == 7)    {
                        board[j][i].setPiece(new Rook(j, i));
                    }
                    else if(j == 1 || j == 6)   {
                        board[j][i].setPiece(new Knight(j, i));
                    }
                    else if(j == 2 || j == 5)   {
                        board[j][i].setPiece(new Bishop(j, i));
                    }
                    else if(j == 3) {
                        board[j][i].setPiece(new Queen(j, i));
                    }                       
                    else    {
                        board[j][i].setPiece(new King(j, i));
                    }
                }
                else if(i == 1) {
                    board[j][i].setPiece(new Pawn(j, i));
                }
                else if(i == 6) {
                    board[j][i].setPiece(new Pawn(j, i));
                }
                else if(i == 7) {
                    if(j == 0 || j == 7)    {
                        board[j][i].setPiece(new Rook(j, i));
                    }
                    else if(j == 1 || j == 6)   {
                        board[j][i].setPiece(new Knight(j, i));
                    }
                    else if(j == 2 || j == 5)   {
                        board[j][i].setPiece(new Bishop(j, i));
                    }
                    else if(j == 3) {
                        board[j][i].setPiece(new Queen(j, i));
                    }
                    else    {
                        board[j][i].setPiece(new King(j, i));
                    }
                }
            }
        }
    }

    public void printBoard() {
        for(int j = 0; j < 8; j++)  {
            System.out.print(" " + (7-j) + "| ");
            for(int i = 0; i < 8; i++)  {
                if(board[i][7-j].isOccupied())    {
                    System.out.print(board[i][7-j].getPiece().getPieceChar() + " ");
                }
                else    {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println("   -----------------");
        System.out.println("    a b c d e f g h");
    }
   
    public void move(int x, int y, int a, int b) {

        if(board[x][y].isOccupied())    {
            System.out.println("Piece Char: " + board[x][y].getPiece().getPieceChar());
            if(!board[x][y].getPiece().isLegalMove(a, b, board))    {
                System.out.println("Invalid move");
            }
            else    {
                board[a][b].setPiece(board[x][y].getPiece());
                board[x][y] = new Tile(x, y);
            }
        }
        else    {
            System.out.println("No piece at this location");
        }
    }
}


