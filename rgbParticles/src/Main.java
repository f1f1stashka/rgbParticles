import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.PrintStream;
import java.util.Random;

public class Main {
    public static Point2D oldCursorPos = new Point2D(0, 0);
    public static boolean running = true;
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("RGB Particles");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Canvas mainCanvas = new Canvas(frame);

        RGB rD = RGB.Random();
        RGB gD = RGB.Random();
        RGB bD = RGB.Random();
        rD.print();
        gD.print();
        bD.print();
        Simulation mainSimulation = new Simulation(rD, gD, bD);
        Random random = new Random();
        for(int i = 0; i < 1000; i++){
            mainSimulation.AddParticle(new Particle(
                    new Point2D(random.nextInt(-5, 5),
                    random.nextInt(-5, 5)),
                    random.nextInt(0, 3),
                    1));
        }

        frame.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                mainCanvas.scale += e.getWheelRotation() * 0.1;
                if(mainCanvas.scale <= 0){
                    mainCanvas.scale = 0.1;
                }
            }
        });

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                oldCursorPos = new Point2D(e.getX(), e.getY());
                if(e.getButton() == MouseEvent.BUTTON3){
                    running = !running;
                }
            }
        });

        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mainCanvas.cameraPosition.x -= (oldCursorPos.x - e.getX()) * mainCanvas.scale;
                mainCanvas.cameraPosition.y -= (oldCursorPos.y - e.getY()) * mainCanvas.scale;
                oldCursorPos = new Point2D(e.getX(), e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        while(true){
            FullRender(mainSimulation, mainCanvas);
            if(running){
                for(int i = 0; i < 10; i++){
                    mainSimulation.Step();
                    mainSimulation.ApplyAllFriction(10);
                }
            }


            //Thread.sleep(1000/60);
            //System.out.println(mainSimulation.particles.get(0).velocity.x + " " + mainSimulation.particles.get(0).velocity.y);
        }


    }

    public static void FullRender(Simulation sim, Canvas canvas){
        canvas.ClearBackground();
        canvas.DrawParticles(sim.particles);
        canvas.Render();
    }
}