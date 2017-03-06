/**
 * Created by Ilua on 05.03.2017.
 */
public class BinaryTree<T extends Comparable<T>>{

    public Node<T> root;
    private int size;

    public void add(T element)
    {
        Node<T> node=new Node<>(element);
        if(root==null) root=node;
        else
        {
            boolean check=true;
            Node newNode=root;
            while (check)
            {
                if(newNode.getValue().compareTo(element)<=0)
                {
                    if(newNode.getRight()==null) {
                        newNode.setRight(node);
                        check=false;
                    }
                    else newNode=newNode.getRight();
                }
                else
                {
                    if(newNode.getLeft()==null) {
                        newNode.setLeft(node);
                        check=false;
                    }
                    else newNode=newNode.getLeft();
                }
            }
        }
        size++;
    }

    public boolean isEmpty()
    {
        return root==null;
    }

    public int size() {
        return size;
    }

    public boolean contains(Node<T> node,T element)
    {
        if(node==null) return false;
        else
        {
            Node<T> newNode=node;
            while (true)
            {
                int compare=newNode.getValue().compareTo(element);
                if(compare==0)
                {
                    return true;
                }
                else if(compare<0)
                {
                    if(newNode.getRight()==null) return false;
                    else newNode=newNode.getRight();
                }
                else if(compare>0)
                {
                    if(newNode.getLeft()==null) return false;
                    else newNode=newNode.getLeft();
                }
                else return false;
            }
        }
    }

    private Node<T> toNode;
    public boolean checkEmail(T from, T to)
    {
        toNode=root;
        boolean containsFrom = containsNodePoint(root,from,to);
        if(containsFrom)
        {
            return contains(toNode,to);
        }
        else return false;
    }

    private boolean containsNodePoint(Node<T> currentNode, T value, T secondValue)
    {
        boolean c=true;
        if(currentNode==null) return false;
        while (true) {
            int compare=currentNode.getValue().compareTo(value);
            int compare2=currentNode.getValue().compareTo(secondValue);
            if(compare==0)
            {
                return true;
            }
            else if(compare<0)
            {
                if (compare2 < 0 && c) toNode = currentNode.getRight();
                else c=false;
                if(currentNode.getRight()==null) return false;
                else currentNode = currentNode.getRight();
            }
            else if(compare>0)
            {
                if (compare2 > 0 && c) toNode = currentNode.getLeft();
                else c=false;
                if(currentNode.getLeft()==null) return false;
                else currentNode = currentNode.getLeft();
            }
            else return false;
        }
    }

    private class Node<T extends Comparable>
    {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }
    }
}

