import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        System.out.println("Iteration method:");
        IterationMethod iterationMethod = new IterationMethod(Arrays.asList((aDouble, aDouble2) -> 1.5 - Math.cos(aDouble2),
                (aDouble, aDouble2) -> (1 + Math.sin(aDouble - 0.5)) / 2), 0.000001,
                (aDouble, aDouble2) -> Math.cos(aDouble2) + aDouble, 1.5);
        System.out.println(iterationMethod.calculate());
        System.out.println("Newton Method:");
        NewtonMethod newtonMethod = new NewtonMethod(Arrays.asList((aDouble, aDouble2) -> Math.cos(aDouble2) + aDouble - 1.5,
                (aDouble, aDouble2) -> 2 * aDouble2 - Math.sin(aDouble - 0.5) - 1), 0.000001, ((aDouble, aDouble2) -> Math.cos(aDouble2) + aDouble), 1.5);
        System.out.println(newtonMethod.calculate());
    }
}
