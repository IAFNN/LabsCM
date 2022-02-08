import java.util.function.Function;

public abstract class RectangleMethod extends IntegrationMethod{

    double calculateError(double step){
        Function<Double, Double> secondDerivative = Util10Lab.derive(Util10Lab.derive(getFunction()));
        double temp = secondDerivative.apply(getLowerIntegrationLimit() + Math.abs((getHigherIntegrationLimit() - getLowerIntegrationLimit()) / 2));
        temp /= 24;
        temp *= (getHigherIntegrationLimit() - getLowerIntegrationLimit());
        temp *= Math.pow(step, 2);
        return temp;
    }
}
