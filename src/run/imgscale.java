package run;
import java.awt.image.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class imgscale {

public BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename) {
    BufferedImage bi = null;
    try {
        ImageIcon ii = new ImageIcon(filename);
        bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    return bi;
}

}
