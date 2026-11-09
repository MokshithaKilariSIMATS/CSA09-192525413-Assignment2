
import java.util.*;

public class Q7_Redesign_ArrayDeque {
    static long benchmarkList(int n){
        LinkedList<Integer> q=new LinkedList<>();
        long s=System.nanoTime();
        for(int i=0;i<n;i++) q.addLast(i);
        for(int i=0;i<n;i++) q.removeFirst();
        return System.nanoTime()-s;
    }
    static long benchmarkDeque(int n){
        ArrayDeque<Integer> q=new ArrayDeque<>();
        long s=System.nanoTime();
        for(int i=0;i<n;i++) q.addLast(i);
        for(int i=0;i<n;i++) q.removeFirst();
        return System.nanoTime()-s;
    }
    public static void main(String[] args){
        System.out.println("=== DAY-4 DESIGN CHALLENGE ===");
        System.out.println("Q7: Diagnose, Redesign and Validate");
        System.out.println();
        System.out.println("Selected limitation: a LinkedList is convenient for a queue but stores each element in a node with link overhead.");
        System.out.println("Design objective: preserve O(1) amortized end operations while reducing per-element node overhead and improving locality.");
        System.out.println("Redesign: ArrayDeque for the Up Next / double-ended queue.");
        System.out.println();
        System.out.printf("%-12s %-18s %-18s%n","Size","LinkedList(ms)","ArrayDeque(ms)");
        for(int n:new int[]{10000,100000,500000}){
            System.out.printf("%-12d %-18.3f %-18.3f%n",n,benchmarkList(n)/1e6,benchmarkDeque(n)/1e6);
        }
        System.out.println();
        System.out.println("Complexity: LinkedList add/remove at ends O(1); ArrayDeque add/remove at ends O(1) amortized.");
        System.out.println("Trade-off: ArrayDeque is not intended for indexed random access.");
        System.out.println("Final decision: use ArrayDeque for the Up Next queue; keep ArrayList for index-heavy playlist editing.");
        System.out.println("Result: redesign directly addresses the changed requirement without unnecessary scanning or shifting.");
    }
}
