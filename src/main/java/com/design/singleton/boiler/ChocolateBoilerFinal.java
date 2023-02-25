package com.design.singleton.boiler;

/**
 * public static final field
 */
public class ChocolateBoilerFinal {
    private boolean empty;
    private boolean boiled;

    // 싱글톤 인스턴스를 처음부터 초기화한다.
    private static final ChocolateBoilerFinal uniqueInstance = new ChocolateBoilerFinal();

    private ChocolateBoilerFinal() {
        empty = true;
        boiled = false; // 보일러가 비어있을 때만 돌아간다
    }

    public static ChocolateBoilerFinal getInstance() {
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
