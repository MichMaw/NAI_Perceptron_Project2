public class Perceptron {
    double threshold;
    double[] weights;
    double learningRate;
    Perceptron(){

    }
    public int predict(double[] inVector){
        double output =- threshold;
        for(int i=0; i< weights.length;i++)
           output += weights[i] *inVector[i];
        return output >=0  ? 1: 0;
    }
    public void  learn(double[] vectorToLearnFrom,int target) {
        int predictedInt = this.predict(vectorToLearnFrom);
        int error = target - predictedInt;
        if(error!=0){
            for(int j = 0; j <weights.length; j++){
                weights[j] += error * learningRate * vectorToLearnFrom[j];
            }
        }
    }
}
