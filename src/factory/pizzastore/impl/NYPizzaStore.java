package factory.pizzastore.impl;

import factory.ingredient.factory.PizzaIngredientFactory;
import factory.ingredient.factory.impl.NYPizzaIngredientFactory;
import factory.pizza.Pizza;
import factory.pizza.impl.NYStyleCheesePizza;
import factory.pizza.impl.NYStylePepperoniPizza;
import factory.pizzastore.PizzaStore;

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(Pizza.PizzaType pizzaType) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();

        if (Pizza.PizzaType.CHEESE.equals(pizzaType)) {
            pizza = new NYStyleCheesePizza(pizzaIngredientFactory);
            pizza.setName("뉴욕 스타일 치즈 피자");
        } else if (Pizza.PizzaType.PEPPERONI.equals(pizzaType)) {
            pizza = new NYStylePepperoniPizza(pizzaIngredientFactory);
            pizza.setName("뉴욕 스타일 페퍼로니 피자");
        }
        return pizza;
    }
}
