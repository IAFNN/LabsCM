public class TangentMethod extends Method{
    double x;
    TangentMethod(double a, double b, double eps, Function function, Function firstDerivative, Function secondDerivative){
        this.eps = eps;
        this.function = function;
        this.firstDerivative = firstDerivative;
        if(a >= b) {
            throw new RuntimeException("Error, a is bigger or equal b");
        }
        if(eps > b - a){
            throw new RuntimeException("Error, eps is bigger than interval between a and b");
        }
        if(function.calculateFunction(a) * secondDerivative.calculateFunction(a) > 0){
            x = a;
        }else{
            x = b;
        }
    }

    @Override
    double calculate() {
        System.out.println("x: " + x + "\t\tf(x): " + function.calculateFunction(x) + "\t\tf'(x): " + firstDerivative.calculateFunction(x));
        if(Math.abs(function.calculateFunction(x)) < eps){
            return x;
        }else{
            x = x - function.calculateFunction(x) / firstDerivative.calculateFunction(x);
            return calculate();
        }
    }
}
