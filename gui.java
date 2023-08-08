import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class gui extends Chess{
    private JButton clickedButton;
    Image blackPawn = new ImageIcon("PiecesPNG/Chess_pdt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image blackRook = new ImageIcon("PiecesPNG/Chess_rdt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image blackKnight = new ImageIcon("PiecesPNG/Chess_ndt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image blackBishop = new ImageIcon("PiecesPNG/Chess_bdt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image blackQueen = new ImageIcon("PiecesPNG/Chess_qdt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image blackKing = new ImageIcon("PiecesPNG/Chess_kdt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image whitePawn = new ImageIcon("PiecesPNG/Chess_plt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image whiteKnight = new ImageIcon("PiecesPNG/Chess_nlt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image whiteRook = new ImageIcon("PiecesPNG/Chess_rlt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image whiteBishop = new ImageIcon("PiecesPNG/Chess_blt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image whiteQueen = new ImageIcon("PiecesPNG/Chess_qlt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image whiteKing = new ImageIcon("PiecesPNG/Chess_klt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    JButton[] tile = new JButton[64];
    public boolean buttonClicked = false;


    public void makeBoard(){
        JFrame frame = new JFrame("Chess Board");
        JPanel panel = new JPanel(new GridLayout(8,8));
        //panel.setPreferredSize(new Dimension(800,700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        int n = 0; int a = 0; int b = 1;
        for (int i = 0; i< 64;i++){
            JPanel label= new JPanel(new GridLayout(1,1));
            label.add(new JLabel(new ImageIcon()));
            //label.addMouseListener(this);
            //label.add(new JLabel("chess" + n));
            
            if(i%2 == a)
                label.setBackground(Color.white);
            if(i%2 == b)
                label.setBackground(new Color(0,128,0));
            
            if(i%8 == 7){
                int temp = a;
                a=b;
                b=temp;				
            }			
            panel.add(label, n);
            n++;
        }
        frame.setVisible(true);
        for(int i = 0; i <64; i++){
            if(i < 16)  {
                switch(i)   {
                    case 0: tile[i] = new JButton(new ImageIcon(blackRook));
                    break;
                    case 1: tile[i] = new JButton(new ImageIcon(blackKnight));
                    break;
                    case 2: tile[i] = new JButton(new ImageIcon(blackBishop));
                    break;
                    case 3: tile[i] = new JButton(new ImageIcon(blackQueen));
                    break;
                    case 4: tile[i] = new JButton(new ImageIcon(blackKing));
                    break;
                    case 5: tile[i] = new JButton(new ImageIcon(blackBishop));
                    break;
                    case 6: tile[i] = new JButton(new ImageIcon(blackKnight));
                    break;
                    case 7: tile[i] = new JButton(new ImageIcon(blackRook));
                    break;
                    default: tile[i] = new JButton(new ImageIcon(blackPawn));
                    break;
                }
            }
            else if (i <= 47)    {
                tile[i] = new JButton();
            }
            else if (i > 16){
                switch (i)  {
                    case 63: tile[i] = new JButton(new ImageIcon(whiteRook));
                    break;
                    case 62: tile[i] = new JButton(new ImageIcon(whiteKnight));
                    break;
                    case 61: tile[i] = new JButton(new ImageIcon(whiteBishop));
                    break;
                    case 60: tile[i] = new JButton(new ImageIcon(whiteKing));
                    break;
                    case 59: tile[i] = new JButton(new ImageIcon(whiteQueen));
                    break;
                    case 58: tile[i] = new JButton(new ImageIcon(whiteBishop));
                    break;
                    case 57: tile[i] = new JButton(new ImageIcon(whiteKnight));
                    break;
                    case 56: tile[i] = new JButton(new ImageIcon(whiteRook));
                    break;
                    default: tile[i] = new JButton(new ImageIcon(whitePawn));
                    break;
                    
                }
            }
            tile[i].setBorderPainted(false);
        }
        for(int i = 0; i < 64; i++){
            ((JPanel) panel.getComponent(i)).remove(0);
            ((JPanel) panel.getComponent(i)).add(tile[i]);
        }
        
        frame.add(panel);
		frame.setSize(600, 600);
		frame.getContentPane().setPreferredSize(new Dimension(800,700));
        
        for (int i = 0; i < 64; i++) {
            int [] coords = new int[2];
            int row = i / 8;
            int col = i % 8;
            coords[0] = col;
            coords[1] = 7-row;
            tile[i].addActionListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Button clicked");

                    clickedButton = (JButton) e.getSource();
                    playTurn(coords);
                }
            });
        }

        /*JPanel topPanel = new JPanel();
        JButton startButton = new JButton("Start");
        topPanel.add(startButton);
        frame.add(topPanel, BorderLayout.PAGE_START);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chess.game();
            }
        });
        */// a button to start the game to be implemented later


    }

    public boolean updateGui(Tile[][] boardTiles)   {
        for (int i = 0; i < 64; i++) {
            int y = 7-(i / 8);
            int x = (i % 8);
            if (boardTiles[x][y].getPiece() !=null) {
                if (boardTiles[x][y].getPiece().getColor() == 0) {
                    switch (boardTiles[x][y].getPiece().getPieceChar()) {
                        case 'P':
                            tile[i].setIcon(new ImageIcon(whitePawn));
                            break;
                        case 'R':
                            tile[i].setIcon(new ImageIcon(whiteRook));
                            break;
                        case 'N':
                            tile[i].setIcon(new ImageIcon(whiteKnight));
                            break;
                        case 'B':
                            tile[i].setIcon(new ImageIcon(whiteBishop));
                            break;
                        case 'Q':
                            tile[i].setIcon(new ImageIcon(whiteQueen));
                            break;
                        case 'K':
                            tile[i].setIcon(new ImageIcon(whiteKing));
                            break;
                    }
                } else {
                    switch (boardTiles[x][y].getPiece().getPieceChar()) {
                        case 'P':
                            tile[i].setIcon(new ImageIcon(blackPawn));
                            break;
                        case 'R':
                            tile[i].setIcon(new ImageIcon(blackRook));
                            break;
                        case 'N':
                            tile[i].setIcon(new ImageIcon(blackKnight));
                            break;
                        case 'B':
                            tile[i].setIcon(new ImageIcon(blackBishop));
                            break;
                        case 'Q':
                            tile[i].setIcon(new ImageIcon(blackQueen));
                            break;
                        case 'K':
                            tile[i].setIcon(new ImageIcon(blackKing));
                            break;
                    }
                }
            } else {
                tile[i].setIcon(null);
            }
    }
    return true;
    }
    


    public int[] waitForButtonPressed() {
        while(clickedButton == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String name = clickedButton.getName();
        //split the name into coordinates
        String[] coordinates = name.split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        buttonClicked = true;
        return new int[]{x, y};
    }

    public void printBoard(Tile[][] board) {
        for (int j = 0; j < 8; j++) {
            System.out.print(" " + (7 - j) + "| ");
            for (int i = 0; i < 8; i++) {
                if (board[i][7 - j].isOccupied()) {
                    System.out.print(board[i][7 - j].getPiece().getPieceChar() + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println("   -----------------");
        System.out.println("    a b c d e f g h");
    }

}

