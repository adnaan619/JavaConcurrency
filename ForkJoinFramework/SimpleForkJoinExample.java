package ForkJoinFramework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SimpleForkJoinExample{
    
    //Recursive to sum a portion of the array
    static class SumTask extends RecursiveTask<Integer>{
        private static final int THRESHOLD = 5; //Threshold for splitting the task
        private final int[] array; //Array to sum
        private final int start, end; //Range to sum

        public SumTask(int[] array, int start, int end){
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute(){
            if (end - start <= THRESHOLD){
                //If the task is small enough, compute directly
                int sum = 0;
                for (int i = start; i < end; i++){
                    sum += array[i];
                }
                return sum;
            } else {
                //Otherwise, split the task into 2 subsets
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);

                //Fork the left task (run asynchronously)
                leftTask.fork();

                //Compute the right task directly
                int rightResult = rightTask.compute();

                int leftResult = leftTask.join();

                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        //Initialize an array with some values
        int[] array = {1,2,3,4,5,6,7,8,9,10};

        //Create a ForkJoinPool to manage the tasks 
        ForkJoinPool pool = new ForkJoinPool();

        SumTask mainTask = new SumTask(array, 0, array.length);

        int sum = pool.invoke(mainTask);

        System.out.println("Sum: " + sum);
    }
}