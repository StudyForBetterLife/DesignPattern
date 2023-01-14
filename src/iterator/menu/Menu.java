package iterator.menu;


import iterator.menu.vo.MenuItem;

import java.util.Iterator;

public interface Menu {
    Iterator<MenuItem> createIterator();
}
