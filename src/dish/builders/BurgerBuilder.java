package dish.builders;

import dish.ingredient.Ingredient;
import dish.second_dish.Burger;
import dish.second_dish.Pizza;

import java.util.ArrayList;
import java.util.List;

public class BurgerBuilder {
    private String name;
    private List<Ingredient> ingredients;
    public BurgerBuilder(){
        ingredients= new ArrayList<>();

    }
    public BurgerBuilder setName(String name){
        this.name=name;
        return this;
    }
    public BurgerBuilder addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
        return this;
    }
    public BurgerBuilder resetIngredients(){
        ingredients = new ArrayList<>();
        return this;
    }
    public Burger build(){
        if(name == null || name.isEmpty()){
            name = "costumn";
        }
        if(ingredients.isEmpty()){
            throw new RuntimeException("Попытка создать пустой бургер");
        }
        return new Burger(name, new ArrayList<>(ingredients));
    }
}
