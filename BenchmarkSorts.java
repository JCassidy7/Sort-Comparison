package sortmain;

import java.util.Arrays;
import java.util.Random;


/**
 *
 * @author Jessica Cassidy
 */
public class BenchmarkSorts {
    int [] list;
    int iterativeCount = 0;
    int recursiveCount = 0;
    long iterativeTime, recursiveTime;
    int [] iterativeCountLog = new int [50];
    int [] recursiveCountLog = new int [50];
    int a = 0;
    int b = 0;
    long [] iterativeTimeLog = new long[50];
    long []recursiveTimeLog = new long[50];
    int n;
    
    
    YourSort mySort = new YourSort();
    
    public BenchmarkSorts (int[] sizes)throws Exception{
        
        for (int a = 0; a < sizes.length; a++){
            n = sizes[a];
            BenchmarkSorts bSort = new BenchmarkSorts(n);
            
        }
    
   
}
    private BenchmarkSorts (int n) throws Exception{
        for (int i = 1; i < 50; i++){
            list = new int [n];
            for (int j = 0; j < n; j++){
                Random val = new Random();
                list[j] = (val.nextInt(1001));
            }
            runSorts();
        }
        displayReport(n);
    }
    
   
    public void runSorts() throws Exception{
     
      int [] tempArray1 = list;
      int [] tempArray2 = list;
      mySort.iterativeSort(tempArray1);
      int returnCount = mySort.getCount();
      long returnTime = mySort.getTime();
      iterativeCount = iterativeCount + returnCount;
      iterativeTime = iterativeTime + returnTime;
      iterativeCountLog[a] = returnCount;
      iterativeTimeLog[a] = returnTime;
      a++;
     
      mySort.recursiveSort(tempArray2);
      returnCount = mySort.getCount();
      returnTime = mySort.getTime();
      recursiveCount = recursiveCount + returnCount;
      recursiveTime = recursiveTime + returnTime;
      recursiveCountLog[b] = recursiveCount;
      recursiveTimeLog[b] = recursiveTime;
      b++;
      
      
    }
    
    public void displayReport(int n){
        double iterativeAverageCount = 0;
        double iterativeAverageTime = 0;
        double recursiveAverageCount = 0;
        double recursiveAverageTime = 0;
        double iterativeSDCount = 0;
        double iterativeSDTime = 0;
        double recursiveSDCount = 0;
        double recursiveSDTime = 0;
        
        iterativeAverageCount = iterativeCount / 49;
        iterativeAverageTime = iterativeTime / 49;
        recursiveAverageCount = recursiveCount / 49;
        recursiveAverageTime = recursiveTime / 49;
        
        for (int i = 1; i < 50; i++){
            iterativeSDCount = iterativeSDCount + Math.pow((iterativeCountLog[i] - iterativeAverageCount), 2);
            iterativeSDTime = iterativeSDTime + Math.pow((iterativeTimeLog[i] - iterativeAverageTime), 2);
            recursiveSDCount = recursiveSDCount + Math.pow((recursiveCountLog[i] - recursiveAverageCount), 2);
            recursiveSDTime = recursiveSDTime + Math.pow((recursiveTimeLog[i] - recursiveAverageTime), 2);
        }
        
        iterativeSDCount = Math.pow(iterativeSDCount, .5) / n;
        iterativeSDTime = Math.pow(iterativeSDTime, .5) / n;
        recursiveSDCount = Math.pow(recursiveSDCount, .5) / n;
        recursiveSDTime = Math.pow(recursiveSDTime, .5) / n;
        
        System.out.println("Iterative Selection Sort Results: " + "\nData Set Size (n): " + n + 
                ", Average Critical Operation Count: " + iterativeAverageCount + ", Standard Deviation of Count: " +
                iterativeSDCount + ", Average Execution Time: " + iterativeAverageTime + ", Standard Deviation of Time: " + 
                iterativeSDTime);
        
        System.out.println("Recursive Selection Sort Results: " + "\nData Set Size (n): " + n + 
                ", Average Critical Operation Count: " + recursiveAverageCount + ", Standard Deviation of Count: " +
                recursiveSDCount + ", Average Execution Time: " + recursiveAverageTime + ", Standard Deviation of Time: " + 
                recursiveSDTime);
    }
    
    
}
    
