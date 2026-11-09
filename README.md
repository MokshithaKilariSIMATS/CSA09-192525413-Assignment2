# CSA09-RegisterNumber-Assignment2

## Programming in Java – Assignment 2 (CO2)
### Strings and Collections

**Name:** Mokshitha Kilari  
**Register Number:** ____________________  
**Java Version:** Java 17 or above  
**Repository:** CSA09-<RegisterNumber>-Assignment2

---

## Repository Structure

Each question is stored in a separate task folder as required.

```text
CSA09-RegisterNumber-Assignment2/
├── README.md
├── Task01/
├── Task02/
├── Task03/
├── Task04/
├── Task05/
├── Task06/
└── Task07/
```

Every task folder contains:
- Java source code
- input.txt describing the test data/workload
- output.png showing the terminal-style execution result

---

## Java Version

Check Java installation:

```bash
java -version
javac -version
```

This repository is written for Java 17+.

---

## Task 01 – Building Text Under Load

**Topics:** String, StringBuilder, StringBuffer

**Compile**
```bash
cd Task01
javac Q1_String_Builder_Analysis.java
```

**Run**
```bash
java Q1_String_Builder_Analysis
```

**Result:** Three contrasting workloads compare repeated `+`, `StringBuilder` and `StringBuffer`. The program recommends StringBuilder for per-ticket construction and StringBuffer for a shared mutable log where synchronized mutation is required.

---

## Task 02 – When Is ArrayList an Appropriate Engineering Choice?

**Topics:** ArrayList, LinkedList, ArrayDeque

**Compile**
```bash
cd Task02
javac Q2_List_Comparison.java
```

**Run**
```bash
java Q2_List_Comparison
```

**Result:** ArrayList and LinkedList are compared at 1,000, 10,000 and 50,000 elements. The changed Up Next requirement is evaluated and ArrayDeque is identified as the natural double-ended queue.

---

## Task 03 – Engineer the hashCode–equals Contract

**Topics:** HashSet, equals(), hashCode()

**Compile**
```bash
cd Task03
javac Q3_HashCode_Equals.java
```

**Run**
```bash
java Q3_HashCode_Equals
```

**Result:** A deliberately broken Student class is compared with a corrected implementation. The corrected class uses regNo in both equals() and hashCode(), producing the expected two unique students.

---

## Task 04 – Choosing a Map for a Pharmacy Inventory

**Topics:** HashMap, TreeMap, LinkedHashMap

**Compile**
```bash
cd Task04
javac Q4_Map_Inventory.java
```

**Run**
```bash
java Q4_Map_Inventory
```

**Result:** The three Map implementations are tested with 100, 1,000 and 10,000 medicines. The program demonstrates lookup performance and the natural ordering behavior of TreeMap and LinkedHashMap.

---

## Task 05 – Generic Ranking Component

**Topics:** Generics, Comparable/Comparator concepts, Comparator chaining

**Compile**
```bash
cd Task05
javac Q5_Generic_Leaderboard.java
```

**Run**
```bash
java Q5_Generic_Leaderboard
```

**Result:** A reusable generic Leaderboard is implemented with points, goal difference and name as ranking criteria. The expected ordering is produced.

---

## Task 06 – Priority, Order and Fairness in a Queue

**Topics:** Queue, PriorityQueue, Comparator

**Compile**
```bash
cd Task06
javac Q6_Priority_Triage.java
```

**Run**
```bash
java Q6_Priority_Triage
```

**Result:** Patients are served by lowest severity number first, with arrival order preserved for equal severity. The starvation/fairness issue is also identified.

---

## Task 07 – Diagnose, Redesign and Validate

**Topics:** Diagnosis, redesign, validation, ArrayDeque

**Compile**
```bash
cd Task07
javac Q7_Redesign_ArrayDeque.java
```

**Run**
```bash
java Q7_Redesign_ArrayDeque
```

**Result:** The queue design is diagnosed and redesigned using ArrayDeque for the Up Next requirement. Original and redesigned approaches are measured under the same workload.

---

## Experimental Evidence

The assignment brief requires repeated/averaged measurements and raw experimental data rather than relying on one execution time. The programs therefore execute multiple workload sizes and print measured timings.

The repository also contains the terminal output screenshots for each task.

## Overall Coverage

- String and StringBuilder
- StringBuffer
- Regular-expression/collection context
- ArrayList
- LinkedList
- ArrayDeque
- HashSet
- hashCode–equals contract
- HashMap
- TreeMap
- LinkedHashMap
- Generics
- Comparator
- Comparable design considerations
- PriorityQueue
- Queue fairness
- Diagnosis and redesign

## Author

**Mokshitha Kilari**
