/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;
import java.awt.Dimension;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Luis Lee
 */
public class NeverRunnable {
    public void NeverRunnable(String filePath) {
        try {
            int count;
            ArrayList < Integer > jobID = new ArrayList < Integer > ();
            ArrayList < String > cpuGpu = new ArrayList < String > ();
            ArrayList < String > partitions = new ArrayList < String > ();
            ArrayList < String > partitions2 = new ArrayList < String > ();
            File file = new File(filePath);
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();

                //collect never runnable data: job id, cpu/gpu, partitions
                if (line.contains("never runnable")) {
                    String[] words = line.split(" ");
                    partitions2.add(words[7]);
                    String[] words2 = words[2].split("=");
                    jobID.add(Integer.parseInt(words2[1])); //collect job id
                    String[] words3 = words[7].split("-");
                    cpuGpu.add(words3[0]); //collect cpu/gpu
                    partitions.add(words3[1]); //collect partitions name

                }
            }
            //Overall summary of data
            int freqCPU = Collections.frequency(cpuGpu, "cpu");
            int freqGPU = Collections.frequency(cpuGpu, "gpu");
            Collections.sort(partitions2);

            //print out the data
            StringBuilder sb = new StringBuilder();
            //append summary to string builder
            sb.append("\nSummary: \n");
            sb.append("The number of jobs that never runnable in partitions: " + jobID.size() + "\n");
            sb.append("The frequency of CPU involved: " + freqCPU + "\n");
            sb.append("The frequency of GPU involved: " + freqGPU + "\n");
            sb.append("\n");
            sb.append("The number never runnable jobs by partition: \n");
            //if partitions2 arraylist is not empty
            while (!partitions2.isEmpty()) {
                String display = partitions2.get(0);
                //find how many similar partition name
                int frequencyName = Collections.frequency(partitions2, display);
                //remove all duplicate display
                partitions2.removeAll(Collections.singleton(display));
                sb.append(String.format("%-20s%-5d\n", display, frequencyName));
            }
            //print
            sb.append("\n");
            sb.append("The jobs that never runnable in partitions: \n");
            sb.append("+-------------------------------------------------------------------+\n");
            sb.append(String.format("%5s%9s%10s%12s\n", "No.", "Job ID", "CPU/GPU", "Partitions"));
            for (int i = 0; i < jobID.size(); i++) {
                sb.append(String.format("%5d%8d%10s%18s\n", (i + 1), jobID.get(i), cpuGpu.get(i), partitions.get(i)));
            }
            
            //write to file
            try {
                FileWriter fw = new FileWriter("NeverRunnableJobs.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(sb.toString());
                bw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            //output in WINDOW GUI
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(800, 600));
            JOptionPane.showMessageDialog(null, scrollPane, "Jobs Never Runnable", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found");
        }
    }
}
