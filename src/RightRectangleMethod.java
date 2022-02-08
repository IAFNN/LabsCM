import java.util.function.Function;

public class RightRectangleMethod extends RectangleMethod{
    RightRectangleMethod(Function<Double, Double> function, double eps, double higherIntegrationLimit, double lowerIntegrationLimit) {
        this.function = function;
        this.eps = eps;
        this.higherIntegrationLimit = higherIntegrationLimit;
        this.lowerIntegrationLimit = lowerIntegrationLimit;
    }
    @Override
    public double calculateWithThisStep(RectangleMethod rectangleMethod, double step){
        double seriesSum = 0;
        for(double x = rectangleMethod.getLowerIntegrationLimit() + step; x <= rectangleMethod.getHigherIntegrationLimit(); x += step){
            seriesSum += rectangleMethod.getFunction().apply(x);
        }
        return step * seriesSum;
    }

}
