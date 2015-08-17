package sortmain;

/**
 *
 * @author Jessica Cassidy
 */
public class YourSort implements SortInterface{
    public UnsortedException unsorted;
    int iterativeCount;
    int recursiveCount;
    long iterativeTime;
    long recursiveTime;
  //  long [] times;
//    int [] counts;
    
   //iterative selection sort method, modified from Liang Listing 6.8
    public void iterativeSort (int [] list) throws Exception {
        iterativeCount = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.length - 1; i++){
            //find the minimum in the list [i..n]
            int currentMin = list[i];
            int currentMinIndex = i;
            
            for (int j = i + 1; j < list.length; j++){
                iterativeCount++;
                if (currentMin > list[j]){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            
            //swap list [i] with list [currentMinIndex] if necessary
            if (currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
        long endTime = System.currentTimeMillis();
        iterativeTime = endTime - startTime;
        for (int i = 0; i < list.length - 1; i++){
            if (list[i] > list [i + 1]){
                unsorted = new UnsortedException ("Sort failed!");
                throw unsorted;
            }
        }
                
    }
    
    
    //recursive selection sort method from Liang listing 20.5
    public void recursiveSort(int [] list) throws Exception {
        
        recursiveSort(list, 0, list.length - 1);
    }
    
    private void recursiveSort(int [] list, int low, int high)throws Exception{            

        long startTime = System.currentTimeMillis();
        recursiveCount = 0;
        if (low < high) {
            //find the smallest number and its index in list [low...high]
            int indexOfMin = low;
            int min = list[low];
            for (int i = low + 1; i <= high; i++){
                recursiveCount++;
                if (list[i] < min) {
                    min = list[i];
                    indexOfMin = i;
                }
            }
            
            //swap the smallest in list [low...high] with list [low]
            list[indexOfMin] = list[low];
            list[low] = min;
            //sort the remaining list [low+1...high]
            recursiveSort(list, low + 1, high);
        }
        long endTime = System.currentTimeMillis();
        recursiveTime = endTime - startTime;
        for (int i = 0; i < list.length - 1; i++){
            if (list[i] > list [i + 1]){
                unsorted = new UnsortedException ("Sort failed!");
                throw unsorted;
            }
        }
    }
    
    
    public int getCount(){
        int totalCount = iterativeCount + recursiveCount;
        iterativeCount = 0;
        recursiveCount = 0;        
        return totalCount;
    }
    
    public long getTime(){
        long totalTime = iterativeTime + recursiveTime;
        iterativeTime = 0;
        recursiveTime = 0;
        return totalTime;
    }
    
}
