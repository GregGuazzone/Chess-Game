public class Chess  {
    public static void main(String[] args)  {
        Board chess = new Board();
        chess.initialize();
        chess.newChessBoard();
        chess.printBoard();
        System.out.println("Moving the pawn at (0, 1) to (0, 2)");
        chess.move(0, 1, 0, 2);
        chess.printBoard();
        System.out.println("Moving the pawn at (7, 1) to (7, 3)");
        chess.move(7, 1, 7, 3);
        chess.printBoard();
        System.out.println("Moving the pawn at (7, 3) to (7, 4)");
        chess.move(7, 3, 7, 4);
        chess.printBoard();
        System.out.println("Moving the rook at (7, 0) to (7, 3)");
        chess.move(7, 0, 7, 3);
        chess.printBoard();
        System.out.println("Moving the pawn at (4, 6) to (4, 5)");
        chess.move(4, 6, 4, 5);
        chess.printBoard();
        System.out.println("Moving the pawn at (4, 5) to (4, 6)");
        chess.move(4, 5, 4, 6);
        chess.printBoard();

        
    }
  }