package Assignment;

import java.awt.Dimension;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class RequestKillJob {
    public void getRequestKillJob(String filePath) 
    {  
        try 
        {
            ArrayList<String> kill_job_id = new ArrayList<String>();
            ArrayList<String> kill_job_uid = new ArrayList<String>();
            int total_kill_id = 0;

            File file = new File(filePath);
            Scanner in = new Scanner (new FileInputStream(filePath));

            //total kill job and user id for kill job
            String temp1 = ""; 
            while(in.hasNextLine())
            {
                temp1 = in.nextLine();
                if(temp1.toLowerCase().contains("request_kill_job"))
                {   
                    String [] data = temp1.split("JobId="); 
                    String [] data_uid = temp1.split("uid ");
                    kill_job_id.add(data[1].substring(0,5));
                    kill_job_uid.add(data_uid[1].substring(0));
                    total_kill_id++;
                }
            }
            Collections.sort(kill_job_id);
            Collections.sort(kill_job_uid);

            
            // Create a JTextArea to hold the output
            JTextArea output = new JTextArea();
            // Create a JScrollPane to hold the JTextArea
            JScrollPane scrollPane = new JScrollPane(output);
            output.append(String.format("%-10s%-18s\n", "Job ID", "User ID"));
            for (int i = 0; i < kill_job_id.size(); i++) {
                String kill_id = kill_job_id.get(i);
                String kill_uid = kill_job_uid.get(i);
                output.append(String.format("%-10s%-18s\n", kill_id, kill_uid));
            }
            output.append(String.format("\nTotal Request Kill Job ID: %-5d", total_kill_id));

            //write to file
            try {
                FileWriter fw = new FileWriter("RequestKillJobID.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(output.toString());
                bw.close();
            } 
            catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
            scrollPane.setPreferredSize(new Dimension(800, 600));
            JOptionPane.showMessageDialog(null, scrollPane, "Request Kill Job ID", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }   
}

