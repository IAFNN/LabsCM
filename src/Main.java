import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        try {
            InterpolatedFunction function = new InterpolatedFunction(new ArrayList<>(Arrays.asList(1.43, 1.435, 1.44, 1.445, 1.45, 1.455,
                    1.46, 1.465, 1.47, 1.475)), new ArrayList<>(Arrays.asList(0.88, 0.889, 0.890, 0.891, 0.892, 0.893, 0.894, 0.895, 0.896, 0.897)),
                    1.461);
            LagrangeMethod lagrangeMethod = new LagrangeMethod(function);
            System.out.println(lagrangeMethod.calculatePolinom());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
