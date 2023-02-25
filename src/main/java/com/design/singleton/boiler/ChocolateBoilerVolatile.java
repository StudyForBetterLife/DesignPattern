package com.design.singleton.boiler;

/**
 * lazy initialization & volatile
 */
public class ChocolateBoilerVolatile {
    private boolean empty;
    private boolean boiled;

    private volatile static ChocolateBoilerVolatile uniqueInstance;

    private ChocolateBoilerVolatile() {
        empty = true;
        boiled = false; // 보일러가 비어있을 때만 돌아간다
    }

    public static ChocolateBoilerVolatile getInstance() {
        if (uniqueInstance == null) {
            // 인스턴스가 최초로 초기화되는 시점에만 동기화가 일어난다.
            // 다만 java 5 버전 이하의 JVM에서는 volatile 키워드가 제대로 동작하지 않는 이슈가 있다.
            synchronized (ChocolateBoilerVolatile.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new ChocolateBoilerVolatile();
                }
            }
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
