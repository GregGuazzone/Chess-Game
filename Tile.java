public class Tile extends Board  {
    int coordX;
    int coordY;
    boolean occupied;
    Piece piece;
    public Tile(int x, int y) {
        coordX = x;
        coordY = y;
        occupied = false;
        piece = null;
    }
    public void setPiece(Piece p) {
        piece = p;
        occupied = true;
    }
    public void removePiece() {
        piece = null;
        occupied = false;
    }
    public Piece getPiece() {
        return piece;
    }
    public boolean isOccupied() {
        return occupied;
    }
    public boolean isEmpty() {
        return !occupied;
    }
    public int getX() {
        return coordX;
    }
    public int getY() {
        return coordY;
    }
    public void setX(int x) {
        coordX = x;
    }
    public void setY(int y) {
        coordY = y;
    }
    public String toString() {
        if(occupied) {
            return piece.toString();
        }
        else    {
            return " ";
        }
    }

}