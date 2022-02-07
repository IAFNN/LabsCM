import java.util.ArrayList;
import java.util.Collections;

public class SmallestSquaresMethod {
    private InterpolatedFunction function;
    private int power;
    SmallestSquaresMethod(InterpolatedFunction function, int power){
        this.function = function;
        this.power = power;
    }

    public void setFunction(InterpolatedFunction function) {
        this.function = function;
    }

    public InterpolatedFunction getFunction() {
        return function;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public ArrayList<Double> calculate(){
        ArrayList<Double> elements = new ArrayList<>(Collections.nCopies((this.getPower() + 1 ) * (this.getPower() + 1), 0.0));
        Matrix system = new Matrix(elements);
        for(int i = 0; i < system.size; i++){
            for(int j = 0; j < system.size; j++){
                double seriesSum = 0;
                for(int i1 = 0; i1 < this.getFunction().getSize(); i1++){
                    seriesSum += Math.pow(this.getFunction().getArguments().get(i1), i + j);
                }
                system.matrix.get(i).set(j, seriesSum);
            }
        }
        ArrayList <Double> results = buildResults(function, power);
        GaussMethod gaussMethod = new GaussMethod();
        return gaussMethod.calculateMethod(system, results);
    }
    private ArrayList<Double> buildResults(InterpolatedFunction function, int power){
        ArrayList<Double> results = new ArrayList<>();
        for(int i = 0; i < power + 1; i++){
            double seriesSum = 0;
            for(int i1 = 0; i1 < function.getSize(); i1++){
                seriesSum += function.getResults().get(i1) * Math.pow(function.getArguments().get(i1), i);
            }
            results.add(seriesSum);
        }
        return results;
    }

}
