import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Warehouse {
    private Map<String, Integer> productPrice;
    private Map<String, Integer> productStock;

    public Warehouse() {
        productPrice = new HashMap<String, Integer>();
        productStock = new HashMap<String, Integer>();
    }

    public void add(String productName, int price, int stock) {
        if(!(productPrice.containsKey(productName))) {
            productPrice.put(productName, price);
            productStock.put(productName, stock);
        }
    }
    public void getStockInfo(String product) {
        if(!(productStock.containsKey(product))) {
            System.out.println("Product doesn't exist in warehouse. Please add it!");
        } else {
            System.out.println(product + " - Amount left: " + productStock.get(product));
        }
    }
    public int getStockValue() {
        int stockVal = 0;
        for(String p: this.productPrice.keySet()) {
            stockVal += productPrice.get(p);
        }
        return stockVal;
    }
    public int price(String product) {
        return productPrice.getOrDefault(product, -99);
    }
    public int stock(String product) {
        return productStock.getOrDefault(product, 0);
    }
    public boolean take(String product) {
        boolean getStatus = true;
        if(!(productStock.get(product) > 0)) {
            productStock.replace(product, productStock.get(product) - 1);
        } else {
            getStatus = false;
        }
        return getStatus;
    }
    public void restock(String product, int stockPile, int price) {
        if(!(productStock.containsKey(product))) {
            System.out.println("Product hasn't been imported. Please add a new product type!");
        } else {
            productStock.replace(product, productStock.get(product) + stockPile);
        }
    }
    public ArrayList<String> products() {
        ArrayList<String> productList = new ArrayList<String>();
        for(String prod: productStock.keySet()) {
            productList.add(prod);
        }
        return productList;
    }
    public void printProducts() {
        for(String s: products()) {
            System.out.print(s + ", ");
        }
    }
    public String toString() {
        return "Warehouse currently holds " + productStock.size() + "products.\n" +
                "Total warehouse stock value: " + getStockValue();
    }
}

class Item {
    private String product;
    private int amount;
    private int unitPrice;

    public Item(String name, int amount, int unitPrice) {
        this.product = name;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }
    public String getName() {
        return product;
    }
    public int getUnitPrice() {
        return unitPrice;
    }
    public int getTotalPrice() {
        return this.unitPrice * this.amount;
    }
    public int getAmount() {
        return amount;
    }
    public void increase() {
        this.amount++;
    }
    public String toString() {
        return getName() + "- Quantity: " + getAmount();
    }
}

class ShoppingCart {
    private HashMap<String, Item> items;
    private int cartValue;

    public ShoppingCart() {
        items = new HashMap<String, Item>();
        this.cartValue = 0;
    }
    public void addToCart(String product, Item i) {
        items.put(product, i);
    }
    public int getCartValue() {
       this.cartValue = calculateCart();
       return this.cartValue;
    }
    public int calculateCart() {
        int cartValue = 0;
        if(items.isEmpty()) {
            return 0;
        } else {
            for(String i: items.keySet()) {
                cartValue += items.get(i).getTotalPrice();
            }
            return cartValue;
        }
    }
    public void printCart() {
        for(String display: items.keySet()) {
            System.out.println(items.get(display));
        }
    }
}
