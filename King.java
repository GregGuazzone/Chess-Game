public class King implements Piece{
    int x;
    int y;
    int color;
    public King(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public int[][] legalMoveTiles(Tile[][] board)   {
        int[][] legalMoveTiles = new int[8][8];
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if(x+i >= 0 && x+i < 8 && y+j >= 0 && y+j < 8) {
                    if(board[x+i][y+j].isEmpty())   {
                        legalMoveTiles[x+i][y+j] = 1;
                    }
                    else if(board[x+i][y+j].getPiece().getColor() != color) {
                        legalMoveTiles[x+i][y+j] = 1;
                    }
                }
            }
        }
        return legalMoveTiles;
    }

    public boolean isLegalMove(int a, int b, Tile board[][]) {
        return legalMoveTiles(board)[a][b] == 1;
    }
    public char getPieceChar()  {
        return 'K';
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setColor(int color) {
        this.color = color;
    }
    public int getColor()   {
        return color;
    }
}
