import java.util.function.Function;

public class Util10Lab {
    public static double DX = 0.00001;
    public static Function<Double, Double> derive(Function<Double, Double> function){
        return (aDouble) -> (function.apply(aDouble + DX) - function.apply(aDouble)) / DX;
    }
}
