import java.util.ArrayList;
import java.util.List;

public class Simulation {
    RGB rD;
    RGB gD;
    RGB bD;

    ArrayList<Particle> particles;

    Simulation(RGB rD, RGB gD, RGB bD){
        this.rD = rD;
        this.gD = gD;
        this.bD = bD;
        this.particles = new ArrayList<Particle>();
    }

    public void AddParticle(Particle p){
        particles.add(p);
    }

    public void CalcAllPartilces(){
        this.particles.forEach(particle1 -> {
            this.particles.forEach(particle2 -> {
                double distance = Point2D.Distance(particle1.position, particle2.position);
                if (distance == 0) {
                    return;
                }
                double pForce = particle1.GetForceToParticle(particle2, rD, gD, bD);

                particle1.velocity.x -= Math.signum(particle1.position.x - particle2.position.x) * pForce / distance * particle2.mass / particle1.mass;
                particle1.velocity.y -= Math.signum(particle1.position.y - particle2.position.y) * pForce / distance * particle2.mass / particle1.mass;
                //System.out.println(particle1.velocity.x);
            });
        });
    }

    public void ApplyAllVelocity(){
        particles.forEach(particle -> {
            particle.ApplyVelocity();
            //particle.position.Loop(new Point2D(400, 400));
        });
    }

    public void ApplyAllFriction(double friction){
        particles.forEach(particle -> {
            particle.ApplyFriction(friction);
        });
    }

    public void Step(){
        this.CalcAllPartilces();
        this.ApplyAllVelocity();
    }
}
