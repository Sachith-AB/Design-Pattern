interface Coffee {
    String getDescription();
    Float getCost();
}

class BasicCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public Float getCost() {
        return 50.00f;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    public Float getCost() {
        return decoratedCoffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public Float getCost() {
        return decoratedCoffee.getCost() + 10.0f;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }
    @Override
    public Float getCost() {
        return decoratedCoffee.getCost() + 5.0f;
    }
}

class CreamDecorator extends CoffeeDecorator {
    public CreamDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Cream";
    }
    @Override
    public Float getCost() {
        return decoratedCoffee.getCost() + 15.0f;
    }
}

public class DecoratorDemo {

    public static void main(String[] args) {
        Coffee basic = new BasicCoffee();
        System.out.println(basic.getDescription() + " -> " + basic.getCost());

        Coffee milkCoffee = new MilkDecorator(basic);
        System.out.println(milkCoffee.getDescription() + " -> " + milkCoffee.getCost());

        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println(sugarMilkCoffee.getDescription() + " -> " + sugarMilkCoffee.getCost());

        Coffee deluxe = new CreamDecorator(new SugarDecorator(new MilkDecorator(new BasicCoffee())));
        System.out.println(deluxe.getDescription() + " -> " + deluxe.getCost());
    }
}