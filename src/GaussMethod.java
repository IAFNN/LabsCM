import java.util.ArrayList;

public class GaussMethod implements Method{
    @Override
    public ArrayList<Double> calculateMethod(Matrix matrix, ArrayList<Double> results) {
        Util.searchForMainElement(matrix, results);
        for(int i = 0; i < matrix.size; i++){
            double mainElement = matrix.matrix.get(i).get(i);
            for(int i2 = i + 1; i2 < matrix.size; i2++){
                double coefficient = matrix.matrix.get(i2).get(i) / mainElement;
                for(int i3 = i; i3 < matrix.size; i3++){
                    matrix.matrix.get(i2).set(i3, matrix.matrix.get(i2).get(i3) - matrix.matrix.get(i).get(i3) * coefficient);
                }
                results.set(i2, results.get(i2) - results.get(i) * coefficient);
            }
        }
        for(int i = matrix.size - 1; i > -1; i--){
            for(int i2 = matrix.size - 1; i2 > i; i2--){
                results.set(i, results.get(i) - results.get(i2) * matrix.matrix.get(i).get(i2));
            }
            results.set(i, results.get(i) / matrix.matrix.get(i).get(i));
        }
        return results;
    }

}
