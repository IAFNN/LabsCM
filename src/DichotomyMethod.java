public class DichotomyMethod extends Method{
    DichotomyMethod(double a, double b, double eps, Function function){
        this.a = a;
        this.b = b;
        this.eps = eps;
        this.function = function;
        if(a >= b) {
            throw new RuntimeException("Error, a is bigger or equal b");
        }
        if(eps > b - a){
            throw new RuntimeException("Error, eps is bigger than interval between a and b");
        }
    }
    double c;

    @Override
    public double calculate() {
        c = (a + b) / 2;
        System.out.println("a: " + a + "\t\tb: " + b + "\t\tc: " + c + "\t\tf(c): " + function.calculateFunction(c));
        if(Math.abs(function.calculateFunction(c)) < eps){
            return c;
        }else if(a == b){
            throw new RuntimeException("Error, there is no roots on this interval");
        }else if(function.calculateFunction(c) * function.calculateFunction(a) < 0){
            b = c;
            return calculate();
        }else{
            a = c;
            return calculate();
        }
    }

}
