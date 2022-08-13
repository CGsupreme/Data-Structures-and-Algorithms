package DataStructures_and_Algorithms.Recursion;

//斐波那契数列(非递归方法)
/*
    分析：
        1、n不能小于1，而且当n等于1、2时值都为1.
        2、用beforebefore记录第一个数，before记录第二个数。
        3、当n大于2时：current = beforebefore + before
        4、使用循环：将beforebefore替代before，before替代current，current其相加。
 */

public class FibonacciNotRecursion {
    public int function(int n){
        if(n < 1){
            return -1;
        }else if (n == 1 || n == 2){
            return 1;
        }else {
            int beforebefore = 1;
            int before = 1;
            int current = beforebefore + before;
            for(int i = 3 ; i <= n ; i++){
                current = beforebefore + before;
                beforebefore = before;
                before = current;
            }
            return current;
        }
    }
}

class TestFibonacciNotRecursion{
    public static void main(String[] args) {
        FibonacciNotRecursion f = new FibonacciNotRecursion();

        //打印斐波那契数列
        for (int i = 1; i <= 10; i++) {
            System.out.print(f.function(i)+" ");
        }

        //打印斐波那契数列值
        System.out.println();
        int num = f.function(20);
        System.out.println(num);
    }
}

