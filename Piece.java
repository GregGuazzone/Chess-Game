public interface Piece {
    
    boolean isLegalMove(int a, int b, Tile board[][]);

    public abstract void setLegalTiles(Tile[][] board);

    void setLegalTiles(Tile[][] board, int[][] whiteMoves, int[][] blackMoves);

    int [][] getMoveTiles();

    int [][] getAttDefTiles();

    int [][] getAllTiles();

    char getPieceChar();

    void setX(int x);

    void setY(int y);

    void setColor(int color);

    int getColor();

}