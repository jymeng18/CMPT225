import java.util.Arrays;

//Implement Me
public class HockeyPlayer {

    // Class variables
    private final String name;
    private final int rank;
    private int points;

    // Constructor
    public HockeyPlayer(String name, int rank, int points){
        this.name = name;
        this.rank = rank;
        this.points = points;
    }

    // Bubble sort
    public static void sortRank(HockeyPlayer[] players){
        for(int i = 0; i < players.length - 1; i++){
            for(int j = 0; j < players.length - 1 - i; j++){
                // Compare rank values
                if(players[j].rank > players[j+1].rank){
                    HockeyPlayer temp = players[j];
                    players[j] = players[j+1];
                    players[j+1] = temp;
                }
            }
        }
    }

    public static void sortName(HockeyPlayer[] players){
        for(int i = 0; i < players.length - 1; i++){
            for(int j = 0; j < players.length - 1 - i; j++){
                if(players[j].name.compareTo(players[j+1].name) > 0) {
                    HockeyPlayer temp = players[j];
                    players[j] = players[j+1];
                    players[j+1] = temp;
                }
            }
        }
    }

    public static void printArray(HockeyPlayer[] players){
        for(int i = 0; i < players.length; i++){
            System.out.println(players[i].name + " " + players[i].rank + " " +
            players[i].points);
        }
    }

    public static void main(String[] args){
        HockeyPlayer[] players = {
                new HockeyPlayer("Connor McDavid", 11, 153),
                new HockeyPlayer("Leon Draisaitl", 2, 128),
                new HockeyPlayer("Nathan MacKinnon", 3, 140),
                new HockeyPlayer("Auston Matthews", 6, 107),
                new HockeyPlayer("David Pastrnak", 5, 110),
                new HockeyPlayer("Mikko Rantanen", 4, 105),
                new HockeyPlayer("Artemi Panarin", 7, 120),
                new HockeyPlayer("Nikita Kucherov", 8, 113),
                new HockeyPlayer("Matthew Tkachuk", 10, 109),
                new HockeyPlayer("Cale Makar", 9, 90),
                new HockeyPlayer("Elias Pettersson", 1, 89)
        };
        printArray(players);
        System.out.println();
        System.out.println();
        sortName(players);
        sortRank(players);
        printArray(players);
    }


}
