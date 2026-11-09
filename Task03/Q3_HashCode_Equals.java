
import java.util.*;

class Student {
    private final String regNo;
    private final String name;
    Student(String regNo,String name){this.regNo=regNo;this.name=name;}
    public boolean equals(Object o){
        if(this==o)return true;
        if(!(o instanceof Student))return false;
        return regNo.equals(((Student)o).regNo);
    }
    // Deliberately correct implementation for the final design.
    public int hashCode(){return Objects.hash(regNo);}
    public String toString(){return regNo+" "+name;}
}

public class Q3_HashCode_Equals {
    static void brokenExperiment(){
        class BrokenStudent {
            String regNo,name;
            BrokenStudent(String r,String n){regNo=r;name=n;}
            public boolean equals(Object o){
                return o instanceof BrokenStudent && regNo.equals(((BrokenStudent)o).regNo);
            }
            public String toString(){return regNo+" "+name;}
        }
        Set<BrokenStudent> s=new HashSet<>();
        s.add(new BrokenStudent("192311001","Arun"));
        s.add(new BrokenStudent("192311002","Divya"));
        s.add(new BrokenStudent("192311001","Arun"));
        System.out.println("Broken class set size: "+s.size()+" (duplicate can survive because hashCode differs by identity)");
    }
    static void correctExperiment(){
        Set<Student> s=new HashSet<>();
        s.add(new Student("192311001","Arun"));
        s.add(new Student("192311002","Divya"));
        s.add(new Student("192311001","Arun"));
        System.out.println("Correct class set size: "+s.size());
        System.out.println("Set contents: "+s);
    }
    public static void main(String[] args){
        System.out.println("=== EVENT ATTENDANCE DE-DUPLICATION ===");
        System.out.println("Q3: hashCode-equals Contract");
        System.out.println();
        System.out.println("Prediction: broken implementation may retain duplicate logical students.");
        brokenExperiment();
        correctExperiment();
        System.out.println("\nRule: if a.equals(b) is true, a.hashCode() must equal b.hashCode().");
        System.out.println("Result: final Student class satisfies the contract.");
    }
}
