package ga222gb_assign1.XChart;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;

public class SinMain {
    public static void main(String[] args) {
        XYChart chart = new XYChartBuilder().width(800).height(600).build();
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(5);

        List xData = new ArrayList();
        List yData = new ArrayList();

        for(double x = 0; x <= 2*Math.PI; x+=0.001){
            yData.add((1 + x/Math.PI)*Math.cos(x)*Math.cos(40*x));
            xData.add(x);
        }

        chart.addSeries("SinMain", xData, yData);
        new SwingWrapper<>(chart).displayChart();
    }
}
