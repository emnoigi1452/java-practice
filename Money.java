class Main {
    public static class Money {
        public int euros;
        public int cents;

        public Money(int euros, int cents) {
            this.euros = euros;
            this.cents = cents;
            if(this.cents >= 100) {
                this.euros += this.cents / 100;
                this.cents /= 100;
            }
        }
        public Money(int euros) {
            this.euros = euros;
            this.cents = 0;
        }

        public int getEuros() {
            return this.euros;
        }
        public int getCents() {
            return this.cents;
        }

        public Money add(Money added) {
            Money bal = new Money(this.euros, this.cents);
            bal.euros += added.euros;
            bal.cents += added.cents;

            if(bal.cents >= 100) {
                bal.euros += bal.cents / 100;
                bal.cents %= 100;
            }

            return bal;
        }

        public boolean isLess(Money otherBalance) {
            if(otherBalance.euros < this.euros) {
                return true;
            }
            else if(otherBalance.euros == this.euros && otherBalance.cents < this.cents) {
                return true;
            }
            else {
                return false;
            }
        }

        public Money remove(Money decreased) {
            Money bal = new Money(this.euros, this.cents);
            bal.euros -= decreased.euros;
            bal.cents -= decreased.cents;

            if(bal.cents < 0) {
                bal.euros -= Math.abs(bal.cents / 100);
                bal.cents = Math.abs(bal.cents % 100);
            }

            return bal;
        }

        public void display() {
            if(cents < 10) {
                System.out.println(this.euros + ".0" + this.cents);
            }
            else {
                System.out.println(this.euros + "." + this.cents);
            }
        }
    }
}
