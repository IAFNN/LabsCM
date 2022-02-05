import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public abstract class Method {
    abstract ArrayList<Double> calculate();
    List<BiFunction<Double, Double, Double>> system;
    double eps;
}
