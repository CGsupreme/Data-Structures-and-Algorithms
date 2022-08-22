package DataStructures_and_Algorithms.LinkedList;
//单向环形链表（约瑟夫环问题）

//节点类
class NewNode {
    private int no;
    private NewNode next;

    //构造器
    public NewNode(int no) {
        this.no = no;
    }

    //get/set方法

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public NewNode getNext() {
        return next;
    }

    public void setNext(NewNode next) {
        this.next = next;
    }
}

//单向环形链表
public class SingleCircleLinkedList {
    //first指针：保存第一个节点，使新增的节点指向first指针，构成环形链表
    NewNode first = null;

    //方法一：增加节点
    public void addNode(int num){
        //temp指针：保存链表中的最后一个节点，在添加新节点时，其可以指向新节点
        NewNode temp = null;

        //对传入参数判断
        if(num < 1){
            System.out.println("请输入合法值");
            return;
        }

        //for循环根据循环因子数创建带有编号的节点
        for(int i = 1 ; i <= num ; i++){
            //每次创建一个新的节点
            NewNode current = new NewNode(i);
            //第一个节点和其余节点有区别
            if (i == 1){
                first = current;
                current.setNext(first);
                temp = first;
            }else {
                temp.setNext(current);
                current.setNext(first);
                //temp后移
                temp = current;
            }
        }

    }

    //方法二：遍历单向环形链表
    public void traverseNode(){
        //temp指针：用于遍历环形链表
        NewNode temp = null;

        //环形链表为空
        if(first == null){
            System.out.println("单向环形链表为空");
            return;
        }

        temp = first;
        while(true){
            System.out.println("节点编号为:"+temp.getNo());

            if(temp.getNext() == first){
                break;
            }

            temp = temp.getNext();
        }

        return;
    }

    //方法三：循环出圈直到最后一个
    //n：总共多少人，startNo:开始编号，k:每隔k号出圈
    public void out(int n ,int startNo,int k){
        //判断参数
        if(n < 1 || startNo < 1 || k < 1){
            System.out.println("输入数据不合法");
            return;
        }
        //循环temp指针，指向first后一个位置
        NewNode temp = first;
        while(true){
            if(temp.getNext() == first){
                break;
            }
            temp = temp.getNext();
        }

        //将first和temp指针指向startNo位置，移动startNo-1次
        for (int i = 0 ; i < startNo-1 ; i++){
            first = first.getNext();
            temp = temp.getNext();
        }

        while (true){
            //只剩一个节点时退出
            if(temp == first){
                break;
            }

            for (int i = 0; i < k-1; i++) {
                 first = first.getNext();
                 temp = temp.getNext();
            }

            System.out.println("出圈节点为："+first.getNo());

            first = first.getNext();
            temp.setNext(first);
        }

        System.out.println("最后一个节点为："+first.getNo());
    }
    
}

//测试
class SingleCircleLinkedListTest{
    public static void main(String[] args) {
        //创建环形链表
        SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();
        singleCircleLinkedList.addNode(5);

        //遍历环形链表
        singleCircleLinkedList.traverseNode();

        //总共5人，从1号开始，2号出圈
        singleCircleLinkedList.out(5,1,2);
    }

}
