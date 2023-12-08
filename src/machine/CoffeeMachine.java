package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public int water; // ml
    public int waterMin;
    public int milk; // ml
    public int milkMin;
    public int beans; // g
    public int beansMin;
    public int requestedCups; // of coffee
    public int cups;
    public int money;
    public int price;
    public String choice;
    public String action;
    public String enoughResources;
    public String notEnough;

    Scanner scanner = new Scanner(System.in);

    public void numberOfCoffees(int count) {
        water = 200;
        milk = 50;
        beans = 15;

        System.out.println("For " + count + " cups of coffee you will need: ");
        System.out.println(count * water + " ml of water");
        System.out.println(count * milk + " ml of milk");
        System.out.println(count * beans+ " g of coffee beans");
        return;

    }

    public void amounts() {
        System.out.println("Write how many ml of water the coffee machine has: ");
        water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        requestedCups = scanner.nextInt();
    }

    public void currentState() {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " ml of water ");
        System.out.println(milk + " ml of milk ");
        System.out.println(beans + " g of coffee beans ");
        System.out.println(cups + " disposable cups ");
        System.out.println("$" + money + " of money ");
    }

    public void writeAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scanner.next();
        switch(action) {
            case "buy":
                buy(choice);
                writeAction();
                break;
            case "fill":
                fillMachine();
                writeAction();
                break;
            case "take":
                System.out.println("I gave you " + money + "$");
                money = 0;
                writeAction();
                break;
            case "remaining":
                currentState();
                writeAction();
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("This is not a valid choice.");
                writeAction();
                break;
        }
    }

    public void resourcesCheck(int waterMin, int milkMin, int beansMin, int price) {
        String enoughResources = "I have enough resources, making you a coffee! ";
        String notEnough = "Sorry, not enough ";
        if (water < waterMin) {
            System.out.println(notEnough + "water");
        } else if (milk < milkMin) {
            System.out.println(notEnough + "milk");
        } else if (beans < beansMin) {
            System.out.println(notEnough + "beans");
        } else if (cups < 1) {
            System.out.println(notEnough + "cups");
        } else {
            System.out.println(enoughResources);
            water -= waterMin;
            milk -= milkMin;
            beans -= beansMin;
            cups--;
            money += price;
        }
    }

    public void espresso() {
        int waterMin = 250;
        int milkMin = 0;
        int beansMin = 16;
        int price = 4;
        resourcesCheck(waterMin, milkMin, beansMin, price);
    }

    public void latte() {
        int waterMin = 350;
        int milkMin = 75;
        int beansMin = 20;
        int price = 7;
        resourcesCheck(waterMin, milkMin, beansMin, price);
    }

    public void cappuccino() {
        int waterMin = 200;
        int milkMin = 100;
        int beansMin = 12;
        int price = 6;
        resourcesCheck(waterMin, milkMin, beansMin, price);
    }

    public void buy(String choice) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuchino, back - to main menu: ");
        choice = scanner.next();
        switch (choice) {
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
            case "back": // to main menu
                break;
            default:
                System.out.println("This is not a valid choice.");
                writeAction();
                break;
        }
    }

    public void fillMachine() {
        System.out.println("Write how many ml of water you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        cups += scanner.nextInt();
    }

    public int cupsPossible(int water, int milk, int beans) {
        int cups = 0;
        while ((water >= 200) && (milk >= 50) && (beans >= 15)) {
            cups++;
            water -= 200;
            milk -= 50;
            beans -= 15;
        }
        return cups;
    }

    public void cupsCheck(int requestedCups, int cupsTotal) {
        int extra = cupsTotal - requestedCups;
        if (requestedCups < cupsTotal) {
            System.out.println("Yes, I can make that amount of coffee (and even " + extra + " more than that) ");
        } else if (requestedCups == cupsTotal) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println("No, I can make only " + cupsTotal + " cup(s) of coffee");
        }

    }

    public static void main(String[] args) {
        /*
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
        */

        //Scanner scanner = new Scanner(System.in);

        /*
        System.out.println("Write how many cups of coffee you will need:");
        int number = scanner.nextInt();
        */
        CoffeeMachine classObj = new CoffeeMachine();
        //classObj.numberOfCoffees(number);
        /*
        int water = 0;
        int milk = 0;
        int beans = 0;
        int requestedCups = 0;
        int cupsTotal = 0;
        classObj.amounts();
        water = classObj.water;
        milk = classObj.milk;
        beans = classObj.beans;
        requestedCups = classObj.requestedCups;
        cupsTotal = classObj.cupsPossible(water, milk, beans);
        classObj.cupsCheck(requestedCups, cupsTotal);
        */

        classObj.water = 400;
        classObj.milk = 540;
        classObj.beans = 120;
        classObj.cups = 9;
        classObj.money = 550;
        String action;

        // classObj.currentState();
        classObj.writeAction();
        // classObj.currentState();

    }
}