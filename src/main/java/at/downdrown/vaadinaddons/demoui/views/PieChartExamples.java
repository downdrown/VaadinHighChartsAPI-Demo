package at.downdrown.vaadinaddons.demoui.views;

import at.downdrown.vaadinaddons.demoui.SourceCodeWindow;
import at.downdrown.vaadinaddons.highchartsapi.HighChart;
import at.downdrown.vaadinaddons.highchartsapi.HighChartFactory;
import at.downdrown.vaadinaddons.highchartsapi.exceptions.HighChartsException;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartConfiguration;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartType;
import at.downdrown.vaadinaddons.highchartsapi.model.data.PieChartData;
import at.downdrown.vaadinaddons.highchartsapi.model.series.PieChartSeries;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class PieChartExamples extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        this.setSizeFull();
        this.setStyleName("view");

        ChartConfiguration pieConfiguration = new ChartConfiguration();
        pieConfiguration.setTitle("Fruits");
        pieConfiguration.setChartType(ChartType.PIE);

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
            pieChart.setHeight(60, Unit.PERCENTAGE);
            pieChart.setWidth(100, Unit.PERCENTAGE);
            this.addComponent(pieChart);
            this.setComponentAlignment(pieChart, Alignment.MIDDLE_CENTER);
            this.setExpandRatio(pieChart, 1.0f);
        } catch (HighChartsException e) {
            e.printStackTrace();
        }

        Button viewSourceFruits = new Button("View Source");
        viewSourceFruits.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
            UI.getCurrent().addWindow(new SourceCodeWindow("ChartConfiguration pieConfiguration = new ChartConfiguration();\n" +
                "pieConfiguration.setTitle(\"Fruits\");\n" +
                "pieConfiguration.setChartType(ChartType.PIE);\n" +
                "\n" +
                "PieChartSeries pieFruits = new PieChartSeries(\"Fruits\");\n" +
                "PieChartData bananas = new PieChartData(\"Bananas\", 33.2);\n" +
                "PieChartData melons = new PieChartData(\"Melons\", 6.21);\n" +
                "PieChartData apples = new PieChartData(\"Apples\", 3.44);\n" +
                "\n" +
                "pieFruits.getData().add(bananas);\n" +
                "pieFruits.getData().add(melons);\n" +
                "pieFruits.getData().add(apples);\n" +
                "\n" +
                "pieConfiguration.getSeriesList().add(pieFruits);\n" +
                "\n" +
                "try {\n" +
                "   HighChart pieChart = HighChartFactory.renderChart(pieConfiguration);\n" +
                "   pieChart.setHeight(40, Unit.PERCENTAGE);\n" +
                "   pieChart.setWidth(100, Unit.PERCENTAGE);\n" +
                "   this.addComponent(pieChart);\n" +
                "   this.setComponentAlignment(pieChart, Alignment.TOP_CENTER);\n" +
                "} catch (HighChartsException e) {\n" +
                "   e.printStackTrace();\n" +
                "}"));
            }
        });

        viewSourceFruits.setStyleName(ValoTheme.BUTTON_TINY);
        viewSourceFruits.addStyleName(ValoTheme.BUTTON_BORDERLESS);

        this.addComponent(viewSourceFruits);
        this.setExpandRatio(viewSourceFruits, 0);
    }
}
