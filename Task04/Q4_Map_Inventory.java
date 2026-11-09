
import java.util.*;

public class Q4_Map_Inventory {
    static class Medicine {
        String code,name;
        Medicine(String c,String n){code=c;name=n;}
        public String toString(){return code+"-"+name;}
    }
    static void test(int n){
        HashMap<String,Medicine> hash=new HashMap<>();
        TreeMap<String,Medicine> tree=new TreeMap<>();
        LinkedHashMap<String,Medicine> linked=new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            String code=String.format("M%05d",i);
            Medicine m=new Medicine(code,"Medicine"+i);
            hash.put(code,m); tree.put(code,m); linked.put(code,m);
        }
        Random r=new Random(11);
        long s=System.nanoTime(); long checksum=0;
        for(int i=0;i<100000;i++) checksum += hash.get(String.format("M%05d",r.nextInt(n))).name.length();
        long hashLookup=System.nanoTime()-s;
        s=System.nanoTime();
        for(int i=0;i<100000;i++) checksum += tree.get(String.format("M%05d",r.nextInt(n))).name.length();
        long treeLookup=System.nanoTime()-s;
        s=System.nanoTime(); int count=0; for(Medicine m:tree.values())count++; long treeReport=System.nanoTime()-s;
        s=System.nanoTime(); count=0; for(Medicine m:linked.values())count++; long linkedReport=System.nanoTime()-s;
        if(checksum==0)System.out.print("");
        System.out.printf("%nMedicines: %d%n",n);
        System.out.printf("HashMap 100k get: %.3f ms%n",hashLookup/1e6);
        System.out.printf("TreeMap 100k get: %.3f ms%n",treeLookup/1e6);
        System.out.printf("TreeMap code-order report: %.3f ms%n",treeReport/1e6);
        System.out.printf("LinkedHashMap insertion-order report: %.3f ms%n",linkedReport/1e6);
        System.out.println("First code-order item: "+tree.firstEntry());
        System.out.println("First insertion-order item: "+linked.entrySet().iterator().next());
    }
    public static void main(String[] args){
        System.out.println("=== HOSPITAL PHARMACY INVENTORY ===");
        System.out.println("Q4: HashMap vs TreeMap vs LinkedHashMap");
        test(100); test(1000); test(10000);
        System.out.println("\nDeployment choice: HashMap for frequent code lookup; TreeMap when natural code order is continuously required.");
        System.out.println("Result: Map choice depends on lookup and ordering requirements.");
    }
}
