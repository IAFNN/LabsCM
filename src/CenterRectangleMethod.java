import java.util.function.Function;

public class CenterRectangleMethod extends RectangleMethod{
    CenterRectangleMethod(Function<Double, Double> function, double eps, double higherIntegrationLimit, double lowerIntegrationLimit) {
        this.function = function;
        this.eps = eps;
        this.higherIntegrationLimit = higherIntegrationLimit;
        this.lowerIntegrationLimit = lowerIntegrationLimit;
    }
    public double calculateWithThisStep(RectangleMethod rectangleMethod, double step){
        double seriesSum = 0;
        for(double x = rectangleMethod.getLowerIntegrationLimit() + step / 2; x < rectangleMethod.getHigherIntegrationLimit(); x += step){
            seriesSum += rectangleMethod.getFunction().apply(x);
        }
        return step * seriesSum;
    }
}
