package treeImplementation;

import java.util.NoSuchElementException;
import java.util.Stack;

import utilities.Iterator;


/**
 * An iterator for traversing a binary search tree in post-order traversal.
 *
 * @param <E> The type of elements in the binary search tree.
 */
public class PostOrderIterator<E extends Comparable<? super E>> implements Iterator<E> {

    private Stack<BSTreeNode<E>> stack;
    private BSTreeNode<E> current;

    // // Debugging
    // public void printTraversal() {
    //     System.out.println("Post-order traversal:");
    //     printPostOrderTraversal(current);
    //     System.out.println();
    // }

    // private void printPostOrderTraversal(BSTreeNode<E> node) {
    //     if (node != null) {
    //         printPostOrderTraversal(node.getLeft());
    //         printPostOrderTraversal(node.getRight());
    //         System.out.print(node.getData() + " ");
    //     }
    // }
    
    // // End of Debugging

    /**
     * Constructs an PostOrderIterator starting from the given root node.
     *
     * @param root The root node of the binary search tree.
     */
    public PostOrderIterator(BSTreeNode<E> root) {
        this.stack = new Stack<>();
        this.current = root;

        // Initialize the stack with nodes along the leftmost path
        while (current != null) {
            stack.push(current);
            current = current.getLeft();
        }
    }

    /**
     * Checks if there is another element in the binary search tree.
     *
     * @return True if there is another element, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * Gets the next element in the binary search tree.
     *
     * @return The next element in the binary search tree.
     * @throws NoSuchElementException If there is no next element.
     */
    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        // Get the top node from the stack
        BSTreeNode<E> node = stack.pop();
        E data = node.getData();

        // Move to the next node in the traversal
        if (!stack.isEmpty() && node == stack.peek().getLeft()) {
            // If the node is the left child, move to the right child's leftmost path
            current = stack.peek().getRight();
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
        }

        return data;
    }
    

}