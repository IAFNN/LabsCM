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
