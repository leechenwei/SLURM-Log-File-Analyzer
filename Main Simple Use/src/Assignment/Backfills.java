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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Backfills {
    public void getBackfill(String filePath) {
        try {
            ArrayList < Integer > jobID = new ArrayList < Integer > ();
            ArrayList < String > in = new ArrayList < String > ();
            ArrayList < String > on = new ArrayList < String > ();

            File file = new File(filePath);
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();

                //collect backfill data: job id, in, out
                if (line.contains("sched/backfill:")) {
                    String[] words = line.split(" "); in .add(words[6]); //collect in
                    on.add(words[8]); //collect out
                    String[] words2 = words[4].split("=");
                    jobID.add(Integer.parseInt(words2[1])); //collect job id

                }
            }
            // Create a JTextArea to hold the output
            JTextArea output = new JTextArea();
            // Create a JScrollPane to hold the JTextArea
            JScrollPane scrollPane = new JScrollPane(output);
            output.append("Sched/backfill: \n");
            output.append("+-------------------------------------------------------------------+\n");
            output.append(String.format("%-5s%-8s%-14s%-14s\n", "No.", "Job ID", "In", "On"));
            for (int i = 0; i < jobID.size(); i++) {
                output.append(String.format("%-5d%-8d%-14s%-14s\n", (i + 1), jobID.get(i), in .get(i), on.get(i)));
            }
            output.append("+-------------------------------------------------------------------+\n\n");

            //calculate and print out frequency of in and out, just REMOVE this part if not needed
            output.append("Frequency of in: \n");
            output.append(String.format("%-5s%-15s%-10s\n", "No.", "in", "frequency"));
            int n = 1;
            while ( in .size() != 0) {
                String word = in .get(0);
                int frequency = Collections.frequency( in , word); in .removeAll(Collections.singleton(word));
                output.append(String.format("%-5d%-15s%-10d\n", n, word, frequency));
                n++;
            }

            //calculate and print out frequency of in and out, just REMOVE this part if not needed
            output.append("\nFrequency of on: \n");
            output.append(String.format("%-5s%-15s%-10s\n", "No.", "on", "frequency"));
            int j = 1;
            while (on.size() != 0) {
                String word = on.get(0);
                int frequency = Collections.frequency(on, word);
                on.removeAll(Collections.singleton(word));
                output.append(String.format("%-5d%-15s%-10d\n", j, word, frequency));
                j++;
            }

            //write to file
            try {
                FileWriter fw = new FileWriter("Backfills.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(output.toString());
                bw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
            scrollPane.setPreferredSize(new Dimension(800, 600));
            JOptionPane.showMessageDialog(null, scrollPane, "Sched/backfill", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
