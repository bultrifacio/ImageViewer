package imageViewer.control;

import imageViewer.ui.ImageViewer;

public class NextImageCommand extends ImageCommand {

    public NextImageCommand(ImageViewer viewer) {
        super(viewer);
    }

    @Override
    public void execute() {
        this.getViewer().showNext();
    }
}