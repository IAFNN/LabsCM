public class Main {
    public static void main(String[] args){
        System.out.println(Controller.CalculateDichotomyMethod(-2, -1, 0.0001, x -> Math.pow(x, 3) + 0.2 * Math.pow(x, 2) - 0.6 * x + 1.5));
    }
}
