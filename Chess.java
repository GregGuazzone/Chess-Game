public class Chess {
    static gui gBoard = new gui();
    static Board board = new Board();
    public static void main(String[] args)  {
        gBoard.makeBoard();
        board.initialize();
        board.newChessBoard();
        board.printBoard();
        board.printValidMoves(board.totalReachableBy(0));
        board.printValidMoves(board.totalReachableBy(1));
    }
    int[] start = new int[2];
    int[] end = new int[2];
    int currColor = 0;
    int movePart = 0;

    public void playTurn(int[] coords)   {
      int x = coords[0];
      int y = coords[1];
      System.out.println("Move Part: " + movePart + "currColor: " + currColor);
      if(movePart == 0) {
           if(board.board[x][y].isOccupied() && board.board[x][y].getPiece().getColor() == currColor) {
              movePart = 1;
              start = startTurn(coords);
           }
           else {
               System.out.println("Invalid Move");
               return;
           }
      }
      else if(movePart == 1)  {
          movePart = 0;
          end = endTurn(coords);
          if(board.move(start[0], start[1], end[0], end[1])) {
              gBoard.updateGui(board.board);
              currColor = 1 - currColor;
          }
          
      }
      board.printValidMoves(board.totalReachableBy(0));
      board.printValidMoves(board.totalReachableBy(1));
      for(int i = 0; i < 8; i++)  {
        for(int j = 0; j < 8; j++)  {
            if(board.board[i][j].isOccupied())  {
                System.out.println("x: " + i + " y: " + j + ":  " + board.board[i][j].getReachableBy(0).size());
            }
        }
    }
      System.out.println("In Check white: " + board.inCheck(0) +  ", In Check black: " + board.inCheck(1));

    }
  public int[] startTurn(int [] coords)  {
      return coords;

  }
  public int[] endTurn(int [] coords)    {
      return coords;
  }



}
