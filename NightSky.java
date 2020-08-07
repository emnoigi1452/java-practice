class Main {
  public static class NightSky {
    public double density;
    public int height;
    public int width;

    public int stars;

    public NightSky(double density, int height, int width) {
      this.density = density;
      this.height = height;
      this.width = width;
      this.stars = 0;
    }

    public void print() {
      for(int i = 0; i < this.height; i++) {
        for(int j = 0; j < this.width; j++) {
          int random = (int)(Math.random() * ((100 - 1) + 1)) + 1;
          if(random <= (this.density * 100)) {
            System.out.print("*");
            this.stars++;
          }
          else {
            System.out.print(" ");
          }
        }
        System.out.println();
      }
    }
    public int getStarCount() {
      return this.stars;
    }
  }

  public static void main(String[] args) {
    NightSky sky = new NightSky(0.1, 10, 40);
    sky.print();
    System.out.println("Number of stars: " + sky.getStarCount());
  }
}
