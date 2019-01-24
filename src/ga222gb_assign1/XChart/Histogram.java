package ga222gb_assign1.XChart;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Histogram{

    public static void main(String[] args) throws IOException{
        try{
            ArrayList<Integer> numberList = readFile("C:\\Users\\guust\\Desktop\\heltal.dat");
            System.out.println("Antal i intervallet [1,100]: " + getAmount(numberList));
            System.out.println("Övriga: " + (numberList.size() - getAmount(numberList)));
            int[] arr = getHistogram(numberList);

            Histogram chart = new Histogram();
            CategoryChart barChart = chart.getBarChart(arr);
            new SwingWrapper<>(barChart).displayChart();

            PieChart pieChart = chart.getPieChart(arr);
            new SwingWrapper<>(pieChart).displayChart();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static ArrayList<Integer> readFile(String path) throws IOException{
        ArrayList<Integer> numbers = new ArrayList<>();
        File file = new File(path);
        Scanner scanFile = new Scanner(file);
        while(scanFile.hasNext()){
            int value = Integer.parseInt(scanFile.next());
            numbers.add(value);
        }
        scanFile.close();
        return numbers;
    }

    private static int getAmount(ArrayList<Integer> numberList) {
        int intervalAmount = 0;
        for (int i : numberList) {
            if (i >= 1 && i <= 100) {
                intervalAmount++;
            }
        }
        return intervalAmount;
    }

    private static int[] getHistogram(ArrayList<Integer> numberList){
        int[] array = new int[10];
        for(int i : numberList){
            if(i >= 1 && i <= 10){
                array[0] = array[0] + 1;
            }else if(i >= 11 && i <= 20){
                array[1] = array[1] + 1;
            }else if(i >= 21 && i <= 30){
                array[2] = array[2] + 1;
            }else if(i >= 31 && i <= 40){
                array[3] = array[3] + 1;
            }else if(i >= 41 && i <= 50){
                array[4] = array[4] + 1;
            }else if(i >= 51 && i <= 60){
                array[5] = array[5] + 1;
            }else if(i >= 61 && i <= 70){
                array[6] = array[6] + 1;
            }else if(i >= 71 && i <= 80){
                array[7] = array[7] + 1;
            }else if(i >= 81 && i <= 90){
                array[8] = array[8] + 1;
            }else if(i >= 91 && i <= 100){
                array[9] = array[9] + 1;
            }
        }
        return array;
    }

    public CategoryChart getBarChart(int[] arr) {
        CategoryChart chart = new CategoryChartBuilder().width(1000).height(600).title("Number Histogram").xAxisTitle("Interval").yAxisTitle("Amount").build();
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.addSeries("Bar chart", new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
        return chart;
    }

    public PieChart getPieChart(int[] arr){
        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();
        Color[] sliceColors = new Color[] {
                new Color(224, 28, 32),
                new Color(79, 230, 29),
                new Color(236, 224, 16),
                new Color(19, 16, 243),
                new Color(246, 113, 10),
                new Color(100, 0,0),
                new Color(80, 10, 100),
                new Color(5, 99, 97),
                new Color(70, 70, 70),
                new Color(150, 50, 134)
            };

        chart.getStyler().setSeriesColors(sliceColors);
        chart.addSeries("1-10", arr[0]);
        chart.addSeries("11-20", arr[1]);
        chart.addSeries("21-30", arr[2]);
        chart.addSeries("31-40", arr[3]);
        chart.addSeries("41-50", arr[4]);
        chart.addSeries("51-60", arr[5]);
        chart.addSeries("61-70", arr[6]);
        chart.addSeries("71-80", arr[7]);
        chart.addSeries("81-90", arr[8]);
        chart.addSeries("91-100", arr[9]);

        return chart;
    }
}