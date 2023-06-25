package pl.maciek;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class CustomTools {
    //stworzenie JLabel ze zdjęciem

    public static JLabel loadImage(String resource) {
        BufferedImage image;
        try {
            InputStream inputStream = CustomTools.class.getResourceAsStream(resource);
            image = ImageIO.read(inputStream);
            return new JLabel(new ImageIcon(image));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }
}
