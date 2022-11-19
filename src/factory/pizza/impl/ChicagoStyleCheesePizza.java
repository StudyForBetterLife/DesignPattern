package factory.pizza.impl;

import factory.ingredient.factory.PizzaIngredientFactory;
import factory.pizza.Pizza;

public class ChicagoStyleCheesePizza extends Pizza {

	private final PizzaIngredientFactory pizzaIngredientFactory;

	public ChicagoStyleCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
		this.pizzaIngredientFactory = pizzaIngredientFactory;
	}


	@Override
	public void prepare() {
		System.out.println("준비 중:" + name);
		dough = pizzaIngredientFactory.createDough();
		sauce = pizzaIngredientFactory.createSauce();
		cheese = pizzaIngredientFactory.createCheese();
		clam = pizzaIngredientFactory.createClam();
		pepperoni = pizzaIngredientFactory.createPepperoni();
	}

	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
