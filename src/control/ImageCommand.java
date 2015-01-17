package imageViewer.control;

import imageViewer.ui.ImageViewer;

public abstract class ImageCommand implements Command {
    private final ImageViewer viewer;

    public ImageCommand(ImageViewer viewer) {
        this.viewer = viewer;
    }
    
    public ImageViewer getViewer(){
        return viewer;
    }
}