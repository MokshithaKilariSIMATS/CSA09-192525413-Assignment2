
import java.util.*;

class Team {
    final String name; final int points; final int goalDiff;
    Team(String name,int points,int goalDiff){this.name=name;this.points=points;this.goalDiff=goalDiff;}
    public String toString(){return name+"("+points+","+goalDiff+")";}
}

class Leaderboard<T> {
    private final List<T> items=new ArrayList<>();
    private final Comparator<? super T> order;
    Leaderboard(Comparator<? super T> order){this.order=order;}
    void add(T item){items.add(item);}
    List<T> ranking(){
        List<T> copy=new ArrayList<>(items);
        copy.sort(order);
        return copy;
    }
}

public class Q5_Generic_Leaderboard {
    public static void main(String[] args){
        System.out.println("=== INTER-COLLEGE SPORTS LEADERBOARD ===");
        System.out.println("Q5: Generics, Comparator and Reusable Ranking");
        System.out.println();

        Comparator<Team> byRank =
            Comparator.comparingInt((Team t)->t.points).reversed()
            .thenComparingInt(t->t.goalDiff).reversed()
            .thenComparing(t->t.name);

        Leaderboard<Team> board=new Leaderboard<>(byRank);
        board.add(new Team("Panthers",9,4));
        board.add(new Team("Eagles",9,6));
        board.add(new Team("Cobras",6,1));
        board.add(new Team("Bisons",9,4));

        System.out.println("Ranking: "+board.ranking());
        System.out.println("Bisons is above Panthers because points tie, goal difference ties, then Bisons < Panthers alphabetically.");
        System.out.println("Result: Generic Leaderboard works with a reusable multi-field Comparator.");
    }
}
