package imageViewer.swing;

import imageViewer.ui.ImageViewer;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {
    private ImageViewer viewer;
    private final ActionListenerFactory factory;

    public ApplicationFrame(ActionListenerFactory factory) {
        super("Image Viewer");
        this.factory = factory;
        this.setSize(1300,750);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createComponents();
        this.setVisible(true);
    }

    public ImageViewer getViewer() {
        return viewer;
    }

    private void createComponents() {
        this.add(createImagePanel());
        this.add(createToolbar(), BorderLayout.SOUTH);
    }

    private JPanel createImagePanel() {
        ImagePanel panel = new ImagePanel();
        viewer = panel;
        return panel;
    }

    private JPanel createToolbar() {
        JPanel panel = new JPanel();
        panel.add(createButton("Prev"));
        panel.add(createButton("Next"));
        return panel;
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener((ActionListener) factory.addAction(label));
        return button;
    }
}