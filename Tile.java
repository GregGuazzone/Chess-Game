import java.util.ArrayList;

public class Tile extends Board  {
    int coordX;
    int coordY;
    boolean occupied;
    Piece piece;
    ArrayList<Tile> reachableByWhite = new ArrayList<Tile>();
    ArrayList<Tile> reachableByBlack = new ArrayList<Tile>();
    ArrayList<Tile> reachableByThis = new ArrayList<Tile>();

    public Tile(int x, int y) {
        coordX = x;
        coordY = y;
        occupied = false;
        piece = null;
        reachableByWhite = new ArrayList<Tile>();
        reachableByBlack = new ArrayList<Tile>();
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
    public void addReachableByWhite(Tile t) {
        reachableByWhite.add(t);
    }
    public void addReachableByBlack(Tile t) {
        reachableByBlack.add(t);
    }
    public void addReachableBy(int color, Tile t) {
        if(color == 0)  {
            addReachableByWhite(t);
        }
        else    {
            addReachableByBlack(t);
        }
    }
    public ArrayList<Tile> getReachableByWhite() {
        return reachableByWhite;
    }
    public ArrayList<Tile> getReachableByBlack() {
        return reachableByBlack;
    }
    public ArrayList<Tile> getReachableBy(int color) {
        if(color == 0)  {
            return getReachableByWhite();
        }
        else    {
            return getReachableByBlack();
        }
    }
    
    public boolean isReachableBy(int color) {
        if(color == 0)  {
            return getReachableByWhite().size() > 0;
        }
        else    {
            return getReachableByBlack().size() > 0;
        }
    }
    public void addReachableByThis(Tile t) {
        reachableByThis.add(t);
    }
    public ArrayList<Tile> getReachableByThis() {
        return reachableByThis;
    }
    public boolean canMove ()   {
        return getReachableByThis().size() > 0;
    }

    
}