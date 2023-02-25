package proxy.virtual;

import java.net.URL;

public class ImageIcon implements Icon {

    private final URL imageUrl;
    private final int width;
    private final int height;

    public ImageIcon(URL imageUrl) {
        this.imageUrl = imageUrl;
        this.width = 600;
        this.height = 800;
    }

    @Override
    public int getIconWidth() {
        System.out.println("real");
        return this.width;
    }

    @Override
    public int getIconHeight() {
        System.out.println("real");
        return this.height;
    }

    @Override
    public void paintIcon() {
        System.out.println("(width:" + width + ", height:" + height + " ,URL:" + imageUrl + ") 이미지를 그렸습니다.");
    }
}
