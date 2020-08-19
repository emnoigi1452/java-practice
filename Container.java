import java.util.ArrayList;

class Thing {
    public String name;
    public int weight;

    public Thing(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return getName() + " (" + getWeight() + " kg)";
    }
}

class Suitcase {
    public ArrayList<Thing> things;
    public int weightLimit;

    public Suitcase(int weightLimit) {
        this.weightLimit = weightLimit;
        things = new ArrayList<Thing>();
        ;           }

    public int getWeightLimit() {
        return weightLimit;
    }

    public int getSuitcaseWeight() {
        int weight = 0;
        for(Thing itemWeight: things) {
            weight += itemWeight.getWeight();
        }
        return weight;
    }

    public void addThing(Thing thing) {
        if(!(getSuitcaseWeight() + thing.getWeight() > this.weightLimit)) {
            things.add(thing);
        }
    }

    public int getThings() {
        return things.size();
    }

    public String toString() {
        if(getThings() == 0) {
            return "Empty suitcase (0 kg)";
        }
        else if(getThings() == 1) {
            return "1 thing (" + getSuitcaseWeight() + " kg)";
        }
        else {
            return getThings() + " (" + getSuitcaseWeight() + " kg)";
        }
    }

    public void printSuitcase() {
        for(Thing display: things) {
            System.out.println(display.getName() + " (" + display.getWeight() + " kg)");
        }
    }

    public Thing getHeaviestThing() {
        Thing heaviest = new Thing(things.get(0).getName(), things.get(0).getWeight());
        for(Thing compare: things) {
            if(compare.getWeight() > heaviest.getWeight()) {
                heaviest = compare;
            }
        }
        return heaviest;
    }
}

class Container {
    public ArrayList<Suitcase> cases;
    public int weightLimit;

    public Container(int weightLimit) {
        this.weightLimit = weightLimit;
        cases = new ArrayList<Suitcase>();
    }

    public int getContainerWeight() {
        int weight = 0;
        for(Suitcase caseWeight: cases) {
            weight += caseWeight.getSuitcaseWeight();
        }
        return weight;
    }

    public void addCase(Suitcase suitcase) {
        if(!(getContainerWeight() + suitcase.getSuitcaseWeight() > this.weightLimit)) {
            cases.add(suitcase);
        }
    }

    public int getCases() {
        return cases.size();
    }

    public String toString() {
        if(getCases() == 0) {
            return "Empty container (0 kg)";
        }
        else if(getCases() == 1) {
            return "1 suitcase (" + getContainerWeight() + " kg)";
        }
        else {
            return getCases() + " suitcases (" + getContainerWeight() + " kg)";
        }
    }

    public void printThings() {
        for(Suitcase suitcase: cases) {
            for(Thing things: suitcase.things) {
                System.out.println(things.getName() + " (" + things.getWeight() + " kg)");
            }
        }
    }
}

class Main {
    public static void addBricks(Container container) {
        for(int i = 1; i <= 100; i++) {
            Thing brick = new Thing("Brick", i);
            Suitcase suitcase = new Suitcase(100);
            suitcase.addThing(brick);

            container.addCase(suitcase);
        }
    }

    public static void main(String[] args) {
        Container container = new Container(1000);
        addBricks(container);

        System.out.println(container);
    }
}
