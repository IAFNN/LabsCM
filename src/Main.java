import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        ArrayList<Double> numbers = new ArrayList<>();
        numbers.add(0.43);
        numbers.add(1.24);
        numbers.add(-0.58);
        numbers.add(0.74);
        numbers.add(0.83);
        numbers.add(1.17);
        numbers.add(1.43);
        numbers.add(-1.58);
        numbers.add(0.83);
        Matrix matrix = new Matrix(numbers);
        KramerMethod kramerMethod = new KramerMethod();
        ArrayList<Double> results = new ArrayList<>();
        results.add(2.71);
        results.add(1.26);
        results.add(1.03);
        System.out.println("Kramer method:");
        try {
            System.out.println(kramerMethod.calculateMethod(matrix, results));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        InverseMethod inverseMethod = new InverseMethod();
        System.out.println("Inverse method:");
        try {
            System.out.println(inverseMethod.calculateMethod(matrix, results));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Gauss method:");
        GaussMethod gaussMethod = new GaussMethod();
        try {
            System.out.println(gaussMethod.calculateMethod(matrix, results));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\nLUMethod:");
        LUMethod LUMethod = new LUMethod();
        try {
            System.out.println(LUMethod.calculateMethod(matrix, results));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\nYakobi Method:");
        YakobiMethod yakobiMethod = new YakobiMethod();
        try {
            System.out.println(yakobiMethod.calculateMethod(matrix, results));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\nZeidel Method:");
        ZeidelMethod zeidelMethod = new ZeidelMethod();
        try{
            System.out.println(zeidelMethod.calculateMethod(matrix, results));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        numbers = new ArrayList<>();
        numbers.add(2.0);
        numbers.add(-3.0);
        numbers.add(1.0);
        numbers.add(-1.0);
        numbers.add(-5.0);
        numbers.add(0.0);
        numbers.add(2.0);
        numbers.add(-1.0);
        numbers.add(3.0);
        numbers.add(1.0);
        numbers.add(-1.0);
        numbers.add(-4.0);
        numbers.add(-1.0);
        numbers.add(3.0);
        numbers.add(2.0);
        results = new ArrayList<>();
        results.add(3.0);
        results.add(-3.0);
        results.add(-1.0);
        results.add(6.0);
        results.add(3.0);
        matrix = new Matrix(numbers, 5, 3);
        System.out.println("\nOverrided system of linear equations solving:");
        OverrideSoLAQ overrideSoLAQ = new OverrideSoLAQ(matrix, results);
        overrideSoLAQ.calculateN();
        System.out.println("N matrix:\n" + overrideSoLAQ.N);
        overrideSoLAQ.calculateC();
        System.out.println("C matrix:\n" + overrideSoLAQ.C);
        System.out.println("\nSquare root method:");
        SquareRootMethod squareRootMethod = new SquareRootMethod();
        try{
            System.out.println(squareRootMethod.calculateMethod(overrideSoLAQ.N, overrideSoLAQ.C));
        }catch (RuntimeException e){
            e.printStackTrace();
        }

        try{
            System.out.println("Smallest squares method:");
            InterpolatedFunction function = new InterpolatedFunction(new ArrayList<>(Arrays.asList(8.03, 8.08, 8.16, 8.23, 8.26, 8.33)), new ArrayList<>(Arrays.asList(5.01, 4.78, 3.52, 3.12, 3.19, 2.95)), 8.05);
            SmallestSquaresMethod smallestSquaresMethod = new SmallestSquaresMethod(function, 1);
            System.out.println("\n\nLinear polinom:" + smallestSquaresMethod.calculate() + "\n");
            smallestSquaresMethod.setPower(2);
            System.out.println("\n\nQuadratic polinom:" + smallestSquaresMethod.calculate() + "\n");
            smallestSquaresMethod.setPower(3);
            System.out.println("\n\nCube polinom:" + smallestSquaresMethod.calculate() + "\n");
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        try{
            System.out.println("Left Rectangles Method:");
            LeftRectangleMethod leftRectangleMethod = new LeftRectangleMethod((x) -> Math.sqrt(0.3 * x + 1.2), 0.000001, 2.3, 1.5);
            System.out.println(leftRectangleMethod.calculateArea());
            System.out.println("Right Rectangles Method:");
            RightRectangleMethod rightRectangleMethod = new RightRectangleMethod((x) -> Math.sqrt(0.3 * x + 1.2), 0.000001, 2.3, 1.5);
            System.out.println(rightRectangleMethod.calculateArea());
            System.out.println("Central Rectangles Method:");
            CenterRectangleMethod centralRectangleMethod = new CenterRectangleMethod((x) -> Math.sqrt(0.3 * x + 1.2), 0.000001, 2.3, 1.5);
            System.out.println(centralRectangleMethod.calculateArea());
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}
