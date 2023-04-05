/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;


/**
 *
 * @author phuaw
 */
public class NewFXMain extends Application {


    @Override
    public void start(Stage stage) {
        
        
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis  = new NumberAxis();
        xAxis.setLabel("Months");
        yAxis.setLabel("Number of Jobs");
        BarChart barchart = new BarChart(xAxis,yAxis);
        
        
        //1
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("BarChart 1: Numbers of Job Started");
        dataSeries1.getData().add(new XYChart.Data("June", 2191));
        dataSeries1.getData().add(new XYChart.Data("July"  , 1304));
        dataSeries1.getData().add(new XYChart.Data("August"  , 1232));
        dataSeries1.getData().add(new XYChart.Data("September"  , 1253));
        dataSeries1.getData().add(new XYChart.Data("October"  , 1778));
        dataSeries1.getData().add(new XYChart.Data("November"  , 907));
        dataSeries1.getData().add(new XYChart.Data("December"  , 551));
        
        //2
        CategoryAxis xAxis2 = new CategoryAxis();
        NumberAxis yAxis2 = new NumberAxis();
        xAxis2.setLabel("Months");
        yAxis2.setLabel("Number of Jobs");
        BarChart barchart2 = new BarChart(xAxis2, yAxis2);
        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("BarChart 2: Number of Jobs Completed By Month");
        dataSeries2.getData().add(new XYChart.Data("June", 1893));
        dataSeries2.getData().add(new XYChart.Data("July"  , 1139));
        dataSeries2.getData().add(new XYChart.Data("August"  , 1186));
        dataSeries2.getData().add(new XYChart.Data("September"  , 1153));
        dataSeries2.getData().add(new XYChart.Data("October"  ,1564 ));
        dataSeries2.getData().add(new XYChart.Data("November"  , 1092));
        dataSeries2.getData().add(new XYChart.Data("December"  , 452));
        
        //3
        CategoryAxis xAxis3 = new CategoryAxis();
        NumberAxis yAxis3 = new NumberAxis();
        BarChart barchart3 = new BarChart(xAxis3,yAxis3);
        xAxis3.setLabel("Months");
        yAxis3.setLabel("Number of Job Id");
        XYChart.Series dataSeries3 = new XYChart.Series();
        dataSeries3.setName("BarChart 3: Number of Job Id Found");
        dataSeries3.getData().add(new XYChart.Data<>("June", 2191));
        dataSeries3.getData().add(new XYChart.Data<>("July", 1304)); 
        dataSeries3.getData().add(new XYChart.Data<>("August", 1232)); 
        dataSeries3.getData().add(new XYChart.Data<>("September", 1253)); 
        dataSeries3.getData().add(new XYChart.Data<>("October", 1778)); 
        dataSeries3.getData().add(new XYChart.Data<>("November", 907)); 
        dataSeries3.getData().add(new XYChart.Data<>("December",551));
        
        //4
        CategoryAxis xAxis4 = new CategoryAxis();
        NumberAxis yAxis4  = new NumberAxis();
        xAxis4.setLabel("Partition");
        yAxis4.setLabel("Number of Jobs");
        BarChart barchart4 = new BarChart(xAxis4,yAxis4);
        XYChart.Series dataSeries4 = new XYChart.Series();
        dataSeries4.setName("BarChart 4: Number of Jobs by each different partition");
        dataSeries4.getData().add(new XYChart.Data("gpu-v100s", 588));
        dataSeries4.getData().add(new XYChart.Data("cpu-opteron"  , 4509));
        dataSeries4.getData().add(new XYChart.Data("gpu-k10"  , 428));
        dataSeries4.getData().add(new XYChart.Data("gpu-titan"  , 640));
        dataSeries4.getData().add(new XYChart.Data("cpu-epyc"  ,2756 ));
        dataSeries4.getData().add(new XYChart.Data("gpu-k40c"  , 295));
  
        //5
        CategoryAxis xAxis5 = new CategoryAxis();
        NumberAxis yAxis5 = new NumberAxis();
        xAxis5.setLabel("Username");
        yAxis5.setLabel("Number of errors");
        BarChart barchart5 = new BarChart(xAxis5, yAxis5);
        XYChart.Series dataSeries5 = new XYChart.Series();
        dataSeries5.setName("BarChart 5: Number of errors with user name");
        dataSeries5.getData().add(new XYChart.Data("lobbeytan", 3));
        dataSeries5.getData().add(new XYChart.Data("tingweijing"  , 2));
        dataSeries5.getData().add(new XYChart.Data("f4ww4z"  , 4));
        dataSeries5.getData().add(new XYChart.Data("xinpeng"  , 1));
        dataSeries5.getData().add(new XYChart.Data("aznul"  , 2));
        dataSeries5.getData().add(new XYChart.Data("hass"  , 17));
        dataSeries5.getData().add(new XYChart.Data("liew.wei.shiung"  , 3));
        dataSeries5.getData().add(new XYChart.Data("roland"  , 4));
        dataSeries5.getData().add(new XYChart.Data("shahreeza"  , 6));
        dataSeries5.getData().add(new XYChart.Data("janvik" , 4));
        dataSeries5.getData().add(new XYChart.Data("lin0618"  , 4));
        dataSeries5.getData().add(new XYChart.Data("fahmi8"  , 1));
        dataSeries5.getData().add(new XYChart.Data("farhatabjani"  , 3));
        dataSeries5.getData().add(new XYChart.Data("kurk"  , 1));
        dataSeries5.getData().add(new XYChart.Data("fairus"  , 10));
        dataSeries5.getData().add(new XYChart.Data("manoj"  , 4));
        dataSeries5.getData().add(new XYChart.Data("han" , 11));
        dataSeries5.getData().add(new XYChart.Data("aah"  , 12));
        dataSeries5.getData().add(new XYChart.Data("mk_98"  , 24));
        dataSeries5.getData().add(new XYChart.Data("hva170037"  , 5));
        dataSeries5.getData().add(new XYChart.Data("yatyuen.lim"  , 1));
        dataSeries5.getData().add(new XYChart.Data("ongkuanhung" , 1));
        dataSeries5.getData().add(new XYChart.Data("chiuling" , 2));
        dataSeries5.getData().add(new XYChart.Data("noraini"  ,4));
        dataSeries5.getData().add(new XYChart.Data("hongvin"  ,9));
        dataSeries5.getData().add(new XYChart.Data("htt_felicia"  ,21));
        
        //6
        CategoryAxis xAxis6 = new CategoryAxis();
        NumberAxis yAxis6 = new NumberAxis();
        xAxis6.setLabel("Months");
        yAxis6.setLabel("Time in Seconds");
        BarChart barchart6 = new BarChart(xAxis6, yAxis6);
        XYChart.Series dataSeries6 = new XYChart.Series();
        dataSeries6.setName("BarChart 6: Average execution time");
        dataSeries6.getData().add(new XYChart.Data("June", 440));
        dataSeries6.getData().add(new XYChart.Data("July"  , 994));
        dataSeries6.getData().add(new XYChart.Data("August"  , 1013));
        dataSeries6.getData().add(new XYChart.Data("September"  , 1094));
        dataSeries6.getData().add(new XYChart.Data("October"  , 763));
        dataSeries6.getData().add(new XYChart.Data("November"  , 1135));
        dataSeries6.getData().add(new XYChart.Data("December"  , 1385));
        
        //7
        CategoryAxis xAxis7 = new CategoryAxis();
        NumberAxis yAxis7 = new NumberAxis();
        xAxis7.setLabel("Months");
        yAxis7.setLabel("Number of OOM Failure");
        BarChart barchart7 = new BarChart(xAxis7, yAxis7);
        XYChart.Series dataSeries7 = new XYChart.Series();
        dataSeries7.setName("BarChart 7: Number of OOM Failure");
        dataSeries7.getData().add(new XYChart.Data("June", 16));
        dataSeries7.getData().add(new XYChart.Data("July"  , 7));
        dataSeries7.getData().add(new XYChart.Data("August"  , 17));
        dataSeries7.getData().add(new XYChart.Data("September"  , 6));
        dataSeries7.getData().add(new XYChart.Data("October"  , 20));
        dataSeries7.getData().add(new XYChart.Data("November"  , 12));
        dataSeries7.getData().add(new XYChart.Data("December"  , 9));
        
        //8
        CategoryAxis xAxis8 = new CategoryAxis();
        NumberAxis yAxis8 = new NumberAxis();
        xAxis8.setLabel("Months");
        yAxis8.setLabel("Number of Jobs Never Runnable in Partitions");
        BarChart barchart8 = new BarChart(xAxis8, yAxis8);
        XYChart.Series dataSeries8 = new XYChart.Series();
        dataSeries8.setName("BarChart 8: Number of Jobs Never Runnable in Partitions");
        dataSeries8.getData().add(new XYChart.Data("June", 64));
        dataSeries8.getData().add(new XYChart.Data("July"  , 17));
        dataSeries8.getData().add(new XYChart.Data("August"  , 9));
        dataSeries8.getData().add(new XYChart.Data("September"  , 4));
        dataSeries8.getData().add(new XYChart.Data("October"  , 9));
        dataSeries8.getData().add(new XYChart.Data("November"  , 9));
        dataSeries8.getData().add(new XYChart.Data("December"  , 4));
        
        //9
        CategoryAxis xAxis9 = new CategoryAxis();
        NumberAxis yAxis9 = new NumberAxis();
        xAxis9.setLabel("WEXITSTATUS");
        yAxis9.setLabel("Frequency");
        LineChart linechart9 = new LineChart(xAxis9, yAxis9);
        XYChart.Series dataSeries9 = new XYChart.Series();
        dataSeries9.setName("LineChart 1: Frequency for WEXITSTATUS");
        dataSeries9.getData().add(new XYChart.Data("0", 5779));
        dataSeries9.getData().add(new XYChart.Data("1", 1984));
        dataSeries9.getData().add(new XYChart.Data("102", 4));
        dataSeries9.getData().add(new XYChart.Data("104", 3));
        dataSeries9.getData().add(new XYChart.Data("105", 3));
        dataSeries9.getData().add(new XYChart.Data("120", 2));
        dataSeries9.getData().add(new XYChart.Data("126", 10));
        dataSeries9.getData().add(new XYChart.Data("127", 133));
        dataSeries9.getData().add(new XYChart.Data("13", 2));
        dataSeries9.getData().add(new XYChart.Data("130", 20));
        dataSeries9.getData().add(new XYChart.Data("132", 2));
        dataSeries9.getData().add(new XYChart.Data("134", 9));
        dataSeries9.getData().add(new XYChart.Data("137", 18));
        dataSeries9.getData().add(new XYChart.Data("139", 83));
        dataSeries9.getData().add(new XYChart.Data("16", 14));
        dataSeries9.getData().add(new XYChart.Data("174", 3));
        dataSeries9.getData().add(new XYChart.Data("2", 127));
        dataSeries9.getData().add(new XYChart.Data("200", 21));
        dataSeries9.getData().add(new XYChart.Data("21", 6));
        dataSeries9.getData().add(new XYChart.Data("255", 32));
        dataSeries9.getData().add(new XYChart.Data("3", 7));
        dataSeries9.getData().add(new XYChart.Data("31", 21));
        dataSeries9.getData().add(new XYChart.Data("41", 2));
        dataSeries9.getData().add(new XYChart.Data("8", 1));
        
        //10
        CategoryAxis xAxis10 = new CategoryAxis();
        NumberAxis yAxis10 = new NumberAxis();
        xAxis10.setLabel("Months");
        yAxis10.setLabel("Number of Backfill for IN/ON");
        BarChart barchart10 = new BarChart(xAxis10, yAxis10);
        XYChart.Series dataSeries10 = new XYChart.Series();
        dataSeries10.setName("BarChart 9: Number of Backfill for IN/ON");
        dataSeries10.getData().add(new XYChart.Data("June", 28));
        dataSeries10.getData().add(new XYChart.Data("July"  , 25));
        dataSeries10.getData().add(new XYChart.Data("August"  , 253));
        dataSeries10.getData().add(new XYChart.Data("September"  , 99));
        dataSeries10.getData().add(new XYChart.Data("October"  , 23));
        dataSeries10.getData().add(new XYChart.Data("November"  , 274));
        dataSeries10.getData().add(new XYChart.Data("December"  , 48));
        
        
        //11
        CategoryAxis xAxis11 = new CategoryAxis();
        NumberAxis yAxis11 = new NumberAxis();
        xAxis11.setLabel("Months");
        yAxis11.setLabel("Number of Update Job Complete");
        BarChart barchart11 = new BarChart(xAxis11, yAxis11);
        XYChart.Series dataSeries11 = new XYChart.Series();
        dataSeries11.setName("BarChart 10: Number of Update Job Complete");
        dataSeries11.getData().add(new XYChart.Data("June", 1));
        dataSeries11.getData().add(new XYChart.Data("July"  , 0));
        dataSeries11.getData().add(new XYChart.Data("August"  , 57));
        dataSeries11.getData().add(new XYChart.Data("September"  , 2));
        dataSeries11.getData().add(new XYChart.Data("October"  , 0));
        dataSeries11.getData().add(new XYChart.Data("November"  , 1));
        dataSeries11.getData().add(new XYChart.Data("December"  , 26));
        
        
        //12
        CategoryAxis xAxis12 = new CategoryAxis();
        NumberAxis yAxis12 = new NumberAxis();
        xAxis12.setLabel("Months");
        yAxis12.setLabel("Number of Job Id that Time Limit Exhausted");
        BarChart barchart12 = new BarChart(xAxis12, yAxis12);
        XYChart.Series dataSeries12 = new XYChart.Series();
        dataSeries12.setName("BarChart 11: Number of Job Id that Time Limit Exhausted");
        dataSeries12.getData().add(new XYChart.Data("June", 98));
        dataSeries12.getData().add(new XYChart.Data("July"  , 56));
        dataSeries12.getData().add(new XYChart.Data("August"  , 40));
        dataSeries12.getData().add(new XYChart.Data("September"  , 66));
        dataSeries12.getData().add(new XYChart.Data("October"  , 49));
        dataSeries12.getData().add(new XYChart.Data("November"  , 74));
        dataSeries12.getData().add(new XYChart.Data("December"  , 54));
        
        //13
        CategoryAxis xAxis13 = new CategoryAxis();
        NumberAxis yAxis13 = new NumberAxis();
        xAxis13.setLabel("Months");
        yAxis13.setLabel("Number of Cleaned Up Jobs");
        BarChart barchart13 = new BarChart(xAxis13, yAxis13);
        XYChart.Series dataSeries13 = new XYChart.Series();
        dataSeries13.setName("BarChart 12: Number of Cleaned Up Jobs");
        dataSeries13.getData().add(new XYChart.Data("June", 17));
        dataSeries13.getData().add(new XYChart.Data("July"  , 0));
        dataSeries13.getData().add(new XYChart.Data("August"  , 15));
        dataSeries13.getData().add(new XYChart.Data("September"  , 14));
        dataSeries13.getData().add(new XYChart.Data("October"  , 12));
        dataSeries13.getData().add(new XYChart.Data("November"  , 53));
        dataSeries13.getData().add(new XYChart.Data("December"  , 14));
      
        
 
        
        barchart.getData().addAll(dataSeries1);
        barchart2.getData().addAll(dataSeries2);
        barchart3.getData().addAll(dataSeries3);
        barchart4.getData().addAll(dataSeries4);
        barchart5.getData().addAll(dataSeries5);
        barchart6.getData().addAll(dataSeries6);
        barchart7.getData().addAll(dataSeries7);
        barchart8.getData().addAll(dataSeries8);
        linechart9.getData().addAll(dataSeries9);
        barchart10.getData().addAll(dataSeries10);
        barchart11.getData().addAll(dataSeries11);
        barchart12.getData().addAll(dataSeries12);
        barchart13.getData().addAll(dataSeries13);
        
        TabPane tabPane = new TabPane();
        
        Tab tab1 = new Tab("Tab 1");
        HBox hbox1 = new HBox(barchart,barchart2,barchart3);
        tab1.setContent(hbox1);
        tabPane.getTabs().add(tab1);
        
        Tab tab2 = new Tab("Tab 2");
        HBox hbox2 = new HBox(barchart4,barchart5,barchart6);
        tab2.setContent(hbox2);
        tabPane.getTabs().add(tab2);
        
        Tab tab3 = new Tab("Tab 3");
        HBox hbox3 = new HBox(barchart7,barchart8,barchart10);
        tab3.setContent(hbox3);
        tabPane.getTabs().add(tab3);
        
        Tab tab4 = new Tab("Tab 4");
        HBox hbox4 = new HBox(barchart11,barchart12,barchart13);
        tab4.setContent(hbox4);
        tabPane.getTabs().add(tab4);
        
        Tab tab5 = new Tab("Tab 5");
        HBox hbox5 = new HBox(linechart9);
        tab5.setContent(hbox5);
        tabPane.getTabs().add(tab5);
        
        Scene scene = new Scene(tabPane);
        
        
        
        
        
        stage.setScene(scene);
        stage.setHeight(450);
        stage.setWidth(900);
        stage.show();
        
        
      
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}