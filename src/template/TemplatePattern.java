package template;

import template.abstractlist.MyStringList;

import java.util.List;

import static template.beverage.CaffeineBeverage.*;

public class TemplatePattern {
    public static void main(String[] args) {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();
        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();

        tea.prepareRecipe();
        coffee.prepareRecipe();
        coffeeWithHook.prepareRecipe();

        String[] list = {"a", "b", "c"};
        MyStringList myStringList = new MyStringList(list);
        List<String> strings = myStringList.subList(0, 3);
        System.out.println(strings); // [a, b, c]
    }
}
