package at.downdrown.vaadinaddons.demoui.views;

public enum Views {

    DASHBOARD(Dashboard.class),
    PIECHARTEXAMPLES(PieChartExamples.class),
    LINECHARTEXAMPLES(LineChartExamples.class),
    BARCHARTEXAMPLES(BarChartExamples.class),
    COLUMNCHARTEXAMPLES(ColumnChartExamples.class);

    private final Class view;

    Views(Class view) {
        this.view = view;
    }

    public Class getView() {
        return this.view;
    }

    public String getBezeichnung() {
        return this.view.getSimpleName();
    }
}
