import java.util.function.Function;

public abstract class IntegrationMethod {
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
    abstract double calculateWithThisStep(IntegrationMethod integrationMethod, double step);
    abstract double calculateError(double step);
}

