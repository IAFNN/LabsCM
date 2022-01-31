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
        if(numbers.size() != size * size){
            throw new RuntimeException("Error, amount of numbers is not right");
        }
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
