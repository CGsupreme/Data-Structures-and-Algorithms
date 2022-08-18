package DataStructures_and_Algorithms.LinkedList;

//单链表
/*
    方法一：往链表尾添加新节点
    方法二：链表的遍历
    方法三：按顺序插入新节点
    方法四：修改节点的信息
    方法五：删除节点
    方法六：统计节点个数
    方法七：查找单链表表倒数第k个节点
    方法八-1：单链表的反转（拆分）
    方法八-2：单链表的反转

 */

import javax.management.NotificationEmitter;

//测试类
class SingleLinkedListTest{
    public static void main(String[] args) {
        //创建链表，自动初始化头节点
        SingleLinkedList linkedList = new SingleLinkedList();

        //初始化新节点
        Node node1 = new Node(1,"张三","及时雨");
        Node node2 = new Node(2,"李四","智多星");
        Node node3 = new Node(3,"王五","豹子头");
        Node node4 = new Node(4,"老六","黑旋风");

        //链表中添加新节点
        linkedList.addNodeByOrder(node1);
        linkedList.addNodeByOrder(node4);
        linkedList.addNodeByOrder(node3);
        linkedList.addNodeByOrder(node2);

        //修改节点信息之前遍历单链表
        System.out.println("修改节点信息之前：");
        linkedList.traverseLinkedList();


        //修改链表某个节点的信息
        Node newNode1 = new Node(1,"及时雨","张三");
        Node newNode2 = new Node(2,"智多星","李四");
        Node newNode3 = new Node(3,"豹子头","王五");
        Node newNode4 = new Node(4,"黑旋风","老六");

        linkedList.upDate(newNode1);
        linkedList.upDate(newNode2);
        linkedList.upDate(newNode3);
        linkedList.upDate(newNode4);


        //修改节点信息之后遍历单链表
        System.out.println("修改节点信息之后：");
        linkedList.traverseLinkedList();

        //删除节点之前个数
        System.out.println("删除节点之前节点个数："+linkedList.count());

        //删除节点
        linkedList.delete(newNode1);

        //删除节点之后遍历单链表
        System.out.println("删除节点之后：");
        linkedList.traverseLinkedList();

        //删除节点之后个数
        System.out.println("删除节点之后节点个数："+linkedList.count());

        //倒数第k个节点
        System.out.println("倒数第1个节点的信息：");
        System.out.println(linkedList.seekReciprocalNode(1).toString());

        //单链表的反转
        linkedList.reverse();
        System.out.println("法一：反转之后的链表：");
        linkedList.traverseLinkedList();

        linkedList.newReverse(linkedList.head);
        System.out.println("法二：再次反转之后的链表：");
        linkedList.traverseLinkedList();

    }

}

//单链表的类，用于管理单链表
public class SingleLinkedList {
    //创建头结点
    Node head = new Node(0,"","");

    //方法一：往链表尾添加新节点
    public void addNode(Node newNode){
        //定义一个节点类型的临时指针指向头结点
        Node temp = head;

        //找到链表的最后一个节点，使最后一个节点的next指向新节点
        while(true){
            //进循环先判断的是头节点next域是否为空
            if(temp.next == null){
                break;  //为空即找到最后一个节点，开始添加新节点
            }
            //没有找到最后一个节点，临时指针后移
            temp = temp.next;
        }

        //最后一个节点的next指向新节点
        temp.next = newNode;

    }

    //方法二：链表的遍历
    public void traverseLinkedList(){
        //定义一个节点类型的临时指针
        Node temp = head;

        if(temp.next == null){
            System.out.println("链表为空");
            return;
        }

        //用while循环遍历链表
        while(true){
            if(temp.next == null){
                break;
            }
            //上一个节点的next域不空，就使temp指向下一个节点
            temp = temp.next;
            //打印节点信息
            System.out.println(temp.toString());
        }
    }

    //方法三：按顺序插入新节点
    public void addNodeByOrder(Node newNode){
        //定义节点类型的临时指针，指向头节点
        Node temp = head;

        //设置标志看是否存在相同值
        boolean flag = false;

        //找合适的位置插入要等于temp小于temp.next
        while(true){
            //如果到达单链表尾，直接插入
            if(temp.next == null){
                break;
            }
            //找到合适的位置，即可插入
            if(temp.next.id > newNode.id){
                break;
            }
            //没有合适位置：即存在相同序号
            if(temp.id == newNode.id){
                flag = true;
                break;
            }
            //没有找到，指针后移
            temp = temp.next;
        }

        //插入节点
        if(flag == true){
            System.out.println("存在相同节点，不能插入");
            return;
        }else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    //方法四：修改节点的信息
    public void upDate(Node newNode){// 传入节点，编号不能修改
        //创建临时指针
        Node temp = head;

        //是否找到的标志
        boolean flag = false;

        //找需要修改的节点
        while(true){
            //没找到，或者链表为空
            if(temp.next == null){
                break;
            }
            //找到该节点
            if(temp.next.id == newNode.id){
                flag = true;
                break;
            }
            //没找到指针后移
            temp = temp.next;
        }

        if(flag == false){
            System.out.println("该节点不存在");
            return;
        }else{//找到，进行节点信息修改
            temp.next.name = newNode.name;
            temp.next.nickName = newNode.nickName;
        }

    }

    //方法五：删除节点
    public void delete(Node oldNode){
        //创建临时指针
        Node temp = head;
        if(temp.next == null){
            System.out.println("空链表");
        }

        //是否找到的标志
        boolean flag = false;

        //找需要删除的节点
        while(true){
            //没找到
            if(temp.next == null){
                break;
            }
            //找到
            if(temp.next.id == oldNode.id){
                flag = true;
                break;
            }
            //临时指针后移
            temp = temp.next;
        }

        if(flag == false){
            System.out.println("没有找到节点");
            return;
        }else {//删除节点
            temp.next = temp.next.next;
        }

    }

    //方法六：统计节点个数
    public int count(){
        //临时指针
        Node temp = head.next;
        if(head.next == null){
            System.out.println("单链表尾空");
            return 0;
        }

        int count = 0;
        while(true){
            count++;
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }

        return count;

    }

    //方法七：查找单链表表倒数第k个节点
    public Node seekReciprocalNode(int k){
        //限制k的下标
        if(k<1 || k>count()){
            System.out.println("找不到此下标的节点");
            return null;
        }
        //临时节点
        Node temp = head;
        if(head.next == null){
            System.out.println("链表为空");
            return null;
        }

        for(int i = 0 ; i < count()-k ; i++){
            temp = temp.next;
        }

        return temp.next;
    }

    //方法八-1：单链表的反转（拆分）
    public void reverse(){
        //临时指针
        Node temp = head.next;
        if(temp == null || temp.next == null){
            return;
        }

        //新建一个临时头节点
        Node newHead = new Node(0,"","");
        Node tempNext  = null;
        int length = count();
        for(int i =0 ; i < length ; i++){
            //也可以使用次循环：while (temp != null)
            //1、需要用一个变量保存temp后面的节点，否则断开连接以后找不到
            tempNext = temp.next;

            //2、把temp节点的next断开，指向newHead的next此区域为空
            temp.next = newHead.next;

            //3、再使newHead指向拆下的节点
            newHead.next = temp;

            //4、再将临时指针后移
            temp = tempNext;
        }

        //将头节点指向连接好的反转后的链表
        head.next = newHead.next;
    }

    //方法八-2：单链表的反转
    public void newReverse(Node head){
        //临时指针
        Node temp = head.next;
        if(temp == null || temp.next == null){
            return;
        }

        //保存下一个节点信息的变量
        Node nextTemp = null;
        Node preTemp = null;


        while (temp != null){
            nextTemp = temp.next;
            temp.next = preTemp;
            preTemp = temp;
            temp = nextTemp;
        }
        head.next = preTemp;
    }

}

//节点类，对象为单个节点
class Node{
    //节点的数据域data
    public int id;
    public String name;
    public String nickName;
    //节点的指针域next
    public Node next;

    //构造器：用于初始化节点
    public Node(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    //重写toString方法，用于单链表遍历，此处next不能添加，不然会循环调用以后的对象信息
    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
