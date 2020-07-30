class Main {
    public static void main(String[] args) {
        class Apartment {
            private int rooms;
            private int squareMetres;
            private int pricePerSquareMetres;

            Apartment(int rooms, int squareMetres, int pricePerSquareMetres) {
                this.rooms = rooms;
                this.squareMetres = squareMetres;
                this.pricePerSquareMetres = pricePerSquareMetres;
            }
            boolean larger(Apartment otherApartment) {
                if (this.squareMetres > otherApartment.squareMetres) {
                    return true;
                }
                else {
                    return false;
                }
            }
            int priceDifference(Apartment otherApartment) {
                return Math.abs((otherApartment.squareMetres * otherApartment.pricePerSquareMetres) -
                        (this.squareMetres * this.pricePerSquareMetres));
            }
            boolean moreExpensiveThan(Apartment otherApartment) {
                if(this.squareMetres * this.pricePerSquareMetres > otherApartment.squareMetres * otherApartment.pricePerSquareMetres) {
                    return true;
                }
                else {
                    return false;
                }
            }
         }
    }
}
