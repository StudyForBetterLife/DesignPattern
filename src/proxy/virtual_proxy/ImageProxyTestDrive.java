package proxy.virtual_proxy;

import java.net.URL;

public class ImageProxyTestDrive {

  public static void main(String[] args) throws Exception {
    ImageProxy proxy = new ImageProxy(new URL("http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg"));
    System.out.println(proxy.getIconHeight());
    System.out.println(proxy.getIconWidth());
    proxy.paintIcon();

    Thread.sleep(100L);
    System.out.println("-----------------------");

    System.out.println(proxy.getIconHeight());
    System.out.println(proxy.getIconWidth());
    proxy.paintIcon();
  }
}
