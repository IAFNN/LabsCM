public class Main {
    public static void main(String[] args){
        System.out.println("DichotomyMethod:");
        DichotomyMethod dichotomyMethod = new DichotomyMethod(-2, -1, 0.0001, x -> Math.pow(x, 3) + 0.2 * Math.pow(x, 2) - 0.6 * x + 1.5);
        System.out.println(dichotomyMethod.calculate());
        System.out.println("\n\nHord method:");
        HordMethod hordMethod = new HordMethod(-2, -1, 0.0001, x -> Math.pow(x, 3) + 0.2 * Math.pow(x, 2) - 0.6 * x + 1.5, x -> 6 * x + 0.4);
        System.out.println(hordMethod.calculate());
        System.out.println("\n\nTangent method:");
        TangentMethod tangentMethod = new TangentMethod(-2, -1, 0.0001, x -> Math.pow(x, 3) + 0.2 * Math.pow(x, 2) - 0.6 * x + 1.5, x -> 3 * Math.pow(x, 2) + 0.4 * x - 0.6, x -> 6 * x + 0.4 );
        System.out.println(tangentMethod.calculate());
    }
}
