#Board.java

This project is a Java implementation of a chess board and its pieces. The Board class is the main class that contains an array of Tile objects and manages the placement and movement of the pieces on the board.

##The Board class has the following methods:

initialize(): Initializes the board with empty tiles.
newChessBoard(): Sets up the board with the pieces in their starting positions.
printBoard(): Prints the board to the console.
movePiece(int startX, int startY, int endX, int endY): Attempts to move a piece from the starting position to the ending position. Returns true if the move is valid and false if it is not.
The Tile class represents a single square on the board. It has the following attributes:

x: The x-coordinate of the tile on the board (0-7).
y: The y-coordinate of the tile on the board (0-7).
occupied: A boolean value indicating if the tile is occupied by a piece.
piece: A reference to the piece occupying the tile, if any.
The Chess class is the superclass for all of the chess pieces. It has the following attributes:

x: The x-coordinate of the piece on the board (0-7).
y: The y-coordinate of the piece on the board (0-7).
color: An integer representing the color of the piece (0 for white, 1 for black).
The following piece classes extend Chess:

Rook: Represents a rook chess piece.
Knight: Represents a knight chess piece.
Bishop: Represents a bishop chess piece.
Queen: Represents a queen chess piece.
King: Represents a king chess piece.
Pawn: Represents a pawn chess piece.
Each piece class has a getPieceChar() method that returns a character representing the piece (e.g. 'R' for rook, 'P' for pawn). The moveIsValid() method in each class determines if a move is a valid move for that piece.
