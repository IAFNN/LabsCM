public class Util {
    public static double findMaxAbsolute(double a, double b){
        if(Math.abs(a) > Math.abs(b)){
            return a;
        }else{
            return b;
        }
    }
}
