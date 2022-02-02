import java.util.ArrayList;

public class YakobiMethod implements Method{
    @Override
    public ArrayList<Double> calculateMethod(Matrix matrix, ArrayList<Double> results) {
        double eps = 0.0001;
        ArrayList<Double> beta = Util5Lab.calculateBeta(matrix, results);
        Matrix alpha = Util5Lab.calculateAlpha(matrix);
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
                    seriesSum += alpha.matrix.get(i).get(j) * x.get(j);
                }
                xNextIter.add(beta.get(i) + seriesSum);
            }
            x = xNextIter;
            result = Util5Lab.calculateResult(matrix.matrix.get(0), x);
            System.out.println("X: " + x);
            if (k > 100) {
                throw new RuntimeException("Error, iteration process isn't convergent in this System of Linear Algebraic Equations");
            }
        }
        return x;
    }
}
