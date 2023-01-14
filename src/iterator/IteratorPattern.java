package iterator;

import iterator.menu.DinerMenu;
import iterator.menu.PancakeHouseMenu;
import iterator.menu.Waitress;

public class IteratorPattern {
    public static void main(String[] args) {
        DinerMenu dinerMenu = new DinerMenu();
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        Waitress waitress = new Waitress(dinerMenu, pancakeHouseMenu);
        waitress.printMenuAfter();
    }


}
