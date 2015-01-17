package imageViewer.persistence;

import imageViewer.model.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileListLoader implements  ListLoader {
    private String url;

    public FileListLoader(String url) {
        this.url = url;
    }

    @Override
    public List<Image> load() {
        return linkImages(loadImages());
    }

    private List<Image> loadImages() {
        List<Image> list = new ArrayList<>();
        for (String file : new File(url).list()) {
            list.add(new ProxyImage(new FileImageLoader(url + "/" + file)));
        }
        return list;
    }

    private List<Image> linkImages(List<Image> list) {
        for (int i = 0; i < list.size(); i++) {
            Image image = list.get(i);
            image.setNext(list.get((i + 1) % list.size()));
            image.setPrev(list.get((i + list.size() - 1) % list.size()));
        }
        return list;
    }

}
