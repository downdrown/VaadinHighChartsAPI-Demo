package at.downdrown.vaadinaddons.demoui.views;

import at.downdrown.vaadinaddons.demoui.SourceCodeWindow;
import at.downdrown.vaadinaddons.highchartsapi.HighChart;
import at.downdrown.vaadinaddons.highchartsapi.HighChartFactory;
import at.downdrown.vaadinaddons.highchartsapi.exceptions.HighChartsException;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartConfiguration;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartType;
import at.downdrown.vaadinaddons.highchartsapi.model.data.HighChartsData;
import at.downdrown.vaadinaddons.highchartsapi.model.data.base.DoubleData;
import at.downdrown.vaadinaddons.highchartsapi.model.series.LineChartSeries;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

public class LineChartExamples extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        this.setSizeFull();
        this.setStyleName("view");

        ChartConfiguration lineConfiguration = new ChartConfiguration();
        lineConfiguration.setTitle("Fruit vs Sweets sells");
        lineConfiguration.setChartType(ChartType.LINE);

        List<HighChartsData> bananaValues = new ArrayList<>();
        bananaValues.add(new DoubleData(11.3));
        bananaValues.add(new DoubleData(25.1));
        bananaValues.add(new DoubleData(32.7));

        LineChartSeries bananaLine = new LineChartSeries("Bananas", bananaValues);

        List<HighChartsData> sweetValues = new ArrayList<>();
        sweetValues.add(new DoubleData(33.65));
        sweetValues.add(new DoubleData(63.24));
        sweetValues.add(new DoubleData(21.52));

        LineChartSeries choclateLine = new LineChartSeries("Choclate", sweetValues);

        lineConfiguration.getSeriesList().add(bananaLine);
        lineConfiguration.getSeriesList().add(choclateLine);

        try {
            HighChart lineChart = HighChartFactory.renderChart(lineConfiguration);
            lineChart.setHeight(60, Unit.PERCENTAGE);
            lineChart.setWidth(90, Unit.PERCENTAGE);
            this.addComponent(lineChart);
            this.setComponentAlignment(lineChart, Alignment.MIDDLE_CENTER);
            this.setExpandRatio(lineChart, 1.0f);
        } catch (HighChartsException e) {
            e.printStackTrace();
        }
        
        Button viewSourceChoclate = new Button("View Source");
        viewSourceChoclate.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
            UI.getCurrent().addWindow(new SourceCodeWindow("ChartConfiguration lineConfiguration = new ChartConfiguration();\n" +
                "lineConfiguration.setTitle(\"Fruit vs Sweets sells\");\n" +
                "lineConfiguration.setChartType(ChartType.LINE);\n" +
                "\n" +
                "List<Object> bananaValues = new ArrayList<Object>();\n" +
                "bananaValues.add(11.3);\n" +
                "bananaValues.add(25.1);\n" +
                "bananaValues.add(32.7);\n" +
                "\n" +
                "LineChartSeries bananaLine = new LineChartSeries(\"Bananas\", bananaValues);\n" +
                "\n" +
                "List<Object> sweetValues = new ArrayList<Object>();\n" +
                "sweetValues.add(33.65);\n" +
                "sweetValues.add(63.24);\n" +
                "sweetValues.add(21.52);\n" +
                "\n" +
                "LineChartSeries choclateLine = new LineChartSeries(\"Choclate\", sweetValues);\n" +
                "\n" +
                "lineConfiguration.getSeriesList().add(bananaLine);\n" +
                "lineConfiguration.getSeriesList().add(choclateLine);\n" +
                "\n" +
                "try {\n" +
                "   HighChart lineChart = HighChartFactory.renderChart(lineConfiguration);\n" +
                "   lineChart.setHeight(60, Unit.PERCENTAGE);\n" +
                "   lineChart.setWidth(90, Unit.PERCENTAGE);\n" +
                "   this.addComponent(lineChart);\n" +
                "   this.setComponentAlignment(lineChart, Alignment.MIDDLE_CENTER);\n" +
                "} catch (HighChartsException e) {\n" +
                "   e.printStackTrace();\n" +
                "}"));
            }
        });

        viewSourceChoclate.setStyleName(ValoTheme.BUTTON_TINY);
        viewSourceChoclate.addStyleName(ValoTheme.BUTTON_BORDERLESS);

        this.addComponent(viewSourceChoclate);
        this.setExpandRatio(viewSourceChoclate, 0);
    }
}
