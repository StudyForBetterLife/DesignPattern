package com.design.singleton.boiler;

/**
 * lazy initialization -> 동기화 문제
 */
public class ChocolateBoilerLazy {
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoilerLazy uniqueInstance;

    private ChocolateBoilerLazy() {
        empty = true;
        boiled = false; // 보일러가 비어있을 때만 돌아간다
    }

    public static ChocolateBoilerLazy getInstance() {
        if (uniqueInstance == null) { // 멀티 스레딩 환경에서 최초로 인스턴스가 생성될 시점에 동기화 문제 발생
            uniqueInstance = new ChocolateBoilerLazy();
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
