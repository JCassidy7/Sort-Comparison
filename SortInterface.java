package sortmain;

/**
 *
 * @author Jessica Cassidy
 */
public interface SortInterface {
    
    void iterativeSort (int [] list) throws Exception;
    void recursiveSort (int [] list) throws Exception;
    
    public int getCount();
    
    public long getTime();
    
}
