package treeImplementation;



public class BSTreeNode<E extends Comparable<? super E>> {
    private E data;
    private BSTreeNode<E> left;
    private BSTreeNode<E> right;
    private BSTreeNode<E> parent;

    public BSTreeNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BSTreeNode<E> getLeft() {
        return left;
    }
    
    public void setLeft(BSTreeNode<E> left) {
        this.left = left;
    }

    public BSTreeNode<E> getRight() {
        return right;
    }

    public void setRight(BSTreeNode<E> right) {
        this.right = right;
    }

    public BSTreeNode<E> getParent() {
        return parent;
    }

    public void setParent(BSTreeNode<E> parent) {
        this.parent = parent;
    }

}
