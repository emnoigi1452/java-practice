import java.util.Scanner;

class Container {
    public int liquidAmount;
    public int liquidLimit;

    public Container() {
        this.liquidAmount = 0;
        this.liquidLimit = 100;
    }

    public int getLiquidAmount() {
        return this.liquidAmount;
    }

    public void add(int amount) {
        if(this.liquidAmount + amount < this.liquidLimit) {
            this.liquidAmount += amount;
        }
        else {
            this.liquidAmount = 100;
        }
    }

    public void remove(int amount) {
        if(this.liquidAmount - amount > 0) {
            this.liquidAmount -= amount;
        }
        else {
            this.liquidAmount = 0;
        }
    }

    public String toString() {
        return liquidAmount + "/" + liquidLimit;
    }
}

class Main {
    public static void main(String[] args) {
        Container ctn = new Container();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Input command: ");
            String cmd = sc.nextLine();
            String[] param = cmd.split(" ");
            if(param.length == 1) {
                if(param[0].equalsIgnoreCase("liquidamount")) {
                    System.out.println(ctn);
                }
                else if(param[0].equalsIgnoreCase("quit")) {
                    System.exit(-1);
                    break;
                }
                else {
                    System.out.println("Unknown command!");
                }
            }
            else if(param.length == 2) {
                if(param[0].equalsIgnoreCase("add")) {
                    ctn.add(Integer.parseInt(param[1]));
                }
                else if(param[0].equalsIgnoreCase("remove")) {
                    ctn.remove(Integer.parseInt(param[1]));
                }
            }
            else {
                System.out.println("Invalid parameters!");
            }
        }
    }
}
