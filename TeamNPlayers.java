import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        class Player {
            private String name;
            private int goals;

            Player(String name, int goals) {
                this.name = name;
                this.goals = goals;
            }
            Player(String name) {
                this.name = name;
                this.goals = 0;
            }
            String getName() {
                return this.name;
            }
            int getGoals() {
                return this.goals;
            }
        }
        class Team {
            private String name;
            private int goals;
            private int teamSize;
            ArrayList<Player> team = new ArrayList<>();

            Team(String name, int teamSize) {
                this.name = name;
                this.teamSize = teamSize;
                this.goals = 0;
            }
            Team(String name) {
                this.name = name;
                this.teamSize = 5;
                this.goals = 0;
            }
            int getGoals() {
                for(Player p: team) {
                    this.goals += p.goals;
                }
                return this.goals;
            }
            String getName() {
                return this.name;
            }
            void setTeamSize(int size) {
                if(size < 4) {
                    System.out.println("Team size has to be at least 5!");
                }
                else {
                    this.teamSize = size;
                }
            }
            void addPlayers(Player p) {
                if(team.size() < this.teamSize) {
                    team.add(p);
                }
                else {
                    System.out.println("Team reached maximum member count");
                }
            }
            int getTeamSize() {
                return this.teamSize;
            }
            void displayToString() {
                if(team.isEmpty()) {
                    System.out.println("Team has no members");
                }
                else {
                    for(Player p: team) {
                        System.out.println(p.getName() + ", goals: " + p.getGoals());
                    }
                }
            }
        }
        Team team1 = new Team("School's FC Team");
        Player michael = new Player("Michael", 1);
        Player tommy = new Player("Tommy", 2);
        Player david = new Player("David", 4);

        team1.addPlayers(michael);
        team1.addPlayers(tommy);
        team1.addPlayers(david);

        System.out.println("Total team goals: " + team1.getGoals());

    }
}
