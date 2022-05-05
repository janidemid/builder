package main;

import dish.builders.OrderBuilder;
import dish.dessert.Cake;
import dish.drink.FruitFresh;
import dish.first_dish.Soup;
import dish.second_dish.Macaroni;
import dish.snack.CheeseSticks;
import dish.snack.Chips;

public class Aplication {

    public static void main(String[] args) {
        Order order = new OrderBuilder()
                .addSnack(new CheeseSticks())
                .addDesert(new Cake()).build();

        Order order1 = new OrderBuilder()
                .addFirstDish(new Soup())
                .addSecon_dish(new Macaroni())
                .addDrink(new FruitFresh())
                .build();
    }
}
