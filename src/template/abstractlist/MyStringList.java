package template.abstractlist;

import java.util.AbstractList;

/**
 * 탬플릿 메소드 활용 : AbstractList
 * <p>
 * subList 메소드에서 사용되는 get(), size() 메소드를 오버라이딩한다
 */
public class MyStringList extends AbstractList<String> {

    private final String[] list;

    public MyStringList(String[] list) {
        this.list = list;
    }

    @Override
    public String get(int index) {
        return list[index];
    }

    @Override
    public int size() {
        return list.length;
    }

    public String set(int index, String item) {
        String old = list[index];
        list[index] = item;
        return old;
    }
}
