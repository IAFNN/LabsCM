import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            ArrayList<Double> arguments = new ArrayList<>(Arrays.asList(1.43, 1.435, 1.44, 1.445, 1.45, 1.455,
                    1.46, 1.465, 1.47, 1.475));
            ArrayList<Double> results = new ArrayList<>(Arrays.asList(0.88, 0.889, 0.890, 0.891, 0.892, 0.893, 0.894, 0.895, 0.896, 0.897));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number of arguments and results:");
            int count = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter " + count + " x's and f(x)'s separated by space");
            for(int i = 0; i < count; i++){
                String line = scanner.nextLine();
                String[] numbers = line.split(" ");
                if(numbers.length > 2){
                    throw new RuntimeException("Error, incorrect number of values");
                }
                arguments.add(Double.valueOf(numbers[0]));
                results.add(Double.valueOf(numbers[1]));
            }
            double x0 = Math.random() / (arguments.get(arguments.size() - 1) - arguments.get(0)) + arguments.get(0);
//            System.out.println("Enter x0:");
//            double x0 = scanner.nextDouble();
//            InterpolatedFunction function = new InterpolatedFunction(new ArrayList<>(Arrays.asList(1.43, 1.435, 1.44, 1.445, 1.45, 1.455,
//                    1.46, 1.465, 1.47, 1.475)), new ArrayList<>(Arrays.asList(0.88, 0.889, 0.890, 0.891, 0.892, 0.893, 0.894, 0.895, 0.896, 0.897)),
//                    1.461);
            InterpolatedFunction function = new InterpolatedFunction(arguments, results, x0);
            LagrangeMethod lagrangeMethod = new LagrangeMethod(function);
            System.out.println(lagrangeMethod.calculatePolinom());
            NewtonMethod newtonMethod = new NewtonMethod(function);
            System.out.println(newtonMethod.calculatePolinom());
        }catch (RuntimeException e){
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
