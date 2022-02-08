import java.util.function.Function;

public class TrapezeMethod extends IntegrationMethod{
    TrapezeMethod(Function<Double, Double> function, double eps, double higherIntegrationLimit, double lowerIntegrationLimit) {
        this.function = function;
        this.eps = eps;
        this.higherIntegrationLimit = higherIntegrationLimit;
        this.lowerIntegrationLimit = lowerIntegrationLimit;
    }
    @Override
    public double calculateError(double step){
        Function<Double, Double> secondDerivative = Util10Lab.derive(Util10Lab.derive(getFunction()));
        double temp = secondDerivative.apply(getLowerIntegrationLimit() + Math.abs((getHigherIntegrationLimit() - getLowerIntegrationLimit()) / 2));
        temp /= -12;
        temp *= (getHigherIntegrationLimit() - getLowerIntegrationLimit());
        temp *= Math.pow(step, 2);
        return temp;
    }
    @Override
    public double calculateWithThisStep(IntegrationMethod integrationMethod, double step){
        double seriesSum = 0;
        for(double x = integrationMethod.getLowerIntegrationLimit(); x < integrationMethod.getHigherIntegrationLimit(); x += step){
            double resultInX = integrationMethod.getFunction().apply(x);
            double resultInXPlus1 = integrationMethod.getFunction().apply(x + step);
            seriesSum += (resultInX + resultInXPlus1) / 2;
        }
        return step * seriesSum;
    }
}
