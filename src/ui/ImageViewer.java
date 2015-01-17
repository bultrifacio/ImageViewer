package imageViewer.ui;
import imageViewer.model.Image;

public interface ImageViewer {

    public void setImage(Image image);

    public Image getImage();

    public void showNext();
 
    public void showPrev();
}
