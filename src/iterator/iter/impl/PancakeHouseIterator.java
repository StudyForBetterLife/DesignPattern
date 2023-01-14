package iterator.iter.impl;

import iterator.menu.vo.MenuItem;

import java.util.Iterator;
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
