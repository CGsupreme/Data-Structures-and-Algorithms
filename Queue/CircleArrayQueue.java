package DataStructures_and_Algorithms.Queue;

import java.util.Scanner;

//数组模拟循环队列
/*
1、基础:
	·数组模拟队列使用一次就不能使用，故使用数组模拟环形队列。

	·队头指针(front)指向队列第一个元素。
	·队尾指针(rear)指向队列最后一个元素的下一个位置。
	·队头队尾指针初始值：front=rear=0
	·最大有效数据个数为：n-1

	·队满条件：
			(rear+1) % maxSize == front

	·队空条件：
			rear == front
		或者:
			(rear+maxSize-front) % maxSize == 0

	·队列有效数据个数：
			(rear+maxSize-front) % maxSize
			%maxSize:是为了0个有效数据


2、数组模拟队列和数组模拟环形队列区别：
	·front和rear的初始值和指针指向位置不同：
		1）队列：front指向队列头元素的前一个位置，rear指向队列尾部元素。初始值：front = rear = -1
		2）环形队列：front指向队列头元素，rear指向队列尾部的后一个元素位置。初始值：front = rear = 0

	·判断队满isFull：
		1）队列：rear == maxSize-1
		2）环形队列：(rear+1) % maxSize == front

	·判断队空isEmpty：
		1）队列：front = rear = -1
		2）环形队列：front = rear = 0

	·入队addQueue：
		1）队列：判断队列是否满；arr[rear] = num；rear++
		2）环形队列：判读队列是否满；arr[rear] =num;rear = (rear+1)%maxSize;

	·出队getQueue：
		1）队列：判断队列是否为空；front++;arr[front]出队；
		2）环形队列：判断队列是否为空；arr[front]出队需要临时变量存储；front = (front+1)%maxSize;

	·显示队列情况showQueue：
		1）队列：判断队列是否为空；for循环从下标为0到数组最大长度循环遍历数组；数组下标为 i
		2）环形队列：判断队列是否为空；for循环从小标为front 开始到 (ront+数组有效数据个数) 循环遍历数组;数组的下标为 i%maxSize

	·查看队列头元素headQueue：
		1）队列：判断队列是否为空；返回arr[front+1]
		2）循环队列：判断队列是否为空；返回arr[front]

	·队列有效数据个数effectiveData：
		1）环形队列：(rear+maxSize-front) % maxSize
 */
//数组模拟循环队列
public class CircleArrayQueue {
    //队列的私有属性:队头、队尾、队列最大值、数组
    //初始化队列：默认值front = rear = 0
    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;

    //构造器：用于队列初始化大小
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
    }

    //判断队列是否为空---队头等于队尾即为队空
    public boolean isEmpty() {
        return front == rear;
    }

    //判断队列是否已满---队尾等于最大队列减一即队满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //入队：队尾指针后移，入队元素进入数组
    public void addQueue(int num) {
        //入队前必须判断队列是否已满,必须有空的返回值,没有返回值就会继续向下执行，指针后移数组下标越界，报错
        if (isFull()) {
            System.out.println("队列已满,禁止入队");
            return;
        }
        //rear指针是从0开始的，先赋值再后移，rear永远在最后一个元素的后一个位置
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    //出队：队头元素出队,队头指针后移
    public int getQueue() {
        //出队前必须判断队列是否为空，队列空报错异常，不能返回数字-1,可能队列中有元素-1
        if (isEmpty()) {
            throw new RuntimeException("队列为空，出队异常，请添加数据");
        }
        //队头指针后移，返回出队元素
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列情况
    public void showQueue() {
        System.out.println("队列如下：");
        for (int i = front; i < front + effectiveData(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //获取队列有效数据个数
    public int effectiveData() {
        return (rear + maxSize - front) % maxSize;
    }

    //查看队头元素
    public int headQueue() {
        //队列为空时，查看队头元素报错
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法返回队头元素，请添加数据");
        }
        return arr[front];
    }

}

//数组模拟环形队列测试
class CircleArrayQueueTest {
    public static void main(String[] args) {
        //初始化队列对象
        Scanner input = new Scanner(System.in);
        System.out.println("请输入环形队列初始化大小：");
        int maxSize = input.nextInt();
        CircleArrayQueue queue = new CircleArrayQueue(maxSize);

        boolean flag = true;
        while (flag) {
            //菜单
            System.out.println("导航窗口：");
            System.out.println("a(addQueue):元素入队");
            System.out.println("g(getQueue):元素出队");
            System.out.println("s(showQueue):显示队列");
            System.out.println("h(headQueue):获取队头元素");
            System.out.println("d(effectiveData):获取队列有效数据个数");
            System.out.println("e(exit):退出");

            //获取用户输入的字符,在进行匹配
            System.out.println("请输入你的操作：");
            char key = input.next().charAt(0);

            switch (key) {
                case 'a':
                    System.out.println("请输入入队元素：");
                    int num = input.nextInt();
                    queue.addQueue(num);
                    break;
                case 'g':
                    try {
                        System.out.println(queue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    queue.showQueue();
                    break;

                case 'h':
                    try {
                        System.out.println("队头元素：" + queue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'd':
                    System.out.println("有效数据个数：" + queue.effectiveData());
                    break;

                case 'e':
                    input.close();
                    flag = false;
                    break;

            }

        }

    }
}