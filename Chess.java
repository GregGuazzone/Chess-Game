public class Chess  {
    public static void main(String[] args)  {
        Board chess = new Board();
        chess.initialize();
        chess.newChessBoard();
        chess.printBoard();
        System.out.println("Moving the pawn at (0, 1) to (0, 2)");
        chess.move(0, 1, 0, 2);
        chess.printBoard();
        System.out.println("Moving the pawn at (0, 2) to (0, 3)");
        chess.move(0, 2, 0, 3);
        chess.printBoard();
        System.out.println("Moving the pawn at (0, 3) to (0, 4)");
        chess.move(0, 3, 0, 4);
        chess.printBoard();
        System.out.println("Moving the knight at (1, 0) to (2, 2)");
        chess.move(1, 0, 2, 2);
        chess.printBoard();
        System.out.println("Moving the pawn at (7, 1) to (7, 3)");
        chess.move(7, 1, 7, 3);
        chess.printBoard();
        System.out.println("Moving the rook at (7, 0) to (7, 2)");
        chess.move(7, 0, 7, 3);
        chess.printBoard();

    }
    
}