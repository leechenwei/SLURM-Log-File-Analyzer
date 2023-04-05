/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Assignment;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class MAIN_UserInterface extends JFrame implements ActionListener {
    private JTextField filePathField;
    private JComboBox < String > optionsComboBox;
    private JButton submitButton;
    private JLabel filePathLabel;
    private JLabel optionsLabel;
    private String logFilePath;
    private String[] logLinesArray;
    private ArrayList < String > logLinesList;

    //to get the start and end date
    private Date[] getStartEndDates() {
        //set the date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDateString = JOptionPane.showInputDialog(this, "Enter start date (yyyy-MM-dd HH:mm:ss) :");
        String endDateString = JOptionPane.showInputDialog(this, "Enter end date (yyyy-MM-dd HH:mm:ss) :");
        Date startDate = null;
        Date endDate = null;
        try {
            //convert to date format
            startDate = dateFormat.parse(startDateString);
            endDate = dateFormat.parse(endDateString);
        } catch (ParseException e) {
            //show error in a window
            JOptionPane.showMessageDialog(this, "Invalid date format");
        }
        //return start and end Date
        return new Date[] {
            startDate,
            endDate
        };
    }

    public static void main(String[] args) {
        //create an object to prevent error
        MAIN_UserInterface logFileGUI = new MAIN_UserInterface();
    }

    //main user interface class that used to run the whole program
    public MAIN_UserInterface() {
        //set window title for the GUI window
        setTitle("Log File Analyzer");
        //set program window size
        setSize(800, 400);
        //terminate program when close button is clicked;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //no set any fixed location for program window
        setLocationRelativeTo(null);

        //create layout 
        GridBagLayout layout = new GridBagLayout();
        //show the layout using Jpanel
        JPanel panel = new JPanel(layout);
        //create the properties object for GridBagConstraints
        GridBagConstraints constraints = new GridBagConstraints();
        //set grid properties to be horizontal
        constraints.fill = GridBagConstraints.HORIZONTAL;

        //label the words
        filePathLabel = new JLabel("Enter the path of the log file: ");
        //the box for user to input the file path
        filePathField = new JTextField(20);
        //set the input box size
        filePathField.setPreferredSize(new Dimension(200, 30));
        //option selection box label
        optionsLabel = new JLabel("Select an option: ");
        //create the list of options box
        optionsComboBox = new JComboBox < String > ();
        //list of options
        optionsComboBox.addItem("Number of Jobs Started within a given Time Range");
        optionsComboBox.addItem("Number of Jobs Completed within a given Time Range");
        optionsComboBox.addItem("Number of Jobs by Partitions");
        optionsComboBox.addItem("Number of Jobs causing Error and the Corresponding User");
        optionsComboBox.addItem("Average Execution Time of the Jobs submitted to UMHPC");
        optionsComboBox.addItem("Number of Jobs Found with Job Id, NodeList, CPUs, and Partition");
        optionsComboBox.addItem("Number of OOM Failure with which Jobs Id Experienced");
        optionsComboBox.addItem("Number of Jobs that Never Runnable in Partition with Frequency of CPU,GPU and each partition and Job ID");
        optionsComboBox.addItem("Number of WEXITSTATUS for each Status Type and showing List of Id with Status");
        optionsComboBox.addItem("Number of Backfill for IN/ON with Jobs Id and Frequency of On and In of each Partition");
        optionsComboBox.addItem("Number of Update Job that Completed with Job Id, UID and Frequency");
        optionsComboBox.addItem("Number of Jobs Id that Time Exhausted and list Jobs ID");
        optionsComboBox.addItem("Number of Cleaned up Jobs with Job Id and Time Taken");
        optionsComboBox.addItem("List of Node Failure with Frequency");
        optionsComboBox.addItem("Number of Underflow Errors with Time Stamp, Job Id, Association ID, TRES Type, Metric, Duration, Remaining Duration");
        optionsComboBox.addItem("Number of Request Kill Job and Job ID");
        optionsComboBox.addItem("Number of Job ID Requeuing");
        optionsComboBox.addItem("Number of Job create exceeded association/QOS limit");
        //set the size for the selection box
        optionsComboBox.setPreferredSize(new Dimension(450, 30));
        //create a button labelled "Submit"
        submitButton = new JButton("Submit");
        //when button is click, perform the program
        submitButton.addActionListener(this);

        //set first row first column for file path label
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(filePathLabel, constraints);
        //set second column for file path field
        constraints.gridx = 1;
        panel.add(filePathField, constraints);

        //set first row and second column for options label
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(optionsLabel, constraints);

        //set second column for options box field
        constraints.gridx = 1;
        panel.add(optionsComboBox, constraints);

        //set second column and third row for submit button
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(submitButton, constraints);

        //add the panel
        add(panel);
        //set visible to user
        setVisible(true);
    }

    @Override
    //listen to any click event
    public void actionPerformed(ActionEvent e) {
        //if submit button is clicked
        if (e.getSource() == submitButton) {
            //get filepath
            logFilePath = filePathField.getText();
            logLinesArray = new String[100];
            logLinesList = new ArrayList < > ();
            //get user selected option
            String selectedOption = (String) optionsComboBox.getSelectedItem();
            //switch case
            switch (selectedOption) {
                case "Number of Jobs Started within a given Time Range":
                    // code to execute for option 1
                    //get start and end date
                    Date[] startEndDates = getStartEndDates();
                    try {
                        JobsCompletedStarted.findNumberOfJobsStarted(logFilePath, startEndDates[0], startEndDates[1]);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Error finding number of jobs started: " + ex.getMessage());
                    }
                    break;
                case "Number of Jobs Completed within a given Time Range":
                    // code to execute for option 2
                    startEndDates = getStartEndDates();
                    try {
                        JobsCompletedStarted.findNumberOfJobsCompleted(logFilePath, startEndDates[0], startEndDates[1]);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Error finding number of jobs completed: " + ex.getMessage());
                    }
                    break;
                case "Number of Jobs by Partitions":
                    // code to execute for option 3
                    JOptionPane.showMessageDialog(this, "you have selected option: Number of Jobs by Partitions");
                    extractPartition extractpartition = new extractPartition();
                    extractpartition.extractPartition(filePathField.getText());
                    break;
                case "Number of Jobs causing Error and the Corresponding User":
                    // code to execute for option 4
                    JOptionPane.showMessageDialog(this, "you have selected option: Number of Jobs causing Error and the Corresponding User");
                    FindErrorUsers finderrorusers = new FindErrorUsers();
                    finderrorusers.findErrorUsers(filePathField.getText());
                    break;
                case "Average Execution Time of the Jobs submitted to UMHPC":
                    // code to execute for option 5
                    JOptionPane.showMessageDialog(this, "you have selected option: Average Execution Time of the Jobs submitted to UMHPC");
                    averageExec avgExec = new averageExec();
                    avgExec.findAverageExecutionTime(filePathField.getText());
                    break;
                case "Number of Jobs Found with Job Id, NodeList, CPUs, and Partition":
                    // code to execute for option 6
                    JOptionPane.showMessageDialog(this, "you have selected option:Number of Jobs Found with Job Id, NodeList, CPUs, and Partition");
                    ListJobID listjobid = new ListJobID();
                    listjobid.listJobID(filePathField.getText());
                    break;
                case "Number of OOM Failure with which Jobs Id Experienced":
                    // code to execute for option 7
                    JOptionPane.showMessageDialog(this, "you have selected option: Number of OOM Failure with which Jobs Id Experienced");
                    checkOOM oomFailure = new checkOOM();
                    oomFailure.findOOMFailure(filePathField.getText());
                    break;
                case "Number of Jobs that Never Runnable in Partition with Frequency of CPU,GPU and each partition and Job ID":
                    // code to execute for option 8
                    JOptionPane.showMessageDialog(this, "you have selected option: Number of Jobs that Never Runnable in Partition with Frequency of CPU,GPU and each partition and Job ID");
                    NeverRunnable nvrrunnable = new NeverRunnable();
                    nvrrunnable.NeverRunnable(filePathField.getText());
                    break;
                case "Number of WEXITSTATUS for each Status Type and showing List of Id with Status":
                    // code to execute for option 9
                    JOptionPane.showMessageDialog(this, "you have selected option: Number of WEXITSTATUS for each Status Type and showing List of Id with Status");
                    Status status = new Status();
                    status.wexitstatus(filePathField.getText());
                    break;
                case "Number of Backfill for IN/ON with Jobs Id and Frequency of On and In of each Partition":
                    // code to execute for option 10
                    JOptionPane.showMessageDialog(this, "you have selected option: Number of Backfill for IN/ON with Jobs Id and Frequency of On and In of each Partition");
                    Backfills bfills = new Backfills();
                    bfills.getBackfill(filePathField.getText());
                    break;
                case "Number of Update Job that Completed with Job Id, UID and Frequency":
                    // code to execute for option 11
                    JOptionPane.showMessageDialog(this, "you have selected option: Number of Update Job that Completed with Job Id, UID and Frequency");
                    UpdateJobs updatejobs = new UpdateJobs();
                    updatejobs.getUpdateCompleteJob(filePathField.getText());
                    break;
                case "Number of Jobs Id that Time Exhausted and list Jobs ID":
                    // code to execute for option 12
                    JOptionPane.showMessageDialog(this, "you have selected option: Number of Jobs Id that Time Exhausted and list Jobs ID");
                    TimeExhaustJobId exhaustjobid = new TimeExhaustJobId();
                    exhaustjobid.getTimeExhaustJobId(filePathField.getText());
                    break;
                case "Number of Cleaned up Jobs with Job Id and Time Taken":
                    // code to execute for option 13
                    JOptionPane.showMessageDialog(this, "you have selected option: Number of Cleaned up Jobs with Job Id and Time Taken");
                    CleanedJob cleanedjob = new CleanedJob();
                    cleanedjob.getCleanupCompletingJob(filePathField.getText());
                    break;
                case "List of Node Failure with Frequency":
                    // code to execute for option 14
                    JOptionPane.showMessageDialog(this, "you have selected option: List of Node Failure with Frequency");
                    NodeFailure nodefailure = new NodeFailure();
                    nodefailure.getNodeFailure(filePathField.getText());
                    break;
                case "Number of Underflow Errors with Time Stamp, Job Id, Association ID, TRES Type, Metric, Duration, Remaining Duration":
                    // code to execute for option 15
                    JOptionPane.showMessageDialog(this, "you have selected option: Number of Underflow Errors with Time Stamp, Job Id, Association ID, TRES Type, Metric, Duration, Remaining Duration");
                    UnderflowList underflow = new UnderflowList();
                    underflow.getUnderflowList(filePathField.getText());
                    break;
                case "Number of Request Kill Job and Job ID":
                    // code to execute for option 16
                    JOptionPane.showMessageDialog(this, "you have selected option: Number of Request Kill Job and Job ID");
                    RequestKillJob requestkilljob = new RequestKillJob();
                    requestkilljob.getRequestKillJob(filePathField.getText());
                    break;
                case "Number of Job ID Requeuing":
                    // code to execute for option 17
                    JOptionPane.showMessageDialog(this, "you have selected option: Number of Job ID Requeuing");
                    RequeingJobID requeingjobid = new RequeingJobID();
                    requeingjobid.getRequeuingJobID(filePathField.getText());
                    break;
                case "Number of Job create exceeded association/QOS limit":
                    // code to execute for option 18
                    JOptionPane.showMessageDialog(this, "you have selected option: Number of Job create exceeded association/QOS limit");
                    QOSLimit  qoslimit = new  QOSLimit();
                    qoslimit.getQOSLimitUID(filePathField.getText());
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Invalid selection. Please choose an option from the list.");
            }
        }
    }
}