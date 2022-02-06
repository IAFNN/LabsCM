public class LagrangeMethod {
    private InterpolatedFunction function;
    public InterpolatedFunction getFunction(){
        return this.function;
    }
    public void setFunction(InterpolatedFunction function) {
        this.function = function;
    }
    LagrangeMethod(InterpolatedFunction function){
        this.function = function;
    }
    public double calculatePolinom(){
        return calculateProduct(function) * calculateSum(function);
    }
    private double calculateProduct(InterpolatedFunction function){
        double product = 1;
        for(int i = 0; i < function.getSize(); i++){
            product *= function.getX0() - function.getArguments().get(i);
        }
        System.out.println("Product: " + product);
        return product;
    }
    private double calculateSum(InterpolatedFunction function){
        double sum = 0;
        for(int i = 0; i < function.getSize(); i++){
            double productInLine = 1;
            for(int i2 = 0; i2 < function.getSize(); i2++){
                if(i2 == i){
                    productInLine *= function.getX0() - function.getArguments().get(i);
                }else{
                    productInLine *= function.getArguments().get(i) - function.getArguments().get(i2);
                }
            }
            System.out.println("y" + i + ": " + function.getResults().get(i) + "\t\tD" + i + ": " + productInLine);
            sum += function.getResults().get(i) / productInLine;
        }
        System.out.println("Sum: " + sum);
        return sum;
    }
}
