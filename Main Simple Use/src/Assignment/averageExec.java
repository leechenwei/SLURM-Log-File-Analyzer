/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class averageExec {
    public void findAverageExecutionTime(String filePath) {
        ArrayList < Double > executionTimes = new ArrayList < > ();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Date startTime = null;
            while ((line = reader.readLine()) != null) {
                if (line.contains("sched: Allocate")) {
                    startTime = getDateFromLine(line, dateFormat);
                } else if (line.contains("_job_complete")) {
                    if (startTime != null) {
                        Date endTime = getDateFromLine(line, dateFormat);
                        executionTimes.add((endTime.getTime() - startTime.getTime()) / 1000.0);
                        startTime = null;
                    }
                }
            }
            double totalTime = 0;
            for (double time: executionTimes) {
                totalTime += time;
            }
            double averageTimeInSeconds = totalTime / executionTimes.size();
            int minutes = (int) averageTimeInSeconds / 60;
            int seconds = (int) averageTimeInSeconds % 60;
            JOptionPane.showMessageDialog(null, "Average execution time: " + minutes + " minutes " + seconds + " seconds");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static Date getDateFromLine(String line, SimpleDateFormat dateFormat) throws ParseException {
        int startIndex = line.indexOf("[");
        int endIndex = line.indexOf("]");
        String dateString = line.substring(startIndex + 1, endIndex);
        return dateFormat.parse(dateString);
    }
}