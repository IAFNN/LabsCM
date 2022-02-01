import java.util.ArrayList;

public class GaussMethod implements Method{
    @Override
    public ArrayList<Double> calculateMethod(Matrix matrix, ArrayList<Double> results) {
        Matrix matrix1 = matrix.clone();
        ArrayList<Double> results1 = (ArrayList<Double>) results.clone();
        Util.searchForMainElement(matrix1, results1);
        for(int i = 0; i < matrix1.size; i++){
            double mainElement = matrix1.matrix.get(i).get(i);
            System.out.println("\nMain element equals " + mainElement);
            for(int i2 = i + 1; i2 < matrix1.size; i2++){
                double coefficient = matrix1.matrix.get(i2).get(i) / mainElement;
                for(int i3 = i; i3 < matrix1.size; i3++){
                    matrix1.matrix.get(i2).set(i3, matrix1.matrix.get(i2).get(i3) - matrix1.matrix.get(i).get(i3) * coefficient);
                }
                results1.set(i2, results1.get(i2) - results1.get(i) * coefficient);
            }
            System.out.print("Matrix now is:\n" + matrix1);
            System.out.println("Results now are:\n" + results1);
        }
        Util.gaussReverse(matrix1, results1);
        return results1;
    }
}
