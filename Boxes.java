import java.util.ArrayList;
import java.util.Objects;

abstract class Box {

    public abstract void add(Item i);

    public void add(ArrayList<Item> iList) {
        for(Item i: iList) {
            Box.this.add(i);
        }
    }

    public abstract boolean isInBox(Item i);
}

class Item {
    private String name;
    private int weight;

    public Item(String paramName, int paramWeight) {
        this.name = paramName;
        this.weight = paramWeight;
    }
    public Item(String paramName) {
        this.name = paramName;
        this.weight = 0;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return weight == item.weight &&
                Objects.equals(name, item.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }
}

class BoxWithMaxWeight extends Box {
    private int maxWeight;
    private ArrayList<Item> itemList;

    public BoxWithMaxWeight(int weightLimit) {
        this.maxWeight = weightLimit;
        this.itemList = new ArrayList<Item>();
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    @Override
    public void add(Item i) {
        int countWeight = 0;
        for(Item itemArray: itemList) {
            countWeight += itemArray.getWeight();
        }
        if(countWeight + i.getWeight() <= this.maxWeight) {
            this.itemList.add(i);
        }
    }

    @Override
    public boolean isInBox(Item i) {
        boolean inBox = false;
        for(Item list: itemList) {
            if(list.equals(i)) {
                inBox = true;
                break;
            } else {
                inBox = false;
            }
        }
        return inBox;
    }
}

class MisplacingBox extends Box {
    private ArrayList<Item> misplace;
    private int actions;

    public MisplacingBox() {
        this.misplace = new ArrayList<Item>();
        this.actions = 0;
    }

    @Override
    public void add(Item i) {
        this.misplace.add(i);
        this.actions++;
    }

    public int getActions() {
        return actions;
    }

    @Override
    public boolean isInBox(Item i) {
        return false;
    }
}
