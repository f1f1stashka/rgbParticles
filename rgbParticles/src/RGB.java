import java.util.Random;

public class RGB {
    public double r;
    public double g;
    public double b;

    RGB(double r, double g, double b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static RGB Random(){

        Random random = new Random();
        return new RGB(
                random.nextDouble(0,1) > 0.5 ? 1 : -1,
                random.nextDouble(0,1) > 0.5 ? 1 : -1,
                random.nextDouble(0,1) > 0.5 ? 1 : -1);
    }

    public void print(){
        System.out.println("(" + r + ", " + g + ", " + b + ")");
    }
}
