package iterator.menu;

import iterator.iter.Iterator;
import iterator.iter.impl.PancakeHouseIterator;

import java.util.ArrayList;
import java.util.List;

public class PancakeHouseMenu {
    private final List<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        addItem("A set", "스크램블 에그 & 토스트 & 펜케이크", true, 2.99);
        addItem("B set", "레귤러 펜케이크", false, 2.99);
        addItem("C set", "블루베리 펜케이크", true, 3.99);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        menuItems.add(new MenuItem(name, description, vegetarian, price));
    }

    @Deprecated
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public Iterator<MenuItem> createIterator() {
        return new PancakeHouseIterator(menuItems);
    }
}
