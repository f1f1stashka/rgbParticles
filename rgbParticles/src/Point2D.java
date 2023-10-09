public class Point2D {
    public double x;
    public double y;

    Point2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void Add(Point2D addPoint){
        this.x += addPoint.x;
        this.y += addPoint.y;
    }

    public void Substract(Point2D substractPoint){
        this.x -= substractPoint.x;
        this.y -= substractPoint.y;
    }

    public void MultipyByNumber(double number){
        this.x *= number;
        this.y *= number;
    }

    public void Loop(Point2D bound){
        if(x > 0){
            int divX = (int) (this.x / bound.x);
            this.x -= divX * bound.x;
        }else if(x < 0){
            int divX = (int) (this.x / bound.x);
            this.x = bound.x - (this.x - (divX * bound.x));
        }

        if(y > 0){
            int divY = (int) (this.y / bound.y);
            this.y -= divY * bound.y;
        }else if(y < 0){
            int divY = (int) (this.y / bound.y);
            this.y = bound.y - (this.y - (divY * bound.y));
        }
    }

    public void Clamp(Point2D bound){
        if(this.x > bound.x){
            this.x = bound.x;
        }else if(this.x < 0){
            this.x = 0;
        }

        if(this.y > bound.y){
            this.y = bound.y;
        }else if(this.y < 0){
            this.y = 0;
        }
    }

    public static Point2D MultipitionByNumber(Point2D p, double number){
        return new Point2D(p.x * number, p.y * number);
    }

    public void DivideByNumber(double number){
        this.x /= number;
        this.y /= number;
    }

    public static double Distance(Point2D p1, Point2D p2){
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
