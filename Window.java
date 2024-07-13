import javax.swing.*; // Needed for swing classes
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
*   This program displays a simple window with a title. The
*   application exits when the user clicks the close button.
*/

public  class Window extends JFrame{
    final int WINDOW_WIDTH = 350;   // Window width in pixels
    final int WINDOW_HEIGHT = 250;  // Window height in pixels
    public Window(){

        // Set the title.
        setTitle("A Simple Window");

        // Set the size of the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         Change the backgrouond color
        getContentPane().setBackground(Color.orange);

        // Add Score to window
        int score = 0;
        JLabel scoreLabel = new JLabel("Score: ");
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
//        Add Score value
        JLabel totalScore = new JLabel(score+"/100");
        totalScore.setHorizontalAlignment(JLabel.CENTER);
        totalScore.setFont(new Font("Arial", Font.ITALIC, 16));

//        Add timer label
        JLabel timerLabel = new JLabel("Tme: ");
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));

//        Add total time the player spent by player
        JLabel totalTime = new JLabel("12mins 54sec");
        totalTime.setHorizontalAlignment(JLabel.CENTER);
        totalTime.setFont(new Font("Arial", Font.ITALIC, 16));

        // Create a JPanel for the south part
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.orange);

//        Create a JPanel for the CENTER part
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.orange);

//        Create a JPanel for the North part
        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.orange);

        // Add button
        JButton playButton = new JButton("PLAY AGAIN");
        JButton exitButton = new JButton("EXIT");

        // Add center panel to window
        add(centerPanel, BorderLayout.CENTER);

//        add north panel to window
        add(northPanel, BorderLayout.NORTH);

        // Add Buttons to window
        southPanel.add(playButton, BorderLayout.SOUTH);
        southPanel.add(exitButton, BorderLayout.SOUTH);

//        Add scores to Center Panel
        centerPanel.add(scoreLabel, BorderLayout.SOUTH);
        centerPanel.add(totalScore, BorderLayout.SOUTH);

//        Add timer to north panel
        northPanel.add(timerLabel, BorderLayout.NORTH);
        northPanel.add(totalTime, BorderLayout.SOUTH);

        // Add the south panel to the window
        add(southPanel, BorderLayout.SOUTH);

        // Display the window.
        setVisible(true);
    }
    public static void main(String[] args){
      SwingUtilities.invokeLater(() -> new Window());
    }
}