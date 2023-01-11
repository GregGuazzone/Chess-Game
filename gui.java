import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class gui{
    private JButton clickedButton;
    Image whitePawn = new ImageIcon("PiecesPNG/Chess_pdt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image whiteRook = new ImageIcon("PiecesPNG/Chess_rdt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image whiteKnight = new ImageIcon("PiecesPNG/Chess_ndt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image whiteBishop = new ImageIcon("PiecesPNG/Chess_bdt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image whiteQueen = new ImageIcon("PiecesPNG/Chess_qdt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image whiteKing = new ImageIcon("PiecesPNG/Chess_kdt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image blackPawn = new ImageIcon("PiecesPNG/Chess_plt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image blackKnight = new ImageIcon("PiecesPNG/Chess_nlt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image blackRook = new ImageIcon("PiecesPNG/Chess_rlt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image blackBishop = new ImageIcon("PiecesPNG/Chess_blt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image blackQueen = new ImageIcon("PiecesPNG/Chess_qlt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    Image blackKing = new ImageIcon("PiecesPNG/Chess_klt45.svg.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    JButton[] tile = new JButton[64];


    public void makeBoard(){
        JFrame frame = new JFrame("Chess Board");
        JPanel panel = new JPanel(new GridLayout(8,8));
        //panel.setPreferredSize(new Dimension(800,700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        int n = 0; int a = 0; int b = 1;
        for (int i = 0; i< 8;i++){
            JPanel label= new JPanel(new GridLayout(1,1));
            label.add(new JLabel(new ImageIcon()));
            //label.addMouseListener(this);
            //label.add(new JLabel("chess" + n));
            
            if(i%2 == a)
                label.setBackground(Color.green);
            if(i%2 == b)
                label.setBackground(Color.white);
            
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
                    case 60: tile[i] = new JButton(new ImageIcon(whiteQueen));
                    break;
                    case 59: tile[i] = new JButton(new ImageIcon(whiteKing));
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
            int row = i / 8;
            int col = i % 8;
            tile[i].setName(row + "," + col);
            tile[i].addActionListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickedButton = (JButton) e.getSource();
                    // Now you can use the name variable to get the coordinates of the clicked tile
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
//iterate thorugh the board and update the gui
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (boardTiles[i][j].getPiece() != null) {
                    if (boardTiles[i][j].getPiece().getColor() == 1) {
                        switch (boardTiles[i][j].getPiece().getPieceChar()) {
                            case 'P':
                                tile[i * 8 + j].setIcon(new ImageIcon(blackPawn));
                                break;
                            case 'R':
                                tile[i * 8 + j].setIcon(new ImageIcon(blackRook));
                                break;
                            case 'N':
                                tile[i * 8 + j].setIcon(new ImageIcon(blackKnight));
                                break;
                            case 'B':
                                tile[i * 8 + j].setIcon(new ImageIcon(blackBishop));
                                break;
                            case 'Q':
                                tile[i * 8 + j].setIcon(new ImageIcon(blackQueen));
                                break;
                            case 'K':
                                tile[i * 8 + j].setIcon(new ImageIcon(blackKing));
                                break;
                        }
                    } else {
                        switch (boardTiles[i][j].getPiece().getPieceChar()) {
                            case 'P':
                                tile[i * 8 + j].setIcon(new ImageIcon(whitePawn));
                                break;
                            case 'R':
                                tile[i * 8 + j].setIcon(new ImageIcon(whiteRook));
                                break;
                            case 'N':
                                tile[i * 8 + j].setIcon(new ImageIcon(whiteKnight));
                                break;
                            case 'B':
                                tile[i * 8 + j].setIcon(new ImageIcon(whiteBishop));
                                break;
                            case 'Q':
                                tile[i * 8 + j].setIcon(new ImageIcon(whiteQueen));
                                break;
                            case 'K':
                                tile[i * 8 + j].setIcon(new ImageIcon(whiteKing));
                                break;
                        }
                    }
                } else {
                    tile[i * 8 + j].setIcon(null);
                }
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
        return new int[]{x, y};
    }
}