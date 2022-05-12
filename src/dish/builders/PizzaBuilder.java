package dish.builders;

import dish.ingredient.Ingredient;
import dish.second_dish.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {

    private  String name;
    private  List<Ingredient> ingredients;
    private  boolean cheeseBumpers;
    private  String doughBase;


    public  PizzaBuilder(){
        ingredients=new ArrayList<>();
    }

    public PizzaBuilder setName(String name){
        this.name = name;
        return this;
    }

    public PizzaBuilder addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
        return this;
    }

    public PizzaBuilder removeIngredient(Ingredient ingredient){
        this.ingredients.remove(ingredient);
        return this;
    }

    public PizzaBuilder resetIngredients(){
        ingredients = new ArrayList<>();
        return this;
    }

    public PizzaBuilder setCheseBumpers(boolean needChepseBumpers){
        cheeseBumpers=needChepseBumpers;
        return this;
    }

    public PizzaBuilder setDoughBase(String doughBase){
        this.doughBase = doughBase;
        return this;
    }

    public Pizza build(){
        if(name==null || name.isEmpty()){
            name="costumn";
        }
        if(doughBase==null || doughBase.isEmpty()){
            name="defoult";
        }
        if(ingredients.isEmpty()){
            throw new RuntimeException("Попытка создать пустую пицу");
        }
        return new Pizza(name,new ArrayList<>(ingredients),cheeseBumpers,doughBase);
    }
}
