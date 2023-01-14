package iterator.iter.impl;

import iterator.iter.Iterator;
import iterator.menu.MenuItem;

import java.util.List;

public class PancakeHouseIterator implements Iterator<MenuItem> {
    private final List<MenuItem> menuItems;
    private int position = 0;

    public PancakeHouseIterator(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return menuItems.size() <= position;
    }

    @Override
    public MenuItem next() {
        return menuItems.get(position++);
    }
}
