package DataStructures_and_Algorithms.Search;

//二分查找

import DataStructures_and_Algorithms.Sort.BubbleSort;

import java.util.Scanner;

/*
    分析：
        1、先设置标志 left=0 right=arr.length mid=left+(right-left)/2 设置下标即可。
        2、如果所要找的数是mid退出，返回找到。
        3、所找的数在mid左边，将right设置为mid-1。
        4、所找的数在mid右边，将left设置为mid+1
        5、循环找，循环终止条件为left<=right即可。
        6、前提条件为：数组为有序数组。
 */
public class BinarySearch {
    public void binarySearch(int num){
        //生成一个随机数组
        int[] arr = new int[10];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = (int)(Math.random()*10);
        }

        //冒泡排序将其变为有序数组
        BubbleSort sort = new BubbleSort();
        sort.bubbleSort(arr);

        //打印数组
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+"\t");
        }

        boolean flag = false;
        for(int left = 0,right = arr.length-1;left <= right;){
            int mid = left + (right - left)/2;
            if(num == arr[mid]){
                flag = true;
                break;
            }else if (num < arr[mid]){
                right = mid -1;
            }else if (num > arr[mid]){
                left = mid +1;
            }

        }

        System.out.println();

        if(flag == false){
            System.out.println("没有找到");
        }else if (flag == true){
            System.out.println("找到该数");
        }
    }

    //test
    public static void main(String[] args) {
        System.out.printf("请输入要查询的数：");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        BinarySearch binary = new BinarySearch();
        binary.binarySearch(num);
    }
}
