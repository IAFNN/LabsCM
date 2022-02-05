import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class IterationMethod extends Method{
    BiFunction<Double, Double, Double> firstFunction;
    double result;
    @Override
    ArrayList<ArrayList<Double>> calculate() {
        ArrayList<ArrayList<Double>> results = new ArrayList<>();
        results.add(new ArrayList<>(Collections.nCopies(system.size(), 0.0)));
        results.add(new ArrayList<>(Collections.nCopies(system.size(), 0.0)));
        double difference = Double.POSITIVE_INFINITY;
        while (difference > eps) {
            for (int i = 0; i < system.size(); i++) {
                results.get(i).set(0, system.get(i).apply(results.get(0).get(0), results.get(1).get(0)));
            }
            difference = checkDifference(results);
        }
        return results;
    }

    IterationMethod(List<BiFunction<Double, Double, Double>> system, double eps, BiFunction<Double, Double, Double> firstFunction, double result){
        this.system = system;
        this.eps = eps;
        this.firstFunction = firstFunction;
        this.result = result;
    }
    double checkDifference(ArrayList<ArrayList<Double>> results){
        return Math.abs(result - firstFunction.apply(results.get(0).get(0), results.get(1).get(0)));
    }
}
