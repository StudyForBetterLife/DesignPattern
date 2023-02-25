package template.base;

public abstract class AbstractClass {
    final public void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
        hook();
    }

    /**
     * 구상 클래스에서 구현할 메소드
     */
    abstract void primitiveOperation1();

    abstract void primitiveOperation2();

    /**
     * 추상 클래스 내에서 정의되는 메소드. (구상클래스에서 오버라이드 불가)
     */
    final void concreteOperation() {

    }

    /**
     * 템플릿 메소드 속 "후크"
     * 구상 클래스에서 오버라이드가 필수는 아님.
     */
    void hook() {
    }
}
