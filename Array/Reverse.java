package DataStructures_and_Algorithms.Array;

//数组元素反转

public class Reverse {
    public void reverse(int[] arr){
        if(arr == null){
            return;
        }
        for(int i = 0,j = arr.length-1 ; i < j ; i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    //test
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        Reverse re = new Reverse();
        re.reverse(arr);

        //打印数组
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+"\t");
        }
    }
}
