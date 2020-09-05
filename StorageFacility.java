/*
* Your task is creating a class called StorageFacility that can be used to keep track of storage units
and their contents. The class is to implement the following methods:

* [public void add(String unit, String item)] - adds the parameter item to the storage unit that is
also given as a parameter.
* [public ArrayList<String> contents(String storageUnit)] - returns a list that contains all the items in the storage unit indicated
by the parameter. If there is no such storage unit or it contains no items, the method should return an empty list.

* [public void remove(String storageUnit, String item)] - removes the given item from the given storage unit.
NB! Only removes one item — if there are several items with the same name, the rest still remain.
If the storage unit would be empty after the removal, the method also removes the unit.
* [public ArrayList<String> storageUnits()] - returns the names of the storage units as a list.
NB! Only the units that contain items are listed.

*/

import java.util.ArrayList;
import java.util.HashMap;

class StorageFacility {
    public ArrayList<String> units;
    public HashMap<String, ArrayList<String>> unitList;

    public StorageFacility() {
        unitList = new HashMap<String, ArrayList<String>>();
    }

    public void addItem(String unit, String item) {
        if(!(this.unitList.containsKey(unit))) {
            if(this.unitList.get(unit).contains(item)) {
                System.out.println("This item already exist in unit " + unit);
            }
            else {
                this.unitList.put(unit, new ArrayList<>());
                this.unitList.get(unit).add(item);
            }
        }
        else {
            System.out.println("This unit already exist in the storage!");
        }
    }

    public ArrayList<String> contentsList(String unit) {
        ArrayList<String> thisUnitContents = new ArrayList<String>();
        if(this.unitList.containsKey(unit)) {
            for(String units: this.unitList.get(unit)) {
                thisUnitContents.add(units);
            }
        }
        return thisUnitContents;
    }

    public void removeItem(String storageParam, String itemParam) {
        if(!(this.unitList.get(storageParam).contains(itemParam))) {
            System.out.println("This storage doesn't contain this item!");
        }
        else {
            for(int i = 0; i < unitList.get(storageParam).size(); i++) {
                if(unitList.get(storageParam).get(i).equalsIgnoreCase(itemParam)) {
                    this.unitList.get(storageParam).remove(i);
                    break;
                }
            }
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> units = new ArrayList<String>();
        for(String unit: this.unitList.keySet()) {
            units.add(unit);
        }
        return units;
    }
}
