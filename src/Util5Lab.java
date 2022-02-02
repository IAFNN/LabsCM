import java.util.ArrayList;

public class Util5Lab {
    static Matrix calculateAlpha(Matrix matrix){
        ArrayList<Double> alpha = new ArrayList<>();
        for(int i = 0; i < matrix.size; i++){
            for(int j = 0; j < matrix.size; j++){
                if(j == i){
                    alpha.add(0.0);
                    continue;
                }
                alpha.add(matrix.matrix.get(i).get(j) / matrix.matrix.get(i).get(i) * -1);
            }
        }
        return new Matrix(alpha);
    }
    static ArrayList<Double> calculateBeta(Matrix matrix, ArrayList<Double> results){
        ArrayList<Double> beta = new ArrayList<>();
        for(int i = 0; i < matrix.size; i++){
            beta.add(results.get(i) / matrix.matrix.get(i).get(i));
        }
        return beta;
    }
    static double calculateResult(ArrayList <Double> coefficients, ArrayList<Double> x){
        return ((MyFunction<Double, Double>) (coefficients1, x1) -> {
            double sum = 0;
            if (coefficients1.size() != x1.size()) {
                throw new RuntimeException("Error, number of coefficents doesn`t equal number of X`s");
            }
            for (int i = 0; i < coefficients1.size(); i++) {
                sum += coefficients1.get(i) * x1.get(i);
            }
            return sum;
        }).apply(coefficients, x);
    }
}
