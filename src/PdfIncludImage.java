import com.itextpdf.text.Image;

public class PdfIncludImage {


    private Image image;
    // incloud page number
    private int overContent;
    private int absolutePositionX;
    private int absolutePositionY;
    // pdf image colnum width
    private float fixWidth;
    // pdf image colnum height
    private int fixHieght;
    // pdf scale
    private float scale;


    public PdfIncludImage(Image image, int overContent, int absolutePositionX, int absolutePositionY, int fixWidth,
                          int fixHieght) {
        super();
        this.image = image;
        this.overContent = overContent;
        this.absolutePositionX = absolutePositionX;
        this.absolutePositionY = absolutePositionY;
        this.fixWidth = (float) fixWidth;
        this.fixHieght = fixHieght;
        this.scale = (float) fixWidth / fixHieght;
    }

    public Image getScaleImage() {
        float fix = (float) 0.0;
        if (image.getWidth() / image.getHeight() > this.scale) {
            //set scale by width
            fix = image.getWidth() / fixWidth;
        } else {
            //set scale by height
            fix = image.getHeight() / fixHieght;
        }
        image.scaleAbsolute(image.getWidth() / fix, image.getHeight() / fix);
        image.setAbsolutePosition(absolutePositionX, absolutePositionY);
        return image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getOverContent() {
        return overContent;
    }

    public void setOverContent(int overContent) {
        this.overContent = overContent;
    }

    public int getAbsolutePositionX() {
        return absolutePositionX;
    }

    public void setAbsolutePositionX(int absolutePositionX) {
        this.absolutePositionX = absolutePositionX;
    }

    public int getAbsolutePositionY() {
        return absolutePositionY;
    }

    public void setAbsolutePositionY(int absolutePositionY) {
        this.absolutePositionY = absolutePositionY;
    }

    public float getFixWidth() {
        return fixWidth;
    }

    public void setFixWidth(float fixWidth) {
        this.fixWidth = fixWidth;
    }

    public int getFixHieght() {
        return fixHieght;
    }

    public void setFixHieght(int fixHieght) {
        this.fixHieght = fixHieght;
    }

    public float getScale() {
        return fixWidth / fixHieght;
    }


}
