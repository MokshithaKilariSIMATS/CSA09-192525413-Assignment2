
import java.util.*;

class Patient {
    final String name; final int severity; final long arrival;
    Patient(String name,int severity,long arrival){this.name=name;this.severity=severity;this.arrival=arrival;}
    public String toString(){return name+"(S"+severity+")";}
}

public class Q6_Priority_Triage {
    private long counter=0;
    private final PriorityQueue<Patient> queue =
        new PriorityQueue<>(Comparator.comparingInt((Patient p)->p.severity)
            .thenComparingLong(p->p.arrival));

    void admit(String name,int severity){queue.add(new Patient(name,severity,counter++));}
    Patient next(){return queue.poll();}

    public static void main(String[] args){
        Q6_Priority_Triage er=new Q6_Priority_Triage();
        System.out.println("=== HOSPITAL EMERGENCY TRIAGE ===");
        System.out.println("Q6: PriorityQueue and Fair Arrival Ordering");
        System.out.println();
        er.admit("Ravi",3); er.admit("Meena",1); er.admit("John",3);
        er.admit("Asha",5); er.admit("Kumar",1); er.admit("Lata",2);
        StringBuilder order=new StringBuilder(); Patient p;
        while((p=er.next())!=null) order.append(p).append(' ');
        System.out.println("Treatment order: "+order.toString().trim());
        System.out.println("Arrival counter: equal-severity patients are served in arrival order.");
        System.out.println("Fairness note: repeated critical arrivals can starve minor cases; an aging rule can increase waiting patients' effective priority.");
        System.out.println("Result: PriorityQueue enforces severity-first treatment with FIFO tie-breaking.");
    }
}
