/**
 * Import Java
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * array sort a10 tester class
 * 
 * @author Michael Mangrobang
 *
 */
public class ArraySortA10Tester {
  

  /**
   * main method to test everything
   * 
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {

    /* Initialize Scanner with file prompt */
    Scanner scan = new Scanner(new File(args[0]));

    System.out.println("Please enter the type of sort you want.");
    System.out.println("Commands:");
    System.out.println("1 / insert / insertion - calls for insertion sort");
    System.out.println("2 / bubble - calls for bubble sort");
    System.out.println("3 / select / selection - calls for selection sort");
    System.out.println("4 / heap - calls for heap sort");
    System.out.println("5 / merge - calls for merge sort");
    System.out.println("6 / quick - calls for quick sort");
    
    Scanner s = new Scanner(System.in);
    String line = s.next();
    
    doSort(scan, line);

  } // end main
  
  
  /**
   * does sort with selected input.
   * 
   * @param scan
   * @param input
   */
  private static void doSort(Scanner scan, String input) {
    
    String[] data = createArray(scan);
    A10Comparator<String> compare = new A10Comparator<String>();
    ArraySortA10<String> sort = new ArraySortA10<String>();
    
    switch (input) {
    
    case "1":
    case "insert":
    case "insertion":
      System.out.println("Array Size: " + data.length);
      sort.insertionSort(data, compare);
      sort.insertResults();
      break;
      
    case "2":
    case "bubble":
      System.out.println("Array Size: " + data.length);
      sort.bubbleSort(data, compare);
      break;
      
    case "3":
    case "select":
    case "selection":
      System.out.println("Array Size: " + data.length);
      sort.selectionSort(data, compare);
      break;
      
    case "4":
    case "heap":
      System.out.println("Array Size: " + data.length);
      sort.heapSort(data, compare);
      break;
      
    case "5":
    case "merge":
      System.out.println("Array Size: " + data.length);
      sort.mergeSort(data, compare);
      break;
      
    case "6":
    case "quick":
      System.out.println("Array Size: " + data.length);
      sort.quickSort(data, compare);
      break;
      
      default:
        
        throwError(3);
    
    }
    
    checkArray(data);
    
  } // end doSort
  

  /**
   * creates string array. creates an array list of strings, then converts it to a string array
   * 
   * @param s
   * @return
   */
  private static String[] createArray(Scanner s) {

    ArrayList<String> list = new ArrayList<String>(); 

    while (s.hasNext()) {

      list.add(s.next());

    }

    s.close();
    String[] stringArray = new String[list.size()];
    stringArray = list.toArray(stringArray);
    return stringArray;

  } // end createArray
  
  
  /**
   * checks to see if the array is correctly sorted.
   * 
   * @param data
   */
  private static void checkArray(String[] d) {
    
    for (int i = 0; i < d.length - 1; i++) {
      
      if (d[i].compareTo(d[i+1]) > 0) {
        
        System.err.println("Problem with sort or comparator! Array is not correctly sorted!");
        break;
        
      }
      
    }
    
  } // end checkArray
  
  
  /**
   * 
   * @param i
   */
  private static void sleepwait(long i) {
    
    try {
      
      Thread.sleep(i);
      
    } catch(InterruptedException ex) {
      
      Thread.currentThread().interrupt();
      
    }
    
  } // end sleepwait
  
  
  /**
   * throws error
   */
  private static void throwError(int num) {
    
    errorTalk(0);
    
    for (int i = 0; i < num; i++) {

      for (int j = 0; j < num; j++) {
        
        System.err.println("Error!");
        sleepwait(1000);
        
      }
      
      System.err.println("Does not compute.");
      sleepwait(1000);
      
    }
    
    errorTalk(1);
    
    for (int i = 0; i < num; i++) {
      
      System.err.println("Crashing...");
      sleepwait(2000);
      
    }

    errorTalk(3);
    sleepwait(2000);
    throw new UnsupportedOperationException();
    
  } // end throwError
  
  
  /**
   * 
   * @param num
   */
  private static void errorTalk(int num) {
    
    if (num == 0) {

      sleepwait(1000);
      for (int i = 0; i < 3; i ++) {
        
        System.err.print(".");
        sleepwait(1000);
        
        
      }

      System.out.println();
      
    }
    
    if (num == 1) {
      
      sleepwait(1000);
      System.err.println("You did not follow the commands."); 
      sleepwait(2000);
      System.err.println("What a smartass.");
      sleepwait(2000);
      System.err.println("You're a jerk.");
      sleepwait(2000);
      
    }
    
    if (num != 0 && num != 1){
      
      System.err.println("Going to die now.");
      sleepwait(2000);
      System.err.println("Wait.");
      sleepwait(3000);
      System.err.println("Did I tell you you're a jerk?");
      sleepwait(2000);
      System.err.println("Well, you're a jerk.");
      sleepwait(2000);
      System.err.println("Goodbye.");
      sleepwait(2000);
      System.err.println("Jerk.");
      
    }
    
  }  // end errorTalk
  

} // end class