package composite;

import composite.menu.Menu;
import composite.menu.MenuComponent;
import composite.menu.MenuItem;

public class CompositePattern {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("pancake house menu", "아침 메뉴");
        MenuComponent dinerMenu = new Menu("diner menu", "점심 메뉴");
        MenuComponent cafeMenu = new Menu("cafe menu", "저녁 메뉴");
        MenuComponent dessertMenu = new Menu("dessert menu", "디저트 메뉴");
        MenuComponent coffeeMenu = new Menu("COFFEE MENU", "Stuff to go with your afternoon coffee");

        MenuComponent allMenu = new Menu("all menu", "전체 메뉴");

        allMenu.add(pancakeHouseMenu);
        allMenu.add(dinerMenu);
        allMenu.add(cafeMenu);
        pancakeHouseMenu.add(new MenuItem(
                "K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs and toast",
                true,
                2.99));


        dinerMenu.add(new MenuItem(
                "Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true,
                2.99));

        allMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem(
                "Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla icecream",
                true,
                1.59));

        cafeMenu.add(new MenuItem(
                "Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true,
                3.99));

        cafeMenu.add(coffeeMenu); // cafe 메뉴 하위에 coffee 메뉴
        coffeeMenu.add(new MenuItem(
                "Bagel",
                "Flavors include sesame, poppyseed, cinnamon raisin, pumpkin",
                false,
                0.69));
        coffeeMenu.add(new MenuItem(
                "Biscotti",
                "Three almond or hazelnut biscotti cookies",
                true,
                0.89));
        Waitress waitress = new Waitress(allMenu);
        waitress.printMenu();
    }
}
