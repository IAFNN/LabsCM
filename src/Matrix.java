import java.util.ArrayList;
import java.util.Collections;

public class Matrix implements Cloneable{
    ArrayList<ArrayList<Double>> matrix;
    Integer size;
    Integer m;
    Integer n;
    Matrix(ArrayList<Double> numbers, int m, int n){
        this.m = m;
        this.n = n;
        matrix = new ArrayList<>();
        for(int i = 0; i < m; i++){
            matrix.add(new ArrayList<>(Collections.nCopies(n, 0.0)));
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix.get(i).set(j, numbers.get(i * n + j));
            }
        }
    }
    Matrix(ArrayList<Double> numbers){
        for(int i = 1;;i++){
            if(i * i >= numbers.size()){
                this.size = i;
                break;
            }
        }
        matrix = new ArrayList<>();
        for(int i = 0; i < size; i++){
            matrix.add(new ArrayList<>(Collections.nCopies(size, 0.0)));
        }
        for(int i = 0; i < numbers.size(); i++){
            matrix.get(i / size).set(i % size, numbers.get(i));
        }
    }

    @Override
    public String toString() {
        String result = "";
        for(ArrayList<Double> line : this.matrix){
            for(Double number : line){
                result += number.toString() + "\t\t";
            }
            result += "\n";
        }
        return result;
    }


    @Override
    public Matrix clone() {
        try {
            Matrix clone = (Matrix) super.clone();
            clone.matrix = (ArrayList<ArrayList<Double>>) matrix.clone();
            try {
                clone.size = size;
                for (int i = 0; i < clone.size; i++) {
                    clone.matrix.set(i, (ArrayList<Double>) matrix.get(i).clone());
                }
            }catch (NullPointerException e){
                clone.m = m;
                clone.n = n;
                for(int i = 0; i < m; i++){
                    clone.matrix.set(i, (ArrayList<Double>) matrix.get(i).clone());
                }
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}