/*

* The exercise template contains a class Warehouse, which has the following constructors and methods:

* [public Warehouse(double capacity)] - Creates an empty warehouse, which has the capacity provided
as a parameter; an invalid capacity (<=0) creates a useless warehouse, with the the capacity 0.
* [public double getBalance()] - Returns the balance of the warehouse, i.e. the capacity which is
taken up by the items in the warehouse.
* [public double getCapacity()] - Returns the total capacity of the warehouse 
(i.e. the one that was provided in the constructor).
* [public double howMuchSpaceLeft()] - Returns a value telling how much space is left in the warehouse.
* [public void addToWarehouse(double amount)] - Adds the desired amount to the warehouse; if the amount
is negative, nothing changes, and if everything doesn't fit, then the warehouse is filled up and
the rest is "thrown away" / "overflows".
* [public double takeFromWarehouse(double amount)] - Take the desired amount from the warehouse. The method
returns much we actually get. If the desired amount is negative, nothing changes and we return 0. If
the desired amount is greater than the amount the warehouse contains, we get all there is to take
and the warehouse is emptied.
* [public String toString()] - Returns the state of the object represented as a string like this:
balance = 64.5, space left = 123.5

* The class Warehouse handles the functions related to the amount of a product. Now we want a product name for
the product and a way to handle the name. Let's write ProductWarehouse as a subclass of Warehouse!
First, we'll just create a private object variable for the product name, a constructor, 
and a getter for the name field:

* [public ProductWarehouse(String productName, double capacity)] - Creates an empty product warehouse. The name of the
product and the capacity of the warehouse are provided as parameters.
* [public String getName()] - Returns the name of the product.

* As we can see from the previous example, the toString() inherited by the ProductWarehouse object doesn't
(obviously!) know anything about the product name. Something must be done! Let's also add a setter
for the product name while we're at it:

* [public void setName(String newName)] - sets a new name for the product.
* [public String toString()] - Returns the state of the object represented as a string like this:
Juice: balance = 64.5, space left 123.5

* Sometimes it might be useful to know how the inventory of a product changes over time: Is the inventory often low?
Are we usually at the limit? Are the changes in inventory big or small? Etc.
Thus we should give the ProductWarehouse class the ability to remember
the changes in the amount of a product.

* Let's begin by creating a tool that aids in the desired functionality.

* The storing of the change history could of course have been done using an ArrayList<Double> object in the class ProductWarehouse,
however, we want our own specialized tool for this purpose. The tool should be implemented by encapsulating the
ArrayList<Double> object.

Public constructors and methods of the ChangeHistory class:

* [public ChangeHistory()] - creates an empty ChangeHistory object.
* [public void add(double status)] - adds provided status as the latest amount to remember in the change history.
* [public void clear() - empties the history.
* [public String toString()] - returns the string representation of the change history. The string representation provided by the ArrayList
class is sufficient.

* Build on the ChangeHistory class by adding analysis methods:

* [public double maxValue()] - returns the largest value in the change history. If the history is empty, the method should return zero.
* [public double minValue()] - returns the smallest value in the change history. If the history is empty, the method should return zero.
* [public double average()] - returns the average of the values in the change history. If the history is empty, the method should return zero.

* The methods should not modify the order of the encapsulated list.

* Implement ProductWarehouseWithHistory as a subclass of ProductWarehouse. In addition to all the previous features this new warehouse
also provides services related to the change history of the warehouse inventory. The history is managed using the
ChangeHistory object.

* Public constructors and methods:

* [public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance)] - creates a product warehouse. The product name,
capacity, and initial balance are provided as parameters. Set the initial balance as the initial balance of the warehouse, as well as
the first value of the change history.
* [public String history()] returns the product history like this [0.0, 119.2, 21.2]. Use the string representation of the
ChangeHistory object as is.

* The first version didn't know anything but the initial state of the history. Expand the class with the following methods:

* [public void addToWarehouse(double amount)] - works just like the method in the Warehouse class, but we also record the changed state
to the history. NB: the value recorded in the history should be the warehouse's balance after adding, not the amount added!
* [public double takeFromWarehouse(double amount)] - works just like the method in the Warehouse class, but we also record the changed state
to the history. NB: the value recorded in the history should be the warehouse's balance after removing, not the amount removed!

* Expand the class with the method

* [public void printAnalysis()] - which prints history related information for the product in the way presented in the example.

* Written in : IntelliJ IDEA (With Codota)
* Time: ~1h30' - Class Inheritance

*/

import java.util.ArrayList;

class Warehouse {
    private double balance;
    private final double capacity;

    public Warehouse(double capacity) {
        this.capacity = capacity;
        this.balance = balance;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getSpaceLeft() {
        return this.capacity - this.balance;
    }

    public void addToWarehouse(double amount) {
        if(!(this.balance + amount >= getSpaceLeft())) {
            this.balance += amount;
        }
        else {
            this.balance = this.capacity;
        }
    }

    public double takenFromWarehouse(double amount) {
        if(amount < 0) {
            return 0;
        }
        else {
            if(amount >= this.balance) {
                return this.balance;
            }
            else {
                return amount;
            }
        }
    }

    public String toString() {
        return "Balance: " + getBalance() + " - Space left: " + getSpaceLeft();
    }
}

class ProductWarehouse extends Warehouse {

    private String productName;

    public ProductWarehouse(String name , double capacity) {
        super(capacity);
        this.productName = name;

    }

    public String getName() {
        return this.productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public String toString() {
        return this.productName + ": Balance: " + getBalance() + "- Space left: " + getSpaceLeft();
    }
}

class ChangeHistory {
    private ArrayList<Double> changes;

    public ChangeHistory() {
        changes = new ArrayList<Double>();
    }

    public void addStatus(double status) {
        /*
        * Status parameter is seen as the balance.
        * The ArrayList keeps the balance history.
         */
        changes.add(status);
    }

    public void clearHistory() {
        changes.clear();
    }

    public String toString() {
        String history = "";
        for(Double display: changes) {
            history += display + ", ";
        }
        return "Warehouse balance history: " + history;
    }

    public double maxValue() {
        double highestBalance = 0;
        if(!(changes.isEmpty())) {
            for(Double bal: changes) {
                if(bal > highestBalance) {
                    highestBalance = bal;
                }
            }
        }
        return highestBalance;
    }

    public double minValue() {
        double smallestBalance = 0;
        if(!(changes.isEmpty())) {
            for(Double bal: changes) {
                if(bal < smallestBalance) {
                    smallestBalance = bal;
                }
            }
        }
        return smallestBalance;
    }

    public double averageValue() {
        double totalBalances = 0;
        if(!(changes.isEmpty())) {
            for(Double balances: changes) {
                totalBalances += balances;
            }
        }
        if(changes.isEmpty()) {
            return 0;
        }
        else {
            return totalBalances / changes.size();
        }
    }
}

class ProductWarehouseWithHistory extends ProductWarehouse {
    private String productName;
    private double capacity;
    private double initialBalance;
    private ChangeHistory history;

    public ProductWarehouseWithHistory(String name, double capacity, double initialBalance) {
        super(name, capacity);
        history = new ChangeHistory();
        history.addStatus(initialBalance);
    }

    public String history() {
        return history.toString();
    }

    public void addToWarehouse(double paramAmount) {
        if(!(this.initialBalance + paramAmount >= this.capacity - this.initialBalance)) {
            this.initialBalance += paramAmount;
            history.addStatus(this.initialBalance);
        }
        else {
            this.initialBalance = this.capacity;
            history.addStatus(this.initialBalance);
        }
    }

    public double takenFromWarehouse(double amount) {
        if(amount < 0) {
            return 0;
        }
        else {
            if(amount >= this.initialBalance) {
                history.addStatus(this.initialBalance - amount);
                return this.initialBalance;
            }
            else {
                this.initialBalance -= amount;
                history.addStatus(this.initialBalance);
                return amount;
            }
        }
    }

    public void printAnalysis() {
        System.out.println("Highest balance: " + history.maxValue());
        System.out.println("Lowest balance: " + history.minValue());
        System.out.println("Average: " + history.averageValue());
    }
}
