public class Data {
    private final double[] vectorValues;

    private final String label;
    Data(double[] vectorValues, String label){
        this.vectorValues = vectorValues;
        this.label = label;
    }
    Data(double[] vectorValues){
        this.vectorValues = vectorValues;
        this.label = "{Uninitialized}";
    }
    public double[] getVectorValues(){
        return vectorValues;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(double e : vectorValues){
            sb.append(e);
            sb.append(",");
        }
        return sb.toString();
    }

    public String getLabel(){
        return label;
    }

}

