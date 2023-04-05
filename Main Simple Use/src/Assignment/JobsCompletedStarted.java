/*
Click nbfs: //nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs: //nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/
package Assignment;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class JobsCompletedStarted {
    private static JTable tableStarted = new JTable();
    private static JTable tableCompleted = new JTable();

    public static void findNumberOfJobsStarted(String filePath, Date startDate, Date endDate) throws IOException {
        ArrayList < Integer > jobStartedIds = new ArrayList < > ();
        //create a list of lines that read all lines for the specified file
        List < String > lines = Files.readAllLines(Paths.get(filePath), Charset.defaultCharset());

        int jobStartedCount = 0;
        //use library to set data format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        //for each readed lines
        for (String line: lines) {
            //check if consist the words, continue if not
            if (!line.contains("sched: Allocate")) {
                continue;
            }
            //split the time and get the first splited time
            String timestamp = line.split(" ")[0];
            timestamp = timestamp.substring(1, timestamp.length() - 1);
            Date eventDate = null;
            try {
                //set eventDate to timestamp with the customized data format
                eventDate = dateFormat.parse(timestamp);
                //throws ParseException for error faced
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid Time");
            }

            //check if time is valid and within the time frame
            if (eventDate != null && eventDate.after(startDate) && eventDate.before(endDate)) {
                jobStartedCount++;
                int jobId = Integer.parseInt(line.split(" ")[3].split("=")[1]);
                jobStartedIds.add(jobId);
            }
        }
        JOptionPane.showMessageDialog(null, "Number of jobs started within time frame: " + jobStartedCount);

        //create table and add data
        String[] columnNames = {
            "Job ID"
        };
        DefaultTableModel modelStarted = new DefaultTableModel(columnNames, 0);
        for (Integer jobId: jobStartedIds) {
            modelStarted.addRow(new Object[] {
                jobId
            });
        }
        tableStarted.setModel(modelStarted);
        tableStarted.setEnabled(false);

        try {
            File file = new File("JobStarted.txt");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter fw = new FileWriter("JobStarted.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Number of jobs started within time frame: " + jobStartedCount);
            bw.write("\n\n");
            for (int i = 0; i < modelStarted.getRowCount(); i++) {
                for (int j = 0; j < modelStarted.getColumnCount(); j++) {
                    bw.write(modelStarted.getValueAt(i, j).toString() + "\t");
                }
                bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        JFrame frame = new JFrame("Started Jobs within the Time Range");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(tableStarted));
        frame.pack();
        frame.setVisible(true);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void findNumberOfJobsCompleted(String filePath, Date startDate, Date endDate) throws IOException {
        ArrayList < Integer > jobCompletedIds = new ArrayList < > ();
        List < String > lines = Files.readAllLines(Paths.get(filePath), Charset.defaultCharset());

        int jobCompletedCount = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        for (String line: lines) {
            if (!line.contains("_job_complete:") || !line.contains("done")) {
                continue;
            }
            String timestamp = line.split(" ")[0];
            timestamp = timestamp.substring(1, timestamp.length() - 1);
            Date eventDate = null;
            try {
                eventDate = dateFormat.parse(timestamp);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid Time");
            }

            if (eventDate != null && eventDate.after(startDate) && eventDate.before(endDate)) {
                jobCompletedCount++;
                int jobId = Integer.parseInt(line.split(" ")[2].split("=")[1]);
                jobCompletedIds.add(jobId);
            }
        }
        JOptionPane.showMessageDialog(null, "Number of jobs completed within time frame: " + jobCompletedCount);

        //create table and add data
        String[] columnNames = {
            "Job ID"
        };
        DefaultTableModel modelCompleted = new DefaultTableModel(columnNames, 0);
        for (Integer jobId: jobCompletedIds) {
            modelCompleted.addRow(new Object[] {
                jobId
            });
        }
        tableCompleted.setModel(modelCompleted);
        tableCompleted.setEnabled(false);

        try {
            File file = new File("JobCompleted.txt");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter fw = new FileWriter("JobCompleted.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Number of jobs completed within time frame: " + jobCompletedCount);
            bw.write("\n\n");
            for (int i = 0; i < modelCompleted.getRowCount(); i++) {
                for (int j = 0; j < modelCompleted.getColumnCount(); j++) {
                    bw.write(modelCompleted.getValueAt(i, j).toString() + "\t");
                }
                bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Write to file Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        JFrame frame = new JFrame("Completed Jobs within the Time Range");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(tableCompleted));
        frame.pack();
        frame.setVisible(true);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }
}

