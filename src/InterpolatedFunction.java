import java.util.ArrayList;

public class InterpolatedFunction {
    private ArrayList<Double> arguments;
    private ArrayList<Double> results;
    public ArrayList<Double> getArguments() {
        return arguments;
    }
    public void setArguments(ArrayList<Double> arguments) {
        this.arguments = arguments;
    }
    public ArrayList<Double> getResults() {
        return results;
    }
    public void setResults(ArrayList<Double> results) {
        this.results = results;
    }
    private double x0;
    public double getX0() {
        return x0;
    }
    public void setX0(double x0) {
        this.x0 = x0;
    }

    private int size;
    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size = size;
    }
    InterpolatedFunction (ArrayList<Double> arguments, ArrayList<Double> results, double x){
        this.x0 = x;
        if(results.size() != arguments.size()){
            throw new RuntimeException("Error, arguments amount doesn't equal results amount");
        }
        this.size = results.size();
        this.arguments = arguments;
        this.results = results;
    }
}
