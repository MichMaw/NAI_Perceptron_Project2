import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world");
        List<Data> trainingData = loadDataSet("iris.data");
        Perceptron perceptron = new Perceptron(4,0.2);
        perceptron.learnFromData(trainingData,100);
    }


    public static List<Data> loadDataSet(String filename) throws Exception {
        List<Data> dataSet = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                dataSet.add(convertStringToData(line));
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("ERROR: couldn't load file " + filename + " make sure its in correct directory");
        }
        System.out.println("file Successfully added");
        return dataSet;

    }


    public static Data convertStringToData(String line) {
        String[] parts = line.split(",");


        String label = parts[parts.length - 1];
        double[] values = new double[parts.length - 1];

        for (int i = 0; i < parts.length - 1; i++) {
            values[i] = Double.parseDouble(parts[i]);
        }
        return new Data(values, label);
    }


    public static Data convertStringWithoutLableToData(String line){
        String[] parts = line.split(",");
        double[] values = new double[parts.length];
        for (int i= 0; i < parts.length; i++){
            values[i] = Double.parseDouble(parts[i]);
        }
        return new Data(values);
    }


}