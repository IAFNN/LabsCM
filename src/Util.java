import java.util.ArrayList;

public class Util {
    static double calculateDeterminant(Matrix matrix){
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
}
