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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CleanedJob {
    public void getCleanupCompletingJob(String filePath) {
        try {
            ArrayList < String > jobId = new ArrayList < String > ();
            ArrayList < String > id = new ArrayList < String > ();
            ArrayList < String > time = new ArrayList < String > ();

            File file = new File(filePath);
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains("cleanup_completing: ")) {
                    String[] words = line.split(" ");
                    jobId.add(words[2]);
                    time.add(words[6]);
                    String[] words_2 = words[2].split("=");
                    id.add(words_2[1]);
                }
            }
            // Create a JTextArea to hold the output
            JTextArea output = new JTextArea();
            output.append(String.format("%-5s%-11s%-17s", "No.", "Job ID", "Process Time"));
            for (int i = 0; i < id.size(); i++) {
                String word = id.get(i);
                String word1 = time.get(i);
                output.append(String.format("\n%-5d%-11s%-17s", i + 1, word, word1));
            }

            //write to file
            try {
                FileWriter fw = new FileWriter("CleanedJob.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(output.toString());
                bw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
            output.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(output);
            scrollPane.setPreferredSize(new Dimension(800, 600));
            JOptionPane.showMessageDialog(null, scrollPane, "Jobs that Cleaned", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
