public class Board extends Chess{
    Tile[][] board = new Tile[8][8];
    
    public void initialize() {
        for(int i = 0; i < 8; i++)  {
            for(int j = 0; j < 8; j++)  {
                board[i][j] = new Tile(i, j);
            }
        }
    }

    public void newChessBoard() {
        for(int i = 0; i < 8; i++)  {
            for(int j = 0; j < 8; j++)  {
                if(i == 0)  {
                    if(j == 0 || j == 7)    {
                        board[i][j].setPiece(new Rook(i, j));
                    }
                    else if(j == 1 || j == 6)   {
                        board[i][j].setPiece(new Knight(i, j));
                    }
                    else if(j == 2 || j == 5)   {
                        board[i][j].setPiece(new Bishop(i, j));
                    }
                    else if(j == 3) {
                        board[i][j].setPiece(new Queen(i, j));
                    }                       
                    else    {
                        board[i][j].setPiece(new King(i, j));
                    }
                }
                else if(i == 1) {
                    board[i][j].setPiece(new Pawn(i, j));
                }
                else if(i == 6) {
                    board[i][j].setPiece(new Pawn(i, j));
                }
                else if(i == 7) {
                    if(j == 0 || j == 7)    {
                        board[i][j].setPiece(new Rook(i, j));
                    }
                    else if(j == 1 || j == 6)   {
                        board[i][j].setPiece(new Knight(i, j));
                    }
                    else if(j == 2 || j == 5)   {
                        board[i][j].setPiece(new Bishop(i, j));
                    }
                    else if(j == 3) {
                        board[i][j].setPiece(new Queen(i, j));
                    }
                    else    {
                        board[i][j].setPiece(new King(i, j));
                    }
                }
            }
        }
    }

    public void printBoard() {
        for(int i = 0; i < 8; i++)  {
            for(int j = 0; j < 8; j++)  {
                if(board[i][j].isOccupied())    {
                    System.out.print(board[i][j].getPiece().getPieceChar() + " ");
                }
                else    {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
   
    public void move(int x, int y, int a, int b) {
        if(board[x][y].isOccupied())    {
            if(!board[x][y].getPiece().isLegalMove(a, b, board))    {
                System.out.println("Invalid move");
            }
        }
        else    {
            System.out.println("No piece at this location");
        }
    }
}

