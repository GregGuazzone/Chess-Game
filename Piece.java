public interface Piece {
    public boolean isLegalMove(int a, int b, Tile board[][]);
   
    public char getPieceChar();
}