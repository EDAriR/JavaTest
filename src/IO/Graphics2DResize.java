package IO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Graphics2DResize {
    public static void main(String[] args) throws IOException {

        String imgPath ="./TEXeTFjBTR.jpeg";
        String type = "jpg";
        int width = 400;
        int height= 400;
        Graphics2D g = null;
        try {
            File file = new File(imgPath);
            System.out.println(file.exists());
            System.out.println(file.length());
            BufferedImage img = ImageIO.read(file);

            System.out.println(img.getWidth());
            System.out.println(img.getHeight());
//            int imgWidth = img.getWidth();
//            int imgHeight = img.getHeight();
//            if (imgWidth*height < imgHeight*width) {
//                width = imgWidth*height/imgHeight;
//            } else {
//                height = imgHeight*width/imgWidth;
//            }
//            int imageType = "png".equalsIgnoreCase(type) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
//            BufferedImage newImage = new BufferedImage(width, height,
//                    imageType);
//            g = newImage.createGraphics();
//            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//                    RenderingHints.VALUE_INTERPOLATION_BICUBIC);
//            g.setColor(Color.WHITE);
//            g.fillRect(0,0,width,height);
////			g.clearRect(0, 0, width, height);
//            g.drawImage(img, 0, 0, width, height, null);
//            ImageIO.write( newImage,type, new File(imgPath) );
        } finally {
            if(g != null)
                g.dispose();
        }
    }
}
