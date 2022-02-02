import java.util.ArrayList;

@FunctionalInterface
public interface MyFunction<T, R> {
       R apply(ArrayList<T> coefficients, ArrayList<T> arguments);
}
