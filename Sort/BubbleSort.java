package DataStructures_and_Algorithms.Sort;

//冒泡排序

/*
    分析：
        1、最后一个数不需要排，其余排好其就是最大。故需要(n-1)轮。
        2、没个数需要和后面的一个数比较，前比后大交换位置。
        3、没个数比较时不需要和前面的数比较。故内层比较(n-1-i)次。
 */

public class BubbleSort {
    public void bubbleSort(int[] arr){
        if(arr == null){
            return;
        }
        for(int i = 0 ; i < arr.length-1 ; i++){
            for(int j = 0 ; j < arr.length-1-i ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //test
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,6,8,3,2,2};
        BubbleSort sort = new BubbleSort();
        sort.bubbleSort(arr);

        //打印数组
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+"\t");
        }
    }

}
