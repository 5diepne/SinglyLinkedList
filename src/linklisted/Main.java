/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linklisted;

/**
 *
 * @author DiepTCNN
 */
class LinkedList {

    Node head, tail;

    public LinkedList() {
        head = tail = null;
    }

    public boolean empty() {
        return head == null;
    }

    public void insert_tail(int x) {
        Node new_node = new Node(x);
        if (empty()) {
            head = new_node;
        } else {
            tail.next = new_node;
        }
        tail = new_node;
    }

    public void insert_after(Node new_ele, Node pred) {
        // new_ele = new element
        // pred là previous node
        if (pred != null) {
            new_ele.next = pred.next;
            pred.next = new_ele;
        } else {
            // pred = null thì chèn đầu
            new_ele.next = head;
            head = new_ele;
        }

        if (pred == tail) {
            tail = new_ele;
        }
    }
// ================ addToTail =========================   

    public void addToTail(int x) {
        Node new_ele = new Node(x);
        insert_after(new_ele, tail);
    }

// ================ addToHead ========================= 
    public void addToHead(int x) {
        insert_after(new Node(x), null);
    }
// ====================== deleteFromHead ==================

    public void deleteHead() {
        if (empty()) {
            System.out.println("List is empty!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node p = head; // gán head cho biến tạm gọi là p
            head = head.next; // Khởi tạo head mới 
            tail.next = head;
        }
    }
//====================== deleteTail =======================
    
    public void deleteTail() {
        if (empty())
            System.out.println("List is empty.");
        else
            if (head == tail)
                head = tail = null;
            else {
                Node p = head;
                while (p.next != tail)
                    p = p.next;
                tail = p;
                tail.next = null;
            }           
    }
    // ====================== deleteAfter ==================

    public void deleteAfter(Node pred) {
        Node temp;
        if (pred != null) {
            temp = pred.next;
            pred.next = temp.next;
        } else {
            temp = head;
            head = temp.next;
        }
        if (temp == tail) {
            tail = pred;
        }
    }
// ================ traverse =========================  

    public void traverse() {
        for (Node i = head; i != null; i = i.next) {
            System.out.println(" - " + i);
        }
    }

// ==================== increasing sort ========================= 
    public boolean isSorted() {
        Node t = head;
        while (t.next != null) {
            if (t.data > t.next.data) {
                return false;
            }
            t = t.next;
        }
        return true;
    }

// ====================  Reverse linked list =========================  
    public void reverse() {
        Node t = head.next;
        tail = head.next = null;
        while (t != null) {
            Node sau = t.next; // giữ lại node sau của t
            insert_after(t, null);
            t = sau;
        }
    }
// ======================= updateNodeData =========================
    public boolean updateNodeData(int target, int newData) {
        for (Node p = head; p != null; p = p.next)
            if (p.data == target) {
                p.data = newData;
                return true;
            }
        return false;
    }
// ====================== toString() ======================
    @Override
    public String toString() {
        String s = "";
        for (Node i = head; i != null; i = i.next) {
            s += i;
        }
        return s;
    }

}

public class Main {

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
//            l.insert_tail(6);
//            l.insert_tail(3);
//            l.traverse();
        l.addToTail(6);
        l.addToTail(4);
        l.addToTail(5);
        l.addToTail(3);
        l.addToTail(1);
        l.insert_tail(10);
        l.insert_tail(9);
        l.insert_tail(7);
        
        // reverse    
        l.reverse();
        System.out.println("The reverse is " + l);
        // sort
        if (l.isSorted()) {
            System.out.println("INCREASING SORTED");
        } else {
            System.out.println("UNSORTED");
        }
        //update
        System.out.println("");
        if (l.updateNodeData(6, 11))
            System.out.println("Updating is successful.");
        else
            System.out.println("Updating is failed.");
        
        // traverse
        l.traverse();

    }
}
