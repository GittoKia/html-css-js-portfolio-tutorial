
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author kiaab
 */
public class AbbasiKiaArraysAssignmentUI extends javax.swing.JFrame {

    /**
     * Creates new form AbbasiKiaArraysAssignmentUI
     */
    /**
     * Compares two arrays and returns the number of indexes where both array
     * values are equal
     *
     * @param secret the first array
     * @param guess the second array
     * @param length number of indexes to compare
     * @return an integer
     */
    public int CharCompare(char[] secret, char[] guess, int length) {

        //find number of correct letters guessed
        int correct = 0;
        for (int l = 0; l < length; l++) {

            if (secret[l] == guess[l]) {
                correct++;
            }
        }

        //update number of total guesses eneterd
        if (hard) {
            guessNum.setText(String.valueOf(Integer.parseInt(guessNum.getText()) - 1));
        } else {
            guessNum.setText(String.valueOf(Integer.parseInt(guessNum.getText()) + 1));
        }
        if (Integer.parseInt(guessNum.getText()) == 1) {
            G1.setText("Guess");
        } else {
            G1.setText("Guesses");
        }

        return correct;
    }

    /**
     * Converts letter displays into a String
     *
     * @param toGuess number of letter displays to change
     * @return Converts display to String
     */
    public String Compute(int toGuess) {

        //populate guess array based on display
        JButton[] buttons = {Letter0, Letter1, Letter2, Letter3, Letter4, Letter5, Letter6, Letter7, Letter8, Letter9};
        String output = "";
        for (int l = 0; l < toGuess; l++) {
            buttons[l].setBorder(null);
            if (buttons[l].getBackground() == Color.RED) {
                output += "r";

            } else if (buttons[l].getBackground() == Color.GREEN) {
                output += "g";

            } else if (buttons[l].getBackground() == Color.BLUE) {
                output += "b";

            } else {
                output += " ";

                //specify bad letter displays
                Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 5); // Color and thickness
                if (display) {
                    buttons[l].setBorder(lineBorder);
                }
            }

        }
        return output;
    }

    /**
     * Change ability to use certain of letter displays
     *
     * @param iterary number of letter arrays from left to right to impact
     * @param bool enable or disable letter displays
     */
    public void Letters(int iterary, boolean bool) {
        JButton[] buttons = {Letter0, Letter1, Letter2, Letter3, Letter4, Letter5, Letter6, Letter7, Letter8, Letter9};

        //change unused letter displays
        if (bool) {
            for (int k = 0; k < 10 - iterary; k++) {
                buttons[10 - k - 1].setEnabled(!bool);
            }

        }

        //change used letter displays
        for (int l = 0; l < iterary; l++) {
            buttons[l].setEnabled(bool);

        }

    }

    /**
     * Enables the ability to change the color of a display with arrow keys
     *
     * @param evt action event parameter
     * @param letter the letter that is selected
     */
    public void Colors(java.awt.event.KeyEvent evt, JButton letter) {

        int curKey = evt.getKeyCode();
        Color curcolor = letter.getBackground();
        
            //up key press
        if (curKey == evt.VK_UP) {
            if (curcolor == Color.BLUE) {
                letter.setBackground(Color.GREEN);
            } else if (curcolor == Color.GREEN) {
                letter.setBackground(Color.RED);
            } else {
                letter.setBackground(Color.BLUE);
            }

            //down key press
        } else if (curKey == evt.VK_DOWN) {
            if (curcolor == Color.RED) {
                letter.setBackground(Color.GREEN);
            } else if (curcolor == Color.GREEN) {
                letter.setBackground(Color.BLUE);
            } else {
                letter.setBackground(Color.RED);
            }
        }
    }

    /**
     * Clears the letter displays
     */
    public void Clear() {
        JButton[] buttons = {Letter0, Letter1, Letter2, Letter3, Letter4, Letter5, Letter6, Letter7, Letter8, Letter9};

        //forget previous guess
        for (int k = 0; k < 10; k++) {
            buttons[k].setBackground(Color.WHITE);
            buttons[k].setBorder(null);
        }
    }

    /**
     * Replaces redundant lines in the message display
     *
     * @param Text text to replace in the display with
     */
    public void replaceText(String Text) {

        try {
            messageOutput.replaceRange(Text,
                    messageOutput.getLineStartOffset(lineRemove),
                    messageOutput.getLineEndOffset(lineRemove));
        } catch (BadLocationException ex) {

        }
    }

    public AbbasiKiaArraysAssignmentUI() {
        initComponents();

        //set up buttons
        EnterAnswer.setEnabled(false);
        messageOutput.setEditable(false);
        CorrectAnswer.setEnabled(false);
        userInput.setEnabled(false);
        Letters(10, false);
        DisplayToggle.setEnabled(false);

    }

    //public variables
    int userLength = 3;
    String answer;
    boolean finish = true;
    boolean display = false;
    boolean hard = false;
    int lineRemove = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userInput = new javax.swing.JTextField();
        EnterAnswer = new javax.swing.JButton();
        GameBegin = new javax.swing.JButton();
        LengthSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        HardCheck = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        OutputPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageOutput = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        guessNum = new javax.swing.JLabel();
        G1 = new javax.swing.JLabel();
        CorrectAnswer = new javax.swing.JToggleButton();
        Left = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Letter1 = new javax.swing.JButton();
        Letter2 = new javax.swing.JButton();
        Letter3 = new javax.swing.JButton();
        Letter4 = new javax.swing.JButton();
        Letter5 = new javax.swing.JButton();
        Letter6 = new javax.swing.JButton();
        Letter7 = new javax.swing.JButton();
        Letter8 = new javax.swing.JButton();
        Letter9 = new javax.swing.JButton();
        DisplayToggle = new javax.swing.JToggleButton();
        Letter0 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));

        userInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInputActionPerformed(evt);
            }
        });

        EnterAnswer.setText("Submit");
        EnterAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterAnswerActionPerformed(evt);
            }
        });

        GameBegin.setText("Start");
        GameBegin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GameBeginActionPerformed(evt);
            }
        });

        LengthSlider.setMajorTickSpacing(1);
        LengthSlider.setMaximum(10);
        LengthSlider.setMinimum(3);
        LengthSlider.setPaintLabels(true);
        LengthSlider.setPaintTicks(true);
        LengthSlider.setSnapToTicks(true);
        LengthSlider.setValue(3);
        LengthSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LengthSliderMouseReleased(evt);
            }
        });

        jLabel3.setText("Length of List");

        jLabel2.setText("Input");

        HardCheck.setText("Hard Mode");
        HardCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HardCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(EnterAnswer))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(LengthSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(GameBegin)))
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(HardCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LengthSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GameBegin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HardCheck)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EnterAnswer)
                    .addComponent(jLabel2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButton1.setText("Quit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        OutputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));

        messageOutput.setColumns(20);
        messageOutput.setRows(5);
        messageOutput.setText("How many letters in a guess?");
        jScrollPane1.setViewportView(messageOutput);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Answer"));

        guessNum.setText("0");

        G1.setText("Guesses");

        CorrectAnswer.setText("Show Answer");
        CorrectAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorrectAnswerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CorrectAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(guessNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(G1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Left)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CorrectAnswer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guessNum)
                    .addComponent(G1)
                    .addComponent(Left))
                .addContainerGap())
        );

        javax.swing.GroupLayout OutputPanelLayout = new javax.swing.GroupLayout(OutputPanel);
        OutputPanel.setLayout(OutputPanelLayout);
        OutputPanelLayout.setHorizontalGroup(
            OutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OutputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        OutputPanelLayout.setVerticalGroup(
            OutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OutputPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(OutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("AbbasiKia Game");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Display"));

        Letter1.setPreferredSize(new java.awt.Dimension(32, 64));
        Letter1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Letter1KeyPressed(evt);
            }
        });

        Letter2.setPreferredSize(new java.awt.Dimension(32, 64));
        Letter2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Letter2KeyPressed(evt);
            }
        });

        Letter3.setPreferredSize(new java.awt.Dimension(32, 64));
        Letter3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Letter3KeyPressed(evt);
            }
        });

        Letter4.setPreferredSize(new java.awt.Dimension(32, 64));
        Letter4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Letter4KeyPressed(evt);
            }
        });

        Letter5.setPreferredSize(new java.awt.Dimension(32, 64));
        Letter5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Letter5KeyPressed(evt);
            }
        });

        Letter6.setPreferredSize(new java.awt.Dimension(32, 64));
        Letter6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Letter6KeyPressed(evt);
            }
        });

        Letter7.setPreferredSize(new java.awt.Dimension(32, 64));
        Letter7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Letter7KeyPressed(evt);
            }
        });

        Letter8.setPreferredSize(new java.awt.Dimension(32, 64));
        Letter8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Letter8KeyPressed(evt);
            }
        });

        Letter9.setPreferredSize(new java.awt.Dimension(32, 64));
        Letter9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Letter9KeyPressed(evt);
            }
        });

        DisplayToggle.setText("Use Display");
        DisplayToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplayToggleActionPerformed(evt);
            }
        });

        Letter0.setPreferredSize(new java.awt.Dimension(32, 64));
        Letter0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Letter0KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(DisplayToggle)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Letter0, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Letter1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(Letter2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Letter3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Letter4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Letter5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Letter6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Letter7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Letter8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Letter9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(DisplayToggle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Letter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Letter8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Letter7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Letter6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Letter5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Letter4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Letter3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Letter2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Letter9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Letter0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(OutputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OutputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GameBeginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GameBeginActionPerformed

        //create secret array
        char[] secret = new char[userLength];
        int color;
        for (int looper = 0; looper < userLength; looper++) {
            color = (int) (Math.random() * 3 + 1);
            switch (color) {
                case 1:
                    secret[looper] = 'r';
                    break;
                case 2:
                    secret[looper] = 'g';
                    break;
                case 3:
                    secret[looper] = 'b';
                    break;

            }
        }

        //begin program
        answer = new String(secret);
        CorrectAnswer.setText("Show Answer");
        if (hard) {
            guessNum.setText(String.valueOf(userLength * 3));
            Left.setText("Left");
        } else {
            guessNum.setText("0");
            Left.setText("");
        }
        messageOutput.setText("And what's your guess?");

        //change guesses to guess
        if (Integer.parseInt(guessNum.getText()) == 1) {
            G1.setText("Guess");
        } else {
            G1.setText("Guesses");
        }

        //change button states
        LengthSlider.setEnabled(false);
        HardCheck.setEnabled(false);
        EnterAnswer.setEnabled(true);
        CorrectAnswer.setEnabled(true);
        userInput.setEnabled(true);
        Letters(10, false);
        lineRemove = 0;

        //midway of guessing
        if (finish != true) {

            messageOutput.setText("You botched the list!! \n How many letters in a next guess? ");
            CorrectAnswer.setText(answer);

            //reset button states
            LengthSlider.setEnabled(true);
            HardCheck.setEnabled(true);
            messageOutput.setEditable(false);
            CorrectAnswer.setEnabled(false);
            userInput.setEnabled(false);
            Clear();
            GameBegin.setText("Start");
            DisplayToggle.setEnabled(false);
            EnterAnswer.setEnabled(false);
            userInput.setText(null);
            finish = true;

        } else {

            //enable restart button
            GameBegin.setText("Restart");
            DisplayToggle.setEnabled(true);
            finish = false;
            Clear();
        }
        display = false;
        userInput.setEnabled(true);

    }//GEN-LAST:event_GameBeginActionPerformed

    private void EnterAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterAnswerActionPerformed

        //convert answer to char array
        char[] secret = new char[answer.length()];

        for (int t = 0; t < secret.length; t++) {
            secret[t] = answer.charAt(t);
        }

        char arbChar;

        //decipher guess
        char[] guess = new char[userInput.getText().length()];

        try {

            //convert display to char array
            if (display) {
                guess = new char[Compute(secret.length).length()];
                for (int t = 0; t < secret.length; t++) {

                    guess[t] = Compute(secret.length).charAt(t);

                }

                //convert guess to char array
            } else {

                for (int t = 0; t < secret.length; t++) {

                    guess[t] = userInput.getText().charAt(t);
                }
            }

            //check array limits
            arbChar = guess[secret.length - 1];
            arbChar = secret[guess.length - 1];

            //check whether bad list
            boolean bool = false;
            for (char c : guess) {
                if (c != 'r' && c != 'g' && c != 'b') {
                    bool = false;
                    break;
                }
                bool = true;
            }

            //change display colors
            JButton[] buttons = {Letter0, Letter1, Letter2, Letter3, Letter4, Letter5, Letter6, Letter7, Letter8, Letter9};
            for (int t = 0; t < secret.length; t++) {
                switch (guess[t]) {

                    case 'r':
                        buttons[t].setBackground(Color.RED);
                        break;
                    case 'g':
                        buttons[t].setBackground(Color.GREEN);
                        break;
                    case 'b':
                        buttons[t].setBackground(Color.BLUE);
                        break;
                    default:
                        break;
                }
            }

            //good list
            if (bool) {
                finish = false;
                int correct = CharCompare(secret, guess, secret.length);

                //display user's guess again
                String prettyGuess = "[" + guess[0];
                for (int b = 1; b < secret.length; b++) {
                    prettyGuess += ",";
                    prettyGuess += guess[b];
                }
                prettyGuess += "]";

                //update messages
                replaceText("You tried " + prettyGuess + ".");
                lineRemove += 3;

                messageOutput.append("\nYou have " + correct + " correct letters." + "\nYou have "
                        + (guess.length - correct) + " incorrect letters."
                        + "\nNext Guess? ");

                //found correct list
                if (correct == guess.length || Integer.parseInt(guessNum.getText()) == 0) {
                    finish = true;
                    
                    //failed to guess in time
                    if (Integer.parseInt(guessNum.getText()) == 0) {
                        messageOutput.setText("Too long you have been wrong! \n Your array has been terminated!");
                    } else {
                        messageOutput.setText("You found the list!! \n How many letters in a next guess? ");
                    }
                    
                    //reset buttons
                    CorrectAnswer.setText(answer);
                    EnterAnswer.setEnabled(false);
                    LengthSlider.setEnabled(true);
                    HardCheck.setEnabled(true);
                    messageOutput.setEditable(false);
                    CorrectAnswer.setEnabled(false);
                    userInput.setEnabled(false);
                    EnterAnswer.setEnabled(false);
                    GameBegin.setText("Start");
                    DisplayToggle.setEnabled(false);
                    Letters(10, false);
                }

                //bad list 
            } else {

                replaceText("Bad List! Next Guess? ");
                userInput.setText("");

            }

            //big list
        } catch (ArrayIndexOutOfBoundsException e) {

            replaceText("Big list! Next Guess? ");
            userInput.setText("");

            //small list
        } catch (StringIndexOutOfBoundsException e) {

            replaceText("Small list! Next Guess? ");
            userInput.setText("");

        }
    }//GEN-LAST:event_EnterAnswerActionPerformed

    private void userInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInputActionPerformed
        if (EnterAnswer.isEnabled()) {
            EnterAnswerActionPerformed(evt);
        }
    }//GEN-LAST:event_userInputActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void LengthSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LengthSliderMouseReleased
        userLength = LengthSlider.getValue();

    }//GEN-LAST:event_LengthSliderMouseReleased

    private void CorrectAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorrectAnswerActionPerformed
        //reveal answer?
        if (!CorrectAnswer.getText().equals("Show Answer")) {
            CorrectAnswer.setText("Show Answer");
        } else {

            //display answer
            String s = "[" + answer.charAt(0);
            for (int c = 1; c < userLength; c++) {

                s += ",";
                s += answer.charAt(c);
            }
            CorrectAnswer.setText(s + "]");
        }
    }//GEN-LAST:event_CorrectAnswerActionPerformed

    private void Letter0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Letter0KeyPressed
        Colors(evt, Letter0);
    }//GEN-LAST:event_Letter0KeyPressed

    private void Letter1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Letter1KeyPressed
        Colors(evt, Letter1);
    }//GEN-LAST:event_Letter1KeyPressed

    private void Letter2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Letter2KeyPressed
        Colors(evt, Letter2);
    }//GEN-LAST:event_Letter2KeyPressed

    private void Letter3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Letter3KeyPressed
        Colors(evt, Letter3);
    }//GEN-LAST:event_Letter3KeyPressed

    private void Letter4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Letter4KeyPressed
        Colors(evt, Letter4);
    }//GEN-LAST:event_Letter4KeyPressed

    private void Letter5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Letter5KeyPressed
        Colors(evt, Letter5);
    }//GEN-LAST:event_Letter5KeyPressed

    private void Letter6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Letter6KeyPressed
        Colors(evt, Letter6);
    }//GEN-LAST:event_Letter6KeyPressed

    private void Letter7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Letter7KeyPressed
        Colors(evt, Letter7);
    }//GEN-LAST:event_Letter7KeyPressed

    private void Letter8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Letter8KeyPressed
        Colors(evt, Letter8);
    }//GEN-LAST:event_Letter8KeyPressed

    private void Letter9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Letter9KeyPressed
        Colors(evt, Letter9);
    }//GEN-LAST:event_Letter9KeyPressed

    private void DisplayToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplayToggleActionPerformed
        display = !display;
        userInput.setEditable(!display);
        Letters(userLength, display);

    }//GEN-LAST:event_DisplayToggleActionPerformed

    private void HardCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HardCheckActionPerformed
        hard = !hard;
    }//GEN-LAST:event_HardCheckActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AbbasiKiaArraysAssignmentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbbasiKiaArraysAssignmentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbbasiKiaArraysAssignmentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbbasiKiaArraysAssignmentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbbasiKiaArraysAssignmentUI().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton CorrectAnswer;
    private javax.swing.JToggleButton DisplayToggle;
    private javax.swing.JButton EnterAnswer;
    private javax.swing.JLabel G1;
    private javax.swing.JButton GameBegin;
    private javax.swing.JCheckBox HardCheck;
    private javax.swing.JLabel Left;
    private javax.swing.JSlider LengthSlider;
    private javax.swing.JButton Letter0;
    private javax.swing.JButton Letter1;
    private javax.swing.JButton Letter2;
    private javax.swing.JButton Letter3;
    private javax.swing.JButton Letter4;
    private javax.swing.JButton Letter5;
    private javax.swing.JButton Letter6;
    private javax.swing.JButton Letter7;
    private javax.swing.JButton Letter8;
    private javax.swing.JButton Letter9;
    private javax.swing.JPanel OutputPanel;
    private javax.swing.JLabel guessNum;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageOutput;
    private javax.swing.JTextField userInput;
    // End of variables declaration//GEN-END:variables
}
