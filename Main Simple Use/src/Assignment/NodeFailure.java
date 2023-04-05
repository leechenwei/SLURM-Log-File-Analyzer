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
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NodeFailure {
    public void getNodeFailure(String filePath) {
        try {
            ArrayList < String > node = new ArrayList < > ();
            String keyword = "lookup failure";
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    String[] temp = line.split(" ");
                    node.add(temp[7].replace("\"", "").replace("\"", ""));
                }
            }
            // Create a JTextArea to hold the output
            JTextArea output = new JTextArea();
            // Create a JScrollPane to hold the JTextArea
            JScrollPane scrollPane = new JScrollPane(output);
            output.append("Look up failure: \n");
            output.append(String.format("%-30s%-5s\n", "Node", "Frequency"));
            for (int i = 0; i < 39; i++) {
                output.append("-");
            }
            output.append("\n");
            while (!node.isEmpty()) {
                String display = node.get(0);
                int frequency = Collections.frequency(node, display);
                node.removeAll(Collections.singleton(display));
                output.append(String.format("%-30s%-10d\n", display, frequency));
            }

            //write to file
            try {
                FileWriter fw = new FileWriter("NodeFailure.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(output.toString());
                bw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
            scrollPane.setPreferredSize(new Dimension(800, 600));
            // Add the JScrollPane to the JOptionPane
            JOptionPane.showMessageDialog(null, scrollPane, "Lookup Failure", JOptionPane.INFORMATION_MESSAGE);
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
