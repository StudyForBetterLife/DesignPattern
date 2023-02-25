package com.design.factory.pizzastore.impl;

import com.design.factory.ingredient.factory.PizzaIngredientFactory;
import com.design.factory.ingredient.factory.impl.ChicagoPizzaIngredientFactory;
import com.design.factory.pizzastore.PizzaStore;
import com.design.factory.pizza.Pizza;
import com.design.factory.pizza.impl.ChicagoStyleCheesePizza;
import com.design.factory.pizza.impl.ChicagoStylePepperoniPizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(Pizza.PizzaType pizzaType) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();
        if (Pizza.PizzaType.CHEESE.equals(pizzaType)) {
            pizza = new ChicagoStyleCheesePizza(pizzaIngredientFactory);
            pizza.setName("시카고 스타일 치즈 피자");
        } else if (Pizza.PizzaType.PEPPERONI.equals(pizzaType)) {
            pizza = new ChicagoStylePepperoniPizza(pizzaIngredientFactory);
            pizza.setName("시카고 스타일 페퍼로니 피자");
        }
        return pizza;
    }
}
