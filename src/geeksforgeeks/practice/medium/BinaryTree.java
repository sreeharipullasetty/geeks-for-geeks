package geeksforgeeks.practice.medium;

import java.util.ListResourceBundle;
import java.util.Objects;

public class BinaryTree {

    Node root, head, left, right = null;

    public void add(int data) {
        Node node = new Node(data, left, right);
        if (Objects.isNull(root)) {
            root = node;
        } else {
            boolean isLeft = false;
            while (head != null) {
                if (node.data < head.data) {
                    if (head.left != null) {
                        head = head.left;
                    } else {
                        isLeft = true;
                        break;
                    }

                } else {
                    if (head.right != null) {
                        head = head.right;
                    } else {
                        isLeft = false;
                        break;
                    }
                }
            }
            if (isLeft) {
                head.left = node;
            } else {
                head.right = node;
            }
        }
        head = root;
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    public void preOrder(Node head) {
        if (Objects.nonNull(head)) {
            System.out.print(head.data + " ");
            preOrder(head.left);
            preOrder(head.right);
        }
    }

    public void inOrder(Node head) {
        if (Objects.nonNull(head)) {
            inOrder(head.left);
            System.out.print(head.data + " ");
            inOrder(head.right);
        }
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    public void postOrder(Node head) {
        if (Objects.nonNull(head)) {
            postOrder(head.left);
            postOrder(head.right);
            System.out.print(head.data + " ");
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    public void leftView() {
        leftView(root);
    }

    public void leftView(Node head) {
        if (Objects.nonNull(head)) {
            leftView(head.left);
            leftView(head.right);
        }
    }
}
