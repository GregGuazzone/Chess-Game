import java.util.ArrayList;

public class Tile extends Board  {
    int coordX;
    int coordY;
    boolean occupied;
    Piece piece;
    ArrayList<Tile> attackableByWhite = new ArrayList<Tile>();
    ArrayList<Tile> attackableByBlack = new ArrayList<Tile>();

    public Tile(int x, int y) {
        coordX = x;
        coordY = y;
        occupied = false;
        piece = null;
        attackableByWhite = new ArrayList<Tile>();
        attackableByBlack = new ArrayList<Tile>();
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
    public void addAttackableByWhite(Tile t) {
        attackableByWhite.add(t);
    }
    public void addAttackableByBlack(Tile t) {
        attackableByBlack.add(t);
    }

    public void addAttackableBy(int color, Tile t) {
        if(color == 0)  {
            addAttackableByWhite(t);
        }
        else    {
            addAttackableByBlack(t);
        }
    }
    public ArrayList<Tile> getAttackableByWhite() {
        return attackableByWhite;
    }
    public ArrayList<Tile> getAttackableByBlack() {
        return attackableByBlack;
    }
    public ArrayList<Tile> getAttackableBy(int color) {
        if(color == 0)  {
            return getAttackableByWhite();
        }
        else    {
            return getAttackableByBlack();
        }
    }
    
    public boolean isAttackableBy(int color) {
        if(color == 0)  {
            return getAttackableByWhite().size() > 0;
        }
        else    {
            return getAttackableByBlack().size() > 0;
        }
    }
    public void addAttackableByThis(Tile tile) {
        int color = tile.getPiece().getColor();
        if (color == 0) {
            if(!attackableByWhite.contains(tile)) {
                attackableByWhite.add(tile);
            }
        }
        else {
            if(!attackableByBlack.contains(tile)) {
                attackableByBlack.add(tile);
            }
        }
    }


    
}