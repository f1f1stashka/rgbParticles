import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Canvas {
    JFrame frame;
    Graphics frameGraphics;
    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    double scale;
    Point2D cameraPosition;
    Color[] colors;

    Canvas(JFrame frame){
        this.frame = frame;
        this.frameGraphics = frame.getGraphics();
        this.bufferedImage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.bufferedImageGraphics = this.bufferedImage.getGraphics();
        this.scale = 10;
        this.cameraPosition = new Point2D(0, 0);
        this.colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE};
        this.frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                bufferedImage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
                bufferedImageGraphics = bufferedImage.getGraphics();
            }
        });
    }

    public void ClearBackground(){
        this.bufferedImageGraphics.setColor(Color.black);
        this.bufferedImageGraphics.fillRect(0, 0, this.bufferedImage.getWidth(), this.bufferedImage.getHeight());
    }

    public void DrawParticle(Particle particle){
        this.bufferedImageGraphics.setColor(colors[particle.color]);
        this.bufferedImageGraphics.fillRect((int) ((particle.position.x + cameraPosition.x) / scale) + frame.getWidth()/2 - 1, (int) ((particle.position.y + cameraPosition.y) / scale) + frame.getHeight()/2 - 1, 2, 2);
    }
    
    public void DrawParticles(ArrayList<Particle> particles){
        particles.forEach(particle -> {
            this.DrawParticle(particle);
        });
    }

    public void Render(){
        this.frameGraphics.drawImage(this.bufferedImage, 0, 0, null);
    }
}
