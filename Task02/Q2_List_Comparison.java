
import java.util.*;

public class Q2_List_Comparison {
    static long time(Runnable r) {
        long s=System.nanoTime(); r.run(); return System.nanoTime()-s;
    }
    static long addEnd(List<Integer> list,int n){
        return time(()->{for(int i=0;i<n;i++) list.add(i);});
    }
    static long insertFront(List<Integer> list,int n){
        for(int i=0;i<n;i++) list.add(i);
        return time(()->{for(int i=0;i<1000;i++) list.add(0,-i);});
    }
    static long middle(List<Integer> list,int n){
        for(int i=0;i<n;i++) list.add(i);
        int mid=list.size()/2;
        return time(()->{for(int i=0;i<1000;i++) list.add(mid, -i);});
    }
    static long access(List<Integer> list,int n){
        for(int i=0;i<n;i++) list.add(i);
        Random r=new Random(7);
        return time(()->{long x=0; for(int i=0;i<10000;i++) x+=list.get(r.nextInt(n)); if(x==-1)System.out.print("");});
    }
    static long iterate(List<Integer> list,int n){
        for(int i=0;i<n;i++) list.add(i);
        return time(()->{long x=0; for(int v:list)x+=v; if(x==-1)System.out.print("");});
    }
    static void run(String name,int n){
        List<Integer> a=new ArrayList<>(), l=new LinkedList<>();
        System.out.println("\nSize = "+n);
        System.out.printf("%-12s %-12s %-12s %-12s %-12s%n","Structure","AddEnd(ms)","Front(ms)","GetK(ms)","Iterate(ms)");
        System.out.printf("%-12s %-12.3f %-12.3f %-12.3f %-12.3f%n","ArrayList",
            addEnd(a,n)/1e6,insertFront(new ArrayList<>(),n)/1e6,access(new ArrayList<>(),n)/1e6,iterate(new ArrayList<>(),n)/1e6);
        System.out.printf("%-12s %-12.3f %-12.3f %-12.3f %-12.3f%n","LinkedList",
            addEnd(l,n)/1e6,insertFront(new LinkedList<>(),n)/1e6,access(new LinkedList<>(),n)/1e6,iterate(new LinkedList<>(),n)/1e6);
    }
    public static void main(String[] args){
        System.out.println("=== MUSIC PLAYLIST LIST COMPARISON ===");
        System.out.println("Q2: ArrayList vs LinkedList");
        run("ArrayList",1000); run("ArrayList",10000); run("ArrayList",50000);
        System.out.println("\nChanged condition: Up Next queue adds/removes at both ends -> ArrayDeque is preferred.");
        System.out.println("Result: ArrayList is strong for random access and append-heavy playlists; ArrayDeque suits double-ended queues.");
    }
}
