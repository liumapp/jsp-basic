package com.liumapp.jspbasic.algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by liumapp on 6/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */


public class BinarySortTree {

    private BinarySortTree parent;
    private BinarySortTree leftChild;
    private BinarySortTree rightChild;
    private int value;

    public BinarySortTree() {
        super();
    }

    public BinarySortTree(int value) {
        super();
        this.value = value;
    }

    /*
     * 查找某个关键字，存在则返回该节点
     */
    public BinarySortTree find(int target) {
        if (target == value) {
            return this;
        } else if (target < value && leftChild != null) {
            return leftChild.find(target);
        } else if (rightChild != null) {
            return rightChild.find(target);
        }
        return null;
    }

    /*
     * 返回某个点的直接前驱
     */
    public BinarySortTree predecessor() {
        if (leftChild == null) { // 该点没有左孩子，所以假如存在前驱，前驱应该在它的祖先中
            BinarySortTree ancestor = this;
            while (ancestor.parent != null
                    && ancestor.parent.leftChild == ancestor) {
                ancestor = ancestor.parent;
            }
            return ancestor.parent;
        } else { // 该点有左孩子，所以前驱肯定存在，且为左子树中的最右节点
            BinarySortTree child = leftChild;
            while (child.rightChild != null) {
                child = child.rightChild;
            }
            return child;
        }
    }

    /*
     * 返回某个点的直接后继
     */
    public BinarySortTree successor() {
        if (rightChild == null) { // 该点没有右孩子，所以假如存在后继，后继应该在它的祖先中
            BinarySortTree ancestor = this;
            while (ancestor.parent != null
                    && ancestor.parent.rightChild == ancestor) {
                ancestor = ancestor.parent;
            }
            return ancestor.parent;
        } else { // 该点有右孩子，所以后继肯定存在，且为左子树中的最右节点
            BinarySortTree child = rightChild;
            while (child.leftChild != null) {
                child = child.leftChild;
            }
            return child;
        }
    }

    /*
     * 插入一个值
     */
    public void insert(int target) {
        if (target <= value) {
            if (leftChild != null) {
                leftChild.insert(target);
            } else {
                leftChild = new BinarySortTree(target);
                leftChild.parent = this;
            }
        } else {
            if (rightChild != null) {
                rightChild.insert(target);
            } else {
                rightChild = new BinarySortTree(target);
                rightChild.parent = this;
            }
        }
    }

    /*
     * 删除一个值
     */
    public void delete(int target) {
        BinarySortTree delete = find(target);
        if (delete != null) {
            delete.delete();
        }
    }

    /*
     * 删除自身
     */
    public void delete() {
        if (leftChild == null && rightChild == null) { // 删除的节点没有子女
            if (parent.leftChild == this) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (rightChild == null) { // 删除的节点只有一个左孩子
            if (parent.leftChild == this) {
                parent.leftChild = leftChild;
            } else {
                parent.rightChild = leftChild;
            }
        } else if (leftChild == null) { // 删除的节点只有一个右孩子
            if (parent.leftChild == this) {
                parent.leftChild = rightChild;
            } else {
                parent.rightChild = rightChild;
            }
        } else { // 删除的节点有两个孩子
            BinarySortTree successor = this.successor();
            if(successor==null) {
                return;
            }
            value = successor.value;
            successor.delete();
        }
    }

    /*
     * 将树转换成字符串并打印在控制台上，用L表示左孩子，R表示右孩子
     */
    public void print() {
        List<BinarySortTree> tree = locateNodes();
        int size = tree.size(); //
        int deepth = 0;
        // 获取树的深度
        while ((size >>= 1) > 0) {
            deepth++;
        }
        deepth++;
        Iterator<BinarySortTree> iterator = tree.iterator();
        int maxPosition = 1;
        for (int floor = 1; floor <= deepth; floor++) { // 层数，从1开始
            maxPosition = 1 << (floor - 1);
            printBlank((1 << (deepth - floor)) - 1);
            for (int position = 0; position < maxPosition; position++) {
                if (iterator.hasNext()) {
                    BinarySortTree node = iterator.next();
                    if (node != null) {
                        System.out.print(node);
                    } else {
                        System.out.print(" ");
                    }
                    printBlank((1 << (deepth - floor + 1)) - 1);
                }
            }
            System.out.println();
        }
    }

    /*
     * 将二叉树用空节点补充成完全二叉树，并以水平遍历形式返回
     */
    private List<BinarySortTree> locateNodes() {
        Queue<BinarySortTree> queue = new LinkedList<BinarySortTree>();
        List<BinarySortTree> tree = new LinkedList<BinarySortTree>(); // 把树补充成完全二叉树，放在这个链表中
        queue.add(this);
        BinarySortTree empty = null;
        int nodeCount = 1; // 队列中非空节点数
        while (queue.size() > 0 && nodeCount > 0) {
            BinarySortTree node = queue.remove();
            if (node != null) {
                nodeCount--;
                tree.add(node);
                BinarySortTree left = node.leftChild;
                BinarySortTree right = node.rightChild;
                if (left == null) {
                    queue.add(empty);
                } else {
                    queue.add(left);
                    if (left != null) {
                        nodeCount++;
                    }
                }
                if (right == null) {
                    queue.add(empty);
                } else {
                    queue.add(right);
                    if (right != null) {
                        nodeCount++;
                    }
                }
            } else {
                tree.add(empty);
                queue.add(empty);
                queue.add(empty);
            }
        }
        return tree;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    private void printBlank(int length) {
        while (length-- > 0) {
            System.out.print(" ");
        }
    }

    public BinarySortTree getParent() {
        return parent;
    }

    public void setParent(BinarySortTree parent) {
        this.parent = parent;
    }

    public BinarySortTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinarySortTree leftChild) {
        this.leftChild = leftChild;
    }

    public BinarySortTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinarySortTree rightChild) {
        this.rightChild = rightChild;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}




