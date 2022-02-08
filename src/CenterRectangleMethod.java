import java.util.function.Function;

public class CenterRectangleMethod extends RectangleMethod{
    CenterRectangleMethod(Function<Double, Double> function, double eps, double higherIntegrationLimit, double lowerIntegrationLimit) {
        this.function = function;
        this.eps = eps;
        this.higherIntegrationLimit = higherIntegrationLimit;
        this.lowerIntegrationLimit = lowerIntegrationLimit;
    }
    public double calculateWithThisStep(IntegrationMethod integrationMethod, double step){
        double seriesSum = 0;
        for(double x = integrationMethod.getLowerIntegrationLimit() + step / 2; x < integrationMethod.getHigherIntegrationLimit(); x += step){
            seriesSum += integrationMethod.getFunction().apply(x);
        }
        return step * seriesSum;
    }
}
