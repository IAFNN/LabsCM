import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("DichotomyMethod:");
        try {
            DichotomyMethod dichotomyMethod = new DichotomyMethod(2, 3, 0.0001, x -> Math.pow(x, 3) - 6 * x - 8);
            System.out.println(dichotomyMethod.calculate());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n\nHord method:");
        try {
            HordMethod hordMethod = new HordMethod(2, 3, 0.0001, x -> Math.pow(x, 3) - 6 * x - 8, x -> 3 * Math.pow(x, 2) - 6);
            System.out.println(hordMethod.calculate());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n\nTangent method:");
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        double eps = scanner.nextDouble();
        try {
            TangentMethod tangentMethod = new TangentMethod(2, 3, 0.0001, x -> Math.pow(x, 3) - 6 * x - 8, x -> 3 * Math.pow(x, 2) - 6, x -> 6 * x);
            System.out.println(tangentMethod.calculate());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\n\nIteration method:");
        try{
            IterationMethod iterationMethod = new IterationMethod(2, 3, 0.0001, x -> Math.pow(x, 3) - 6 * x - 8, x -> x - 0.0476190476 * (Math.pow(x, 3) - 6 * x - 8));
            System.out.println(iterationMethod.calculate());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
