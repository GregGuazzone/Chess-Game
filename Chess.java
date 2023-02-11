public class Chess {
    static gui gBoard = new gui();
    static Board board = new Board();
    public static void main(String[] args)  {
        gBoard.makeBoard();
        board.initialize();
        board.newChessBoard();
        board.printBoard();
        board.printBoard();
        for(int i = 0; i < 8; i++)  {
          System.out.print("White ");
          System.out.println(board.board[i][0].getPiece().getPieceChar());
          board.printValidMoves(board.board[i][0].getPiece().legalMoveTiles(board.board));
        }
        for (int i = 0; i < 8; i++) {
          System.out.print("Black ");
          System.out.println(board.board[i][7].getPiece().getPieceChar());
          board.printValidMoves(board.board[i][7].getPiece().legalMoveTiles(board.board));
        }
    }
    int[] start = new int[2];
    int[] end = new int[2];
    public void playTurn(int[] coords)   {
      int x = coords[0];
      int y = coords[1];
      if(board.board[x][y].isOccupied()) {
          start = startTurn(coords);
      }
      else {
          end = endTurn(coords);
          if(board.move(start[0], start[1], end[0], end[1])) {
              gBoard.updateGui(board.board);
          }
      }
    }
  public int[] startTurn(int [] coords)  {
      return coords;

  }
  public int[] endTurn(int [] coords)    {
      return coords;
  }
}
