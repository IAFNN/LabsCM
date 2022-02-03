import java.util.ArrayList;
import java.util.Collections;

public class SquareRootMethod implements Method{
    @Override
    public ArrayList<Double> calculateMethod(Matrix matrix, ArrayList<Double> results) {
        if(Util.calculateDeterminant(matrix) <= 0){
            throw new RuntimeException("Error, determinant isn't positive");
        }
        Matrix L = findLMatrix(matrix);
        Matrix LTransposed = Util.transpose(L);
        Util.invertLines(L);
        results = UtilExtendedArrayList.invert(results);
        Util.gaussReverse(L, results);
        results = UtilExtendedArrayList.invert(results);
        Util.gaussReverse(LTransposed, results);
        return results;
    }
    static Matrix findLMatrix(Matrix matrix){
        Matrix L = new Matrix(new ArrayList<>(Collections.nCopies(matrix.size * matrix.size, 0.0)));
        for (int i = 0; i < matrix.size; i++){
            for(int j = 0; j <= i ; j++){
                if(i == 0 && j == 0){
                    L.matrix.get(j).set(i, Math.sqrt(matrix.matrix.get(i).get(j)));
                }else if(j == 0){
                    L.matrix.get(i).set(j, matrix.matrix.get(j).get(i) / L.matrix.get(0).get(0));
                }else if(i == j){
                    double seriesSum = 0;
                    for(int k = 0; k < i; k++){
                        seriesSum += Math.pow(L.matrix.get(i).get(k), 2);
                    }
                    L.matrix.get(j).set(i, Math.sqrt(matrix.matrix.get(i).get(j) - seriesSum));
                }else{
                    double seriesSum = 0;
                    for(int k = 0; k < j; k++){
                        seriesSum += L.matrix.get(i).get(k) * L.matrix.get(j).get(k);
                    }
                    L.matrix.get(i).set(j, (matrix.matrix.get(j).get(i) - seriesSum) / L.matrix.get(j).get(j));
                }
            }
        }
        return L;
    }
}
