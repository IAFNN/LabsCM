import java.util.ArrayList;

public class UtilExtendedArrayList{
    static public void swap(ArrayList<Double> arrayList, int firstIndex, int secondIndex){
        double temp = arrayList.get(firstIndex);
        arrayList.set(firstIndex, arrayList.get(secondIndex));
        arrayList.set(secondIndex, temp);
    }
    static public ArrayList<Double> invert(ArrayList<Double> arrayList){
        ArrayList<Double> result = new ArrayList<>();
        for(int i = arrayList.size() - 1; i > -1; i--){
            result.add(arrayList.get(i));
        }
        return result;
    }
}
