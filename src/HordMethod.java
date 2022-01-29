public class HordMethod{
    final double A;
    final double B;
    final double EPS;
    double x;
    final double c;
    final Function<Double> FUNCTION;
    final Function<Double> FUNCTION_SECOND_DERIVATIVE;
    HordMethod(double a, double b, double eps, Function<Double> function, Function<Double> functionSecondDerivative){
        this.A = a;
        this.B = b;
        this.EPS = eps;
        if(function.calculateFunction(a) * functionSecondDerivative.calculateFunction(a) > 0){
            x = B;
            c = A;
        }else{
            x = A;
            c = B;
        }
        this.FUNCTION = function;
        this.FUNCTION_SECOND_DERIVATIVE = functionSecondDerivative;
    }
    public double calculateHordMethod(){
        System.out.println("x: " + x + "\tc: " + c + "\tf(x): " + FUNCTION.calculateFunction(x));
        if(Math.abs(FUNCTION.calculateFunction(x)) < EPS){
            return x;
        }else{
            x = x - ((FUNCTION.calculateFunction(x) * (c - x)) / (FUNCTION.calculateFunction(c) - FUNCTION.calculateFunction(x)));
            return calculateHordMethod();
        }
    }
}

