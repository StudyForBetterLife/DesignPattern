package com.design.singleton.boiler;

/**
 * enum으로 싱글톤을 생성하면
 * 동기화 문제, 클래스 로딩 문제, 리플렉션, 직렬화, 역직렬화 문제를 해결할 수 있다.
 */
public enum ChocolateBoilerEnum {
    UNIQUE_INSTANCE;

    private boolean empty;
    private boolean boiled;

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
    public void drain() {
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

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
