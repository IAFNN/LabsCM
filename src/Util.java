import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Util {
    static double calculateDeterminant(Matrix matrix){
        try{
            if(Objects.equals(matrix.m, matrix.n) && !(Objects.equals(matrix.m, null))){
                matrix.size = matrix.m;
            }
        }catch (IndexOutOfBoundsException ignored){
        }
        if(matrix.size > 2) {
            ArrayList<Double> additions = new ArrayList<>();
            for(int i = 0; i < matrix.size; i++) {
                additions.add(matrix.matrix.get(0).get(i));
                ArrayList<Double> numbers = new ArrayList<>();
                for(int i2 = 1; i2 < matrix.size; i2++){
                    for(int i3 = 0; i3 < matrix.size; i3++){
                        if(i3 != i){
                            numbers.add(matrix.matrix.get(i2).get(i3));
                        }
                    }
                }
                additions.set(i, additions.get(i) * calculateDeterminant(new Matrix(numbers)));
            }
            double sum = 0;
            for(int i = 0; i < matrix.size; i++){
                sum += additions.get(i) * Math.pow(-1, i);
            }
            return sum;
        }else{
            return matrix.matrix.get(0).get(0) * matrix.matrix.get(1).get(1) - matrix.matrix.get(0).get(1) * matrix.matrix.get(1).get(0);
        }
    }
    static Matrix multiplyMatrixOnMatrix(Matrix matrix, Matrix matrix2){
        ArrayList<ArrayList<Double>> result = new ArrayList<>();
        for(ArrayList<Double> line : matrix.matrix){
            result.add(multiplyMatrixOnVector(Util.transpose(matrix2, matrix2.m, matrix2.n), line));
        }
        Matrix resultMatrix = matrix.clone();
        resultMatrix.matrix = result;
        resultMatrix.m = matrix.m;
        resultMatrix.n = matrix2.n;
        return resultMatrix;
    }
    static ArrayList<Double> multiplyMatrixOnVector(Matrix matrix, ArrayList<Double> vector){
        ArrayList<Double> result = new ArrayList<>();
        for(ArrayList<Double> line : matrix.matrix){
            result.add(Util.multiplyTwoVectors(line, vector));
        }
        return result;
    }
    static double multiplyTwoVectors(ArrayList<Double> vector1, ArrayList<Double> vector2){
        double result = 0;
        for(int i = 0; i < vector1.size(); i++){
            result += vector1.get(i) * vector2.get(i);
        }
        return result;
    }
    static void searchForMainElement(Matrix matrix, ArrayList<Double> results){
        double max = Double.NEGATIVE_INFINITY;
        int maxIndex = 0;
        for(int i = 0; i < matrix.size; i++){
            if(matrix.matrix.get(i).get(0) > max){
                max = matrix.matrix.get(i).get(0);
                maxIndex = i;
            }
        }
        UtilExtendedArrayList.swap(results, 0, maxIndex);
        swapLines(matrix, 0, maxIndex);
    }
    static void swapLines(Matrix matrix, int firstLineIndex, int secondLineIndex){
        ArrayList<Double> temp = matrix.matrix.get(firstLineIndex);
        matrix.matrix.set(firstLineIndex, matrix.matrix.get(secondLineIndex));
        matrix.matrix.set(secondLineIndex, temp);
    }
    static void gaussReverse(Matrix matrix, ArrayList<Double> results){
        for(int i = matrix.size - 1; i > -1; i--){
            for(int i2 = matrix.size - 1; i2 > i; i2--){
                results.set(i, results.get(i) - results.get(i2) * matrix.matrix.get(i).get(i2));
            }
            results.set(i, results.get(i) / matrix.matrix.get(i).get(i));
        }
    }
    static void invertLines(Matrix matrix){
        int count = matrix.size - 1;
        for(int i = 0; i <= count; i++){
            if(i == count){
                moveToEnd(matrix, i);
                break;
            }
            ArrayList<Double> lineTemp = matrix.matrix.get(count);
            matrix.matrix.set(count, matrix.matrix.get(i));
            matrix.matrix.set(i, lineTemp);
            moveToEnd(matrix, i);
            moveToEnd(matrix, count);
            count--;
        }
    }

    public static void moveToEnd(Matrix matrix, int count) {
        for(int i = 0; i < matrix.size / 2; i++){
            double temp = matrix.matrix.get(count).get(matrix.size - i - 1);
            matrix.matrix.get(count).set(matrix.size - i - 1, matrix.matrix.get(count).get(i));
            matrix.matrix.get(count).set(i, temp);
        }

    }
    public static Matrix transpose(Matrix matrix){
        Matrix transposed = new Matrix(new ArrayList<>(Collections.nCopies(matrix.size * matrix.size, 0.0)));
        for(int i = 0; i < matrix.size; i++){
            for(int j = 0; j < matrix.size; j++){
                transposed.matrix.get(j).set(i, matrix.matrix.get(i).get(j));
            }
        }
        return transposed;
    }
    public static Matrix transpose(Matrix matrix, int m, int n){
        Matrix transposed = new Matrix(new ArrayList<>(Collections.nCopies(m * n, 0.0)), n, m);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                transposed.matrix.get(j).set(i, matrix.matrix.get(i).get(j));
            }
        }
        return transposed;
    }
}
