package com.design.factory.pizza.impl;

import com.design.factory.ingredient.factory.PizzaIngredientFactory;
import com.design.factory.pizza.Pizza;

public class NYStylePepperoniPizza extends Pizza {

	private final PizzaIngredientFactory pizzaIngredientFactory;

	public NYStylePepperoniPizza(PizzaIngredientFactory pizzaIngredientFactory) {
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
}
