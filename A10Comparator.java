/**
 * Import Java
 */
import java.util.Comparator;


/**
 * Comparator for A10 class
 * 
 * @author Michael Mangrobang
 *
 */
public class A10Comparator<E> implements Comparator<E> {

  
  /**
   * compares strings
   * 
   *  @param o1
   *  @param o2
   */
  @Override
  public int compare(E o1, E o2) {

    String s1 = (String) o1;
    String s2 = (String) o2;
    return s1.compareTo(s2);
        
  } // end compare

  
} // end class