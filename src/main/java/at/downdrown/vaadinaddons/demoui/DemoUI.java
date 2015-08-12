package at.downdrown.vaadinaddons.demoui;

import at.downdrown.vaadinaddons.demoui.views.Views;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import javax.servlet.annotation.WebServlet;

@Theme("mytheme")
@Widgetset("at.downdrown.vaadinaddons.MyAppWidgetset")
public class DemoUI extends UI {

    private BaseNavigator navigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final VerticalLayout menuBar = new VerticalLayout();
        menuBar.setWidth(250, Unit.PIXELS);
        menuBar.setHeight(100, Unit.PERCENTAGE);
        final VerticalLayout viewScreen = new VerticalLayout();
        viewScreen.setSizeFull();
        final HorizontalLayout screeen = new HorizontalLayout(menuBar, viewScreen);

        screeen.setSizeFull();
        screeen.setExpandRatio(viewScreen, 0.8f);

        //Navigator instanziieren.
        navigator = new BaseNavigator(this, viewScreen);
        this.setNavigator(navigator);
        navigator.navigateTo(Views.DASHBOARD);

        final Panel navigation = new Panel("Vaadin HighCharts API Demo");
        navigation.setStyleName(ValoTheme.PANEL_BORDERLESS);
        navigation.setSizeFull();
        navigation.setIcon(new ThemeResource("resources/images/highcharts-api-icon-small.png"));

        Button pieChartExamples = new Button("Pie Chart");
        pieChartExamples.setStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        pieChartExamples.setWidth(100, Unit.PERCENTAGE);
        pieChartExamples.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                navigator.navigateTo(Views.PIECHARTEXAMPLES);
            }
        });

        Button lineChartExamples = new Button("Line Chart");
        lineChartExamples.setStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        lineChartExamples.setWidth(100, Unit.PERCENTAGE);
        lineChartExamples.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                navigator.navigateTo(Views.LINECHARTEXAMPLES);
            }
        });

        Button barChartExamples = new Button("Bar Chart");
        barChartExamples.setStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        barChartExamples.setWidth(100, Unit.PERCENTAGE);
        barChartExamples.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                navigator.navigateTo(Views.BARCHARTEXAMPLES);
            }
        });

        Button columnChartExamples = new Button("Column Chart");
        columnChartExamples.setStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        columnChartExamples.setWidth(100, Unit.PERCENTAGE);
        columnChartExamples.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                navigator.navigateTo(Views.COLUMNCHARTEXAMPLES);
            }
        });

        Button dashboardExample = new Button("Dashboard");
        dashboardExample.setStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        dashboardExample.setWidth(100, Unit.PERCENTAGE);
        dashboardExample.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                navigator.navigateTo(Views.DASHBOARD);
            }
        });

        VerticalLayout navigationContent = new VerticalLayout(pieChartExamples, lineChartExamples, barChartExamples, columnChartExamples, dashboardExample);
        navigation.setContent(navigationContent);

        menuBar.addComponent(navigation);

        //Make Content visible
        setContent(screeen);
    }

    @WebServlet(urlPatterns = "/*", name = "DemoUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = DemoUI.class, productionMode = true)
    public static class MyUIServlet extends VaadinServlet {
    }
}
