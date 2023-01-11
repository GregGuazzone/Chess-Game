public class Chess  {
    public static void main(String[] args)  {
        gui board = new gui();
        board.makeBoard();
        Board chess = new Board();
        chess.initialize();
        chess.newChessBoard();
        chess.printBoard();
        chess.printBoard();
        for(int i = 0; i < 8; i++)  {
          System.out.print("White ");
          System.out.println(chess.board[i][0].getPiece().getPieceChar());
          chess.printValidMoves(chess.board[i][0].getPiece().legalMoveTiles(chess.board));
        }
        for (int i = 0; i < 8; i++) {
          System.out.print("Black ");
          System.out.println(chess.board[i][7].getPiece().getPieceChar());
          chess.printValidMoves(chess.board[i][7].getPiece().legalMoveTiles(chess.board));
        }
        game(board, chess);
    }
    public static void game(gui guiBoard, Board board)  {
      int [] source = new int[2];
      int [] destination = new int[2];
      int color = 0;
      while(!board.isCheckmate(color)) {
        source = guiBoard.waitForButtonPressed();
        destination = guiBoard.waitForButtonPressed();

        if (board.move(source[0], source[1], destination[0], destination[1])) {
          guiBoard.updateGui(board.getTiles());
          color = 1 - color;
        }
      }
    }


}
