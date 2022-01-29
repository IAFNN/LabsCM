public class DichotomyMethod extends Method{
    DichotomyMethod(double a, double b, double eps, Function function){
        this.a = a;
        this.b = b;
        this.eps = eps;
        this.function = function;
    }
    double c;

    @Override
    public double calculate() {
        c = (a + b) / 2;
        System.out.println("a: " + a + "\t\tb: " + b + "\t\tc: " + c + "\t\tf(c): " + function.calculateFunction(c));
        if(Math.abs(function.calculateFunction(c)) < eps){
            return c;
        }else if(function.calculateFunction(c) * function.calculateFunction(a) < 0){
            b = c;
            return calculate();
        }else{
            a = c;
            return calculate();
        }
    }

}
