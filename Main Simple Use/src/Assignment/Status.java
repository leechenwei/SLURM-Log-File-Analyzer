/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

/**
 *
 * @author Luis Lee
 */
import java.awt.Dimension;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Status {
    public void wexitstatus(String filePath) {
        // Create a JTextArea to hold the output
        JTextArea output = new JTextArea();
        // Create a JPanel to hold the JTextArea
        JPanel panel = new JPanel();
        Scanner input = null;
        try {
            // Open the file
            input = new Scanner(new File(filePath));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Initialize the counter
        int count = 0;
        //ArrayList

        ArrayList < String > jobId = new ArrayList < String > ();
        ArrayList < String > status = new ArrayList < String > ();

        // Read each line of the file
        while (input.hasNextLine()) {
            String line = input.nextLine();
            
            //if line consist WEXITSTATUS
            if (line.contains("WEXITSTATUS ")) {
                //split the line and add jobID
                String[] words = line.split(" ");
                jobId.add(words[2]);
                //split the line and get status no
                String[] words_2 = line.split(" ");
                status.add(words_2[4]);

            }
        }

        output.append("Job ID" + "  " + "WEXITSTATUS" + "\n");
        int n = 1;

        //print out job id and wexitstatus
        for (int i = 0; i < jobId.size(); i++) {
            String word = jobId.get(i);
            String word_2 = status.get(i);
            output.append(word + "  " + word_2 + "\n");

        }

        output.append("\n" + "WEXITSTATUS" + "  " + "Frequency" + "\n");

        //if arraylist status is not empty
        while (!status.isEmpty()) {
            String frequency = status.get(0);
            //sort the output in order
            status.sort(Comparator.naturalOrder());
            //count the number of same status
            int frequencyType = Collections.frequency(status, frequency);
            //remove all duplicate status no
            status.removeAll(Collections.singleton(frequency));
            output.append(frequency + "  " + "                     " + frequencyType + " Times\n");

        }

        //write to file
        try {
            FileWriter fw = new FileWriter("FindErrorUsers.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(output.toString());
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //set output uneditable
        output.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(output);
        scrollPane.setPreferredSize(new Dimension(800, 600));
        JOptionPane.showMessageDialog(null, scrollPane, "List of WEXITSTATUS for status 0/1/2", JOptionPane.INFORMATION_MESSAGE);
    }
}