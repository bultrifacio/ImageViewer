package imageViewer.model;

public abstract class Image {
    private Image nextImage;
    private Image prevImage;
    
    public void setNext(Image image){
        this.nextImage = image;
    }
    public Image getNext(){
        return nextImage;
    }
    public void setPrev(Image image){
        this.prevImage = image;
    }
    public Image getPrev(){
        return prevImage;
    }
    public abstract Bitmap getBitmap();
}
