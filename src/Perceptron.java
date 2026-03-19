import java.util.List;
import java.util.Random;
public class Perceptron {
    double threshold;
    double[] weights;
    double learningRate;
    Perceptron(int inputSize, double learningRate){
        this.learningRate = learningRate;
        Random rand = new Random();
        this.weights = new double[inputSize];
        for (int i = 0; i < weights.length; i++) {
            this.weights[i] = rand.nextDouble();
        }
        this.threshold = rand.nextDouble();
    }
    public int predict(double[] inVector){
        double output =- threshold;
        for(int i=0; i< weights.length;i++)
           output += weights[i] *inVector[i];
        return output >=0  ? 1: 0;
    }
    public void learnFromData(List<Data> learningList, int epokes){
        for(int i =0; i<epokes;i++){
            System.out.println("Epoke: "+ i);
            for(Data learningData : learningList){
                int expectedVal = learningData.getLabel().equals("Iris-setosa") ? 1: 0;
                this.learn(learningData.getVectorValues(),expectedVal);
            }
        }
    }
    private void  learn(double[] vectorToLearnFrom,int target) {
        int predictedInt = this.predict(vectorToLearnFrom);
        int error = target - predictedInt;
        if(error!=0){
            for(int j = 0; j <weights.length; j++){
                System.out.println("weight changed");
                weights[j] += error * learningRate * vectorToLearnFrom[j];
            }
            threshold -= error * learningRate;
        }
    }
}
