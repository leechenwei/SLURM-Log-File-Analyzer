/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Luis Lee
 */
public class extractPartition{
    public void extractPartition(String filePath) {
    ArrayList<String> partition=new ArrayList<>();
    ArrayList<String> type=new ArrayList<>();
    ArrayList<String> name=new ArrayList<>();
    String keyword1="sched:";
    String keyword2="Partition=";
    StringBuilder result = new StringBuilder();
    result.append("The number of jobs by partition: \n\n");
    result.append(String.format("%-20s%-5s\n", "Partition", "Count"));
    try{	
        BufferedReader reader=new BufferedReader(new FileReader(filePath));
        String line="";
        while((line=reader.readLine())!=null){
            if(line.contains(keyword1)){
                if(line.contains(keyword2)){
                    String temp[]=line.split(" ");
                    partition.add(temp[6]);
                    String temp2[]=temp[6].split("=");
                    name.add(temp2[1]);
                    String temp3[]=temp2[1].split("-");
                    type.add(temp3[0]);
                }
            }
        }
        while (!name.isEmpty()) {
            String display = name.get(0);
            int frequencyName = Collections.frequency(name, display);
            name.removeAll(Collections.singleton(display));
            result.append(String.format("%-20s%-5d\n",display,frequencyName));
        }
        reader.close();
    }catch(FileNotFoundException e){
        JOptionPane.showMessageDialog(null, "File not found.");
    }catch(IOException e){
        JOptionPane.showMessageDialog(null, "Problem with file Input.");
    }
    
    try{
                FileWriter fw = new FileWriter("extract_Partition.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(result.toString());
                bw.close();
            }catch(IOException e){
                JOptionPane.showMessageDialog(null,"Write to file Failed", "Error",JOptionPane.ERROR_MESSAGE);
            }
    JTextArea textArea = new JTextArea(result.toString());
    textArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(800, 600));
    JOptionPane.showMessageDialog(null, scrollPane, "Partition", JOptionPane.INFORMATION_MESSAGE);
}
}
