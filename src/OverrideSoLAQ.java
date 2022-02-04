import java.util.ArrayList;

public class OverrideSoLAQ {
    Matrix A;
    ArrayList<Double> B;
    Matrix ATransposed;
    Matrix N;
    ArrayList<Double> C;
    OverrideSoLAQ(Matrix A, ArrayList<Double> B){
        this.A = A;
        this.B = B;
    }
    void calculateN(){
        ATransposed = Util.transpose(A, A.m, A.n);
        N = Util.multiplyMatrixOnMatrix(ATransposed, A);
    }
    void calculateC(){
        C = Util.multiplyMatrixOnVector(ATransposed, B);
    }
}
