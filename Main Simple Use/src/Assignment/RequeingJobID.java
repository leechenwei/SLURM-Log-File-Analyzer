package Assignment;

import java.awt.Dimension;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RequeingJobID {
    public void getRequeuingJobID(String filePath) 
    {  
        try 
        {
            ArrayList<String> reque_id = new ArrayList<String>();
            int tot_reque_id = 0;

            File file = new File(filePath);
            Scanner in = new Scanner (new FileInputStream(filePath));

            //requeuing jobid
            String temp3 = ""; 
            while(in.hasNextLine())
            {
                temp3 = in.nextLine();
                if(temp3.toLowerCase().contains("requeuing"))
                {   
                    String [] data1 = temp3.split("JobId="); 
                    reque_id.add(data1[1].substring(0,5));
                    tot_reque_id++;
                }
            }
            Collections.sort(reque_id);

            // Create a JTextArea to hold the output
            JTextArea output = new JTextArea();
            // Create a JScrollPane to hold the JTextArea
            JScrollPane scrollPane = new JScrollPane(output);
            output.append(String.format("%-5s%-11s\n", "No.", "Job ID"));
            int n = 1;
            for (int i = 0; i < reque_id.size(); i++) {
                String req_id= reque_id.get(i);
                output.append(String.format("%-5s%-11s\n", n, req_id));
                n++;
            }
            output.append(String.format("\nTotal Job ID that are Requeuing: %-5d", tot_reque_id));

            //write to file
            try {
                FileWriter fw = new FileWriter("RequeuingJobID.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(output.toString());
                bw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
            scrollPane.setPreferredSize(new Dimension(800, 600));
            JOptionPane.showMessageDialog(null, scrollPane, "Requeuing Job ID", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
    
