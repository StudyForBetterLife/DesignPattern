package com.design.factory.pizzastore.impl;

import com.design.factory.ingredient.factory.PizzaIngredientFactory;
import com.design.factory.ingredient.factory.impl.NYPizzaIngredientFactory;
import com.design.factory.pizzastore.PizzaStore;
import com.design.factory.pizza.Pizza;
import com.design.factory.pizza.impl.NYStyleCheesePizza;
import com.design.factory.pizza.impl.NYStylePepperoniPizza;

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
