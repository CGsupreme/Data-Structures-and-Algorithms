package DataStructures_and_Algorithms.Queue;

import java.util.Scanner;

//数组模拟队列
//功能：可以实现队列元素入队、出队（出队以后查看队列该处为0）、获取队头元素、查看队列。

public class ArrayQueue {
    //队列的私有属性:队头、队尾、队列最大值、数组
    //初始化队列：front = rear = -1
    //front和arr是静态变量，为了使队列元素出队后变为0
    public static int front = -1;
    private int rear = -1;
    private int maxSize;
    public static int[] arr;

    //构造器：用于队列初始化大小
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
    }

    //判断队列是否为空---队头等于队尾即为队空
    public boolean isEmpty(){
        return front == rear;
    }

    //判断队列是否已满---队尾等于最大队列减一即队满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //入队：队尾指针后移，入队元素进入数组
    public void addQueue(int num){
        //入队前必须判断队列是否已满,必须有空的返回值,没有返回值就会继续向下执行，指针后移数组下标越界，报错
        if(isFull()){
            System.out.println("队列已满,禁止入队");
            return;
        }
        //队尾指针后移，元素入队
        rear++;
        arr[rear] = num;
    }

    //出队：队头指针后移，队头元素出队
    public int getQueue(){
        //出队前必须判断队列是否为空，队列空报错异常，不能返回数字-1,可能队列中有元素-1
        if(isEmpty()){
            throw new RuntimeException("队列为空，出队异常，请添加数据");
        }
        //队头指针后移，返回出队元素
        front++;
        return arr[front];
    }

    //显示队列情况
    public void showQueue(){
        System.out.println("队列如下：");
        for(int i = 0 ; i < arr.length ; i++){
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }

    //查看队头元素
    public int headQueue(){
        //队列为空时，查看队头元素报错
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法返回队头元素，请添加数据");
        }
        return arr[front+1];
    }

}

//数组模拟队列测试
class ArrayQueueTest{
    public static void main(String[] args) {
        //初始化队列对象
        Scanner input = new Scanner(System.in);
        System.out.println("请输入队列初始化大小：");
        int maxSize = input.nextInt();
        ArrayQueue queue = new  ArrayQueue(maxSize);

        boolean flag = true;
        while(flag){
            //菜单
            System.out.println("导航窗口：");
            System.out.println("a(addQueue):元素入队");
            System.out.println("g(getQueue):元素出队");
            System.out.println("s(showQueue):显示队列");
            System.out.println("h(headQueue):获取队头元素");
            System.out.println("e(exit):退出");

            //获取用户输入的字符,在进行匹配
            System.out.println("请输入你的操作：");
            char key = input.next().charAt(0);

            switch(key){
                case 'a':
                    System.out.println("请输入入队元素：");
                    int num = input.nextInt();
                    queue.addQueue(num);
                    break;
                case 'g':
                    try {
                        System.out.println(queue.getQueue());
                        //队头元素出队后，front刚好到出队元素位置这里，置其为0
                        ArrayQueue.arr[ArrayQueue.front] = 0;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'h':
                    System.out.println("队头元素："+queue.headQueue());
                    break;
                case 'e':
                    input.close();
                    flag = false;
                    break;

            }

        }

    }
}
