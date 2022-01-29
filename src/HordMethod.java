public class HordMethod extends Method{
    double x;
    final double c;
    HordMethod(double a, double b, double eps, Function function, Function functionSecondDerivative){
        this.a = a;
        this.b = b;
        this.eps = eps;
        if(function.calculateFunction(a) * functionSecondDerivative.calculateFunction(a) > 0){
            x = b;
            c = a;
        }else{
            x = a;
            c = b;
        }
        this.function = function;
        this.secondDerivative = functionSecondDerivative;
    }
    public double calculate(){
        System.out.println("x: " + x + "\tc: " + c + "\tf(x): " + function.calculateFunction(x));
        if(Math.abs(function.calculateFunction(x)) < eps){
            return x;
        }else{
            x = x - ((function.calculateFunction(x) * (c - x)) / (function.calculateFunction(c) - function.calculateFunction(x)));
            return calculate();
        }
    }
}

