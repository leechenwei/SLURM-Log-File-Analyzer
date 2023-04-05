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

public class checkOOM {
    public void findOOMFailure(String filePath) {
        ArrayList < String > jobID = new ArrayList < String > ();
        try {
            File file = new File(filePath);
            Scanner input = new Scanner(file);
            //check if line consist OOM failure
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains("OOM failure")) {
                    String[] words = line.split(" ");
                    String[] words2 = words[2].split("=");
                    //add job ID
                    jobID.add(words2[1]);
                }
            }
            Collections.sort(jobID);
            StringBuilder sb = new StringBuilder();
            //printing
            sb.append("Number of OOM Failure occurs: ");
            sb.append(jobID.size());
            sb.append("\n");
            sb.append("\n");
            sb.append("Job ID which experience OOM Failure: ");
            sb.append("\n");
            for (String id: jobID) {
                sb.append(id + "\n");
            }
            //write to file
            try {
                FileWriter fw = new FileWriter("OOMfailure.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(sb.toString());
                bw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(800, 600));
            JOptionPane.showMessageDialog(null, scrollPane, "Job Id Experienced OOM Failure", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
