import java.util.ArrayList;

class Main {
    public static class Person {
        public String phoneNum;
        public String name;

        public Person(String name, String phoneNum) {
            this.name = name;
            this.phoneNum = phoneNum;
        }
        public String getName() {
            return this.name;
        }
        public String getPhoneNum() {
            return this.phoneNum;
        }
    }
    public static class PhoneBook {
        ArrayList<Person> phoneBook = new ArrayList<>();
        public void add(String name, String phoneNum) {
            Person p = new Person(name, phoneNum);
            phoneBook.add(p);
        }
        public void printAll() {
            for(Person display: phoneBook) {
                System.out.println(display.getName() + ", phone num: " + display.getPhoneNum());
            }
        }
        public String search(String name) {
            boolean found = false;
            int k = 0;
            for(k = 0; k < phoneBook.size(); k++) {
                if(phoneBook.get(k).getName().equalsIgnoreCase(name)) {
                    found = true;
                }
            }
            if(found) {
                return phoneBook.get(k).getPhoneNum();
            }
            else {
                return "Number not found!";
            }
        }
    }

    public static void main(String[] args) {
        Person brian = new Person("Brain", "0961582013");
        PhoneBook pb1 = new PhoneBook();
        pb1.add("Brian", "0961582013");
    }
}
