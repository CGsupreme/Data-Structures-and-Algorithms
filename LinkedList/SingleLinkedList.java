package DataStructures_and_Algorithms.LinkedList;

//单链表的创建和遍历（直接在链表末尾添加新节点）

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

        //删除节点
        linkedList.delete(newNode1);

        //删除节点之后遍历单链表
        System.out.println("删除节点之后：");
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
