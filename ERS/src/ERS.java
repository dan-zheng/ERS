/*
Programmer: Daniel Zheng
Date: 13 March 2014
This is my Java simulation of the card game Egyptian Ratscrew, using hashmaps.
Card sprites from: http://www.waste.org/~oxymoron/cards/
Queue package from: stackoverflow

All other sprites in this game were made by the programmer, Daniel Zheng!

TO ADD: rules in command prompt
APP STORE: tap deck to flip, tap used pile to slap
*/

import java.awt.Color; // enables color, used for transparency of cards
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent; // enables getKeyCode for KeyListener
import queue.*; // enables queues
import javax.swing.JOptionPane; // enables simple popup boxes, used for dialog boxes
import java.util.ArrayList; // enables arraylists
import java.util.Collections; // enables shuffling using collections
import java.util.Random; // enables random number generation, used for random card generation
import java.util.Map; // enables maps, used to keep track of cards
import java.util.HashMap; // enables hashmaps, used to keep track of cards
import javax.swing.ImageIcon; // enables imageicons, used to display cards


public class ERS extends javax.swing.JFrame 
{
    // Declare variables
    static Card card = new Card();
    static String name; // name of the card
    static int value; // value of the card
    static boolean gameOn = false; // start game condition
    static Queue deckOne = new ListQueue(); // player one deck of cards
    static Queue deckTwo = new ListQueue(); // player two deck of cards
    static ArrayList<String> deckUsed = new ArrayList<>(); // holds the used cards pile
    static Map usedCards = new HashMap(); // need to implement!
    static ArrayList<Integer> maxcards = new ArrayList<>(); // holds the deck of cards
    static boolean turn = true; // holds player turn
    static int cardsToPlace = 1; // holds number of cards needed to place
    static boolean faceCard = false; // holds whether player lost face card streak
    static int faceCardWin = 0; // holds face card winner
    ImageIcon deck1 = new ImageIcon("src/cardsprites/deck1.png");
    ImageIcon deck2 = new ImageIcon("src/cardsprites/deck2.png");
    ImageIcon deck3 = new ImageIcon("src/cardsprites/deck3.png");
    ImageIcon deck4 = new ImageIcon("src/cardsprites/deck4.png");
    ImageIcon flip1 = new ImageIcon("src/cardsprites/flipOne.png");
    ImageIcon slap1 = new ImageIcon("src/cardsprites/slapOne.png");
    ImageIcon flip2 = new ImageIcon("src/cardsprites/flipTwo.png");
    ImageIcon slap2 = new ImageIcon("src/cardsprites/slapTwo.png");
    ImageIcon slap = new ImageIcon("src/cardsprites/slap.png");
    ImageIcon slapalert = new ImageIcon("src/cardsprites/slapalert.png");
    ImageIcon slapfail = new ImageIcon("src/cardsprites/slapfail.png");
    ImageIcon facewin = new ImageIcon("src/cardsprites/win.png");
    ImageIcon victory = new ImageIcon("src/cardsprites/victory.png");
    ImageIcon leftarrow = new ImageIcon("src/cardsprites/leftarrow.png");
    ImageIcon rightarrow = new ImageIcon("src/cardsprites/rightarrow.png");
    ImageIcon troll = new ImageIcon("src/cardsprites/trollface.png");
    ImageIcon bandage = new ImageIcon("src/cardsprites/bandage.png");
    ImageIcon blank = new ImageIcon("src/cardsprites/blank.png");
    static int value1, value2, value3 = 0;
    
    public ERS() 
    { // constructor
        initComponents();
        getContentPane().setBackground(new java.awt.Color(204,204,204)); // sets background color using RGB values 
        // javax.swing.UIManager.put("OptionPane.font", new Font("Visitor TT1 BRK", Font.PLAIN, 24));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        promptOne = new javax.swing.JLabel();
        promptTwo = new javax.swing.JLabel();
        cardsOne = new java.awt.Panel();
        OneLabel = new javax.swing.JLabel();
        cardsTwo = new java.awt.Panel();
        TwoLabel = new javax.swing.JLabel();
        start = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        options = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        countOne = new javax.swing.JLabel();
        countTwo = new javax.swing.JLabel();
        countPile = new javax.swing.JLabel();
        slapLabelOne = new javax.swing.JLabel();
        slapLabelTwo = new javax.swing.JLabel();
        cardsPile = new javax.swing.JPanel();
        PileLabelOne = new javax.swing.JLabel();
        PileLabelTwo = new javax.swing.JLabel();
        PileLabelThree = new javax.swing.JLabel();
        PileLabelFour = new javax.swing.JLabel();
        instructOne = new javax.swing.JPanel();
        flipOne = new javax.swing.JLabel();
        slapOne = new javax.swing.JLabel();
        instructTwo = new javax.swing.JPanel();
        flipTwo = new javax.swing.JLabel();
        slapTwo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Friendly Egyptian Ratscrew");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        title.setFont(new java.awt.Font("Visitor TT1 BRK", 1, 60)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardsprites/title.png"))); // NOI18N
        title.setToolTipText("");

        title2.setFont(new java.awt.Font("Visitor TT1 BRK", 0, 24)); // NOI18N
        title2.setForeground(new java.awt.Color(102, 153, 225));
        title2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardsprites/title2.png"))); // NOI18N

        promptOne.setFont(new java.awt.Font("Visitor TT1 BRK", 0, 24)); // NOI18N
        promptOne.setForeground(new java.awt.Color(86, 137, 173));
        promptOne.setPreferredSize(new java.awt.Dimension(34, 1));

        promptTwo.setFont(new java.awt.Font("Visitor TT1 BRK", 0, 24)); // NOI18N
        promptTwo.setForeground(new java.awt.Color(86, 137, 173));
        promptTwo.setText("click start!");
        promptTwo.setPreferredSize(new java.awt.Dimension(34, 1));

        cardsOne.setBackground(new java.awt.Color(240, 240, 240));
        cardsOne.setMaximumSize(new java.awt.Dimension(174, 194));
        cardsOne.setMinimumSize(new java.awt.Dimension(174, 194));
        cardsOne.setName(""); // NOI18N
        cardsOne.setPreferredSize(new java.awt.Dimension(174, 194));

        OneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OneLabel.setMaximumSize(new java.awt.Dimension(174, 194));
        OneLabel.setMinimumSize(new java.awt.Dimension(174, 194));
        OneLabel.setPreferredSize(new java.awt.Dimension(174, 194));

        javax.swing.GroupLayout cardsOneLayout = new javax.swing.GroupLayout(cardsOne);
        cardsOne.setLayout(cardsOneLayout);
        cardsOneLayout.setHorizontalGroup(
            cardsOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardsOneLayout.setVerticalGroup(
            cardsOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardsTwo.setBackground(new java.awt.Color(240, 240, 240));
        cardsTwo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cardsTwo.setMaximumSize(new java.awt.Dimension(174, 194));
        cardsTwo.setMinimumSize(new java.awt.Dimension(174, 194));
        cardsTwo.setName(""); // NOI18N
        cardsTwo.setPreferredSize(new java.awt.Dimension(174, 194));

        TwoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TwoLabel.setMaximumSize(new java.awt.Dimension(174, 194));
        TwoLabel.setMinimumSize(new java.awt.Dimension(174, 194));
        TwoLabel.setPreferredSize(new java.awt.Dimension(174, 194));

        javax.swing.GroupLayout cardsTwoLayout = new javax.swing.GroupLayout(cardsTwo);
        cardsTwo.setLayout(cardsTwoLayout);
        cardsTwoLayout.setHorizontalGroup(
            cardsTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TwoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardsTwoLayout.setVerticalGroup(
            cardsTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TwoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardsprites/start.png"))); // NOI18N
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                startMouseReleased(evt);
            }
        });

        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardsprites/info.png"))); // NOI18N
        info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                infoMouseReleased(evt);
            }
        });

        options.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardsprites/options.png"))); // NOI18N
        options.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                optionsMouseReleased(evt);
            }
        });

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardsprites/exit.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitMouseReleased(evt);
            }
        });

        countOne.setFont(new java.awt.Font("Visitor TT1 BRK", 0, 24)); // NOI18N
        countOne.setForeground(new java.awt.Color(255, 255, 255));
        countOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countOne.setPreferredSize(new java.awt.Dimension(73, 10));

        countTwo.setFont(new java.awt.Font("Visitor TT1 BRK", 0, 24)); // NOI18N
        countTwo.setForeground(new java.awt.Color(255, 255, 255));
        countTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countTwo.setToolTipText("");
        countTwo.setPreferredSize(new java.awt.Dimension(73, 10));

        countPile.setFont(new java.awt.Font("Visitor TT1 BRK", 0, 24)); // NOI18N
        countPile.setForeground(new java.awt.Color(255, 255, 255));
        countPile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        slapLabelOne.setMaximumSize(new java.awt.Dimension(104, 70));
        slapLabelOne.setMinimumSize(new java.awt.Dimension(104, 70));
        slapLabelOne.setPreferredSize(new java.awt.Dimension(104, 70));

        slapLabelTwo.setMaximumSize(new java.awt.Dimension(104, 70));
        slapLabelTwo.setMinimumSize(new java.awt.Dimension(104, 70));
        slapLabelTwo.setPreferredSize(new java.awt.Dimension(104, 70));

        cardsPile.setPreferredSize(new java.awt.Dimension(224, 194));

        PileLabelOne.setMaximumSize(new java.awt.Dimension(146, 194));
        PileLabelOne.setMinimumSize(new java.awt.Dimension(146, 194));
        PileLabelOne.setPreferredSize(new java.awt.Dimension(146, 194));

        PileLabelTwo.setMaximumSize(new java.awt.Dimension(26, 194));
        PileLabelTwo.setMinimumSize(new java.awt.Dimension(26, 194));
        PileLabelTwo.setPreferredSize(new java.awt.Dimension(26, 194));

        PileLabelThree.setMaximumSize(new java.awt.Dimension(26, 194));
        PileLabelThree.setMinimumSize(new java.awt.Dimension(26, 194));
        PileLabelThree.setPreferredSize(new java.awt.Dimension(26, 194));

        PileLabelFour.setMaximumSize(new java.awt.Dimension(26, 194));
        PileLabelFour.setMinimumSize(new java.awt.Dimension(26, 194));
        PileLabelFour.setPreferredSize(new java.awt.Dimension(26, 194));

        javax.swing.GroupLayout cardsPileLayout = new javax.swing.GroupLayout(cardsPile);
        cardsPile.setLayout(cardsPileLayout);
        cardsPileLayout.setHorizontalGroup(
            cardsPileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardsPileLayout.createSequentialGroup()
                .addComponent(PileLabelFour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PileLabelThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PileLabelTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PileLabelOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        cardsPileLayout.setVerticalGroup(
            cardsPileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsPileLayout.createSequentialGroup()
                .addGroup(cardsPileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PileLabelFour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardsPileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PileLabelTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PileLabelThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PileLabelOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        instructOne.setMaximumSize(new java.awt.Dimension(174, 70));
        instructOne.setMinimumSize(new java.awt.Dimension(174, 70));
        instructOne.setPreferredSize(new java.awt.Dimension(174, 70));

        flipOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        flipOne.setMaximumSize(new java.awt.Dimension(174, 35));
        flipOne.setMinimumSize(new java.awt.Dimension(174, 35));
        flipOne.setName(""); // NOI18N
        flipOne.setPreferredSize(new java.awt.Dimension(174, 35));

        slapOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        slapOne.setMaximumSize(new java.awt.Dimension(174, 35));
        slapOne.setMinimumSize(new java.awt.Dimension(174, 35));
        slapOne.setPreferredSize(new java.awt.Dimension(174, 35));

        javax.swing.GroupLayout instructOneLayout = new javax.swing.GroupLayout(instructOne);
        instructOne.setLayout(instructOneLayout);
        instructOneLayout.setHorizontalGroup(
            instructOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(flipOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(slapOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        instructOneLayout.setVerticalGroup(
            instructOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instructOneLayout.createSequentialGroup()
                .addComponent(flipOne, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(slapOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        instructTwo.setMaximumSize(new java.awt.Dimension(174, 70));
        instructTwo.setMinimumSize(new java.awt.Dimension(174, 70));

        flipTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        flipTwo.setMaximumSize(new java.awt.Dimension(174, 35));
        flipTwo.setMinimumSize(new java.awt.Dimension(174, 35));
        flipTwo.setName(""); // NOI18N
        flipTwo.setPreferredSize(new java.awt.Dimension(174, 35));

        slapTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        slapTwo.setMaximumSize(new java.awt.Dimension(174, 35));
        slapTwo.setMinimumSize(new java.awt.Dimension(174, 35));
        slapTwo.setPreferredSize(new java.awt.Dimension(174, 35));

        javax.swing.GroupLayout instructTwoLayout = new javax.swing.GroupLayout(instructTwo);
        instructTwo.setLayout(instructTwoLayout);
        instructTwoLayout.setHorizontalGroup(
            instructTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(flipTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(slapTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        instructTwoLayout.setVerticalGroup(
            instructTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instructTwoLayout.createSequentialGroup()
                .addComponent(flipTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(slapTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(promptOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(countOne, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cardsOne, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(instructOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(slapLabelOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(slapLabelTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cardsPile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(countPile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cardsTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(instructTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(countTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(promptTwo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(start)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(info)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(options)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(512, 512, 512)
                        .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(0, 0, 0)
                .addComponent(title2)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(countPile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(countOne, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(countTwo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardsTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardsOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardsPile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(instructOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(instructTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(slapLabelTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(slapLabelOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(promptOne, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(promptTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(info)
                    .addComponent(start)
                    .addComponent(options)
                    .addComponent(exit))
                .addContainerGap())
        );

        cardsOne.setBackground( new Color(204, 204, 204, 0) ); // sets alpha value of card panel to 0
        cardsTwo.setBackground( new Color(204, 204, 204, 0) ); // sets alpha value of card panel to 0
        cardsPile.setBackground( new Color(204, 204, 204, 0) ); // sets alpha value of card panel to 0
        instructOne.setBackground( new Color(204, 204, 204) ); // sets alpha value of card panel to 0
        instructTwo.setBackground( new Color(204, 204, 204) ); // sets alpha value of card panel to 0

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void infoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMouseReleased
        JOptionPane.showMessageDialog(ERS.this,
                "Programmer: Daniel Zheng.\n"
                        + "I chose to program this game simply because it's one of the only\n"
                        + "card games I know well and because it's the game I've played most\n often at the Academy.",
                "Friendly Game Information",
                JOptionPane.INFORMATION_MESSAGE); // shows program info
    }//GEN-LAST:event_infoMouseReleased

    private void exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseReleased
        // exits program
        goodbye();
    }//GEN-LAST:event_exitMouseReleased

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // game controls, the bulk of the program is here!
        if(gameOn == true) // controls only work if start button has been pressed
        {        
            int keyCode = evt.getKeyCode();
            switch(keyCode)
            {
                case KeyEvent.VK_W: // if w is released
                {
                    if(turn == true)
                    {
                        evaluateflip(1); // evaluates flip
                        countPile.setText("Pile: " + deckUsed.size()); // sets pile label to number of cards in pile
                        evaluateend(); // evaluates if gameover
                    }
                }
                    break;
                case KeyEvent.VK_UP: // if up arrow key is released
                {
                   if(turn == false)
                   {
                        evaluateflip(2); // evaluates flip
                        countPile.setText("Pile: " + deckUsed.size()); // sets pile label to number of cards in pile
                        evaluateend(); // evaluates if gameover
                   }
                }
                    break;
                case KeyEvent.VK_S: // if s arrow key is released
                {
                    evaluateslap(1);
                    countPile.setText("Pile: " + deckUsed.size()); // sets pile label to number of cards in pile
                }
                break;
                case KeyEvent.VK_DOWN: // if down arrow key is released
                {
                    evaluateslap(2);
                    countPile.setText("Pile: " + deckUsed.size()); // sets pile label to number of cards in pile
                }
                break;
            }
        }
    }//GEN-LAST:event_formKeyReleased

    private void startMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMouseReleased
        if(gameOn == false) // if game has not been started
        {
            gamestart(); // sets up game
        }
        else if(gameOn == true)
        {
            Object[] options = {"Restart",
                    "Resume",
                    "Exit Game"};
            int n = JOptionPane.showOptionDialog(ERS.this,
               "A game session is already in progress.\nWould you like to start a new session?", // message
               "Friendly Prompt", // title
               JOptionPane.YES_NO_CANCEL_OPTION, // type
               JOptionPane.QUESTION_MESSAGE, // icon type
               null,
               options,
               options[2]);
            
           switch(n)
           {
               case 0:
                   gameclear(); // clears game, readying for restart
                   gamestart(); // resets game
                   countPile.setText("restarted"); // shows that game has been restarted
                   break;
               // case 1: resume means do nothing! 
               case 2:
                   goodbye(); // exits game
                   break;
           }
        }
    }//GEN-LAST:event_startMouseReleased

    private void optionsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionsMouseReleased
        JOptionPane.showMessageDialog(ERS.this,
            "There are no options in this game. Yet.",
            "Friendly Troll",
            JOptionPane.INFORMATION_MESSAGE,
            troll);
    }//GEN-LAST:event_optionsMouseReleased

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ERS().setVisible(true);
                System.out.println("Hello, friend!");
                System.out.println("Welcome to my friendly game, Egyptian Ratscrew.");
                System.out.println("To start a game session, click on the start button!");
            }
        });
    }
    
    public void displaycards(String newcard) // displays used cards
    {
        displaydeck(); // changes display of deck\
        
        deckUsed.add(newcard); // adds newcard to the list of used cards
        PileLabelFour.setIcon(PileLabelThree.getIcon()); // sets label 4 icon to label 3 icon
        PileLabelThree.setIcon(PileLabelTwo.getIcon()); // sets label 3 icon to label 2 icon
        PileLabelTwo.setIcon(PileLabelOne.getIcon()); // sets label 2 icon to label 1 icon
        ImageIcon lastCard = new ImageIcon("src/cardsprites/" + newcard + ".png"); // finds icon of newcard in package
        PileLabelOne.setIcon(lastCard); // sets label 1 icon to newcard
    }
    
    public void displayinstruc() // displays instructions
    {
        // sets icon for various instruction labels
        flipOne.setIcon(flip1);
        flipTwo.setIcon(flip2);
        slapOne.setIcon(slap1);
        slapTwo.setIcon(slap2);
    }
    
    public void displaydeck() // displays deck
    {
        // sets icon for the player deck JLabels based on number of cards in deck      
        if((deckOne.size() >= 0)&&(deckOne.size() <= 13))
        {
            OneLabel.setIcon(deck4);
        }
        else if((deckOne.size() >= 13)&&(deckOne.size() <= 26))
        {
            OneLabel.setIcon(deck3);
        }
        else if((deckOne.size() >= 26)&&(deckOne.size() <= 39))
        {
            OneLabel.setIcon(deck2);
        }
        else if((deckOne.size() >= 39)&&(deckOne.size() <= 52))
        {
            OneLabel.setIcon(deck1);
        }
        
        if((deckTwo.size() >= 0)&&(deckTwo.size() <= 13))
        {
            TwoLabel.setIcon(deck4);
        }
        else if((deckTwo.size() >= 13)&&(deckTwo.size() <= 26))
        {
            TwoLabel.setIcon(deck3);
        }
        else if((deckTwo.size() >= 26)&&(deckTwo.size() <= 39))
        {
            TwoLabel.setIcon(deck2);
        }
        else if((deckTwo.size() >= 39)&&(deckTwo.size() <= 52))
        {
            TwoLabel.setIcon(deck1);
        }
        Integer sizeOne = new Integer(deckOne.size());
        countOne.setText("P1: " + sizeOne.toString()); // displays number of cards left in deckOne
        Integer sizeTwo = new Integer(deckTwo.size());
        countTwo.setText("P2: " + sizeTwo.toString()); // displays number of cards left in deckTwo
    }
    
    public void evaluatecards() // checks if face card or ace is played
    {
        String cardname = deckUsed.get(deckUsed.size()-1); // gets the name of last card played
        int cardvalue = (int) usedCards.get(cardname); // checks value of last card played

        if(cardvalue == 11) // if card is jack
        {
            cardsToPlace = 2; // sets additional number of cards to place to 1
            faceCard = true;
            turn = !turn; // switches turn
        }
        else if(cardvalue == 12) // if card is queen
        {
            cardsToPlace = 3; // sets additional number of cards to place to 2
            faceCard = true;
            turn = !turn; // switches turn
        }
        else if(cardvalue == 13) // if card is king
        {
            cardsToPlace = 4; // sets additional number of cards to place to 3
            faceCard = true;
            turn = !turn;
        }
        else if(cardvalue == 1) // if card is ace
        {
            cardsToPlace = 5; // sets additional number of cards to place to 4
            faceCard = true;
            turn = !turn;
        }
    }
    
    public void evaluateflip(int turnvalue) // evaluates flipping
    {
        if(turnvalue == displayplayer()) // checks for player turn
        {
            if(deckUsed.isEmpty()) // if a successful slap has just been performed
            {
                PileLabelThree.setIcon(blank);
                PileLabelTwo.setIcon(blank); // sets label 2 icon to blank
                PileLabelOne.setIcon(blank); // sets label 1 icon to blank
            }
            if(cardsToPlace > 0) // if additional cards must be placed
            {
                labelblank(); // clears label
                if(turnvalue == 1)
                {
                    slapLabelOne.setIcon(rightarrow); // changes icon to right arrow
                    name = (String) deckOne.dequeue(); // sets string name to name of top card in deck
                }
                else if(turnvalue == 2)
                {
                    slapLabelTwo.setIcon(leftarrow); // changes icon to left arrow
                    name = (String) deckTwo.dequeue(); // sets string name to name of top card in deck
                }
                displaycards(name); // changes display for used cards
                evaluatecards(); // checks for face cards
                cardsToPlace--; // reduces additional number of cards needed to place by 1
                if(cardsToPlace == 1)
                {
                    promptTwo.setText("Player " + displayplayer() + " needs to flip 1 more card now."); // sets prompt
                }
                else if(cardsToPlace > 1)
                { 
                    promptTwo.setText("Player " + displayplayer() + " needs to flip " + cardsToPlace + " more cards now."); // sets prompt
                }
            }
            if(cardsToPlace == 0) // if additional number of cards needed to place = 0
            {
                if(faceCardWin == 0)
                {
                    turn = !turn; // changes turn
                }
                if(faceCard == true) // if face card streak
                {
                    labelblank(); // clears labels
                    if(displayplayer() == 1)
                    {
                        slapLabelOne.setIcon(slapalert); // changes icon to slap alert
                    }
                    else if(displayplayer() == 2)
                    {
                        slapLabelTwo.setIcon(slapalert); // changes icon to slap alert
                    }
                    promptTwo.setText("Player " + displayplayer() + " should slap to secure the pile!"); // updates promptOne
                    faceCardWin = displayplayer(); //sets face card streak winner to player
                }
                else if(faceCard == false) // if no face card streak
                {
                    promptTwo.setText("Player " + displayplayer() + " should flip a card now."); // sets prompt
                    cardsToPlace = 1;
                }
            }
        } // end if turn == true
    }
    
    public void evaluateslap(int slapTurn) // checks if slap is legitimate
    {                
        evaluateend(); // evaluates if end condition reached
        if(deckUsed.size() >= 2)
        {
            String cardname = deckUsed.get(deckUsed.size()-1); // gets the name of last card played
            value1 = (int) usedCards.get(cardname); // checks value of last card played
            String cardname2 = deckUsed.get(deckUsed.size()-2); // gets the name of 2nd last card played
            value2 = (int) usedCards.get(cardname2); // checks value of last card played

            String cardname3;

            if(deckUsed.size() >= 3)
            {
                cardname3 = deckUsed.get(deckUsed.size()-3); // gets the name of 3rd last card played
                value3 = (int) usedCards.get(cardname3); // checks value of last card played
            }

            if((value1 == value2) || (value1 == value3))
            {
                labelblank(); // clears labels
                promptOne.setText("Player " + slapTurn + " slapped " + deckUsed.size() + " cards successfully!");
                if(slapTurn == 1)
                {
                    for(int i=deckUsed.size()-1; i>=0; i--)
                    {
                        deckOne.enqueue(deckUsed.get(i));
                    }
                    turn = true; // sets turn to player one
                    slapLabelOne.setIcon(slap);
                }
                else if(slapTurn == 2)
                {
                    for(int i=deckUsed.size()-1; i>=0; i--)
                    {
                        deckTwo.enqueue(deckUsed.get(i));
                    }
                    turn = false; // sets turn to player two
                    slapLabelTwo.setIcon(slap);
                }
                displaydeck(); // update deck
                promptTwo.setText("Player " + displayplayer() + " should flip a card now.");
                refreshdeck(); // blanks out unused icons
                faceCard = false; // sets face card flag to false
                cardsToPlace = 1; // sets cards to place to 1
                faceCardWin = 0; // sets face card win condition to 0
                deckUsed.clear(); // clears the deckUsed array
            }
            else if(faceCardWin != slapTurn) // slap failure, no match
            {
                labelblank(); // clears slap labels
                promptOne.setText("Player " + slapTurn + " slapped illegitimately and burns a card!");
                if(slapTurn == 1) // if player one fails
                {
                    deckUsed.add(0, (String) deckOne.dequeue()); // adds a burned card
                    slapLabelOne.setIcon(slapfail); // sets icon to slapfail
                }
                if(slapTurn == 2) // if player two fails
                {
                    deckUsed.add(0, (String) deckTwo.dequeue()); // adds a burned card
                    slapLabelTwo.setIcon(slapfail); // sets icon to slapfail
                }
                displaydeck(); // displays decks
            }
        }
        if(faceCardWin == slapTurn) // gets if face card win condition reached
        {
            if(slapTurn == 1)
            {
                for(int i=deckUsed.size()-1; i>=0; i--)
                {
                    deckOne.enqueue(deckUsed.get(i));
                    turn = true; // sets turn to player one
                    slapLabelOne.setIcon(slap);
                }
                slapLabelOne.setIcon(facewin);
                slapLabelTwo.setIcon(blank);
            }
            else if(slapTurn == 2)
            {
                for(int i=deckUsed.size()-1; i>=0; i--)
                {
                    deckTwo.enqueue(deckUsed.get(i));
                    turn = false; // sets turn to player two
                    slapLabelOne.setIcon(slap);
                }
                slapLabelOne.setIcon(blank);
                slapLabelTwo.setIcon(facewin);
            }
            displaydeck(); // update deck
            promptTwo.setText("Player " + displayplayer() + " should flip a card now.");
            refreshdeck(); // blanks out unused icons
            faceCard = false; // sets face card flag to false
            faceCardWin = 0; // sets face card win condition to neither
            cardsToPlace = 1; // sets cards to place to 1
            deckUsed.clear(); // clears the deckUsed array
        }
    }
    
    public void evaluateend() // evaluates if game is over
    {
        if(deckOne.isEmpty() == true) // if player one runs out of cards
        {
            Object[] options1 = {"Restart",
                    "Exit Game"};
            
            JOptionPane.showMessageDialog(ERS.this,
                    "Congratulations, player 2!\nYou are victorious!", // message
                    "Friendly Victory Prompt", // title
                    JOptionPane.INFORMATION_MESSAGE, // type
                    victory); // icon
            
            int n = JOptionPane.showOptionDialog(ERS.this,
               "Don't worry, player 1. Better luck next time.\nNo matter how many times you lose, your mother will always think you're a winner.", // message
               "Friendly Reassurance", // title
               JOptionPane.YES_NO_OPTION, // type
               JOptionPane.QUESTION_MESSAGE, // icon type
               bandage,
               options1,
               options1[1]);
            
            switch(n)
            {
                case 0:
                   gameclear(); // clears game, readying for restart
                   gamestart(); // resets game
                   break;
               // case 1: resume means do nothing! 
               case 1:
                   goodbye(); // exits game
                   break;
            }
        }
        if(deckTwo.isEmpty() == true) // if player two runs out of cards
        {
            Object[] options2 = {"Restart",
                    "Exit Game"};
            
            JOptionPane.showMessageDialog(ERS.this,
                    "Congratulations, player 1!\nYou are victorious!", // message
                    "Friendly Victory Prompt", // title
                    JOptionPane.INFORMATION_MESSAGE, // type
                    victory);
            
            int m = JOptionPane.showOptionDialog(ERS.this,
               "Don't worry, player 2. Better luck next time.\nNo matter how many times you lose, your mother will always think you're a winner.", // message
               "Friendly Reassurance", // title
               JOptionPane.YES_NO_OPTION, // type
               JOptionPane.QUESTION_MESSAGE, // icon type
               bandage,
               options2,
               options2[1]);
                    
                switch(m)
                {
                    case 0:
                       gameclear(); // clears game, readying for restart
                       gamestart(); // resets game
                       break;
                   // case 1: resume means do nothing! 
                   case 1:
                       goodbye(); // exits game
                       break;
                }
        }
    }
    
    public int displayplayer()
    {
        if(turn == true)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    
    public void labelblank() // sets the two labels and prompt to blank
    {
        promptOne.setText(null);
        slapLabelOne.setIcon(blank);
        slapLabelTwo.setIcon(blank);
    }
    
    public void refreshdeck() // refreshes used pile icons after face card streak
    {
        PileLabelFour.setIcon(blank); // sets label 4 icon to blank
        if(value == value2)
        {
            PileLabelThree.setIcon(blank); // sets label 3 icon to blank
        }
    }
    
    public void cleardeck() // clears used pile icons after restart
    {
        PileLabelOne.setIcon(blank); // sets label 1 icon to blank
        PileLabelTwo.setIcon(blank); // sets label 2 icon to blank
        PileLabelThree.setIcon(blank); // sets label 3 icon to blank
        PileLabelFour.setIcon(blank); // sets label 4 icon to blank
        cardsToPlace = 1; // resets face card counter
        faceCard = false; // resets face card flag to false
        faceCardWin = 0; // resets face card win condition to 0
    }
    
    public void getdeck() // populates decks with random cards
    {
        usedCards.clear(); // clears hashmap
        for(int i=0; i<=51; i++)
        {
            int index = maxcards.get(i);
            name = card.nameofCard(index); // gets name of card
            value = card.getValueofCard(index); // gets value of card
            usedCards.put(name,value); // places all cards into hashmap, name = key, value = value
            
            // alternates populating player decks with cards
            if(i%2 == 0) 
            {
                deckOne.enqueue(name); // populates deckOne
            }
            else if(i%2 == 1)
            {
                deckTwo.enqueue(name); // populates deckTwo
            }
            else
            {
                System.out.println("Catastrophic error, you have broken math!");
            }
        } // end for
        Integer sizeOne = new Integer(deckOne.size());
        Integer sizeTwo = new Integer(deckTwo.size());
        countOne.setText("P1: " + sizeOne.toString()); // sets countOne label text to number of cards in deckOne
        countTwo.setText("P2: " + sizeTwo.toString()); // sets countTwo label text to number of cards in deckTwo
        System.out.println("\nGame started!");
    } // end getdeck
    
    public static void resetdeck() // fills remainingCards with all cards
    {
        maxcards.clear(); // clears deck
        for(int i=1;i<=52;i++) // adds 1-52 to arraylist
        {
            maxcards.add(i);
        }
        Collections.shuffle(maxcards); // shuffles arraylist
    }
    
    public void gamestart() // starts the game
    {
        // sets game start condition to true
        gameOn = true;
        resetdeck(); // shuffles deck
        getdeck(); // populates decks
        cleardeck(); // clears used cards
        labelblank(); // clears various labels
        displaydeck(); // displays decks
        displayinstruc(); // displays instructions
        
        promptOne.setText("Game started."); // sets prompt
        promptTwo.setText("Player " + displayplayer() + " should flip a card now."); // sets prompt
    }
    
    public void gameclear() // clears all data in game, readying program for new start
    {
        int i = deckOne.size()-1;
        int j = deckTwo.size()-1;
        while(i >= 0)
        {
            deckOne.dequeue(); // clears player one cards
            i--;
        }
        while(j >= 0)
        {
            deckTwo.dequeue(); // clears player two cards
            j--;
        }
        deckUsed.clear(); // clears used card pile
        turn = true; // sets turn to player one
        countPile.setText(null); // sets pile label text to blank
    }
    
    public void goodbye() // exits program
    {
        JOptionPane.showMessageDialog(ERS.this,
            "Thank you for playing, goodbye!", // message
            "Friendly Goodbye", // title
            JOptionPane.PLAIN_MESSAGE, // message type
            null);
        dispose(); // exits game
    }
    
    public void test()
    {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();  
        String[] fontNames = ge.getAvailableFontFamilyNames();  

        for (int index = 0; index < fontNames.length; index++)  
        {  
             System.out.println(fontNames[index]);  
        }  
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel OneLabel;
    private javax.swing.JLabel PileLabelFour;
    private javax.swing.JLabel PileLabelOne;
    private javax.swing.JLabel PileLabelThree;
    private javax.swing.JLabel PileLabelTwo;
    private javax.swing.JLabel TwoLabel;
    private java.awt.Panel cardsOne;
    private javax.swing.JPanel cardsPile;
    private java.awt.Panel cardsTwo;
    private javax.swing.JLabel countOne;
    private javax.swing.JLabel countPile;
    private javax.swing.JLabel countTwo;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel flipOne;
    private javax.swing.JLabel flipTwo;
    private javax.swing.JLabel info;
    private javax.swing.JPanel instructOne;
    private javax.swing.JPanel instructTwo;
    private javax.swing.JLabel options;
    private javax.swing.JLabel promptOne;
    private javax.swing.JLabel promptTwo;
    private javax.swing.JLabel slapLabelOne;
    private javax.swing.JLabel slapLabelTwo;
    private javax.swing.JLabel slapOne;
    private javax.swing.JLabel slapTwo;
    private javax.swing.JLabel start;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title2;
    // End of variables declaration//GEN-END:variables
}
