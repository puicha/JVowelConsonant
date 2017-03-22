/* JVowelConsonant application
   An application that distinguishes between vowels and consonants as the user clicks buttons.  It also randomly selects
   letter to replace the letter on the JButton after the user clicks the button */
   
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class JVowelConsonant extends JFrame implements ActionListener 
{  
   // Declare variable to count the user's button click
   int count = 0;
   
   // Create an array of 26 letters, each index is labeled with a different letter of the alphabet.
   private String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; 
   
   // Create an array of 26 JButton objects
   private JButton[] buttons = new JButton[26];
        
   // Instantiate three JPanel objects
   private JPanel panel01 = new JPanel(new GridLayout(2,2));
   private JPanel panel02 = new JPanel(new GridLayout(2,2));
   private JPanel panel03 = new JPanel(new GridLayout(2,2));
   
   // Instantiate JLabel object with empty string
   private JLabel display = new JLabel("");
   
   // Declare random object that generate distinct random object for each letter everytime it is called
   private int[] rand = new Random().ints(0, 26).distinct().limit(26).toArray();
   
   // Create the constructor 
   public JVowelConsonant()
   {  
      // Set the title by passing it to the JFrame parent class constructor 
      super("Children Learning Program");    
      
      // Assign letter from letters array to each button.  Add listener to each button. 
      for(int i = 0; i < buttons.length; ++i) 
      {
         buttons[i] = new JButton(letters[i]);
         buttons[i].addActionListener(this);
      }
      
      // Set layout of JFrame
      setLayout(new GridLayout(4,4,2,5));
      
      // Add 3 panels to JFrame
      add(panel01);    
      add(panel02);
      add(panel03);
      
      // Randomly add 4 buttons into the first JPanel
      for(int x = 0; x < 4; ++x)
      { 
         int index = rand[x];   
         panel01.add(buttons[index]);
      } 
      
      // Randomly add 4 buttons into the second JPanel
      for(int x = 4; x < 8; ++x)
      {
         int index = rand[x];
         panel02.add(buttons[index]);
      }
       
      // Add display JLabel into the third panel             
      panel03.add(display);
      
      // set the default close operation for the JFrame    
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   // Create the actionPerformed() method
   public void actionPerformed(ActionEvent e)
   {
      Object source = e.getSource();
      
      // Use for loop to check if button selected is equal to button in buttons array      
      for(int y = 0; y < buttons.length; ++y)
      {
         if(source == buttons[y])
         {  
            /* If button selected equal to button in buttons array, use if-else statement to check if button in buttons array is
               vowel or consonant */
            if(buttons[y].getText() == letters[0] || buttons[y].getText() == letters[4] || buttons[y].getText() == letters[8] ||
               buttons[y].getText() == letters[14] || buttons[y].getText() == letters[20])
            {
               // If the button has vowel letter, set text in display JLabel to vowel using setText() method
               display.setText("Vowel");
               
               // Randomly select new letter from letters array.  Assign it to the button by using setText() method.
               buttons[y].setText(letters[rand[count]]);                                    
            }
            else
            {
               // If the button has consonent letter, set text in display JLabel to consonent using setText() method
               display.setText("Consonent");
               
               // Randomly select new letter from letters array.  Assign it to the button by using setText() method.
               buttons[y].setText(letters[rand[count]]);                   
            }
            // Increment by 1 everytime the user click the button
            count++;
            
            // If count eqaul to 26 which is the maximum index of letters array, set count to 0 for the application to continue 
            if(count == 26)
            {
               count = 0;
            }                                              
         }                                                                                                             
      }                           
   }
   
   // Add a main method that instantiates a JVowelConsonant object and sets its size and visibility  
   public static void main(String[] args)
   {
      // Declare named constants 
      final int WIDTH = 700;
      final int HEIGHT = 700;
      
      // Instantiate a JVowelConsonant object
      JVowelConsonant learn = new JVowelConsonant();
      learn.setSize(WIDTH, HEIGHT);
      learn.setVisible(true); 
   }   
}