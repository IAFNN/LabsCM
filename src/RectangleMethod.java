import java.util.function.Function;

public abstract class RectangleMethod {
    Function<Double, Double> function;

    public void setFunction(Function<Double, Double> function) {
        this.function = function;
    }

    public Function<Double, Double> getFunction() {
        return function;
    }

    double eps;

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    double lowerIntegrationLimit;

    public double getLowerIntegrationLimit() {
        return lowerIntegrationLimit;
    }

    public void setLowerIntegrationLimit(double lowerIntegrationLimit) {
        this.lowerIntegrationLimit = lowerIntegrationLimit;
    }
    double higherIntegrationLimit;

    public void setHigherIntegrationLimit(double higherIntegrationLimit) {
        this.higherIntegrationLimit = higherIntegrationLimit;
    }

    public double getHigherIntegrationLimit() {
        return higherIntegrationLimit;
    }
    public double calculateArea(){
        double step = Math.sqrt(eps);
        double resultWithBiggerStep = Double.POSITIVE_INFINITY;
        double resultWithSmallerStep = Double.NEGATIVE_INFINITY;
        while(true){
            resultWithBiggerStep = calculateWithThisStep(this, step);
            resultWithSmallerStep = calculateWithThisStep(this, step / 2);
            if(Math.abs(resultWithBiggerStep - resultWithSmallerStep) < eps){
                break;
            }
            step /= 2;
        }
        System.out.println("Error for this method is: " + calculateError(step));
        return resultWithSmallerStep;
    }
    abstract double calculateWithThisStep(RectangleMethod rectangleMethod, double step);
    double calculateError(double step){
        Function<Double, Double> secondDerivative = Util10Lab.derive(Util10Lab.derive(getFunction()));
        double temp = secondDerivative.apply(getLowerIntegrationLimit() + Math.abs((getHigherIntegrationLimit() - getLowerIntegrationLimit()) / 2));
        temp *= (getHigherIntegrationLimit() - getLowerIntegrationLimit());
        temp *= Math.pow(step, 2);
        return temp;
    }
}
