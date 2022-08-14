package DataStructures_and_Algorithms.Sort;

//选择排序

/*  [2,4,3,9,6,9]
    分析：
        1、假设第一个数为最小值，需要比较(n-1)轮，即除第一个数外剩余的数都会成为一个最小值。
        2、除第一个数外，剩余数找到一个最小值与第一个数比较，比其小交换两个数的位置。
        3、假设第二个数为最小值，一直循环下去。
 */

public class SelectionSort {
    //选择排序
   public void selectionSort(int[] arr){
       if(arr == null){
           return;
       }
       for(int i = 0 ; i < arr.length-1 ; i++){
           int min = arr[i];
           int index = i;
           for(int j = i+1 ; j < arr.length ; j++){
               if(arr[j] < min){
                   min = arr[j];    //记录最小值
                   index = j;   //记录最小值的下标
               }
           }
           int temp = arr[i];
           arr[i] = min;
           arr[index] = temp;   //将假设的最小值给真的最小值
       }
   }

   //test
   public static void main(String[] args) {
       int[] arr =  new int[]{2,4,9,1,2,5};
       SelectionSort sort = new SelectionSort();
       sort.selectionSort(arr);

       //打印数组
       for (int i = 0; i < arr.length; i++) {
           System.out.printf(arr[i]+"\t");
       }
   }
}
