package DataStructures_and_Algorithms;

//顺序查找

/*
    分析：
        1、输入需要查找的数。
        2、在随机生成的数组里逐一比对。
        3、返回是否存在该数。
 */

public class SequentialSearch {
    public void sequentialSearch(int num){

        //生成随机数组
        int[] arr =new int[10];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = (int)(Math.random()*10);
        }

        //进行查找
        boolean flag = false; //如果结果为false则没有找到
        for(int i = 0 ; i < arr.length ; i++){
            if(num == arr[i]){
                flag = true;
            }
        }

        if(flag == false){
            System.out.println("不存在");
        }else if(flag == true){
            System.out.println("存在");
        }

        //打印数组
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+"\t");
        }
    }

    //test
    public static void main(String[] args) {
        SequentialSearch sequential = new SequentialSearch();
        sequential.sequentialSearch(5);
    }
}
