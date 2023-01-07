package template.beverage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class CaffeineBeverage {

    /**
     * 탬플릿(틀) 메소드
     */
    final public void prepareRecipe() {
        boilWater(); // 일반화할 수 있는건 일반화 한다.
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiment();
        }
        System.out.println();
    }

    abstract void brew();

    abstract void addCondiment();

    void boilWater() {
        System.out.println("물 끓임");
    }

    void pourInCup() {
        System.out.println("컵에 따름");
    }

    /**
     * [후크 메소드]
     * 서브 클래스에서 필요할 경우에만 오버라이드를 한다.
     */
    boolean customerWantsCondiments() {
        return true;
    }

    public static class Tea extends CaffeineBeverage {

        @Override
        void brew() {
            System.out.println("찻잎을 우려내는 중");
        }

        @Override
        void addCondiment() {
            System.out.println("레몬을 추가하는 중");
        }
    }

    public static class Coffee extends CaffeineBeverage {

        @Override
        void brew() {
            System.out.println("필터로 커피를 우려내는 중");
        }

        @Override
        void addCondiment() {
            System.out.println("설탕과 우유를 추가하는 중");
        }
    }

    public static class CoffeeWithHook extends CaffeineBeverage {

        @Override
        void brew() {
            System.out.println("필터로 커피를 우려내는 중");
        }

        @Override
        void addCondiment() {
            System.out.println("설탕과 우유를 추가하는 중");
        }

        @Override
        boolean customerWantsCondiments() {
            String input = getInput();
            return "y".equals(input);
        }

        private String getInput() {
            System.out.println("커피에 우유와 설탕을 추가할까? (y/n)");
            String answer;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                answer = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return answer;
        }
    }
}
