/**
 * Import Java
 */
import java.util.Comparator;


/**
 * Array Sort 2 Class. For A10
 * Insertion Sort starts at line 28. 
 * Bubble Sort starts at line 85.
 * Selection Sort starts at line 135.
 * Heap Sort and its methods starts at line 191.
 * Merge Sort and its methods start at line 305.
 * Quick Sort and its methods start at line 388.
 * Big-O analysis within methods.
 *
 * @author Michael Mangrobang
 *
 **/
public class ArraySortA10<E> {
  
  
  private int swaps, comps;
  private long start, end, insertStart, insertEnd;


  /**
   * Insertion Sort. Does the Insertion Sort
   * 
   * @coauthor http://courses.cs.washington.edu/courses/cse373/01wi/slides/Measurement/sld010.htm
   * @param data
   * @param compare
   */
  public void insertionSort(E[] data, Comparator<? super E> compare) {

    /*
     * Big-O Insertion Sort:
     * The first for loop is n because data.length is unknown and could be any size. The second for
     * loop is n - 1 because j is set equal to i - 1 and i is equal to data.length which is an unkown size. Therefore the
     * overall Big-O Performance of this Insertion Sort method is: O(n^2)
     */
    
    insertStart = System.nanoTime();

    for (int i = 1; i < data.length; i++) {

      E temp = data[i];
      int j;

      for (j = i - 1; j >= 0 && compare.compare(temp, data[j]) < 0; j--) {

        data[j + 1] = data[j];
        swaps++;
        comps++;

      }

      data[j + 1] = temp;
      swaps++;

    }
    
    insertEnd = System.nanoTime();

  } // end insertionSort
  
  
  /**
   * insert results
   * prints insert sort time, comparisons and swaps.
   * this is called separately because merge sort also calls for insertion sort
   */
  public void insertResults() {

    System.out.println("Insertion sort completed.");
    long total = insertEnd - insertStart;
    System.out.println("Sort completed in: :" + total + " nanoseconds.");
    printComps();
    printSwaps();
    
  }


  /**
   * Bubble Sort. Does the Bubble Sort
   * 
   * @param data
   * @param compare
   */
  public void bubbleSort(E[] data, Comparator<? super E> compare) {
    
    /*
     * Big-O Bubble Sort:
     * The for loop is n - 1 times because data.length is unkown. The while loop is n because it is
     * checking to see if i is less than data.length which is still unkown. Therefore the overall Big-O Performance of
     * this Bubble Sort method is: O(n^2)
     */

    boolean unSorted = false;
    start = System.nanoTime();

    do {

      unSorted = false;

      for (int i = 0; i < data.length - 1; i++) {

        comps++;

        while (compare.compare(data[i], data[i + 1]) > 0 && i < data.length) {

          swap(data, i, i + 1);
          unSorted = true;
//          E temp = data[i];
//          data[i] = data[i + 1];
//          data[i + 1] = temp;
//          swaps++;

        }

      }

    } while (unSorted);
    
    end = System.nanoTime();
    System.out.println("Bubble sort completed.");
    printTime();
    printComps();
    printSwaps();

  } // end bubbleSort


  /**
   * Selection Sort. Does the Selection Sort
   * 
   * @coauthor http://stackoverflow.com/questions/18975050/selection-sort-in-java-ways-i-can-improve-the-code
   * @param data
   * @param compare
   */
  public void selectionSort(E[] data, Comparator<? super E> compare) {
    
    /*
     * Big-O Selection Sort:
     * The first for loop is n because the loop continues while int i is less than data.length which
     * is unknown. The second for loop is n - 1 because next is set equal to i + 1 loop and continues while int is less
     * than data.length which is still unkown. Therefore the overall Big-O Performance of this Selection Sort method is:
     * O(n^2)
     */

    start = System.nanoTime();

    for (int i = 0; i < data.length; i++) {

      int posMin = i;

      for (int next = i + 1; next < data.length; next++) {

        comps++;

        if (compare.compare(data[posMin], data[next]) > 0) {

          posMin = next;

        }

      }

      if (i != posMin) {

//        E temp = data[i];
//        data[i] = data[posMin];
//        data[posMin] = temp;
//        swaps++;
        swap(data, i, posMin);

      }

    }
    
    end = System.nanoTime();
    System.out.println("Selection sort completed.");
    printTime();
    printComps();
    printSwaps();

  } // end selectionSort

  
  /**
   * heap sort. does the heap sort
   * 
   * @coauthor ICS211 Book
   * @param data
   * @param compare
   */
  public void heapSort(E[] data, Comparator<? super E> compare) {
    
    /*
     * Big-O Heap Sort:
     * The overall Big-O for the heap sort is O(n log(n)).
     */
    
    start = System.nanoTime();
    buildHeap(data, compare);
    shrinkHeap(data, compare);
    end = System.nanoTime();
    System.out.println("Heap sort completed.");
    printTime();
    printComps();
    printSwaps();
    
  } // end heapSort
  
  
  /**
   * build heap. builds the heap
   * 
   * @coauthor ICS211 Book
   * @param d
   * @param c
   */
  private void buildHeap(E[] d, Comparator<? super E> c) {
    
    int n = 1;
    
    while (n< d.length) {
      
      n++;
      int child = n - 1;
      int parent = (child - 1) / 2;
      comps++;
      
      while (parent >= 0 && (c.compare(d[parent], d[child])) < 0) {
        
        swap(d, parent, child);
        child = parent;
        parent = (child - 1) / 2;
        
      }
      
    }
    
    
  } // end buildHeap
  
  
  /**
   * shrink heap. sorts the heap
   * 
   * @coauthor ICS211 Book
   * @param d
   */
  private void shrinkHeap(E[] d, Comparator<? super E> c) {
    
    int n = d.length;
    
    while (n > 0) {
      
      n--;
      swap(d, 0, n);
      int parent = 0;
      
      while (true) {
        
        int leftChild = 2 * parent + 1;
        
        if (leftChild >= n) {
          
          break;
          
        }
        
        int rightChild = leftChild + 1;
        int maxChild = leftChild;
        comps++;
        
        if (rightChild < n && c.compare(d[leftChild], d[rightChild]) < 0) {
          
          maxChild = rightChild;
          
        }
        
        comps++;
        
        if (c.compare(d[parent], d[maxChild]) < 0) {
          
          swap(d, parent, maxChild);
          parent = maxChild;
          
        } else {
          
          break;
          
        }
        
      }
      
    }
    
  } // end shrinkHeap
   
  
  /**
   * merge sort. does the merge sort
   * 
   * @coauthor ICS 211 Book
   * @param data
   * @param compare
   */
  public void mergeSort(E[] data, Comparator<? super E> compare) {
    
    /*
     * Big-O Heap Sort:
     * The overall Big-O for the heap sort is O(n log(n)).
     */
    
    start = System.nanoTime();
    if (data.length > 1) {
    
      int halfSize = data.length / 2;
      E[] left = (E[]) new Comparable[halfSize];
      E[] right = (E[]) new Comparable[data.length - halfSize];
      System.arraycopy(data, 0, left, 0, halfSize);
      System.arraycopy(data, halfSize, right, 0, data.length - halfSize);
      insertionSort(left, compare);
      insertionSort(right, compare);
      merge(left, right, data, compare);
      
    }

    end = System.nanoTime();
    System.out.println("Merge sort completed.");
    printTime();
    printComps();
    printSwaps();
    
  } // end mergeSort
  
  
  /**
   * merges the arrays
   * 
   * @coauthor Cam Moore
   * @coauthor ICS 211 Book
   * @param left
   * @param right
   * @param result
   * @param c
   */
  private void merge(E[] left, E[] right, E[] result, Comparator<? super E> c) {
    
    int leftIndex = 0;
    int rightIndex = 0;
    int resIndex = 0;
    
    while (leftIndex < left.length && rightIndex < right.length) {
      
      comps++;
      if (c.compare(left[leftIndex], right[rightIndex]) < 0) {
        
        result[resIndex++] = left[leftIndex++];
        
      } else {
        
        result[resIndex++] = right[rightIndex++];
        
      }
      
    }
    
    while (leftIndex < left.length) {
      
        result[resIndex++] = left[leftIndex++];
        
    }
    
    while (rightIndex < right.length) {
      
        result[resIndex++] = right[rightIndex++];
        
    }
    
  } // end merge
  
  
  /**
   * quick sort helper. calls recursive quick sort
   * 
   * @param data
   * @param compare
   */
  public void quickSort(E[] data, Comparator<? super E> compare) {
    
    /*
     * Big-O Heap Sort:
     * The overall Big-O for the heap sort is O(n log(n)).
     */
    
    start = System.nanoTime();
    quickSort(data, 0, data.length - 1, compare);
    end = System.nanoTime();
    System.out.println("Quick sort completed.");
    printTime();
    printComps();
    printSwaps();
    
  } // end quickSort helper
  
  
  /**
   * recursive quick sort. does the quick sort recursively
   * 
   * @param d
   * @param first
   * @param last
   * @param c
   */
  private void quickSort(E[] d, int first, int last, Comparator<? super E> c) {
    
    if (first < last) {
      
      int pivIndex = partition(d, first, last, c);
      quickSort(d, first, pivIndex - 1, c);
      quickSort(d, pivIndex + 1, last, c);
      
    }
    
  } // end recursive quickSort
  
  
  /**
   * partition. partitions the data
   * 
   * @param d
   * @param first
   * @param last
   * @param c
   * @return
   */
  private int partition(E[] d, int first, int last, Comparator<? super E> c) {
    
    E pivot = d[first];
    int up = first;
    int down = last;
    
    do {
      
      comps++;
      
      while ((up < last) && c.compare(pivot, d[up]) >= 0) {
       
        up++;
        comps++;
        
      }
      
      comps++;
      
      while (c.compare(pivot, d[down]) < 0) {
        
        down --;
        comps++;
        
      }
      
      comps++;
      
      if (up < down) {
        
        swap(d, up, down);
        
      }
      
      comps++;
      
    } while (up < down);
    
    swap(d, first, down);
    return down;
    
  } // end partition

  
  /**
   * swap. swaps the data around and increments swap counter
   * 
   * @param d
   * @param i
   * @param j
   */
  private void swap(E[] d, int i, int j) {
    
    E temp = d[i];
    d[i] = d[j];
    d[j] = temp;
    swaps++;
    
  } // end swap
  
  
  /**
   * prints the number of comparisons then resets the comparison count to 0
   * 
   * @param comparisons
   * @param exchanges
   */
  private void printComps() {

    System.out.println("Number of Comparisons: " + comps);
    comps = 0;

  } // end printcomps
  
  
  /**
   * prints the number of swaps then resets the swap count to 0
   */
  private void printSwaps() {
    
    System.out.println("Number of swaps: " + swaps);
    swaps = 0;
    
  } // end printSwaps


  /**
   * Prints the total Time when called for.
   * 
   * @param startTime
   * @param stopTime
   */
  private void printTime() {

    long total = end - start;
    System.out.println("Sort completed in: " + total + " nanoseconds.");

  } // end printTime
  

}