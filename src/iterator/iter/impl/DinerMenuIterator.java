package iterator.iter.impl;

import iterator.iter.Iterator;
import iterator.menu.MenuItem;

public class DinerMenuIterator implements Iterator<MenuItem> {
    private final MenuItem[] menuItems;
    private int position = 0;

    public DinerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    @Override
    public boolean hasNext() {
        return !(position >= menuItems.length || menuItems[position] == null);
    }

    @Override
    public MenuItem next() {
        return menuItems[position++];
    }
}
