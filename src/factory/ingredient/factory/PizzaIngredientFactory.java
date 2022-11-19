package factory.ingredient.factory;

import factory.ingredient.ingredients.*;
import factory.ingredient.ingredients.Pepperoni;
import factory.ingredient.ingredients.Sauce;
import factory.ingredient.ingredients.Veggies;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClam();
}
