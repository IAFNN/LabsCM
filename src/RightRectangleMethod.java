import java.util.function.Function;

public class RightRectangleMethod extends RectangleMethod{
    RightRectangleMethod(Function<Double, Double> function, double eps, double higherIntegrationLimit, double lowerIntegrationLimit) {
        this.function = function;
        this.eps = eps;
        this.higherIntegrationLimit = higherIntegrationLimit;
        this.lowerIntegrationLimit = lowerIntegrationLimit;
    }
    @Override
    public double calculateWithThisStep(IntegrationMethod integrationMethod, double step){
        double seriesSum = 0;
        for(double x = integrationMethod.getLowerIntegrationLimit() + step; x <= integrationMethod.getHigherIntegrationLimit(); x += step){
            seriesSum += integrationMethod.getFunction().apply(x);
        }
        return step * seriesSum;
    }

}
