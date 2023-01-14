package iterator.menu;

import iterator.iter.Iterator;

import java.util.List;

public class Waitress {
    private final DinerMenu dinerMenu;
    private final PancakeHouseMenu pancakeHouseMenu;

    public Waitress(DinerMenu dinerMenu, PancakeHouseMenu pancakeHouseMenu) {
        this.dinerMenu = dinerMenu;
        this.pancakeHouseMenu = pancakeHouseMenu;
    }

    public void printMenuBefore() {
        List<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();
        MenuItem[] lunchItems = dinerMenu.getMenuItems();

        // enhanced for loop 을 사용해도 된다.
        System.out.println("아침메뉴");
        for (MenuItem menuItem : breakfastItems) {
            System.out.println(menuItem.getName());
        }

        System.out.println("점심메뉴");
        for (MenuItem lunchItem : lunchItems) {
            System.out.println(lunchItem.getName());
        }
    }

    public void printMenuAfter() {
        System.out.println("아침메뉴");
        printMenuInternal(pancakeHouseMenu.createIterator());
        System.out.println("점심메뉴");
        printMenuInternal(dinerMenu.createIterator());
    }

    private void printMenuInternal(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem next = iterator.next();
            System.out.println(next.getName());
        }
    }
}
