class Main {
    public static void main(String[] args) {
        class LyyraCard {
            private double balance;
            private String cardOwner;

            public LyyraCard(double balance, String cardOwner) {
                this.balance = balance;
                this.cardOwner = cardOwner;
            }

            public void display() {
                System.out.println(cardOwner + "'s card has " + this.balance + " euros");
            }
            public void payEconomical() {
                if(this.balance > 1) {
                    this.balance -= 2.5;
                }
            }
            public void payGourmet() {
                if(this.balance > 1) {
                    this.balance -= 4.0;
                }
            }
            public void loadMoney(double amount) {
                if(amount > 0) {
                    this.balance += amount;
                }
            }
            public boolean pay(double amount) {
                if(this.balance >= amount) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        LyyraCard brianCard = new LyyraCard(150, "Brian");
        brianCard.display();
        brianCard.payEconomical();
        brianCard.payGourmet();
        brianCard.loadMoney(50);
        brianCard.display();

        boolean success = brianCard.pay(100);
        System.out.println("Money taken: " + success);

        LyyraCard alexCard = new LyyraCard(10, "Alex");
        for(int i = 0; i < 6; ++i) {
            alexCard.payEconomical();
            alexCard.display();
            if(alexCard.balance == 2.5) {
                alexCard.loadMoney(1);
            }
        }
        boolean failed = alexCard.pay(6);
        System.out.println("Money taken: " + failed);


        class CashRegister {
            private double cashInRegister;
            private int economicalSold;
            private int gourmetSold;

            CashRegister() {
                this.cashInRegister = 1000;
            }
            double payEconomical(double cashGiven) {
                if(cashGiven >= 2.50) {
                    this.cashInRegister += 2.50;
                    this.economicalSold++;
                    return cashGiven - 2.50;
                }
                else {
                    return -1;
                }
            }
            double payGourmet(double cashGiven) {
                if(cashGiven >= 4.0) {
                    this.cashInRegister += 4.0;
                    this.gourmetSold++;
                    return cashGiven - 4.0;
                }
                else {
                    return -1;
                }
            }
            String display() {
                return "Money in register: " + this.cashInRegister + ". \nEconomical lunches sold: "
                        + this.economicalSold + ". \nGourmet lunches sold: " + this.gourmetSold;
            }

            double payEconomical(LyyraCard card) {
                if(card.balance >= 2.50) {
                    this.cashInRegister += 2.50;
                    this.economicalSold++;
                    return card.balance -= 2.50;
                }
                else {
                    return -1;
                }
            }
            double payGourmet(LyyraCard card) {
                if(card.balance >= 4.0) {
                    this.cashInRegister += 4.0;
                    this.gourmetSold++;
                    return card.balance -= 4.0;
                }
                else {
                    return -1;
                }
            }
            double loadMoneyToCard(LyyraCard card, double sum) {
                if(sum >= 1) {
                    card.balance += sum;
                    return this.cashInRegister += sum;
                }
                else {
                    return -1;
                }
            }
        }
    }
}
