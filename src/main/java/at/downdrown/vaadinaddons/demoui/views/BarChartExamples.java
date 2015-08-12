package at.downdrown.vaadinaddons.demoui.views;

import at.downdrown.vaadinaddons.demoui.SourceCodeWindow;
import at.downdrown.vaadinaddons.highchartsapi.HighChart;
import at.downdrown.vaadinaddons.highchartsapi.HighChartFactory;
import at.downdrown.vaadinaddons.highchartsapi.exceptions.HighChartsException;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartConfiguration;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartType;
import at.downdrown.vaadinaddons.highchartsapi.model.series.BarChartSeries;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

public class BarChartExamples extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        this.setSizeFull();
        this.setStyleName("view");

        ChartConfiguration barConfiguration = new ChartConfiguration();
        barConfiguration.setTitle("Fruit vs Sweets sells");
        barConfiguration.setChartType(ChartType.BAR);

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
            barChart.setHeight(60, Unit.PERCENTAGE);
            barChart.setWidth(90, Unit.PERCENTAGE);
            this.addComponent(barChart);
            this.setComponentAlignment(barChart, Alignment.MIDDLE_CENTER);
            this.setExpandRatio(barChart, 1.0f);
        } catch (HighChartsException e) {
            e.printStackTrace();
        }
        
        Button viewSourceChoclate = new Button("View Source");
        viewSourceChoclate.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
            UI.getCurrent().addWindow(new SourceCodeWindow("ChartConfiguration barConfiguration = new ChartConfiguration();\n" +
                "barConfiguration.setTitle(\"Fruit vs Sweets sells\");\n" +
                "barConfiguration.setChartType(ChartType.BAR);\n" +
                "\n" +
                "List<Object> bananaBarValues = new ArrayList<Object>();\n" +
                "bananaBarValues.add(11.3);\n" +
                "bananaBarValues.add(25.1);\n" +
                "bananaBarValues.add(32.7);\n" +
                "\n" +
                "BarChartSeries bananaBar = new BarChartSeries(\"Bananas\", bananaBarValues);\n" +
                "\n" +
                "List<Object> sweetBarValues = new ArrayList<Object>();\n" +
                "sweetBarValues.add(33.65);\n" +
                "sweetBarValues.add(63.24);\n" +
                "sweetBarValues.add(21.52);\n" +
                "\n" +
                "BarChartSeries choclateBar = new BarChartSeries(\"Choclate\", sweetBarValues);\n" +
                "\n" +
                "barConfiguration.getSeriesList().add(bananaBar);\n" +
                "barConfiguration.getSeriesList().add(choclateBar);\n" +
                "\n" +
                "try {\n" +
                "   HighChart barChart = HighChartFactory.renderChart(barConfiguration);\n" +
                "   barChart.setHeight(60, Unit.PERCENTAGE);\n" +
                "   barChart.setWidth(90, Unit.PERCENTAGE);\n" +
                "   this.addComponent(barChart);\n" +
                "   this.setComponentAlignment(barChart, Alignment.MIDDLE_CENTER);\n" +
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
