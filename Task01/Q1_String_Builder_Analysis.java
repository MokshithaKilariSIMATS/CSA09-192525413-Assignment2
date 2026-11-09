
import java.util.*;

public class Q1_String_Builder_Analysis {
    static String buildPlus(int fields) {
        String s = "";
        for (int i=1;i<=fields;i++) s += "F"+i+"=value"+i+";";
        return s;
    }
    static String buildBuilder(int fields) {
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=fields;i++) sb.append("F").append(i).append("=value").append(i).append(";");
        return sb.toString();
    }
    static String buildBuffer(int fields) {
        StringBuffer sb = new StringBuffer();
        for (int i=1;i<=fields;i++) sb.append("F").append(i).append("=value").append(i).append(";");
        return sb.toString();
    }
    static long measure(java.util.function.IntFunction<String> fn, int fields, int tickets) {
        long start=System.nanoTime();
        long checksum=0;
        for(int t=0;t<tickets;t++) checksum += fn.apply(fields).length();
        long end=System.nanoTime();
        if(checksum==0) System.out.print("");
        return end-start;
    }
    public static void main(String[] args) {
        int[] fields={5,50,200};
        int[] tickets={1000,10000,10000};
        System.out.println("=== RAILWAY E-TICKET STRING BUILDING ===");
        System.out.println("Q1: String vs StringBuilder vs StringBuffer");
        System.out.println();
        System.out.printf("%-12s %-12s %-16s %-16s %-16s%n","Fields","Tickets","String +","StringBuilder","StringBuffer");
        for(int i=0;i<fields.length;i++){
            long a=measure(x->buildPlus(x),fields[i],tickets[i]);
            long b=measure(x->buildBuilder(x),fields[i],tickets[i]);
            long c=measure(x->buildBuffer(x),fields[i],tickets[i]);
            System.out.printf("%-12d %-12d %-16.3f %-16.3f %-16.3f%n",
                    fields[i],tickets[i],a/1_000_000.0,b/1_000_000.0,c/1_000_000.0);
        }
        System.out.println();
        System.out.println("Prediction: StringBuilder should scale better for repeated appends.");
        System.out.println("Recommendation: StringBuilder per ticket; StringBuffer for a shared mutable log.");
        System.out.println("Result: Repeated concatenation creates more intermediate immutable String objects.");
    }
}
