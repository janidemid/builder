package main;

import dish.builders.BurgerBuilder;
import dish.builders.OrderBuilder;
import dish.builders.PizzaBuilder;
import dish.dessert.Cake;
import dish.drink.FruitFresh;
import dish.first_dish.Soup;
import dish.ingredient.Ingredient;
import dish.ingredient.IngredientType;
import dish.second_dish.Burger;
import dish.second_dish.Macaroni;
import dish.second_dish.Pizza;
import dish.snack.CheeseSticks;
import dish.snack.Chips;
import jdk.jshell.execution.LoaderDelegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Aplication {

    public static void main(String[] args) throws IOException {
        Order order = new OrderBuilder()
                .addSnack(new CheeseSticks())
                .addDesert(new Cake()).build();

        Order order1 = new OrderBuilder()
                .addFirstDish(new Soup())
                .addSecon_dish(new Macaroni())
                .addDrink(new FruitFresh())
                .build();

        Pizza pizza =makePizza();
        System.out.println(pizza);
        Burger burger = makeBurger();
        System.out.println(burger);
    }

    public static Pizza makePizza() {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("здравствуйте!");
        System.out.println("Выберите основу для пиццы:1 - тонкая, 2 - обычноя, 3 - толстая, 4 - закрытая");

        String doughBase;
        try {
            String answer = reader.readLine();
            switch (answer) {
                case "1":
                    doughBase = "thin";
                    break;
                case "3":
                    doughBase = "lush";
                    break;
                case "4":
                    doughBase = "closed";
                    break;
                default:
                    doughBase = "normal";
                    break;
            }
            pizzaBuilder.setDoughBase(doughBase);
        } catch (IOException e) {
            System.out.println("При выборе основы для пиццы возникла ошибка!");
        }

        try {
            System.out.println("добавьте иенредиент: \n"
                    + Arrays.stream(IngredientType.values()).map(ingredientType -> ingredientType.getId() + " - " + ingredientType.getRuName())
                    .collect(Collectors.joining(", ")));
            System.out.println("Введите \" зватит \" для завершения выбора ингредиентов");
            String answer;
            while (!((answer = reader.readLine()).equals("хватит"))) {
                Ingredient ingredient = new Ingredient(
                        IngredientType.getById(Integer.parseInt(answer)),
                        "our supplier",
                        LocalDateTime.now(),
                        LocalDateTime.MAX);
                pizzaBuilder.addIngredient(ingredient);
            }
        } catch (IOException e) {
            System.out.println("При выборе инридеентов для пиццы возникла ошибка!");
        }

        return pizzaBuilder.build();
    }

    public static Burger makeBurger() throws IOException {
        BurgerBuilder burgerBuilder = new BurgerBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("здравствуйте!");
        System.out.println("Выберите название для бургера");

        String name = reader.readLine();
        burgerBuilder.setName(name);
        try {
            System.out.println("добавьте иенредиент: \n"
                    + Arrays.stream(IngredientType.values()).map(ingredientType -> ingredientType.getId() + " - " + ingredientType.getRuName())
                    .collect(Collectors.joining(", ")));
            System.out.println("Введите \" зватит \" для завершения выбора ингредиентов");
            String answer;
            while (!((answer = reader.readLine()).equals("хватит"))) {
                Ingredient ingredient = new Ingredient(
                        IngredientType.getById(Integer.parseInt(answer)),
                        "our supplier",
                        LocalDateTime.now(),
                        LocalDateTime.MAX);
                burgerBuilder.addIngredient(ingredient);
            }
        } catch (IOException e) {
            System.out.println("При выборе инридиентов для пиццы возникла ошибка!");
        }
        return burgerBuilder.build();
    }
}
