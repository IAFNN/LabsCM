import java.util.ArrayList;

public class NewtonMethod {
    private InterpolatedFunction function;
    public InterpolatedFunction getFunction() {
        return function;
    }
    public void setFunction(InterpolatedFunction function) {
        this.function = function;
    }
    NewtonMethod(InterpolatedFunction function){
        this.function = function;
    }
    public double calculatePolinom(){
        double sum = 0;
        for(int i = 0; i < function.getSize(); i++){
            double product = 1;
            for(int i2 = 0; i2 < i; i2++){
                product *= function.getX0() - function.getArguments().get(i2);
            }
            System.out.println("Sum: " + sum);
            sum += calculateDividedDifference(new ArrayList<>(function.getArguments().subList(0, i + 1)), function) * product;
        }
        return sum;
    }
    private double calculateDividedDifference(ArrayList<Double> arguments, InterpolatedFunction function){
        if(arguments.size() == 0){
            return 1;
        }else if(arguments.size() == 1){
            return function.getResults().get(function.getArguments().indexOf(arguments.get(0)));
        }else{
            ArrayList<Double> arguments1 = new ArrayList<>(arguments.subList(1, arguments.size()));
            ArrayList<Double> arguments2 = new ArrayList<>(arguments.subList(0, arguments.size() - 1));
            return (calculateDividedDifference(arguments1, function) - calculateDividedDifference(arguments2, function)) / (arguments.get(arguments.size() - 1) - arguments.get(0));
        }
    }
}
