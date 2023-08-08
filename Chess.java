public class Chess {
    static gui gBoard = new gui();
    static Board board = new Board();
    public static void main(String[] args)  {
        gBoard.makeBoard();
        board.initialize();
        board.newChessBoard();
        board.printBoard();
        board.updateLegalTiles();
    }
    int[] start = new int[2];
    int[] end = new int[2];
    int currColor = 0;
    int movePart = 0;

    public void playTurn(int[] coords)   {
        int x = coords[0];
        int y = coords[1];

        if(board.board[x][y].isOccupied() && board.board[x][y].getPiece().getColor() == currColor)    {
            movePart = 0;
        }

        if(movePart == 0 && !board.board[x][y].isOccupied())    {
            System.out.println("No Piece Selected");
            return;
        }
        System.out.println("Move Part: " + movePart + ",  currColor: " + currColor);
        if(movePart == 0) {
            if(board.board[x][y].isOccupied() && board.board[x][y].getPiece().getColor() == currColor) {
                movePart = 1;
                start = coords;
            }
            else {
                System.out.println("Invalid Move");
                return;
            }
        }
        else if(movePart == 1)  {
            end = coords;
            if(board.move(start[0], start[1], end[0], end[1])) {
                movePart = 0;
                gBoard.updateGui(board.board);
                currColor = 1 - currColor;
                board.updateLegalTiles();
            }
            return;
        }
        //System.out.println("Attackable by white:");
        //board.printAllMovesBy(0);
        //System.out.println("Attackable by black:");
        //board.printAllMovesBy(1);
        //System.out.println("In Check white: " + board.inCheck(0) +  ", In Check black: " + board.inCheck(1));

    }
    public int[] startTurn(int [] coords)  {
        return coords;

    }
    public int[] endTurn(int [] coords)    {
        return coords;
    }





}
