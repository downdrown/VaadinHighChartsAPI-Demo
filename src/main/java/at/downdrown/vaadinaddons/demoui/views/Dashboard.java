package at.downdrown.vaadinaddons.demoui.views;

import at.downdrown.vaadinaddons.demoui.SourceCodeWindow;
import at.downdrown.vaadinaddons.highchartsapi.Colors;
import at.downdrown.vaadinaddons.highchartsapi.HighChart;
import at.downdrown.vaadinaddons.highchartsapi.HighChartFactory;
import at.downdrown.vaadinaddons.highchartsapi.exceptions.HighChartsException;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartConfiguration;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartType;
import at.downdrown.vaadinaddons.highchartsapi.model.Margin;
import at.downdrown.vaadinaddons.highchartsapi.model.data.PieChartData;
import at.downdrown.vaadinaddons.highchartsapi.model.plotoptions.BarChartPlotOptions;
import at.downdrown.vaadinaddons.highchartsapi.model.plotoptions.ColumnChartPlotOptions;
import at.downdrown.vaadinaddons.highchartsapi.model.plotoptions.LineChartPlotOptions;
import at.downdrown.vaadinaddons.highchartsapi.model.plotoptions.PieChartPlotOptions;
import at.downdrown.vaadinaddons.highchartsapi.model.series.BarChartSeries;
import at.downdrown.vaadinaddons.highchartsapi.model.series.ColumnChartSeries;
import at.downdrown.vaadinaddons.highchartsapi.model.series.LineChartSeries;
import at.downdrown.vaadinaddons.highchartsapi.model.series.PieChartSeries;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends VerticalLayout implements View {

    private HorizontalLayout upperDash;
    private HorizontalLayout lowerDash;
    private Panel pieChartPanel;
    private Panel lineChartPanel;
    private Panel barChartPanel;
    private Panel columnChartPanel;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        this.setSizeFull();
        this.setStyleName("view");

        upperDash = new HorizontalLayout();
        upperDash.setSizeFull();

        pieChartPanel = createDashboardPanel("Fruits Salary");
        upperDash.addComponent(pieChartPanel);
        upperDash.setComponentAlignment(pieChartPanel, Alignment.MIDDLE_CENTER);
        upperDash.setExpandRatio(pieChartPanel, 0.5f);

        lineChartPanel = createDashboardPanel("Juice Salary");
        upperDash.addComponent(lineChartPanel);
        upperDash.setComponentAlignment(lineChartPanel, Alignment.MIDDLE_CENTER);
        upperDash.setExpandRatio(lineChartPanel, 0.5f);

        lowerDash = new HorizontalLayout();
        lowerDash.setSizeFull();

        barChartPanel = createDashboardPanel("Customer Amount");
        lowerDash.addComponent(barChartPanel);
        lowerDash.setComponentAlignment(barChartPanel, Alignment.MIDDLE_CENTER);
        lowerDash.setExpandRatio(barChartPanel, 0.5f);

        columnChartPanel = createDashboardPanel("Salary by Season");
        lowerDash.addComponent(columnChartPanel);
        lowerDash.setComponentAlignment(columnChartPanel, Alignment.MIDDLE_CENTER);
        lowerDash.setExpandRatio(columnChartPanel, 0.5f);


        //PieChart
        ChartConfiguration pieConfiguration = new ChartConfiguration();
        pieConfiguration.setChartType(ChartType.PIE);
        pieConfiguration.setChartMargin(new Margin(50, 20, 150, 60));

        PieChartPlotOptions pieChartPlotOptions = new PieChartPlotOptions();
        pieChartPlotOptions.setDataLabelsFontColor(Colors.LIGHTGRAY);

        pieConfiguration.setPlotOptions(pieChartPlotOptions);

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
            pieChart.setSizeFull();
            pieChartPanel.setContent(pieChart);
        } catch (HighChartsException e) {
            e.printStackTrace();
        }

        //Line Chart
        ChartConfiguration lineConfiguration = new ChartConfiguration();
        lineConfiguration.getxAxis().setLabelsEnabled(false);
        lineConfiguration.getyAxis().setLabelsEnabled(false);
        lineConfiguration.removeBackgroundLines();
        lineConfiguration.setChartType(ChartType.LINE);
        lineConfiguration.setChartMargin(new Margin(50, 20, 170, 20));
        lineConfiguration.setLegendEnabled(false);

        LineChartPlotOptions lineChartPlotOptions = new LineChartPlotOptions();
        lineChartPlotOptions.setDataLabelsFontColor(Colors.LIGHTGRAY);

        lineConfiguration.setPlotOptions(lineChartPlotOptions);

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
            lineChart.setSizeFull();
            lineChartPanel.setContent(lineChart);
        } catch (HighChartsException e) {
            e.printStackTrace();
        }

        //Bar Chart
        ChartConfiguration barConfiguration = new ChartConfiguration();
        barConfiguration.getxAxis().setLabelsEnabled(false);
        barConfiguration.getyAxis().setLabelsEnabled(false);
        barConfiguration.removeBackgroundLines();
        barConfiguration.setChartType(ChartType.BAR);
        barConfiguration.setChartMargin(new Margin(50, 20, 160, 60));

        BarChartPlotOptions barChartPlotOptions = new BarChartPlotOptions();
        barChartPlotOptions.setDataLabelsFontColor(Colors.LIGHTGRAY);

        barConfiguration.setPlotOptions(barChartPlotOptions);

        List<Object> bananaBarValues = new ArrayList<Object>();
        bananaBarValues.add(11.3);
        bananaBarValues.add(25.1);
        bananaBarValues.add(32.7);

        BarChartSeries bananaBar = new BarChartSeries("Bananas", bananaBarValues);

        List<Object> sweetBarValues = new ArrayList<Object>();
        sweetBarValues.add(33.65);
        sweetBarValues.add(63.24);
        sweetBarValues.add(21.52);

        BarChartSeries choclateBar = new BarChartSeries("Choclate", sweetBarValues);

        barConfiguration.getSeriesList().add(bananaBar);
        barConfiguration.getSeriesList().add(choclateBar);

        try {
            HighChart barChart = HighChartFactory.renderChart(barConfiguration);
            barChart.setSizeFull();
            barChartPanel.setContent(barChart);
        } catch (HighChartsException e) {
            e.printStackTrace();
        }

        //Column Chart
        ChartConfiguration columnConfiguration = new ChartConfiguration();
        columnConfiguration.getxAxis().setLabelsEnabled(false);
        columnConfiguration.getyAxis().setLabelsEnabled(false);
        columnConfiguration.removeBackgroundLines();
        columnConfiguration.setChartType(ChartType.COLUMN);
        columnConfiguration.setChartMargin(new Margin(10, 30, 140, 70));

        ColumnChartPlotOptions columnChartPlotOptions = new ColumnChartPlotOptions();
        columnChartPlotOptions.setDataLabelsFontColor(Colors.LIGHTGRAY);

        columnConfiguration.setPlotOptions(columnChartPlotOptions);

        List<Object> bananaColumnValues = new ArrayList<Object>();
        bananaColumnValues.add(11.3);
        bananaColumnValues.add(15.1);
        bananaColumnValues.add(25.1);
        bananaColumnValues.add(32.7);

        ColumnChartSeries bananaColumn = new ColumnChartSeries("Bananas", bananaColumnValues);

        List<Object> sweetColumnValues = new ArrayList<Object>();
        sweetColumnValues.add(33.65);
        sweetColumnValues.add(63.24);
        sweetColumnValues.add(21.52);
        sweetColumnValues.add(11.22);

        ColumnChartSeries choclateColumn = new ColumnChartSeries("Choclate", sweetColumnValues);

        columnConfiguration.getSeriesList().add(bananaColumn);
        columnConfiguration.getSeriesList().add(choclateColumn);

        try {
            HighChart columnChart = HighChartFactory.renderChart(columnConfiguration);
            columnChart.setSizeFull();
            columnChartPanel.setContent(columnChart);
        } catch (HighChartsException e) {
            e.printStackTrace();
        }

        this.addComponent(upperDash);
        this.setExpandRatio(upperDash, 0.5f);
        this.addComponent(lowerDash);
        this.setExpandRatio(lowerDash, 0.5f);

        Button viewSource = new Button("View Source");
        viewSource.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
            UI.getCurrent().addWindow(new SourceCodeWindow("@Override\n" +
                "public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {\n" +
                "   this.setSizeFull();\n" +
                "\n" +
                "   upperDash = new HorizontalLayout();\n" +
                "   upperDash.setSizeFull();\n" +
                "\n" +
                "   pieChartPanel = createDashboardPanel(\"Fruits Salary\");\n" +
                "   upperDash.addComponent(pieChartPanel);\n" +
                "   upperDash.setComponentAlignment(pieChartPanel, Alignment.MIDDLE_CENTER);\n" +
                "   upperDash.setExpandRatio(pieChartPanel, 0.5f);\n" +
                "\n" +
                "   lineChartPanel = createDashboardPanel(\"Juice Salary\");\n" +
                "   upperDash.addComponent(lineChartPanel);\n" +
                "   upperDash.setComponentAlignment(lineChartPanel, Alignment.MIDDLE_CENTER);\n" +
                "   upperDash.setExpandRatio(lineChartPanel, 0.5f);\n" +
                "\n" +
                "   lowerDash = new HorizontalLayout();\n" +
                "   lowerDash.setSizeFull();\n" +
                "\n" +
                "   barChartPanel = createDashboardPanel(\"Customer Amount\");\n" +
                "   lowerDash.addComponent(barChartPanel);\n" +
                "   lowerDash.setComponentAlignment(barChartPanel, Alignment.MIDDLE_CENTER);\n" +
                "   lowerDash.setExpandRatio(barChartPanel, 0.5f);\n" +
                "\n" +
                "   columnChartPanel = createDashboardPanel(\"Salary by Season\");\n" +
                "   lowerDash.addComponent(columnChartPanel);\n" +
                "   lowerDash.setComponentAlignment(columnChartPanel, Alignment.MIDDLE_CENTER);\n" +
                "   lowerDash.setExpandRatio(columnChartPanel, 0.5f);\n" +
                "\n" +
                "\n" +
                "   //PieChart\n" +
                "   ChartConfiguration pieConfiguration = new ChartConfiguration();\n" +
                "   pieConfiguration.setChartType(ChartType.PIE);\n" +
                "   pieConfiguration.setChartMargin(new Margin(50, 20, 150, 60));\n" +
                "\n" +
                "   PieChartPlotOptions pieChartPlotOptions = new PieChartPlotOptions();\n" +
                "   pieChartPlotOptions.setDataLabelsFontColor(Colors.LIGHTGRAY);\n" +
                "\n" +
                "   pieConfiguration.setPlotOptions(pieChartPlotOptions);\n" +
                "\n" +
                "   PieChartSeries pieFruits = new PieChartSeries(\"Fruits\");\n" +
                "   PieChartData bananas = new PieChartData(\"Bananas\", 33.2);\n" +
                "   PieChartData melons = new PieChartData(\"Melons\", 6.21);\n" +
                "   PieChartData apples = new PieChartData(\"Apples\", 3.44);\n" +
                "\n" +
                "   pieFruits.getData().add(bananas);\n" +
                "   pieFruits.getData().add(melons);\n" +
                "   pieFruits.getData().add(apples);\n" +
                "\n" +
                "   pieConfiguration.getSeriesList().add(pieFruits);\n" +
                "\n" +
                "   try {\n" +
                "     HighChart pieChart = HighChartFactory.renderChart(pieConfiguration);\n" +
                "     pieChart.setSizeFull();\n" +
                "     pieChartPanel.setContent(pieChart);\n" +
                "   } catch (HighChartsException e) {\n" +
                "      e.printStackTrace();\n" +
                "   }\n" +
                "\n" +
                "   //Line Chart\n" +
                "   ChartConfiguration lineConfiguration = new ChartConfiguration();\n" +
                "   lineConfiguration.getxAxis().setLabelsEnabled(false);\n" +
                "   lineConfiguration.getyAxis().setLabelsEnabled(false);\n" +
                "   lineConfiguration.removeBackgroundLines();\n" +
                "   lineConfiguration.setChartType(ChartType.LINE);\n" +
                "   lineConfiguration.setChartMargin(new Margin(50, 20, 170, 20));\n" +
                "   lineConfiguration.setLegendEnabled(false);\n" +
                "\n" +
                "   LineChartPlotOptions lineChartPlotOptions = new LineChartPlotOptions();\n" +
                "   lineChartPlotOptions.setDataLabelsFontColor(Colors.LIGHTGRAY);\n" +
                "\n" +
                "   lineConfiguration.setPlotOptions(lineChartPlotOptions);\n" +
                "\n" +
                "   List<Object> bananaValues = new ArrayList<Object>();\n" +
                "   bananaValues.add(11.3);\n" +
                "   bananaValues.add(25.1);\n" +
                "   bananaValues.add(32.7);\n" +
                "\n" +
                "   LineChartSeries bananaLine = new LineChartSeries(\"Bananas\", bananaValues);\n" +
                "\n" +
                "   List<Object> sweetValues = new ArrayList<Object>();\n" +
                "   sweetValues.add(33.65);\n" +
                "   sweetValues.add(63.24);\n" +
                "   sweetValues.add(21.52);\n" +
                "\n" +
                "   LineChartSeries choclateLine = new LineChartSeries(\"Choclate\", sweetValues);\n" +
                "\n" +
                "   lineConfiguration.getSeriesList().add(bananaLine);\n" +
                "   lineConfiguration.getSeriesList().add(choclateLine);\n" +
                "\n" +
                "   try {\n" +
                "      HighChart lineChart = HighChartFactory.renderChart(lineConfiguration);\n" +
                "     lineChart.setSizeFull();\n" +
                "     lineChartPanel.setContent(lineChart);\n" +
                "   } catch (HighChartsException e) {\n" +
                "     e.printStackTrace();\n" +
                "   }\n" +
                "\n" +
                "   //Bar Chart\n" +
                "   ChartConfiguration barConfiguration = new ChartConfiguration();\n" +
                "   barConfiguration.getxAxis().setLabelsEnabled(false);\n" +
                "   barConfiguration.getyAxis().setLabelsEnabled(false);\n" +
                "   barConfiguration.removeBackgroundLines();\n" +
                "   barConfiguration.setChartType(ChartType.BAR);\n" +
                "   barConfiguration.setChartMargin(new Margin(50, 20, 160, 60));\n" +
                "\n" +
                "   BarChartPlotOptions barChartPlotOptions = new BarChartPlotOptions();\n" +
                "   barChartPlotOptions.setDataLabelsFontColor(Colors.LIGHTGRAY);\n" +
                "\n" +
                "   barConfiguration.setPlotOptions(barChartPlotOptions);\n" +
                "\n" +
                "   List<Object> bananaBarValues = new ArrayList<Object>();\n" +
                "   bananaBarValues.add(11.3);\n" +
                "   bananaBarValues.add(25.1);\n" +
                "   bananaBarValues.add(32.7);\n" +
                "\n" +
                "   BarChartSeries bananaBar = new BarChartSeries(\"Bananas\", bananaBarValues);\n" +
                "\n" +
                "   List<Object> sweetBarValues = new ArrayList<Object>();\n" +
                "   sweetBarValues.add(33.65);\n" +
                "   sweetBarValues.add(63.24);\n" +
                "   sweetBarValues.add(21.52);\n" +
                "\n" +
                "   BarChartSeries choclateBar = new BarChartSeries(\"Choclate\", sweetBarValues);\n" +
                "\n" +
                "   barConfiguration.getSeriesList().add(bananaBar);\n" +
                "   barConfiguration.getSeriesList().add(choclateBar);\n" +
                "\n" +
                "   try {\n" +
                "     HighChart barChart = HighChartFactory.renderChart(barConfiguration);\n" +
                "     barChart.setSizeFull();\n" +
                "     barChartPanel.setContent(barChart);\n" +
                "   } catch (HighChartsException e) {\n" +
                "      e.printStackTrace();\n" +
                "   }\n" +
                "\n" +
                "   //Column Chart\n" +
                "   ChartConfiguration columnConfiguration = new ChartConfiguration();\n" +
                "   columnConfiguration.getxAxis().setLabelsEnabled(false);\n" +
                "   columnConfiguration.getyAxis().setLabelsEnabled(false);\n" +
                "   columnConfiguration.removeBackgroundLines();\n" +
                "   columnConfiguration.setChartType(ChartType.COLUMN);\n" +
                "   columnConfiguration.setChartMargin(new Margin(10, 30, 140, 70));\n" +
                "\n" +
                "   ColumnChartPlotOptions columnChartPlotOptions = new ColumnChartPlotOptions();\n" +
                "   columnChartPlotOptions.setDataLabelsFontColor(Colors.LIGHTGRAY);\n" +
                "\n" +
                "   columnConfiguration.setPlotOptions(columnChartPlotOptions);\n" +
                "\n" +
                "   List<Object> bananaColumnValues = new ArrayList<Object>();\n" +
                "   bananaColumnValues.add(11.3);\n" +
                "   bananaColumnValues.add(15.1);\n" +
                "   bananaColumnValues.add(25.1);\n" +
                "   bananaColumnValues.add(32.7);\n" +
                "\n" +
                "   ColumnChartSeries bananaColumn = new ColumnChartSeries(\"Bananas\", bananaColumnValues);\n" +
                "\n" +
                "   List<Object> sweetColumnValues = new ArrayList<Object>();\n" +
                "   sweetColumnValues.add(33.65);\n" +
                "   sweetColumnValues.add(63.24);\n" +
                "   sweetColumnValues.add(21.52);\n" +
                "   sweetColumnValues.add(11.22);\n" +
                "\n" +
                "   ColumnChartSeries choclateColumn = new ColumnChartSeries(\"Choclate\", sweetColumnValues);\n" +
                "\n" +
                "   columnConfiguration.getSeriesList().add(bananaColumn);\n" +
                "   columnConfiguration.getSeriesList().add(choclateColumn);\n" +
                "\n" +
                "   try {\n" +
                "     HighChart columnChart = HighChartFactory.renderChart(columnConfiguration);\n" +
                "     columnChart.setSizeFull();\n" +
                "    columnChartPanel.setContent(columnChart);\n" +
                "   } catch (HighChartsException e) {\n" +
                "    e.printStackTrace();\n" +
                "   }\n" +
                "\n" +
                "   this.addComponent(upperDash);\n" +
                "   this.setExpandRatio(upperDash, 0.5f);\n" +
                "   this.addComponent(lowerDash);\n" +
                "   this.setExpandRatio(lowerDash, 0.5f);" +
                "}"));
            }
        });

        viewSource.setStyleName(ValoTheme.BUTTON_TINY);
        viewSource.addStyleName(ValoTheme.BUTTON_BORDERLESS);

        this.addComponent(viewSource);
        this.setExpandRatio(viewSource, 0);
    }

    private Panel createDashboardPanel(String caption) {
        Panel tmp = new Panel(caption);
        tmp.setCaptionAsHtml(true);
        tmp.setHeight(95, Unit.PERCENTAGE);
        tmp.setWidth(97, Unit.PERCENTAGE);
        return tmp;
    }
}
