public class IterationMethod extends Method{
    double x;
    Function fi;
    IterationMethod(double a, double b, double eps, Function function, Function fi){
        if(a >= b) {
            throw new RuntimeException("Error, a is bigger or equal b");
        }
        if(eps > b - a){
            throw new RuntimeException("Error, eps is bigger than interval between a and b");
        }
        x = Math.random() + Util.findMaxAbsolute(a, b);
        this.eps = eps;
        this.function = function;
        this.fi = fi;
    }

    @Override
    double calculate() {
        System.out.println("x: " + x);
        if(Math.abs(function.calculateFunction(x)) < eps){
            return x;
        }else{
            x = fi.calculateFunction(x);
            return calculate();
        }
    }
}
