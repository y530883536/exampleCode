package forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {

    private static final int threshold = 2;
    private int start;
    private int end;

    public CountTask(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if(end - start < threshold){
            for(int i=start;i<end+1;i++){
                sum = sum + i;
            }
        }else{
            int middle = (start+end)/2;
            CountTask leftTask = new CountTask(start,middle);
            CountTask rightTask = new CountTask(middle+1,end);
            leftTask.fork();
            rightTask.fork();
            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            sum = sum + leftResult;
            sum = sum + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws  Exception{
        //ForkJoinPool构造函数可以指定初始化多少个线程池，如果没有指定的话是0x7fff和CPU核的较小值（）
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1,10);
        ForkJoinTask<Integer> task = forkJoinPool.submit(countTask);
        Integer sum = task.get();
        forkJoinPool.shutdown();
        System.out.println(sum);
    }
}
