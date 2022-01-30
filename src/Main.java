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
        System.out.println(kramerMethod.calculateMethod(matrix, results));
        InverseMethod inverseMethod = new InverseMethod();
        System.out.println(inverseMethod.calculateMethod(matrix, results));
    }
}
