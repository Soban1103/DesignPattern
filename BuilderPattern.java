package Creational;
import java.util.*;

class Sandwich {
    private String bread;
    private ArrayList<String> meats;
    private ArrayList<String> cheeses;
    private ArrayList<String> toppings;

    private Sandwich(SandwichBuilder builder) {
        this.bread = builder.bread;
        this.meats = builder.meats;
        this.cheeses = builder.cheeses;
        this.toppings = builder.toppings;
    }

    public String getBread() {
        return bread;
    }

    public ArrayList<String> getMeats() {
        return meats;
    }

    public ArrayList<String> getCheeses() {
        return cheeses;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bread: ").append(bread).append("\n");
        sb.append("Meats: ").append(meats).append("\n");
        sb.append("Cheeses: ").append(cheeses).append("\n");
        sb.append("Toppings: ").append(toppings).append("\n");
        return sb.toString();
    }

static class SandwichBuilder {
        private String bread;
        private ArrayList<String> meats;
        private ArrayList<String> cheeses;
        private ArrayList<String> toppings;

        public SandwichBuilder() {
            this.meats = new ArrayList<>();
            this.cheeses = new ArrayList<>();
            this.toppings = new ArrayList<>();
        }

        public SandwichBuilder withBread(String bread) {
            this.bread = bread;
            return this;
        }

        public SandwichBuilder addMeat(String meat) {
            meats.add(meat);
            return this;
        }

        public SandwichBuilder addCheese(String cheese) {
            cheeses.add(cheese);
            return this;
        }

        public SandwichBuilder addTopping(String topping) {
            toppings.add(topping);
            return this;
        }

        public Sandwich build() {
            return new Sandwich(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Sandwich sandwich1 = new Sandwich.SandwichBuilder()
                .withBread("Whole wheat")
                .addMeat("Ham")
                .addCheese("Swiss")
                .addTopping("Lettuce")
                .build();
        System.out.println(sandwich1.toString());

        Sandwich sandwich2 = new Sandwich.SandwichBuilder()
                .withBread("White")
                .addMeat("Turkey")
                .addCheese("Cheddar")
                .addTopping("Tomato")
                .addTopping("Mayonnaise")
                .build();
        System.out.println(sandwich2.toString());
    }
}
