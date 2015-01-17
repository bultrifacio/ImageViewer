package imageViewer;

import imageViewer.swing.ApplicationFrame;
import imageViewer.swing.ActionListenerFactory;
import imageViewer.control.Command;
import imageViewer.control.NextImageCommand;
import imageViewer.control.PrevImageCommand;
import imageViewer.model.Image;
import imageViewer.persistence.FileListLoader;
import imageViewer.persistence.ListLoader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageBrowser {

    private Map<String, Command> commandMap;
    private ApplicationFrame frame;
    private String url;

    public static void main(String[] args) {
        String url = "/Users/juancarlos/Pictures/Fondos";
        new ImageBrowser().execute(url);
    }

    private void execute(String url) {
        this.url = url;
        ListLoader loader = new FileListLoader(url);
        List<Image> list = loader.load();
        frame = new ApplicationFrame(createActionListenerFactory());
        frame.getViewer().setImage(list.get(0));
        createCommandMap();
    }

    private ActionListenerFactory createActionListenerFactory() {
        return new ActionListenerFactory() {
            
            @Override
            public ActionListener addAction(final String action) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Command command = commandMap.get(action);
                        if (command == null) {
                            return;
                        }
                        command.execute();
                    }
                };
            }
        };
    }

    private void createCommandMap() {
        commandMap = new HashMap<>();
        commandMap.put("Prev", new PrevImageCommand(frame.getViewer()));
        commandMap.put("Next", new NextImageCommand(frame.getViewer()));
    }
}