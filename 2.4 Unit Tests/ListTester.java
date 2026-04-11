// Program: Linked List Tester
// Made by: Henry Smith
// Created: Mar 20, 2026

import java.util.LinkedList;

public class ListTester {
    public static void main(String[] args) {
        boolean os1 = true;                // Overall Status (Success of Fail)
        boolean os2 = true; 
        boolean os3 = true; 
        boolean os4 = true; 
        System.out.println("--------------------------------");
        System.out.println(" ");

        // List Test 1
        LinkedList<GenericObjectT1> testList1 = new LinkedList<>();
        os1 = performTest1(testList1, "[testlist1]");
        System.out.println(" ");
        if (os1 == true) {
            System.out.println("Overall Test 1 Result: PASS");
        } else {
            System.out.println("Overall Test 1 Result: FAIL");
        }
        System.out.println("--------------------------------");

        // List Test 2
        LinkedList<GenericObjectT2> testList2 = new LinkedList<>();
        os2 = performTest2(testList2, "[testlist2]");
        System.out.println(" ");
        if (os2 == true) {
            System.out.println("Overall Test 2 Result: PASS");
        } else {
            System.out.println("Overall Test 2 Result: FAIL");
        }
        System.out.println("--------------------------------");

        // List Test 3
        LinkedList<String> testList3 = new LinkedList<>();
        os3 = performTest3(testList3, "[testlist3]");
        System.out.println(" ");
        if (os3 == true) {
            System.out.println("Overall Test 3 Result: PASS");
        } else {
            System.out.println("Overall Test 3 Result: FAIL");
        }
        System.out.println("--------------------------------");

        // List Test 4
        LinkedList<Integer> testList4 = new LinkedList<>();
        os4 = performTest4(testList4, "[testlist4]");
        System.out.println(" ");
        if (os4 == true) {
            System.out.println("Overall Test 4 Result: PASS");
        } else {
            System.out.println("Overall Test 4 Result: FAIL");
        }
        System.out.println("--------------------------------");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println(" ");
        System.out.println("OVERALL RESULTS");
        System.out.println("--------------------------------");
        if (os1 == true) {
            System.out.println("Overall Test 1 Result: PASS");
        } else {
            System.out.println("Overall Test 1 Result: FAIL");
        }
        if (os2 == true) {
            System.out.println("Overall Test 2 Result: PASS");
        } else {
            System.out.println("Overall Test 2 Result: FAIL");
        }
        if (os3 == true) {
            System.out.println("Overall Test 3 Result: PASS");
        } else {
            System.out.println("Overall Test 3 Result: FAIL");
        }
        if (os4 == true) {
            System.out.println("Overall Test 4 Result: PASS");
        } else {
            System.out.println("Overall Test 4 Result: FAIL");
        }

        System.out.println(" ");
        System.out.println("--------------------------------");
    }


public static boolean performTest1(LinkedList<GenericObjectT1> listTBT, String listName) {

    // Creates the object for the test list
    GenericObjectT1 obj1 = new GenericObjectT1("Object1", 5311);
    GenericObjectT1 obj2 = new GenericObjectT1("Object2", 4153);
    GenericObjectT1 obj3 = new GenericObjectT1("Object3", 5622);
    GenericObjectT1 obj4 = new GenericObjectT1("Object4", 9482);
    GenericObjectT1 obj5 = new GenericObjectT1("Object5", 2512);
    GenericObjectT1 obj6 = new GenericObjectT1("Object6", 4153);

    // Creates the variables needed for the test
    boolean ts1 = true;               // Test status for [ add(E e) ]
    boolean ts2 = true;               // Test status for [ add(int index E element) ]           
    boolean ts3 = true;               // Test status for [ addFirst(E, e) ]
    boolean ts4 = true;               // Test status for [ addLast (E, e) ]
    boolean ts5 = true;               // Test status for [ contains(Object 0) ]
    boolean ts6 = true;               // Test status for [ element() ]
    boolean ts7 = true;               // Test status for [ get() ]
    boolean ts8 = true;               // Test status for [ getFirst() ]
    boolean ts9 = true;               // Test status for [ getLast() ]
    boolean ts10 = true;              // Test status for [ pop() ]
    boolean ts11 = true;              // Test status for [ push(E e) ]
    boolean ts12 = true;              // Test status for [ remove() ]
    boolean ts13 = true;              // Test status for [ remove(Object o) ]
    boolean ts14 = true;              // Test status for [ removeFirst() ]
    boolean ts15 = true;              // Test status for [ removeLast() ]
    boolean tsc = true;               // Test status
    boolean tr = true;                // Test Results for Test List 1
    String exceptionsCaught = " ";    // Includes the data on caught exceptions
    String failsCaught = " ";         // Includes the data on test fails
    LinkedList<GenericObjectT1> check1 = new LinkedList<>();

    System.out.println(" ");
    System.out.println(" ");
    System.out.println("TESTING LINKED LIST: ["+listName+"]");
    System.out.println("--------------------------------");

        // Test 1
        try {
            listTBT.add(obj2);
            listTBT.add(obj4);
            listTBT.add(obj5);
            check1.add(obj4);
            check1.add(obj5);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts1 = false;
            tr = false;
        }
        if (ts1 == true) {
            System.out.println("Test 1 Passed!");
        } else {
            System.out.println("Test 1 Failed");
        }

        // Test 2
        try {
            listTBT.add(1 ,obj3);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts2 = false;
            tr = false;
        }
        if (ts2 == true) {
            System.out.println("Test 2 Passed!");
        } else {
            System.out.println("Test 2 Failed");
        }

        // Test 3
        try {
            listTBT.addFirst(obj1);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts3 = false;
            tr = false;
        }
        if (ts3 == true) {
            System.out.println("Test 3 Passed!");
        } else {
            System.out.println("Test 3 Failed");
        }

        // Test 4
        try {
            listTBT.addLast(obj6);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts4 = false;
            tr = false;
        }
        if (ts4 == true) {
            System.out.println("Test 4 Passed!");
        } else {
            System.out.println("Test 5 Failed");
        }

        // Test 5
        try {
            if (listTBT.contains(obj5)) {
               ts5 = true;
            } else {
                ts5 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts5 = false;
            tr = false;
        }
        if (ts5 == true) {
            System.out.println("Test 5 Passed!");
        } else {
            System.out.println("Test 5 Failed");
        }

        // Test 6
        try {
            if (listTBT.element().getName() == obj1.getName()) {
                ts6 = true;
            } else {
               ts6 = false;
               tr = false;
               failsCaught = failsCaught + " element() command gives wrong object! |";
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts6 = false;
            tr = false;
        }
        if (ts6 == true) {
            System.out.println("Test 6 Passed!");
        } else {
            System.out.println("Test 6 Failed");
        }

        // Test 7
        try {
            if  (listTBT.get(1) == obj2) {
                ts7 = true;
            } else {
                ts7 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts7 = false;
            tr = false;
        }
        if (ts7 == true) {
            System.out.println("Test 7 Passed!");
        } else {
            System.out.println("Test 7 Failed");
        }

        // Test 8
        try {
            if  (listTBT.getFirst() == obj1) {
                ts8 = true;
            } else {
                ts8 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts8 = false;
            tr = false;
        }
        if (ts8 == true) {
            System.out.println("Test 8 Passed!");
        } else {
            System.out.println("Test 8 Failed");
        }

        // Test 9
        try {
            if  (listTBT.getLast() == obj6) {
                ts9 = true;
            } else {
                ts9 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts9 = false;
            tr = false;
        }
        if (ts9 == true) {
            System.out.println("Test 9 Passed!");
        } else {
            System.out.println("Test 9 Failed");
        }

        // Test 10
        try {
            if  (listTBT.pop() == obj1) {
                ts10 = true;
            } else {
               ts10 = false;
               tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts10 = false;
            tr = false;
        }
        if (ts10 == true) {
            System.out.println("Test 10 Passed!");
        } else {
            System.out.println("Test 10 Failed");
        }

        // Test 11
        try {
            listTBT.push(obj1);
            ts11 = true;
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts11 = false;
            tr = false;
        }
        if (ts11 == true) {
            System.out.println("Test 11 Passed!");
        } else {
            System.out.println("Test 11 Failed");
        }

        // Test 12
        try {
            listTBT.remove();
            if (listTBT.contains(obj1)) {
                ts12 = false;
                tr = false;
            } else {
                ts12 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts12 = false;
            tr = false;
        }
        if (ts12 == true) {
            System.out.println("Test 12 Passed!");
        } else {
            System.out.println("Test 12 Failed");
        }

        // Test 13
        try {
            listTBT.remove(obj3);
            if (listTBT.contains(obj3)) {
                ts13 = false;
                tr = false;
            } else {
                ts13 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts13 = false;
            tr = false;
        }
        if (ts13 == true) {
            System.out.println("Test 13 Passed!");
        } else {
            System.out.println("Test 13 Failed");
        }

        // Test 14
        try {
            listTBT.removeFirst();
            if (listTBT.contains(obj2)) {
                ts14 = false;
                tr = false;
            } else {
                ts14 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts14 = false;
            tr = false;
        }
        if (ts14 == true) {
            System.out.println("Test 14 Passed!");
        } else {
            System.out.println("Test 14 Failed");
        }

        // Test 15
        try {
            listTBT.removeLast();
            if (listTBT.contains(obj6)) {
                ts15 = false;
                tr = false;
            } else {
                ts15 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts15 = false;
            tr = false;
        }
        if (ts15 == true) {
            System.out.println("Test 15 Passed!");
        } else {
            System.out.println("Test 15 Failed");
        }

        // Final Test
        try {
            if (listTBT.element().getName() == obj4.getName()) {
                tsc = true;
            } else {
               tsc = false;
               tr = false;
               failsCaught = failsCaught + " element() command gives wrong object! |";
            }
            if (listTBT.getLast().getName() == obj5.getName()) {
                tsc = true;
            } else {
               tsc = false;
               tr = false;
               failsCaught = failsCaught + " element() command gives wrong object! |";
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            tsc = false;
            tr = false;
        }
        if (tsc == true) {
            System.out.println("Final Test Passed!");
        } else {
            System.out.println("Final Test Failed");
        }

        System.out.println(" ");
        System.out.println("Test 1 Result");
        for(GenericObjectT1 obj : listTBT) {
            System.out.println(obj.getName() + " | " + obj.getData());
        }   

        System.out.println(" ");
        System.out.println("Test 1 Expected");

        for(GenericObjectT1 obj : check1) {
            System.out.println(obj.getName() + " | " + obj.getData());
        }   

        System.out.println(" ");
        System.out.println(failsCaught);

        return tr;
    }


public static boolean performTest2(LinkedList<GenericObjectT2> listTBT, String listName) {

    // Creates the objects for the test list
    GenericObjectT2 obj1 = new GenericObjectT2("Object1", 5311, 17349);
    GenericObjectT2 obj2 = new GenericObjectT2("Object2", 4153, 38183);
    GenericObjectT2 obj3 = new GenericObjectT2("Object3", 5622, 19374);
    GenericObjectT2 obj4 = new GenericObjectT2("Object4", 9482, 90183);
    GenericObjectT2 obj5 = new GenericObjectT2("Object5", 2512, 23813);
    GenericObjectT2 obj6 = new GenericObjectT2("Object6", 4153, 94813);

    // Creates the variables needed for the test
    boolean ts1 = true;               // Test status for [ add(E e) ]
    boolean ts2 = true;               // Test status for [ add(int index E element) ]           
    boolean ts3 = true;               // Test status for [ addFirst(E, e) ]
    boolean ts4 = true;               // Test status for [ addLast (E, e) ]
    boolean ts5 = true;               // Test status for [ contains(Object 0) ]
    boolean ts6 = true;               // Test status for [ element() ]
    boolean ts7 = true;               // Test status for [ get() ]
    boolean ts8 = true;               // Test status for [ getFirst() ]
    boolean ts9 = true;               // Test status for [ getLast() ]
    boolean ts10 = true;              // Test status for [ pop() ]
    boolean ts11 = true;              // Test status for [ push(E e) ]
    boolean ts12 = true;              // Test status for [ remove() ]
    boolean ts13 = true;              // Test status for [ remove(Object o) ]
    boolean ts14 = true;              // Test status for [ removeFirst() ]
    boolean ts15 = true;              // Test status for [ removeLast() ]
    boolean tsc = true;               // Test status
    boolean tr = true;                // Test Results for Test List 1
    String exceptionsCaught = " ";    // Includes the data on caught exceptions
    String failsCaught = " ";         // Includes the data on test fails
    LinkedList<GenericObjectT2> check1 = new LinkedList<>();

    System.out.println(" ");
    System.out.println(" ");
    System.out.println("TESTING LINKED LIST: ["+listName+"]");
    System.out.println("--------------------------------");

        // Test 1
        try {
            listTBT.add(obj2);
            listTBT.add(obj4);
            listTBT.add(obj5);
            check1.add(obj4);
            check1.add(obj5);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts1 = false;
            tr = false;
        }
        if (ts1 == true) {
            System.out.println("Test 1 Passed!");
        } else {
            System.out.println("Test 1 Failed");
        }

        // Test 2
        try {
            listTBT.add(1 ,obj3);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts2 = false;
            tr = false;
        }
        if (ts2 == true) {
            System.out.println("Test 2 Passed!");
        } else {
            System.out.println("Test 2 Failed");
        }

        // Test 3
        try {
            listTBT.addFirst(obj1);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts3 = false;
            tr = false;
        }
        if (ts3 == true) {
            System.out.println("Test 3 Passed!");
        } else {
            System.out.println("Test 3 Failed");
        }

        // Test 4
        try {
            listTBT.addLast(obj6);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts4 = false;
            tr = false;
        }
        if (ts4 == true) {
            System.out.println("Test 4 Passed!");
        } else {
            System.out.println("Test 5 Failed");
        }

        // Test 5
        try {
            if (listTBT.contains(obj5)) {
               ts5 = true;
            } else {
                ts5 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts5 = false;
            tr = false;
        }
        if (ts5 == true) {
            System.out.println("Test 5 Passed!");
        } else {
            System.out.println("Test 5 Failed");
        }

        // Test 6
        try {
            if (listTBT.element().getName() == obj1.getName()) {
                ts6 = true;
            } else {
               ts6 = false;
               tr = false;
               failsCaught = failsCaught + " element() command gives wrong object! |";
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts6 = false;
            tr = false;
        }
        if (ts6 == true) {
            System.out.println("Test 6 Passed!");
        } else {
            System.out.println("Test 6 Failed");
        }

        // Test 7
        try {
            if  (listTBT.get(1) == obj2) {
                ts7 = true;
            } else {
                ts7 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts7 = false;
            tr = false;
        }
        if (ts7 == true) {
            System.out.println("Test 7 Passed!");
        } else {
            System.out.println("Test 7 Failed");
        }

        // Test 8
        try {
            if  (listTBT.getFirst() == obj1) {
                ts8 = true;
            } else {
                ts8 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts8 = false;
            tr = false;
        }
        if (ts8 == true) {
            System.out.println("Test 8 Passed!");
        } else {
            System.out.println("Test 8 Failed");
        }

        // Test 9
        try {
            if  (listTBT.getLast() == obj6) {
                ts9 = true;
            } else {
                ts9 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts9 = false;
            tr = false;
        }
        if (ts9 == true) {
            System.out.println("Test 9 Passed!");
        } else {
            System.out.println("Test 9 Failed");
        }

        // Test 10
        try {
            if  (listTBT.pop() == obj1) {
                ts10 = true;
            } else {
               ts10 = false;
               tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts10 = false;
            tr = false;
        }
        if (ts10 == true) {
            System.out.println("Test 10 Passed!");
        } else {
            System.out.println("Test 10 Failed");
        }

        // Test 11
        try {
            listTBT.push(obj1);
            ts11 = true;
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts11 = false;
            tr = false;
        }
        if (ts11 == true) {
            System.out.println("Test 11 Passed!");
        } else {
            System.out.println("Test 11 Failed");
        }

        // Test 12
        try {
            listTBT.remove();
            if (listTBT.contains(obj1)) {
                ts12 = false;
                tr = false;
            } else {
                ts12 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts12 = false;
            tr = false;
        }
        if (ts12 == true) {
            System.out.println("Test 12 Passed!");
        } else {
            System.out.println("Test 12 Failed");
        }

        // Test 13
        try {
            listTBT.remove(obj3);
            if (listTBT.contains(obj3)) {
                ts13 = false;
                tr = false;
            } else {
                ts13 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts13 = false;
            tr = false;
        }
        if (ts13 == true) {
            System.out.println("Test 13 Passed!");
        } else {
            System.out.println("Test 13 Failed");
        }

        // Test 14
        try {
            listTBT.removeFirst();
            if (listTBT.contains(obj2)) {
                ts14 = false;
                tr = false;
            } else {
                ts14 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts14 = false;
            tr = false;
        }
        if (ts14 == true) {
            System.out.println("Test 14 Passed!");
        } else {
            System.out.println("Test 14 Failed");
        }

        // Test 15
        try {
            listTBT.removeLast();
            if (listTBT.contains(obj6)) {
                ts15 = false;
                tr = false;
            } else {
                ts15 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts15 = false;
            tr = false;
        }
        if (ts15 == true) {
            System.out.println("Test 15 Passed!");
        } else {
            System.out.println("Test 15 Failed");
        }

        // Final Test
        try {
            if (listTBT.element().getName() == obj4.getName()) {
                tsc = true;
            } else {
               tsc = false;
               tr = false;
               failsCaught = failsCaught + " element() command gives wrong object! |";
            }
            if (listTBT.getLast().getName() == obj5.getName()) {
                tsc = true;
            } else {
               tsc = false;
               tr = false;
               failsCaught = failsCaught + " element() command gives wrong object! |";
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            tsc = false;
            tr = false;
        }
        if (tsc == true) {
            System.out.println("Final Test Passed!");
        } else {
            System.out.println("Final Test Failed");
        }

        System.out.println(" ");
        System.out.println("Test 2 Result");
        for(GenericObjectT2 obj : listTBT) {
            System.out.println(obj.getName() + " | " + obj.getData1() + " | " +  obj.getData2());
        }   

        System.out.println(" ");
        System.out.println("Test 2 Expected");

        for(GenericObjectT2 obj : check1) {
            System.out.println(obj.getName() + " | " + obj.getData2() + " | " +  obj.getData2());
        }   

        System.out.println(" ");
        System.out.println(failsCaught);

        return tr;
    }

public static boolean performTest3(LinkedList<String> listTBT, String listName) {

    // Creates the string objects for the test list
    String obj1 = "Object1";
    String obj2 = "Object2";
    String obj3 = "Object3";
    String obj4 = "Object4";
    String obj5 = "Object5";
    String obj6 = "Object6";

    // Creates the required variables for the test
    boolean ts1 = true;               // Test status for [ add(E e) ]
    boolean ts2 = true;               // Test status for [ add(int index E element) ]           
    boolean ts3 = true;               // Test status for [ addFirst(E, e) ]
    boolean ts4 = true;               // Test status for [ addLast (E, e) ]
    boolean ts5 = true;               // Test status for [ contains(Object 0) ]
    boolean ts6 = true;               // Test status for [ element() ]
    boolean ts7 = true;               // Test status for [ get() ]
    boolean ts8 = true;               // Test status for [ getFirst() ]
    boolean ts9 = true;               // Test status for [ getLast() ]
    boolean ts10 = true;              // Test status for [ pop() ]
    boolean ts11 = true;              // Test status for [ push(E e) ]
    boolean ts12 = true;              // Test status for [ remove() ]
    boolean ts13 = true;              // Test status for [ remove(Object o) ]
    boolean ts14 = true;              // Test status for [ removeFirst() ]
    boolean ts15 = true;              // Test status for [ removeLast() ]
    boolean tsc = true;               // Test status
    boolean tr = true;                // Test Results for Test List 1
    String exceptionsCaught = " ";    // Includes the data on caught exceptions
    String failsCaught = " ";         // Includes the data on test fails
    LinkedList<String> check1 = new LinkedList<>();

    System.out.println(" ");
    System.out.println(" ");
    System.out.println("TESTING LINKED LIST: ["+listName+"]");
    System.out.println("--------------------------------");

        // Test 1
        try {
            listTBT.add(obj2);
            listTBT.add(obj4);
            listTBT.add(obj5);
            check1.add(obj4);
            check1.add(obj5);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts1 = false;
            tr = false;
        }
        if (ts1 == true) {
            System.out.println("Test 1 Passed!");
        } else {
            System.out.println("Test 1 Failed");
        }

        // Test 2
        try {
            listTBT.add(1 ,obj3);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts2 = false;
            tr = false;
        }
        if (ts2 == true) {
            System.out.println("Test 2 Passed!");
        } else {
            System.out.println("Test 2 Failed");
        }

        // Test 3
        try {
            listTBT.addFirst(obj1);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts3 = false;
            tr = false;
        }
        if (ts3 == true) {
            System.out.println("Test 3 Passed!");
        } else {
            System.out.println("Test 3 Failed");
        }

        // Test 4
        try {
            listTBT.addLast(obj6);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts4 = false;
            tr = false;
        }
        if (ts4 == true) {
            System.out.println("Test 4 Passed!");
        } else {
            System.out.println("Test 4 Failed");
        }

        // Test 5
        try {
            if (listTBT.contains(obj5)) {
               ts5 = true;
            } else {
                ts5 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts5 = false;
            tr = false;
        }
        if (ts5 == true) {
            System.out.println("Test 5 Passed!");
        } else {
            System.out.println("Test 5 Failed");
        }

        // Test 6
        try {
            if (listTBT.element() == obj1) {
                ts6 = true;
            } else {
               ts6 = false;
               tr = false;
               failsCaught = failsCaught + " element() command gives wrong object! |";
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts6 = false;
            tr = false;
        }
        if (ts6 == true) {
            System.out.println("Test 6 Passed!");
        } else {
            System.out.println("Test 6 Failed");
        }

        // Test 7
        try {
            if  (listTBT.get(1) == obj2) {
                ts7 = true;
            } else {
                ts7 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts7 = false;
            tr = false;
        }
        if (ts7 == true) {
            System.out.println("Test 7 Passed!");
        } else {
            System.out.println("Test 7 Failed");
        }

        // Test 8
        try {
            if  (listTBT.getFirst() == obj1) {
                ts8 = true;
            } else {
                ts8 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts8 = false;
            tr = false;
        }
        if (ts8 == true) {
            System.out.println("Test 8 Passed!");
        } else {
            System.out.println("Test 8 Failed");
        }

        // Test 9
        try {
            if  (listTBT.getLast() == obj6) {
                ts9 = true;
            } else {
                ts9 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts9 = false;
            tr = false;
        }
        if (ts9 == true) {
            System.out.println("Test 9 Passed!");
        } else {
            System.out.println("Test 9 Failed");
        }

        // Test 10
        try {
            if  (listTBT.pop() == obj1) {
                ts10 = true;
            } else {
               ts10 = false;
               tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts10 = false;
            tr = false;
        }
        if (ts10 == true) {
            System.out.println("Test 10 Passed!");
        } else {
            System.out.println("Test 10 Failed");
        }

        // Test 11
        try {
            listTBT.push(obj1);
            ts11 = true;
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts11 = false;
            tr = false;
        }
        if (ts11 == true) {
            System.out.println("Test 11 Passed!");
        } else {
            System.out.println("Test 11 Failed");
        }

        // Test 12
        try {
            listTBT.remove();
            if (listTBT.contains(obj1)) {
                ts12 = false;
                tr = false;
            } else {
                ts12 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts12 = false;
            tr = false;
        }
        if (ts12 == true) {
            System.out.println("Test 12 Passed!");
        } else {
            System.out.println("Test 12 Failed");
        }

        // Test 13
        try {
            listTBT.remove(obj3);
            if (listTBT.contains(obj3)) {
                ts13 = false;
                tr = false;
            } else {
                ts13 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts13 = false;
            tr = false;
        }
        if (ts13 == true) {
            System.out.println("Test 13 Passed!");
        } else {
            System.out.println("Test 13 Failed");
        }

        // Test 14
        try {
            listTBT.removeFirst();
            if (listTBT.contains(obj2)) {
                ts14 = false;
                tr = false;
            } else {
                ts14 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts14 = false;
            tr = false;
        }
        if (ts14 == true) {
            System.out.println("Test 14 Passed!");
        } else {
            System.out.println("Test 14 Failed");
        }

        // Test 15
        try {
            listTBT.removeLast();
            if (listTBT.contains(obj6)) {
                ts15 = false;
                tr = false;
            } else {
                ts15 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts15 = false;
            tr = false;
        }
        if (ts15 == true) {
            System.out.println("Test 15 Passed!");
        } else {
            System.out.println("Test 15 Failed");
        }

        // Final Test
        try {
            if (listTBT.element() == obj4) {
                tsc = true;
            } else {
               tsc = false;
               tr = false;
               failsCaught = failsCaught + " element() command gives wrong object! |";
            }
            if (listTBT.getLast() == obj5) {
                tsc = true;
            } else {
               tsc = false;
               tr = false;
               failsCaught = failsCaught + " element() command gives wrong object! |";
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            tsc = false;
            tr = false;
        }
        if (tsc == true) {
            System.out.println("Final Test Passed!");
        } else {
            System.out.println("Final Test Failed");
        }

        System.out.println(" ");
        System.out.println("Test 3 Result");
        for(String obj : listTBT) {
            System.out.println(obj);
        }   

        System.out.println(" ");
        System.out.println("Test 3 Expected");

        for(String obj : check1) {
            System.out.println(obj);
        }   

        System.out.println(" ");
        System.out.println(failsCaught);

        return tr;
    }

    


public static boolean performTest4(LinkedList<Integer> listTBT, String listName) {

    // Creates the Interger objects for the test list
    int obj1 = 2351;
    int obj2 = 2362;
    int obj3 = 1351;
    int obj4 = 1241;
    int obj5 = 2462;
    int obj6 = 9684;

    // Creates the required variables for the test
    boolean ts1 = true;               // Test status for [ add(E e) ]
    boolean ts2 = true;               // Test status for [ add(int index E element) ]           
    boolean ts3 = true;               // Test status for [ addFirst(E, e) ]
    boolean ts4 = true;               // Test status for [ addLast (E, e) ]
    boolean ts5 = true;               // Test status for [ contains(Object 0) ]
    boolean ts6 = true;               // Test status for [ element() ]
    boolean ts7 = true;               // Test status for [ get() ]
    boolean ts8 = true;               // Test status for [ getFirst() ]
    boolean ts9 = true;               // Test status for [ getLast() ]
    boolean ts10 = true;              // Test status for [ pop() ]
    boolean ts11 = true;              // Test status for [ push(E e) ]
    boolean ts12 = true;              // Test status for [ remove() ]
    boolean ts13 = true;              // Test status for [ remove(Object o) ]
    boolean ts14 = true;              // Test status for [ removeFirst() ]
    boolean ts15 = true;              // Test status for [ removeLast() ]
    boolean tsc = true;               // Test status
    boolean tr = true;                // Test Results for Test List 1
    String exceptionsCaught = " ";    // Includes the data on caught exceptions
    String failsCaught = " ";         // Includes the data on test fails
    LinkedList<Integer> check1 = new LinkedList<>();

    System.out.println(" ");
    System.out.println(" ");
    System.out.println("TESTING LINKED LIST: ["+listName+"]");
    System.out.println("--------------------------------");

        // Test 1
        try {
            listTBT.add(obj2);
            listTBT.add(obj4);
            listTBT.add(obj5);
            check1.add(obj4);
            check1.add(obj5);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts1 = false;
            tr = false;
        }
        if (ts1 == true) {
            System.out.println("Test 1 Passed!");
        } else {
            System.out.println("Test 1 Failed");
        }

        // Test 2
        try {
            listTBT.add(1 ,obj3);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts2 = false;
            tr = false;
        }
        if (ts2 == true) {
            System.out.println("Test 2 Passed!");
        } else {
            System.out.println("Test 2 Failed");
        }

        // Test 3
        try {
            listTBT.addFirst(obj1);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts3 = false;
            tr = false;
        }
        if (ts3 == true) {
            System.out.println("Test 3 Passed!");
        } else {
            System.out.println("Test 3 Failed");
        }

        // Test 4
        try {
            listTBT.addLast(obj6);
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts4 = false;
            tr = false;
        }
        if (ts4 == true) {
            System.out.println("Test 4 Passed!");
        } else {
            System.out.println("Test 4 Failed");
        }

        // Test 5
        try {
            if (listTBT.contains(obj5)) {
               ts5 = true;
            } else {
                ts5 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts5 = false;
            tr = false;
        }
        if (ts5 == true) {
            System.out.println("Test 5 Passed!");
        } else {
            System.out.println("Test 5 Failed");
        }

        // Test 6
        try {
            if (listTBT.element() == obj1) {
                ts6 = true;
            } else {
               ts6 = false;
               tr = false;
               failsCaught = failsCaught + " element() command gives wrong object! |";
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts6 = false;
            tr = false;
        }
        if (ts6 == true) {
            System.out.println("Test 6 Passed!");
        } else {
            System.out.println("Test 6 Failed");
        }

        // Test 7
        try {
            if  (listTBT.get(1) == obj2) {
                ts7 = true;
            } else {
                ts7 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts7 = false;
            tr = false;
        }
        if (ts7 == true) {
            System.out.println("Test 7 Passed!");
        } else {
            System.out.println("Test 7 Failed");
        }

        // Test 8
        try {
            if  (listTBT.getFirst() == obj1) {
                ts8 = true;
            } else {
                ts8 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts8 = false;
            tr = false;
        }
        if (ts8 == true) {
            System.out.println("Test 8 Passed!");
        } else {
            System.out.println("Test 8 Failed");
        }

        // Test 9
        try {
            if  (listTBT.getLast() == obj6) {
                ts9 = true;
            } else {
                ts9 = false;
                tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts9 = false;
            tr = false;
        }
        if (ts9 == true) {
            System.out.println("Test 9 Passed!");
        } else {
            System.out.println("Test 9 Failed");
        }

        // Test 10
        try {
            if  (listTBT.pop() == obj1) {
                ts10 = true;
            } else {
               ts10 = false;
               tr = false;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts10 = false;
            tr = false;
        }
        if (ts10 == true) {
            System.out.println("Test 10 Passed!");
        } else {
            System.out.println("Test 10 Failed");
        }

        // Test 11
        try {
            listTBT.push(obj1);
            ts11 = true;
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts11 = false;
            tr = false;
        }
        if (ts11 == true) {
            System.out.println("Test 11 Passed!");
        } else {
            System.out.println("Test 11 Failed");
        }

        // Test 12
        try {
            listTBT.remove();
            if (listTBT.contains(obj1)) {
                ts12 = false;
                tr = false;
            } else {
                ts12 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts12 = false;
            tr = false;
        }
        if (ts12 == true) {
            System.out.println("Test 12 Passed!");
        } else {
            System.out.println("Test 12 Failed");
        }

        // Test 13
        try {
            listTBT.remove(0);
            if (listTBT.contains(0)) {
                ts13 = false;
                tr = false;
            } else {
                ts13 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts13 = false;
            tr = false;
        }
        if (ts13 == true) {
            System.out.println("Test 13 Passed!");
        } else {
            System.out.println("Test 13 Failed");
        }

        // Test 14
        try {
            listTBT.removeFirst();
            if (listTBT.contains(obj2)) {
                ts14 = false;
                tr = false;
            } else {
                ts14 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts14 = false;
            tr = false;
        }
        if (ts14 == true) {
            System.out.println("Test 14 Passed!");
        } else {
            System.out.println("Test 14 Failed");
        }

        // Test 15
        try {
            listTBT.removeLast();
            if (listTBT.contains(obj6)) {
                ts15 = false;
                tr = false;
            } else {
                ts15 = true;
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            ts15 = false;
            tr = false;
        }
        if (ts15 == true) {
            System.out.println("Test 15 Passed!");
        } else {
            System.out.println("Test 15 Failed");
        }

        // Final Test
        try {
            if (listTBT.element() == obj4) {
                tsc = true;
            } else {
               tsc = false;
               tr = false;
               failsCaught = failsCaught + " element() command gives wrong object! |";
            }
            if (listTBT.getLast() == obj5) {
                tsc = true;
            } else {
               tsc = false;
               tr = false;
               failsCaught = failsCaught + " element() command gives wrong object! |";
            }
        } catch (Exception e) {
            exceptionsCaught = exceptionsCaught + e.getMessage();
            tsc = false;
            tr = false;
        }
        if (tsc == true) {
            System.out.println("Final Test Passed!");
        } else {
            System.out.println("Final Test Failed");
        }

        System.out.println(" ");
        System.out.println("Test 4 Result");
        for(Integer obj : listTBT) {
            System.out.println(obj);
        }   

        System.out.println(" ");
        System.out.println("Test 4 Expected");

        for(Integer obj : check1) {
            System.out.println(obj);
        }   

        System.out.println(" ");
        System.out.println(failsCaught);

        return tr;
    }
}

