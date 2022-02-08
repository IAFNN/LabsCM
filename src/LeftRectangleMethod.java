import java.util.function.Function;

public class LeftRectangleMethod extends RectangleMethod{
    LeftRectangleMethod(Function<Double, Double> function, double eps, double higherIntegrationLimit, double lowerIntegrationLimit){
        this.function = function;
        this.eps = eps;
        if(eps > higherIntegrationLimit - lowerIntegrationLimit){
            throw new RuntimeException("Error, incorrect eps");
        }
        if(higherIntegrationLimit < lowerIntegrationLimit){
            throw new RuntimeException("Error, incorrect integration limits");
        }
        this.higherIntegrationLimit = higherIntegrationLimit;
        this.lowerIntegrationLimit = lowerIntegrationLimit;
    }
    @Override
    public double calculateWithThisStep(IntegrationMethod integrationMethod, double step){
        double seriesSum = 0;
        for(double x = integrationMethod.getLowerIntegrationLimit(); x < integrationMethod.getHigherIntegrationLimit(); x += step){
            seriesSum += integrationMethod.getFunction().apply(x);
        }
        return step * seriesSum;
    }
}
