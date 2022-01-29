public class DichotomyMethod implements Method{
    DichotomyMethod(double a, double b, double eps, Function function){
        this.a = a;
        this.b = b;
        EPS = eps;
        FUNCTION = function;
    }
    double a;
    double b;
    final double EPS;
    final Function FUNCTION;
    double c;

    @Override
    public double calculate() {
        c = (a + b) / 2;
        System.out.println("a: " + a + "\t\tb: " + b + "\t\tc: " + c + "\t\tf(c): " + FUNCTION.calculateFunction(c));
        if(Math.abs(FUNCTION.calculateFunction(c)) < EPS){
            return c;
        }else if(FUNCTION.calculateFunction(c) * FUNCTION.calculateFunction(a) < 0){
            b = c;
            return calculate();
        }else{
            a = c;
            return calculate();
        }
    }

//    public static double calculate(double a, double b, double eps, Function function){
//        double c = (a + b) / 2;
//        System.out.println("a:" + a + "\tb:" + b + "\tc:" + c);
//        if(Math.abs(function.calculateFunction(c)) < eps){
//            return c;
//        }else if(function.calculateFunction(c) * function.calculateFunction(a) < 0){
//            return DichotomyMethod.CalculateDichotomyMethod(a, c, eps, function);
//        }else{
//            return DichotomyMethod.CalculateDichotomyMethod(c, b, eps, function);
//        }
//    }
}
