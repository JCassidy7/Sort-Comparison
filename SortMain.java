package sortmain;

/**
 *
 * @author Jessica Cassidy
 */
public class SortMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        int[] sizes = {10, 50, 100, 200, 1000, 5000, 10000, 20000, 50000, 100000} ; 
        BenchmarkSorts bSorts = new BenchmarkSorts(sizes);
      }
    
}
