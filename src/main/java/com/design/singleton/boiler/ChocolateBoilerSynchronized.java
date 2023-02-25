package com.design.singleton.boiler;

/**
 * lazy initialization & synchronized
 */
public class ChocolateBoilerSynchronized {
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoilerSynchronized uniqueInstance;

    private ChocolateBoilerSynchronized() {
        empty = true;
        boiled = false; // 보일러가 비어있을 때만 돌아간다
    }

    // 인스턴스가 최초로 초기화 되는 시점에만 동기화가 필요하지만,
    // 이 방식은 항상 동기화가 일어나 속도 문제가 있다.
    public static synchronized ChocolateBoilerSynchronized getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ChocolateBoilerSynchronized();
        }

        return uniqueInstance;
    }

    /**
     * 보일러가 비어있을 경우에만 재료를 넣는다
     */
    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    /**
     * 보일러가 가득차있고, 다 끓여진 상태에서만 초콜릿을 흘려보낸다
     */
    public void  drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    /**
     * 보일러가 가득차있고, 아직 끓지않은 상태에서만 끓인다
     */
    public void boil() {
       if (!isEmpty() && !isBoiled()) {
           boiled = true;
       }
    }
    public boolean isEmpty()  {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
