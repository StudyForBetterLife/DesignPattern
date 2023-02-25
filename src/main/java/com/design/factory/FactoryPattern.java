package com.design.factory;

import com.design.factory.pizza.Pizza;
import com.design.factory.pizzastore.impl.ChicagoPizzaStore;
import com.design.factory.pizzastore.impl.NYPizzaStore;

public class FactoryPattern {
    public static void main(String[] args) {
        final NYPizzaStore nyPizzaStore = new NYPizzaStore();
        final Pizza pizza = nyPizzaStore.orderPizza(Pizza.PizzaType.CHEESE);
        System.out.println(pizza.toString());

        final ChicagoPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        final Pizza pizza1 = chicagoPizzaStore.orderPizza(Pizza.PizzaType.PEPPERONI);
        System.out.println(pizza1.toString());
    }
}
