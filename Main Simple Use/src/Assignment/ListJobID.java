package Assignment;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class ListJobID {
    public void listJobID(String filePath) {
        String keyword1 = "sched:";
        String keyword2 = "Allocate";
        StringBuilder result = new StringBuilder();
        result.append("List of JobID with its corresponding NodeList,CPUs and Partition allocated\n\n");
        result.append(String.format("%5s%15s%15s%15s%20s\n", "No", "JobID", "NodeList", "CPUs", "Partition"));
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = "";
            int count = 0;
            //check if contain the words sched and Allocate
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword1) && line.contains(keyword2)) {
                    //add one to count
                    count++;
                    //split the line and get jobId
                    String temp[] = line.split(" ");
                    String j[] = temp[3].split("=");
                    String jobId = j[1];
                    int jobIdInt = (int)(Integer.parseInt(jobId));
                    
                    //split the line and get nodelist
                    String n[] = temp[4].split("=");
                    String nodeList = n[1];
                    
                    //split the line to get CPU
                    String C[] = temp[5].split("=");
                    String CPUs = C[1];
                    int CPUsInt = (int)(Integer.parseInt(CPUs));
                    
                    //split the line to get partition
                    String p[] = temp[6].split("=");
                    String partition = p[1];
                    //output to result
                    result.append(String.format("%5d%15d%15s%18d%23s\n", count, jobIdInt, nodeList, CPUsInt, partition));

                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not Found");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Problem with File Input");
        }
        //write to file
        try {
            FileWriter fw = new FileWriter("FindErrorUsers.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(result.toString());
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //output in window GUI
        JTextArea textArea = new JTextArea(result.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(800, 600));
        JOptionPane.showMessageDialog(null, scrollPane, "List of Job Id", JOptionPane.INFORMATION_MESSAGE);
    }
}