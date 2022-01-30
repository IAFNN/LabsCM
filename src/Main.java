import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Double> numbers = new ArrayList<>();
        numbers.add(2.0);
        numbers.add(4.5);
        numbers.add(4.6);
        numbers.add(5.0);
        numbers.add(7.0);
        numbers.add(7.1);
        numbers.add(8.8);
        numbers.add(10.4);
        numbers.add(9.3);
        Matrix matrix = new Matrix(numbers);
        KramerMethod kramerMethod = new KramerMethod();
        ArrayList<Double> results = new ArrayList<>();
        results.add(3.2);
        results.add(5.7);
        results.add(8.9);
        System.out.println(kramerMethod.calculateMethod(matrix, results));
    }
}
