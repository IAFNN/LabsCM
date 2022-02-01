import java.util.ArrayList;
import java.util.Collections;

public class LUMethod implements Method{
    @Override
    public ArrayList<Double> calculateMethod(Matrix matrix, ArrayList<Double> results) {
        Matrix L = new Matrix(new ArrayList<>(Collections.nCopies(matrix.size * matrix.size, 0.0)));
        Matrix U = new Matrix(new ArrayList<>(Collections.nCopies(matrix.size * matrix.size, 0.0)));
        for(int i = 0; i < matrix.size; i++){
            for(int j = 0; j < matrix.size; j++){
                double seriesSum = 0;
                if(j <= i) {
                    if(i == j){
                        U.matrix.get(i).set(j, 1.0);
                    }
                    for (int k = 0; k < j; k++) {
                        try {
                            seriesSum += L.matrix.get(i).get(k) * U.matrix.get(k).get(j);
                        } catch (IndexOutOfBoundsException ignored) {
                        }
                    }
                    L.matrix.get(i).set(j, matrix.matrix.get(i).get(j) - seriesSum);
                }else{
                    for(int k = 0; k < i; k++){
                        seriesSum += L.matrix.get(i).get(k) * U.matrix.get(k).get(j);
                    }
                    seriesSum = matrix.matrix.get(i).get(j) - seriesSum;
                    U.matrix.get(i).set(j, seriesSum / L.matrix.get(i).get(i));
                }
            }
        }
        Util.invertLines(L);
        results = UtilExtendedArrayList.invert(results);
        Util.gaussReverse(L, results);
        results = UtilExtendedArrayList.invert(results);
        Util.gaussReverse(U, results);
        return results;
    }
}
