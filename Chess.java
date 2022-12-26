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
    }
    
}