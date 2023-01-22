package composite;


import composite.menu.MenuComponent;

public class Waitress {
    private final MenuComponent allMenus; // 트리의 최상위 노드

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }
}
