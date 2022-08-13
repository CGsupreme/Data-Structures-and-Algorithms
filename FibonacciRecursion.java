package DataStructures_and_Algorithms.Recursion;

//斐波那契数列(递归方法)
/*
    要求：
        斐波那契数列（Fibonacci sequence），又称黄金分割数列、
        因数学家列昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“兔子数列”，
        指的是这样一个数列：1、1、2、3、5、8、13、21、34、……
        其规律很明显，从第3个数开始，每个数都等于它前两个数的和。
        f(n) = f(n-2) + f(n-1);

    分析：
        1、递归调用方法，第n个数的斐波那契数列值。
        2、n不能小于1，而且n为1、2时返回1.
        3、当n大于2时，f(n) = f(n-2) + f(n-1)递归调用
 */

public class FibonacciRecursion {
    public int function(int n){
        if(n < 1){
            return -1;
        }else if (n == 1 || n == 2){
            return 1;
        }else {
            return function(n-2) + function(n-1);
        }
    }
}

class Test{
    public static void main(String[] args) {
        FibonacciRecursion f = new FibonacciRecursion();
        //打印斐波那切数列
        for(int i = 1 ; i < 10 ; i++){
            System.out.print(f.function(i)+" ");
        }
        //打印斐波那契数列值
        System.out.println();
        int num = f.function(20);
        System.out.println(num);
    }
}
