package dish.second_dish;

import dish.ingredient.Ingredient;
import dish.type.SecondDish;

import java.util.List;

public class Burger implements SecondDish {
    private final String name;
    private final List<Ingredient> ingredients;

    public Burger(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "\nname='" + name + '\'' +
                "\n, ingredients=" + ingredients +
                '}';
    }
}
