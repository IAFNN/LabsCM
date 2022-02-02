import java.util.ArrayList;
import java.util.Collections;

public class YakobiMethod implements Method{
    @Override
    public ArrayList<Double> calculateMethod(Matrix matrix, ArrayList<Double> results) {
        double eps = 0.0001;
        ArrayList<Double> beta = new ArrayList<>();
        ArrayList<Double> alpha = new ArrayList<>();
        for(int i = 0; i < matrix.size; i++){
            for(int j = 0; j < matrix.size; j++){
                if(j == i){
                    alpha.add(0.0);
                    continue;
                }
                alpha.add(matrix.matrix.get(i).get(j) / matrix.matrix.get(i).get(i) * -1);
            }
            beta.add(results.get(i) / matrix.matrix.get(i).get(i));
        }
        Matrix alphaM = new Matrix(alpha);
        ArrayList<Double> x = (ArrayList<Double>) beta.clone();
        double result = Double.POSITIVE_INFINITY;
        for (int k = 0; Math.abs(result - results.get(0)) > eps; k++) {
            ArrayList<Double> xNextIter = new ArrayList<>();
            for (int i = 0; i < matrix.size; i++) {
                double seriesSum = 0;
                for (int j = 0; j < matrix.size; j++) {
                    if (j == i) {
                        continue;
                    }
                    seriesSum += alphaM.matrix.get(i).get(j) * x.get(j);
                }
                xNextIter.add(beta.get(i) + seriesSum);
            }
            x = xNextIter;
            result = ((MyFunction<Double, Double>) (coefficients, x1) -> {
                double sum = 0;
                if (coefficients.size() != x1.size()) {
                    throw new RuntimeException("Error, number of coefficents doesn`t equal number of X`s");
                }
                for (int i = 0; i < coefficients.size(); i++) {
                    sum += coefficients.get(i) * x1.get(i);
                }
                return sum;
            }).apply(matrix.matrix.get(0), x);
            System.out.println("X: " + x);
            if (k > 100) {
                throw new RuntimeException("Error, iteration process isn't convergent in this System of Linear Algebraic Equations");
            }
        }
        return x;
    }
}
