class Main {
    public static void main(String[] args) {
        class Counter {
            int num;
            boolean check;

            Counter(int num, boolean check) {
                this.num = num;
                this.check = check;
            }
            Counter(int num) {
                this.num = num;
                this.check = false;
            }
            Counter(boolean check) {
                this.num = 0;
                this.check = check;
            }
            Counter() {
                this.num = 0;
                this.check = false;
            }

            public int value() {
                return this.num;
            }
            public int increase() {
                return this.num += 1;
            }
            public int decrease() {
                if(this.num >= 1) {
                    return this.num -= 1;
                }
                else {
                    return this.num;
                }
            }

            public int increase(int increaseAmount) {
                return this.num += increaseAmount;
            }
            public int decrease(int decreaseAmount) {
                if(this.num >= 1) {
                    return this.num -= decreaseAmount;
                }
                else {
                    return this.num;
                }
            }
        }
    }
}
