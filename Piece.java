public interface Piece {
    public boolean isLegalMove(int a, int b, Tile board[][]);
   
    public char getPieceChar();

    public void setX(int x);

    public void setY(int y);

    public void setColor(int color);

    public int getColor();

}