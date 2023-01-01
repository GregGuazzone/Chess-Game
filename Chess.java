public class Chess  {
    public static void main(String[] args)  {
        Board chess = new Board();
        chess.initialize();
        chess.newChessBoard();
        chess.printBoard();
        chess.move("e2", "e4");
        chess.move("e7", "e5");
        chess.move("g1", "f3");
        chess.move("b8", "c6");
        chess.move("f1", "c4");
        chess.move("g8", "f6");
        chess.move("b1", "c3");
        chess.move("f8", "b4");
        chess.move("h5", "f7");
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
    }
}
