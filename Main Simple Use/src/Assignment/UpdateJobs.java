/*
*
Click nbfs: //nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
    *
    Click nbfs: //nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
    */
package Assignment;

import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Luis Lee
 */
public class UpdateJobs {
    public void getUpdateCompleteJob(String filePath) {
        try {
            ArrayList < Integer > jobID = new ArrayList < Integer > ();
            ArrayList < Integer > uid = new ArrayList < Integer > ();
            ArrayList < Integer > usec = new ArrayList < Integer > ();

            File file = new File(filePath);
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();

                //collect backfill data: job id, in, out
                if (line.contains("_slurm_rpc_update_job: complete")) {
                    String[] words = line.split(" ");
                    String[] words2 = words[3].split("=");
                    jobID.add(Integer.parseInt(words2[1])); //collect job id
                    String[] words3 = words[4].split("=");
                    uid.add(Integer.parseInt(words3[1])); //collect job id
                    String[] words4 = words[5].split("=");
                    usec.add(Integer.parseInt(words4[1])); //collect job id

                }
            }
            // Create a JTextArea to hold the output
            JTextArea output = new JTextArea();
            // Create a JScrollPane to hold the JTextArea
            output.append("Update Job Complete: \n");
            output.append("+-------------------------------------------------------------------+\n");
            output.append(String.format("%-6s%-10s%-10s%-10s\n", "No.", "Job ID", "Uid", "Usec"));
            for (int i = 0; i < jobID.size(); i++) {
                output.append(String.format("%-6d%-10d%-10s%-10s\n", (i + 1), jobID.get(i), uid.get(i), usec.get(i)));
            }
            output.append("+-------------------------------------------------------------------+\n\n");
            //calculate and print out frequency of uid, REMOVE if not used
            output.append("Frequency of uid: \n");
            output.append(String.format("%-5s%-15s%-10s\n", "No.", "Uid", "Frequency"));
            int n = 1;
            while (uid.size() != 0) {
                int word = uid.get(0);
                int frequency = Collections.frequency(uid, word);
                uid.removeAll(Collections.singleton(word));
                output.append(String.format("%-5d%-15d%-10d\n", n, word, frequency));
                n++;
            }

            //calculate and print out average of usec, REMOVE if not used
            int sum = 0;
            for (int i = 0; i < usec.size(); i++) {
                sum += usec.get(i);
            }
            if (usec.size() != 0) {
                output.append("\nAverage of usec: " + (sum / usec.size()) + "\n");
            } else {
                output.append("\nAverage of usec: 0 \n");
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
            JScrollPane scrollPane = new JScrollPane(output);
            scrollPane.setPreferredSize(new Dimension(800, 600));
            JOptionPane.showMessageDialog(null, scrollPane, "List of Updated Jobs", JOptionPane.INFORMATION_MESSAGE);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
