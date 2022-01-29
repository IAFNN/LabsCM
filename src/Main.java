public class Main {
    public static void main(String[] args){
        System.out.println("DichotomyMethod:");
        try {
            DichotomyMethod dichotomyMethod = new DichotomyMethod(-2, -1, 0.0001, x -> Math.pow(x, 3) + 0.2 * Math.pow(x, 2) - 0.6 * x + 1.5);
            System.out.println(dichotomyMethod.calculate());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n\nHord method:");
        try {
            HordMethod hordMethod = new HordMethod(-2, -1, 0.0001, x -> Math.pow(x, 3) + 0.2 * Math.pow(x, 2) - 0.6 * x + 1.5, x -> 6 * x + 0.4);
            System.out.println(hordMethod.calculate());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n\nTangent method:");
        try {
            TangentMethod tangentMethod = new TangentMethod(-2, -1, 0.0001, x -> Math.pow(x, 3) + 0.2 * Math.pow(x, 2) - 0.6 * x + 1.5, x -> 3 * Math.pow(x, 2) + 0.4 * x - 0.6, x -> 6 * x + 0.4);
            System.out.println(tangentMethod.calculate());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
