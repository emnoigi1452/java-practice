import java.util.ArrayList;

class Main {
    static void smartCombine(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> combined) {
        combined.addAll(list1);
        combined.addAll(list2);
        for (int i = 0; i < combined.size(); ++i) {
            for(int j = i +1; j < combined.size(); ++j) {
                if(combined.get(i).equals(combined.get(j))) {
                    combined.remove(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> combined = new ArrayList<Integer>();

        list1.add(5);
        list1.add(3);
        list1.add(8);

        list2.add(7);
        list2.add(5);
        list2.add(9);

        smartCombine(list1, list2, combined);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(combined);
    }
}
