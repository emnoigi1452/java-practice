import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static void input(ArrayList<Integer> list, Scanner sc) {
        System.out.println("Input grades (Press -1 to stop)");
        int num = 0;
        while(true) {
            num = Integer.parseInt(sc.nextLine());
            if(num == -1) {
                System.out.println("Finished!");
                break;
            }
            else {
                if(num >= 0) {
                    list.add(num);
                }
            }
        }
    }
    static double getAvg(ArrayList<Integer> nums) {
        double total = 0;
        for(Integer grade: nums) {
            total += grade;
        }
        return total / nums.size();
    }
    static double getAvgPassed(ArrayList<Integer> nums) {
        double total = 0;
        int pCount = 0;
        for(Integer grade: nums) {
            if(grade >= 50) {
                total += grade;
                pCount++;
            }
        }
        return total / pCount;
    }
    static String passRate(ArrayList<Integer> grades) {
        double totalPassed = 0;
        for(Integer g: grades) {
            if(g >= 50) {
                totalPassed++;
            }
        }
        return totalPassed / grades.size() * 100 + "%";
    }
    static int getPointRating(int p) {
        if(p < 50) {
            return 0;
        }
        else if(p < 60) {
            return 1;
        }
        else if(p < 70) {
            return 2;
        }
        else if(p < 80) {
            return 3;
        }
        else if(p < 90) {
            return 4;
        }
        else {
            return 5;
        }
    }
    static void gradeDistribution(ArrayList<Integer> gradeList) {
        String fail = "0: ";
        String t1 = "1: ";
        String t2 = "2: ";
        String t3 = "3: ";
        String t4 = "4: ";
        String t5 = "5: ";
        
        for(Integer grade: gradeList) {
            switch(getPointRating(grade)) {
                case 0:
                    fail += "*";
                    break;
                case 1:
                    t1 += "*";
                    break;
                case 2:
                    t2 += "*";
                    break;
                case 3:
                    t3 += "*";
                    break;
                case 4:
                    t4 += "*";
                    break;
                case 5:
                    t5 += "*";
                    break;
            }
        }

        System.out.println(fail);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
    }
}
