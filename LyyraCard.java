class Main {
    static class LyyraCard {
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
    }
    public static void main(String[] args) {
        LyyraCard brianCard = new LyyraCard(150, "Brian");
        brianCard.display();
        brianCard.payEconomical();
        brianCard.payGourmet();
        brianCard.loadMoney(50);
        brianCard.display();

        LyyraCard alexCard = new LyyraCard(10, "Alex");
        for(int i = 0; i < 6; ++i) {
            alexCard.payEconomical();
            alexCard.display();
            if(alexCard.balance == 2.5) {
                alexCard.loadMoney(1);
            }
        }
    }
}
