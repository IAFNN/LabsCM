import java.util.ArrayList;

public class KramerMethod implements Method{
    @Override
    public ArrayList<Double> calculateMethod(Matrix matrix, ArrayList<Double> results) {
        double determinant = Matrix.calculateDeterminant(matrix);
        ArrayList<Double> roots = new ArrayList<>();
        Matrix matrixCopy = matrix.clone();
        for(int i = 0; i < matrix.size; i++) {
            double determinantNew = KramerMethod.calculateModifiedDeterminant(matrixCopy, results, i);
            roots.add(determinantNew / determinant);
            matrixCopy = matrix.clone();
        }
        return roots;
    }
    static double calculateModifiedDeterminant(Matrix matrixCopy, ArrayList<Double> results, int i2){
        for(int i = 0; i < matrixCopy.size; i++){
            matrixCopy.matrix.get(i).set(i2, results.get(i));
        }
        return Matrix.calculateDeterminant(matrixCopy);
    }
}
