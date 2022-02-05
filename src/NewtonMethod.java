import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class NewtonMethod extends Method{
    BiFunction<Double, Double, Double> firstFunction;
    double result;
    @Override
    ArrayList<Double> calculate() {
        double difference = Double.POSITIVE_INFINITY;
        ArrayList<Double> results = new ArrayList<>(Collections.nCopies(system.size(), 0.0));
        while(difference > eps){
            double x = results.get(0);
            double y = results.get(1);
            ArrayList<Double> arguments = new ArrayList<>(Arrays.asList(Util.deriveByX(system.get(0)).apply(x, y),
                    Util.deriveByY(system.get(0)).apply(x, y),
                    Util.deriveByX(system.get(1)).apply(x, y),
                    Util.deriveByY(system.get(1)).apply(x, y)));
            double deltaXY = Util.calculateDeterminant(new Matrix(arguments));
            arguments = new ArrayList<>(Arrays.asList(system.get(0).apply(x, y),
                    Util.deriveByY(system.get(0)).apply(x, y), system.get(1).apply(x, y),
                    Util.deriveByY(system.get(1)).apply(x, y)));
            double deltaX = Util.calculateDeterminant(new Matrix(arguments));
            deltaX = deltaX / deltaXY * -1;
            arguments = new ArrayList<>(Arrays.asList(Util.deriveByX(system.get(0)).apply(x, y),
                    system.get(0).apply(x, y), Util.deriveByX(system.get(1)).apply(x, y), system.get(1).apply(x, y)));
            double deltaY = Util.calculateDeterminant(new Matrix(arguments));
            deltaY = deltaY / deltaXY * -1;
            results.set(0, results.get(0) + deltaX);
            results.set(1, results.get(1) + deltaY);
            difference = IterationMethod.checkDifference(results, result, firstFunction);
        }
        return results;
    }
    NewtonMethod(List<BiFunction<Double, Double, Double>> system, double eps, BiFunction<Double, Double, Double> firstFunction, double result){
        this.system = system;
        this.eps = eps;
        this.firstFunction = firstFunction;
        this.result = result;
    }
}
