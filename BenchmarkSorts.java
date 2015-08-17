/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
    int [] iterativeCountLog, recursiveCountLog = new int [50];
    long [] iterativeTimeLog, recursiveTimeLog = new long[50];
    int currentSize = 0;
    
    
    YourSort mySort = new YourSort();
    
    public BenchmarkSorts (int[] sizes)throws Exception{
    
    int count = 0;
    
    for (int i = 0; i < 50; i++){
        list = new int [sizes[i]];
        for (int j = 0; j < (sizes[count]); j++){    
            Random val = new Random();
            list[j] = (val.nextInt(1001));
          //  System.out.println(list[j]);
        }
        runSorts();
        currentSize = sizes[count];
        count++;
        
    }

    displayReport();
}
   
    public void runSorts() throws Exception{
      int a = 0;
      int b = 0;
      int [] tempArray1 = list;
      int [] tempArray2 = list;
      mySort.iterativeSort(tempArray1);
      int returnCount = mySort.getCount();
      long returnTime = mySort.getTime();
      iterativeCount = iterativeCount + returnCount;
      iterativeTime = iterativeTime + returnTime;
      iterativeCountLog[a] = iterativeCount;
      iterativeTimeLog[a] = iterativeTime;
      a++;
      /*System.out.println("Array prior to iterative sort: " );
      for (int i: tempArray1){
          System.out.print(i + "   ");
      }*/
      mySort.recursiveSort(tempArray2);
      returnCount = mySort.getCount();
      returnTime = mySort.getTime();
      recursiveCount = recursiveCount + returnCount;
      recursiveTime = recursiveTime + returnTime;
      recursiveCountLog[b] = recursiveCount;
      recursiveTimeLog[b] = recursiveTime;
      b++;
      
      
    }
    
    public void displayReport(){
        double iterativeAverageCount = 0;
        double iterativeAverageTime = 0;
        double recursiveAverageCount = 0;
        double recursiveAverageTime = 0;
        double iterativeSDCount = 0;
        double iterativeSDTime = 0;
        double recursiveSDCount = 0;
        double recursiveSDTime = 0;
        
        iterativeAverageCount = iterativeCount / 50;
        iterativeAverageTime = iterativeTime / 50;
        recursiveAverageCount = recursiveCount / 50;
        recursiveAverageTime = recursiveTime / 50;
        
        for (int i = 0; i < 50; i++){
            iterativeSDCount = iterativeSDCount + Math.pow((iterativeCountLog[i] - iterativeAverageCount), 2);
            iterativeSDTime = iterativeSDTime + Math.pow((iterativeTimeLog[i] - iterativeAverageTime), 2);
            recursiveSDCount = recursiveSDCount + Math.pow((recursiveCountLog[i] - recursiveAverageCount), 2);
            recursiveSDTime = recursiveSDTime + Math.pow((recursiveTimeLog[i] - recursiveAverageTime), 2);
        }
        
        iterativeSDCount = Math.pow(iterativeSDCount, .5) / currentSize;
        iterativeSDTime = Math.pow(iterativeSDTime, .5) / currentSize;
        recursiveSDCount = Math.pow(recursiveSDCount, .5) / currentSize;
        recursiveSDTime = Math.pow(recursiveSDTime, .5) / currentSize;
        
        System.out.println("Iterative Selection Sort Results: " + "\nData Set Size (n): " + currentSize + 
                "Average Critical Operation Count: " + iterativeAverageCount + ", Standard Deviation of Count: " +
                iterativeSDCount + ", Average Execution Time: " + iterativeAverageTime + ", Standard Deviation of Time" + 
                iterativeSDTime);
        
        System.out.println("Recursive Selection Sort Results: " + "\nData Set Size (n): " + currentSize + 
                "Average Critical Operation Count: " + recursiveAverageCount + ", Standard Deviation of Count: " +
                recursiveSDCount + ", Average Execution Time: " + recursiveAverageTime + ", Standard Deviation of Time" + 
                recursiveSDTime);
    }
    
    
}
    
