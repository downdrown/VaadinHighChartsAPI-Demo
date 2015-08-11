package at.downdrown.vaadinaddons;

import at.downdrown.vaadinaddons.highchartsapi.Colors;
import at.downdrown.vaadinaddons.highchartsapi.HighChart;
import at.downdrown.vaadinaddons.highchartsapi.HighChartFactory;
import at.downdrown.vaadinaddons.highchartsapi.exceptions.HighChartsException;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartConfiguration;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartType;
import at.downdrown.vaadinaddons.highchartsapi.model.data.PieChartData;
import at.downdrown.vaadinaddons.highchartsapi.model.series.BarChartSeries;
import at.downdrown.vaadinaddons.highchartsapi.model.series.ColumnChartSeries;
import at.downdrown.vaadinaddons.highchartsapi.model.series.LineChartSeries;
import at.downdrown.vaadinaddons.highchartsapi.model.series.PieChartSeries;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Theme("mytheme")
@Widgetset("at.downdrown.vaadinaddons.MyAppWidgetset")
public class DemoUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setStyleName("demoContentLayout");

        // *** PIE ***
        ChartConfiguration pieConfiguration = new ChartConfiguration();
        pieConfiguration.setTitle("TestPie");
        pieConfiguration.setChartType(ChartType.PIE);
        pieConfiguration.setBackgroundColor(Colors.WHITE);

        PieChartSeries pieFruits = new PieChartSeries("Fruits");
        PieChartData bananas = new PieChartData("Bananas", 33.2);
        PieChartData melons = new PieChartData("Melons", 6.21);
        PieChartData apples = new PieChartData("Apples", 3.44);

        pieFruits.getData().add(bananas);
        pieFruits.getData().add(melons);
        pieFruits.getData().add(apples);


        pieConfiguration.getSeriesList().add(pieFruits);
        try {
            HighChart pieChart = HighChartFactory.renderChart(pieConfiguration);
            pieChart.setHeight(80, Unit.PERCENTAGE);
            pieChart.setWidth(80, Unit.PERCENTAGE);
            System.out.println("PieChart Script : " + pieConfiguration.getHighChartValue());
            layout.addComponent(pieChart);
            layout.setComponentAlignment(pieChart, Alignment.MIDDLE_CENTER);
        } catch (HighChartsException e) {
            e.printStackTrace();
        }


        // *** LINE ***
        ChartConfiguration lineConfiguration = new ChartConfiguration();
        lineConfiguration.setTitle("TestLine");
        lineConfiguration.setChartType(ChartType.LINE);
        lineConfiguration.setBackgroundColor(Colors.WHITE);

        List<Object> bananaValues = new ArrayList<Object>();
        bananaValues.add(11.3);
        bananaValues.add(25.1);
        bananaValues.add(32.7);

        LineChartSeries bananaLine = new LineChartSeries("Bananas", bananaValues);

        List<Object> sweetValues = new ArrayList<Object>();
        sweetValues.add(33.65);
        sweetValues.add(63.24);
        sweetValues.add(21.52);

        LineChartSeries choclateLine = new LineChartSeries("Choclate", sweetValues);

        lineConfiguration.getSeriesList().add(bananaLine);
        lineConfiguration.getSeriesList().add(choclateLine);

        try {
            HighChart lineChart = HighChartFactory.renderChart(lineConfiguration);
            lineChart.setHeight(80, Unit.PERCENTAGE);
            lineChart.setWidth(80, Unit.PERCENTAGE);
            System.out.println("LineChart Script : " + lineConfiguration.getHighChartValue());
            layout.addComponent(lineChart);
            layout.setComponentAlignment(lineChart, Alignment.MIDDLE_CENTER);

        } catch (HighChartsException e) {
            e.printStackTrace();
        }
        setContent(layout);


        // *** BAR ***
        ChartConfiguration barConfiguration = new ChartConfiguration();
        barConfiguration.setTitle("TestBar");
        barConfiguration.setChartType(ChartType.BAR);
        barConfiguration.setBackgroundColor(Colors.WHITE);

        List<Object> bananaBarValues = new ArrayList<Object>();
        bananaBarValues.add(11.3);
        bananaBarValues.add(25.1);
        bananaBarValues.add(32.7);

        BarChartSeries bananaBar = new BarChartSeries("Bananas", bananaValues);

        List<Object> sweetBarValues = new ArrayList<Object>();
        sweetBarValues.add(33.65);
        sweetBarValues.add(63.24);
        sweetBarValues.add(21.52);

        BarChartSeries choclateBar = new BarChartSeries("Choclate", sweetValues);

        barConfiguration.getSeriesList().add(bananaBar);
        barConfiguration.getSeriesList().add(choclateBar);

        try {
            HighChart barChart = HighChartFactory.renderChart(barConfiguration);
            barChart.setHeight(80, Unit.PERCENTAGE);
            barChart.setWidth(80, Unit.PERCENTAGE);
            System.out.println("BarChart Script : " + barConfiguration.getHighChartValue());
            layout.addComponent(barChart);
            layout.setComponentAlignment(barChart, Alignment.MIDDLE_CENTER);

        } catch (HighChartsException e) {
            e.printStackTrace();
        }

        // *** COLUMN ***
        ChartConfiguration columnConfiguration = new ChartConfiguration();
        columnConfiguration.setTitle("TestColumn");
        columnConfiguration.setChartType(ChartType.COLUMN);
        columnConfiguration.setBackgroundColor(Colors.WHITE);

        List<Object> bananaColumnValues = new ArrayList<Object>();
        bananaColumnValues.add(11.3);
        bananaColumnValues.add(25.1);
        bananaColumnValues.add(32.7);

        ColumnChartSeries bananaColumn = new ColumnChartSeries("Bananas", bananaValues);

        List<Object> sweetColumnValues = new ArrayList<Object>();
        sweetColumnValues.add(33.65);
        sweetColumnValues.add(63.24);
        sweetColumnValues.add(21.52);

        ColumnChartSeries choclateColumn = new ColumnChartSeries("Choclate", sweetValues);

        columnConfiguration.getSeriesList().add(bananaColumn);
        columnConfiguration.getSeriesList().add(choclateColumn);

        try {
            HighChart columnChart = HighChartFactory.renderChart(columnConfiguration);
            columnChart.setHeight(80, Unit.PERCENTAGE);
            columnChart.setWidth(80, Unit.PERCENTAGE);
            System.out.println("ColumnChart Script : " + columnConfiguration.getHighChartValue());
            layout.addComponent(columnChart);
            layout.setComponentAlignment(columnChart, Alignment.MIDDLE_CENTER);

        } catch (HighChartsException e) {
            e.printStackTrace();
        }
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "DemoUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = DemoUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
