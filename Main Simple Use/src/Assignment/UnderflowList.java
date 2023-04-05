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

public class UnderflowList {
    public void getUnderflowList(String filePath) {
        String keyword1 = "error: _handle_assoc_";
        ArrayList < String > timeStamp = new ArrayList < > ();
        ArrayList < String > jobID = new ArrayList < > ();
        ArrayList < String > assocID = new ArrayList < > ();
        ArrayList < String > TREStype = new ArrayList < > ();
        ArrayList < String > TRESmetric = new ArrayList < > ();
        ArrayList < String > remove = new ArrayList < > ();
        ArrayList < String > remain = new ArrayList < > ();

        try {
            File file = new File(filePath);
            Scanner reader = new Scanner(file);
            String line;
            
            //if reader next line is not empty
            while (reader.hasNextLine()) {
                //read next line
                line = reader.nextLine();
                //if contain the words error: _handle_assoc_
                if (line.contains(keyword1)) {
                    String[] temp1 = line.split(" ");
                    //add each timestamp jobID assocID tres type and metric, remove and remaining seconds
                    timeStamp.add(temp1[0].replace("[", "").replace("]", ""));
                    jobID.add(temp1[4].replace(":", ""));
                    assocID.add(temp1[6]);
                    TREStype.add(temp1[8]);
                    TRESmetric.add(temp1[9]);
                    remove.add(temp1[14]);
                    remain.add(temp1[18]);
                }
            }

            // Create a JTextArea to hold the output
            JTextArea output = new JTextArea();
            // Create a JScrollPane to hold the JTextArea
            JScrollPane scrollPane = new JScrollPane(output);
            output.append("Underflow error: \n");
            output.append(String.format("%-32s%-15s%-22s%-20s%-27s%-33s%-35s\n", "Timestamp", "Job ID", "Association ID", "TRES type", "TRES metric", "Attempted to remove(seconds)", "Remaining(seconds)"));
            for (int i = 0; i < 188; i++) {
                output.append("-");
            }
            output.append("\n");
            int count = 0;
            for (int j = 0; j < timeStamp.size(); j++) {
                output.append(String.format("%-32s%-15s%-22s%-20s%-33s\t%-33s%-35s\n", timeStamp.get(j), jobID.get(j), assocID.get(j), TREStype.get(j), TRESmetric.get(j), remove.get(j), remain.get(j)));
                count = j;
            }
            //if the timeStamp is not empty
            if (!timeStamp.isEmpty()) {
                output.append("\nNumber of Underflow Error: " + count + 1);
            }
            reader.close();
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
            JOptionPane.showMessageDialog(null, scrollPane, "List of Jobs that Underflow", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found.");
        }
    }
}
