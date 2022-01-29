public class Controller {
    public static double CalculateDichotomyMethod(double a, double b, double eps, Function<Double> function){
        double c = (a + b) / 2;
        if(Math.abs(function.calculateFunction(c)) < eps){
            return c;
        }else if(function.calculateFunction(c) * function.calculateFunction(a) < 0){
            return Controller.CalculateDichotomyMethod(a, c, eps, function);
        }else{
            return Controller.CalculateDichotomyMethod(c, b, eps, function);
        }
    }
}
