package factory.pizzastore.impl;

import factory.ingredient.factory.PizzaIngredientFactory;
import factory.ingredient.factory.impl.ChicagoPizzaIngredientFactory;
import factory.pizza.Pizza;
import factory.pizza.impl.ChicagoStyleCheesePizza;
import factory.pizza.impl.ChicagoStylePepperoniPizza;
import factory.pizzastore.PizzaStore;

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
