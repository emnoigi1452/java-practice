class Main {
    public static void main(String[] args) {
        class MyDate {
            int day;
            int month;
            int year;

            MyDate(int day, int month, int year) {
                this.day = day;
                this.month = month;
                this.year = year;
            }

            void increaseOneDay() {
                if(this.day == 30) {
                    this.day = 0;
                    this.month++;
                }
                else {
                    this.day++;
                }
            }
            void increaseDate(int amount) {
                this.day += amount;
                if(this.day > 30) {
                    int backup = this.day;
                    this.month += (this.day / 30);
                    this.day = backup % 30;
                }
            }
            void timeHandler() {
                if(month > 12) {
                    int backup = this.month;
                    this.year += (this.month / 12);
                    this.month = backup % 12;
                }
            }
            void display() {
                String dayString;
                String monthString;
                if(this.day < 10) {
                    dayString = "0" + Integer.toString(this.day);
                }
                else {
                    dayString = Integer.toString(this.day);
                }

                if(this.month < 10) {
                    monthString = "0" + Integer.toString(this.month);
                }
                else {
                    monthString = Integer.toString(this.month);
                }
                System.out.println(dayString + "/" + monthString + "/" + this.year);
            }
        }
        MyDate date = new MyDate(12, 1, 2018);
        date.increaseOneDay();
        date.display();

    }
}
