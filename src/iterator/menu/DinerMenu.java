package iterator.menu;

import iterator.iter.Iterator;
import iterator.iter.impl.DinerMenuIterator;

public class DinerMenu {
    private static final int MAX_ITEM = 3;
    private int numOfItems = 0;
    private final MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEM];
        addItem("A set", "스크램블 에그 & 토스트 & 펜케이크", true, 2.99);
        addItem("B set", "레귤러 펜케이크", false, 2.99);
        addItem("C set", "블루베리 펜케이크", true, 3.99);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        final MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numOfItems >= MAX_ITEM) {
            System.err.println("메뉴가 가득차 더 이상 추가가 불가능합니다");
        } else {
            menuItems[numOfItems++] = menuItem;
        }
    }

    @Deprecated
    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public Iterator<MenuItem> createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}
