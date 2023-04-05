package Assignment;

import java.awt.Dimension;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class QOSLimit {
    public void getQOSLimitUID(String filePath) 
    {  
        try 
        {
            ArrayList<String> limit_uid = new ArrayList<String>();
            ArrayList<String> limit_reason = new ArrayList<String>();
            String [] data2;
            String [] data3;
            int num_of_uid = 0;
            Scanner in = new Scanner(new FileInputStream(filePath));
            //_job_create: exceeded association/QOS limit for user
            String temp4 = "";
            while(in.hasNextLine())
            {   
                temp4 = in.nextLine();
                if(temp4.toLowerCase().contains("exceeded association/qos limit"))
                {   
                    data2 = temp4.split("user "); 
                    limit_uid.add(data2[1].substring(0, 9));
                    num_of_uid++;
                    data3 = temp4.split(": "); 
                    String limit_rea = data3[2].substring(0);

                    if (limit_rea.length() > 16)
                        continue;
                    
                    else
                        limit_reason.add(limit_rea);
                }
            }
            // Create a JTextArea to hold the output
            JTextArea output = new JTextArea();
            // Create a JScrollPane to hold the JTextArea
            JScrollPane scrollPane = new JScrollPane(output);
            output.append(String.format("%-10s%-18s\n", "User ID", "Reasons"));
            for (int i = 0; i < limit_reason.size(); i++) {
                String lmt_uid = limit_uid.get(i);
                String lmt_rea = limit_reason.get(i);
                output.append(String.format("%-10s   %-18s\n", lmt_uid, lmt_rea));
            }
            output.append(String.format("\nTotal QOS Limit UID: %-5d", num_of_uid));

            //write to file
            try {
                FileWriter fw = new FileWriter("QOSLimitUID.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(output.toString());
                bw.close();
            } 
            catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
            scrollPane.setPreferredSize(new Dimension(800, 600));
            JOptionPane.showMessageDialog(null, scrollPane, "QOS Limit UID", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


