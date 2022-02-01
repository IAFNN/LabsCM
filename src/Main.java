import java.util.ArrayList;

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
    }
}
