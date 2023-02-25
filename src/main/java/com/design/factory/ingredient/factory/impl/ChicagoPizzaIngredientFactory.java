package com.design.factory.ingredient.factory.impl;

import com.design.factory.ingredient.factory.PizzaIngredientFactory;
import com.design.factory.ingredient.ingredients.*;
import com.design.factory.ingredient.ingredients.impl.*;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		return new Veggies[]{ new BlackOlives(),
		                      new Spinach(),
		                      new Eggplant() };
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
