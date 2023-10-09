public class Particle {
    Point2D position;

    Point2D velocity;

    int color;

    double mass;

    Particle(Point2D position, int color, double mass){
        this.position = position;
        this.velocity = new Point2D(0, 0);
        this.color = color;
        this.mass = mass;
    }

    public double GetForceToParticle(Particle particle, RGB rD, RGB gD, RGB bD){
        if(this.color == 0){
            switch (particle.color) {
                case 0 -> {
                    return rD.r;
                }
                case 1 -> {
                    return rD.g;
                }
                case 2 -> {
                    return rD.b;
                }
            }
        }else if(this.color == 1){
            switch (particle.color) {
                case 0 -> {
                    return gD.r;
                }
                case 1 -> {
                    return gD.g;
                }
                case 2 -> {
                    return gD.b;
                }
            }
        }else if(this.color == 2){
            switch (particle.color) {
                case 0 -> {
                    return bD.r;
                }
                case 1 -> {
                    return bD.g;
                }
                case 2 -> {
                    return bD.b;
                }
            }
        }

        return 0.0;
    }

    public void ApplyFriction(double friction){
        this.velocity.DivideByNumber(friction);
    }

    public void ApplyVelocity(){
        this.position.Add(Point2D.MultipitionByNumber(this.velocity, 1));
    }
}
