package proxy.virtual;

import java.net.URL;
import java.util.Objects;

public class ImageProxy implements Icon {

    private volatile ImageIcon imageIcon; // volatile: 메인 메모리에 변수 값을 저장하여 멀티 스레드 환경에서의 값 불일치를 해결
    private final URL imageUrl;
    private boolean retrieving;

    public ImageProxy(URL imageUrl) {
        this.imageUrl = imageUrl;
    }

    // synchronized: volatile로 인해 여러 스레드에서 imageIcon에 동시에 접근할 수 있으므로 동기화 처리.
    synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    @Override
    public int getIconWidth() {
        if (Objects.nonNull(imageIcon)) {
            return imageIcon.getIconWidth();
        }
        System.out.println("proxy");
        return 800; // default width
    }

    @Override
    public int getIconHeight() {
        if (Objects.nonNull(imageIcon)) {
            return imageIcon.getIconHeight();
        }
        System.out.println("proxy");
        return 600; // default height
    }

    @Override
    public void paintIcon() {
        if (Objects.nonNull(imageIcon)) {
            imageIcon.paintIcon();
            return;
        }

        if (!retrieving) {
            System.out.println("앨범 커버를 불러오는 중입니다...");
            retrieving = true;

            new Thread(() -> {
                setImageIcon(new ImageIcon(imageUrl));
                imageIcon.paintIcon();
            }).start();
        }
    }
}
