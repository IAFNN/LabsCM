import java.util.ArrayList;
import java.util.Objects;
import java.util.function.BiFunction;

public class Util {
    public static final double DX = 0.000001;
    public static BiFunction<Double, Double, Double> deriveByX(BiFunction<Double, Double, Double> function){
        return ((aDouble, aDouble2) -> (function.apply(aDouble + DX, aDouble2) - function.apply(aDouble, aDouble2)) / DX);
    }
    public static BiFunction<Double, Double, Double> deriveByY(BiFunction<Double, Double, Double> function){
        return ((aDouble, aDouble2) -> (function.apply(aDouble, aDouble2 + DX) - function.apply(aDouble, aDouble2)) / DX);
    }
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
}
