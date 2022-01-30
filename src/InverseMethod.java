import java.util.ArrayList;
import java.util.Collections;

public class InverseMethod implements Method{
    @Override
    public ArrayList<Double> calculateMethod(Matrix matrix, ArrayList<Double> results) {
        double determinant = Util.calculateDeterminant(matrix);
        System.out.println("Matrix determinant equals " + determinant);
        ArrayList<Double> transposedList = new ArrayList<>(Collections.nCopies(matrix.size * matrix.size, 0.0));
        for(int i = 0; i < matrix.size; i++){
            for(int i2 = 0; i2 < matrix.size; i2++){
                ArrayList<Double> numbers = new ArrayList<>();
                for(int i3 = 0; i3 < matrix.size; i3++){
                    if(i3 != i){
                        for(int i4 = 0; i4 < matrix.size; i4++){
                            if(i4 != i2){
                                numbers.add(matrix.matrix.get(i3).get(i4));
                            }
                        }
                    }
                }
                double minor = Util.calculateDeterminant(new Matrix(numbers));
                minor *= Math.pow(-1, i + i2 + 2);
                System.out.println("Algebraic complement of " + (i + 1) + (i2 + 1) + " element equals " + minor);
                minor /= determinant;
                transposedList.set(i2 * matrix.size + i, minor);
            }
        }
        Matrix transposed = new Matrix(transposedList);
        return Util.multiplyMatrixOnVector(transposed, results);
    }
}
