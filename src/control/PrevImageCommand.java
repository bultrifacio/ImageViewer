package imageViewer.control;

import imageViewer.ui.ImageViewer;

public class PrevImageCommand extends ImageCommand {

    public PrevImageCommand(ImageViewer viewer) {
        super(viewer);
    }

    @Override
    public void execute() {
        this.getViewer().showPrev();
    }
}