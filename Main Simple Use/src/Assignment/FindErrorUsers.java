package Assignment;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FindErrorUsers {
    //method to find the number of errors with corresponding users
    public void findErrorUsers(String filePath) {
        ArrayList < String > user = new ArrayList < String > ();
        ArrayList < String > userName = new ArrayList < String > ();
        int count = 0;
        try {
            // Open the file
            Scanner input = new Scanner(new File(filePath));

            // Read each line of the file
            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (line.contains("error: This association ")) {
                    String[] words = line.split(" ");
                    user.add(words[5]);
                    String[] words_2 = words[5].split("'");
                    userName.add(words_2[1]);
                    count += 1;
                }
            }
            //close the scanner
            input.close();

            String output = "Number of Errors: " + count;
            output += "\n";
            int n = 1;

            //check if user not 0, then perform get user name with the frequency of how many times user cause error
            while (userName.size() != 0) {
                String word = userName.get(0);
                //read how many time the username appear and treat it as the frequency
                int frequency = Collections.frequency(userName, word);
                //remove all same username
                userName.removeAll(Collections.singleton(word));
                output += n + ". " + word + " = " + frequency + "\n";
                n++;
            }

            //write to file
            try {
                FileWriter fw = new FileWriter("FindErrorUsers.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(output);
                bw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
            //specify the area to show the output
            JTextArea textArea = new JTextArea(output);
            //set the output area noneditable
            textArea.setEditable(false);
            //make the output area scrollable if too many information
            JScrollPane scrollPane = new JScrollPane(textArea);
            //display the window
            JOptionPane.showMessageDialog(null, scrollPane, "Number of Error Jobs w Corresponding User", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File not found or invalid file path");
            e.printStackTrace();
        }
    }
}
        
