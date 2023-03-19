public class Chess {
    static gui gBoard = new gui();
    static Board board = new Board();
    public static void main(String[] args)  {
        gBoard.makeBoard();
        board.initialize();
        board.newChessBoard();
        board.printBoard();
        board.setAttackable();
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
              board.setAttackable();
          }
      }
      printAttackable();
      System.out.println("In Check white: " + board.inCheck(0) +  ", In Check black: " + board.inCheck(1));

    }
    public int[] startTurn(int [] coords)  {
        return coords;

    }
    public int[] endTurn(int [] coords)    {
        return coords;
    }

    public int[][] attackableBy()   {
        int[][] attackable = new int[8][8];
        for(int i = 0; i < 8; i++)  {
            for(int j = 0; j < 8; j++)  {
                attackable[i][j] = board.board[i][j].getAttackableBy(0).size() + board.board[i][j].getAttackableBy(1).size();
            }
        }
        return attackable;
    }

    public void printAttackable()   {
        int [][] attackable = attackableBy();
        for(int i = 0; i < 8; i++)  {
            for(int j = 0; j < 8; j++)  {
                System.out.print(attackable[j][7-i] + " ");
            }
            System.out.println();
        }
    }



}
