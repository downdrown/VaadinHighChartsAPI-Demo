package at.downdrown.vaadinaddons.demoui.views;

import at.downdrown.vaadinaddons.demoui.SourceCodeWindow;
import at.downdrown.vaadinaddons.highchartsapi.HighChart;
import at.downdrown.vaadinaddons.highchartsapi.HighChartFactory;
import at.downdrown.vaadinaddons.highchartsapi.exceptions.HighChartsException;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartConfiguration;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartType;
import at.downdrown.vaadinaddons.highchartsapi.model.data.HighChartsData;
import at.downdrown.vaadinaddons.highchartsapi.model.data.base.DoubleData;
import at.downdrown.vaadinaddons.highchartsapi.model.plotoptions.ColumnChartPlotOptions;
import at.downdrown.vaadinaddons.highchartsapi.model.series.ColumnChartSeries;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

public class ColumnChartExamples extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        this.setSizeFull();
        this.setStyleName("view");

        ChartConfiguration columnConfiguration = new ChartConfiguration();
        columnConfiguration.setTitle("Fruit vs Sweets sells");
        columnConfiguration.setChartType(ChartType.COLUMN);

        ColumnChartPlotOptions columnPlotOptions = new ColumnChartPlotOptions();
        columnConfiguration.setPlotOptions(columnPlotOptions);

        List<HighChartsData> bananaColumnValues = new ArrayList<>();
        bananaColumnValues.add(new DoubleData(11.3));
        bananaColumnValues.add(new DoubleData(25.1));
        bananaColumnValues.add(new DoubleData(32.7));

        ColumnChartSeries bananaColumn = new ColumnChartSeries("Bananas", bananaColumnValues);

        List<HighChartsData> sweetColumnValues = new ArrayList<>();
        sweetColumnValues.add(new DoubleData(33.65));
        sweetColumnValues.add(new DoubleData(63.24));
        sweetColumnValues.add(new DoubleData(21.52));

        ColumnChartSeries choclateColumn = new ColumnChartSeries("Choclate", sweetColumnValues);

        columnConfiguration.getSeriesList().add(bananaColumn);
        columnConfiguration.getSeriesList().add(choclateColumn);

        try {
            HighChart columnChart = HighChartFactory.renderChart(columnConfiguration);
            columnChart.setHeight(60, Unit.PERCENTAGE);
            columnChart.setWidth(90, Unit.PERCENTAGE);
            this.addComponent(columnChart);
            this.setComponentAlignment(columnChart, Alignment.MIDDLE_CENTER);
            this.setExpandRatio(columnChart, 1.0f);

        } catch (HighChartsException e) {
            e.printStackTrace();
        }

        Button viewSourceChoclate = new Button("View Source");
        viewSourceChoclate.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
            UI.getCurrent().addWindow(new SourceCodeWindow("ChartConfiguration columnConfiguration = new ChartConfiguration();\n" +
                "columnConfiguration.setTitle(\"Fruit vs Sweets sells\");\n" +
                "columnConfiguration.setChartType(ChartType.COLUMN);\n" +
                "\n" +
                "List<HighChartsData> bananaColumnValues = new ArrayList<>();\n" +
                "bananaColumnValues.add(new DoubleData(11.3));\n" +
                "bananaColumnValues.add(new DoubleData(25.1));\n" +
                "bananaColumnValues.add(new DoubleData(32.7));\n" +
                "\n" +
                "ColumnChartSeries bananaColumn = new ColumnChartSeries(\"Bananas\", bananaColumnValues);\n" +
                "\n" +
                "List<HighChartsData> sweetColumnValues = new ArrayList<>();\n" +
                "sweetColumnValues.add(new DoubleData(33.65));\n" +
                "sweetColumnValues.add(new DoubleData(63.24));\n" +
                "sweetColumnValues.add(new DoubleData(21.52));\n" +
                "\n" +
                "ColumnChartSeries choclateColumn = new ColumnChartSeries(\"Choclate\", sweetColumnValues);\n" +
                "\n" +
                "columnConfiguration.getSeriesList().add(bananaColumn);\n" +
                "columnConfiguration.getSeriesList().add(choclateColumn);\n" +
                "\n" +
                "try {\n" +
                "   HighChart columnChart = HighChartFactory.renderChart(columnConfiguration);\n" +
                "   columnChart.setHeight(60, Unit.PERCENTAGE);\n" +
                "   columnChart.setWidth(90, Unit.PERCENTAGE);\n" +
                "   this.addComponent(columnChart);\n" +
                "   this.setComponentAlignment(columnChart, Alignment.MIDDLE_CENTER);\n" +
                "\n" +
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
