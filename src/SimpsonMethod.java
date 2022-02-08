import java.util.function.Function;

public class SimpsonMethod extends IntegrationMethod{
    SimpsonMethod(Function<Double, Double> function, double eps, double higherIntegrationLimit, double lowerIntegrationLimit) {
        this.function = function;
        this.eps = eps;
        this.higherIntegrationLimit = higherIntegrationLimit;
        this.lowerIntegrationLimit = lowerIntegrationLimit;
    }
    @Override
    public double calculateWithThisStep(IntegrationMethod integrationMethod, double step){
        double seriesSum1 = 0;
        for(double x = integrationMethod.getLowerIntegrationLimit() + step; x <= integrationMethod.getLowerIntegrationLimit() + (getHigherIntegrationLimit() - getLowerIntegrationLimit()) / 2; x += step){
            double temp = x + (x - integrationMethod.getLowerIntegrationLimit()) - step;
            seriesSum1 += integrationMethod.getFunction().apply(temp);
        }
        double seriesSum2 = 0;
        for(double x = integrationMethod.getLowerIntegrationLimit() + step; x < integrationMethod.getLowerIntegrationLimit() + (getHigherIntegrationLimit() - getLowerIntegrationLimit()) / 2; x += step){
            double temp = x + (x - integrationMethod.getLowerIntegrationLimit());
            seriesSum2 += integrationMethod.getFunction().apply(temp);
        }
        double result = integrationMethod.getFunction().apply(integrationMethod.getLowerIntegrationLimit()) + integrationMethod.getFunction().apply(integrationMethod.higherIntegrationLimit) + 4 * seriesSum1 + 2 * seriesSum2;
        result = result * step / 3;
        return result;
    }
    @Override
    public double calculateError(double step){
        double calculateMax = Double.NEGATIVE_INFINITY;
        int count = 0;
        Function<Double, Double> fourthDerivative = Util10Lab.derive(Util10Lab.derive(Util10Lab.derive(Util10Lab.derive(getFunction()))));
        for(double x = getLowerIntegrationLimit(); x <= getHigherIntegrationLimit(); x += step){
            if(Math.abs(fourthDerivative.apply(x)) > calculateMax){
                calculateMax = Math.abs(fourthDerivative.apply(x));
            }
            count++;
        }
        calculateMax = calculateMax - Math.pow((getHigherIntegrationLimit() - getLowerIntegrationLimit()), 5) / (180 * Math.pow(count, 4));
        double result = Math.pow(getHigherIntegrationLimit() - getLowerIntegrationLimit(), 5);
        result *= calculateMax * -1;
        result /= (180 * Math.pow(count, 4));
        return result;
    }
}
