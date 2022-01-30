import java.util.ArrayList;

public class Matrix implements Cloneable{
    ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
    int size;
    Matrix(ArrayList<Double> numbers){
        for(int i = 1;;i++){
            if(i * i >= numbers.size()){
                size = i;
                break;
            }
        }
        int count = 0;
        for(double number : numbers){
            if(count % size == 0){
                matrix.add(new ArrayList<>());
            }
            matrix.get(count / size).add(number);
            count++;
        }
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + matrix +
                '}';
    }
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

    @Override
    public Matrix clone() {
        try {
            Matrix clone = (Matrix) super.clone();
            clone.matrix = (ArrayList<ArrayList<Double>>) matrix.clone();
            clone.size = size;
            for(int i = 0; i < clone.size; i++){
                clone.matrix.set(i, (ArrayList<Double>) matrix.get(i).clone());
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
