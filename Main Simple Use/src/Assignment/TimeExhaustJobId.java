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
import java.util.Scanner;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TimeExhaustJobId {
    public void getTimeExhaustJobId(String filePath) {
        try {
            ArrayList < String > jobId = new ArrayList < String > ();
            ArrayList < String > id = new ArrayList < String > ();

            File file = new File(filePath);
            Scanner input = new Scanner(file);
            
            //if line contatin Time limit exhausted
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains("Time limit exhausted ")) {
                    String[] words = line.split(" ");
                    //add jobId to arrayList
                    jobId.add(words[5]);
                    String[] words_2 = words[5].split("=");
                    //add uid
                    id.add(words_2[1]);
                }
            }
            // Create a JTextArea to hold the output
            JTextArea output = new JTextArea();
            // Create a JScrollPane to hold the JTextArea
            JScrollPane scrollPane = new JScrollPane(output);
            output.append(String.format("%-5s%-11s\n", "No.", "Job ID"));
            int n = 1;
            while (id.size() != 0) {
                String word = id.get(0);
                id.removeAll(Collections.singleton(word));
                output.append(String.format("%-5d%-11s\n", n, word));
                n++;
            }
            output.append(String.format("\nTotal Job ID that are time limit exhausted: %-5d", n - 1));
            //write to file
            try {
                FileWriter fw = new FileWriter("FindErrorUsers.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(output.toString());
                bw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
            scrollPane.setPreferredSize(new Dimension(800, 600));
            JOptionPane.showMessageDialog(null, scrollPane, "Time Exhausted Job ID", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
