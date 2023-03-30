import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class StickerGenerate {
    
    public void newSticker (InputStream inputStream, String nameFileMovie) throws Exception{

        // read image
        //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_2.jpg").openStream();
            BufferedImage imageOrigin = ImageIO.read(inputStream);
        
        // create new image + footer size for add text.
           int width = imageOrigin.getWidth();
           int height = imageOrigin.getHeight();
           int newHeight = height + 400;    
    
           BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        
        // copy origim image for new image
            Graphics2D graphics = (Graphics2D) newImage.getGraphics();
            graphics.drawImage(imageOrigin, 0, 0, null);
        
        // Font config
            Font newFont = new Font(Font.SANS_SERIF, Font.BOLD, 150);
            graphics.setFont(newFont);

        // write words on the new image
            width = (width/2)-(150/2);
            graphics.drawString("*-*", width , newHeight - 150);

        // write imagem on the file
            ImageIO.write(newImage, "png", new File(nameFileMovie));
        }
    
}
