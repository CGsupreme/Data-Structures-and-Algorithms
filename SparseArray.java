package DataStructures_and_Algorithms.SparseArray;

/*
1、二维数组转稀疏数组分析：
        ·静态初始化一个二维数组,任意位置赋值，其余位置为0
        ·遍历二维数组得到非0值得个数
        ·创建稀疏数组，此时稀疏数组全为0
        ·遍历二维数组，取出非0值，创建完成稀疏数组

2、稀疏数组转二维数组分析：
        ·稀疏数组第一行第一、二列是二维数组行、列数，创建二维数组
        ·遍历稀疏数组从第二行起，非0元素的行列和值,列数固定只要一个for循环，不断变化行就行。
        ·创建完成二维数组
 */

public class SparseArray {
    public static void main(String[] args) {
        //1、由二维数组转换为稀疏数组
        //定义一个10*10的二维数组,任意位置赋值，其余位置为0
        int[][] arr = new int[10][10];
        arr[2][3] = 17;
        arr[4][6] = 20;
        arr[9][9] = 17;

        //打印二维数组,同时得到非0值得个数
        System.out.println("二维数组如下：");
        int count = 0;
        for(int[] row : arr){
            for(int num : row){
                System.out.printf(num+"\t");
                if(num != 0){
                    count++;
                }
            }
            System.out.println();
        }

        //创建稀疏数组
        int[][] sparseArray = new int[count+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = 3;


        //遍历二维数组，取出非0值，创建完成稀疏数组
        int rows = 0;        //记录稀疏数组的行，每个数存在不同行，行数要不断增加
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length ; j++){
                if(arr[i][j] != 0){
                    rows++;
                    sparseArray[rows][0] = i;
                    sparseArray[rows][1] = j;
                    sparseArray[rows][2] = arr[i][j];
                }
            }
        }

        //打印稀疏数组
        System.out.println("稀疏数组：");
        for(int[] row : sparseArray){
            for(int num : row){
                System.out.printf(num+"\t");
            }
            System.out.println();
        }

        //2、稀疏数组转二维数组
        //稀疏数组第一行第一、二列是二维数组行、列数
        int[][] arr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        System.out.println("还未完全转换完的二维数组：");
        for(int[] row : arr2){
            for(int num : row){
                System.out.printf(num+"\t");
            }
            System.out.println();
        }

        //遍历稀疏数组从第二行起，非0元素的行列和值,列数固定只要一个for循环，不断变化行就行。
        for(int i = 1 ; i < sparseArray.length ; i++){
            arr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("完全转换完后的二维数组：");
        for(int[] row : arr2){
            for(int num : row){
                System.out.printf(num+"\t");
            }
            System.out.println();
        }
        
    }
}
