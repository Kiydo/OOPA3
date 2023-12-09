package treeImplementation;

// import org.junit.Assert;
// import org.junit.Before;
// import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utilities.BSTreeADT;
import utilities.Iterator;
import treeImplementation.BSTree;
import treeImplementation.BSTreeNode;

public class BSTreeTest {

    private BSTree<Integer> bst;

    @BeforeEach
    public void setUp() {
        bst = new BSTree<>();
    }

    @Test
    public void testGetRoot() {
       assertNull(bst.getRoot());

        bst.add(10);
        assertEquals(10, bst.getRoot().getData().intValue());
        assertNotNull(bst.getRoot());
    }

    @Test
    public void testGetHeight() {
        assertEquals(0, bst.getHeight());

        bst.add(10);
        assertEquals(1, bst.getHeight());

        bst.add(5);
        bst.add(15);
        assertEquals(2, bst.getHeight());
    }

    @Test
    public void testSize() {
        assertEquals(0, bst.size());

        bst.add(10);
        assertEquals(1, bst.size());

        bst.add(5);
        bst.add(15);
        assertEquals(3, bst.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(bst.isEmpty());

        bst.add(10);
        assertFalse(bst.isEmpty());
    }

    @Test
    public void testClear() {
        bst.add(10);
        assertFalse(bst.isEmpty());

        bst.clear();
        assertTrue(bst.isEmpty());
    }

    @Test
    public void testContains() {
        assertFalse(bst.contains(10));

        bst.add(10);
        assertTrue(bst.contains(10));

        bst.add(5);
        assertFalse(bst.contains(15));
    }

    @Test
    public void testAdd() {
        assertTrue(bst.isEmpty());

        bst.add(10);
        assertFalse(bst.isEmpty());
        assertEquals(1, bst.size());
    }

    @Test
    public void testSearch() {
        assertNull(bst.search(10));

        bst.add(10);
        assertNotNull(bst.search(10));

        bst.add(5);
        assertNull(bst.search(15));
    }

    @Test
    public void testRemoveMin() {
        assertNull(bst.removeMin());

        bst.add(10);
        bst.add(5);
        bst.add(15);

        assertNotNull(bst.removeMin());
        assertEquals(2, bst.size());
    }

    @Test
    public void testRemoveMax() {
        assertNull(bst.removeMax());

        bst.add(10);
        bst.add(5);
        bst.add(15);

        assertNotNull(bst.removeMax());
        assertEquals(2, bst.size());
    }

    @Test
    public void testInorderIterator() {
        bst.add(10);
        bst.add(5);
        bst.add(15);

        Iterator<Integer> iterator = bst.inorderIterator();
        assertEquals(Integer.valueOf(5), iterator.next());
        assertEquals(Integer.valueOf(10), iterator.next());
        assertEquals(Integer.valueOf(15), iterator.next());
    }

    @Test
    public void testPreorderIterator() {
        bst.add(10);
        bst.add(5);
        bst.add(15);

        Iterator<Integer> iterator = bst.preorderIterator();
        assertEquals(Integer.valueOf(10), iterator.next());
        assertEquals(Integer.valueOf(5), iterator.next());
        assertEquals(Integer.valueOf(15), iterator.next());
    }

    @Test
    public void testPostorderIterator() {
        bst.add(10);
        bst.add(5);
        bst.add(15);

        Iterator<Integer> iterator = bst.postorderIterator();
        assertEquals(Integer.valueOf(5), iterator.next());
        assertEquals(Integer.valueOf(15), iterator.next());
        assertEquals(Integer.valueOf(10), iterator.next());
    }

    // @Test
    // public void testPostorderIterator() {
    //     BSTreeNode<Integer> root = new BSTreeNode<>(10);
    //     root.setLeft(new BSTreeNode<>(5));
    //     root.setRight(new BSTreeNode<>(15));

    //     PostOrderIterator<Integer> iterator = new PostOrderIterator<>(root);
    //     assertEquals(Integer.valueOf(5), iterator.next());
    //     assertEquals(Integer.valueOf(15), iterator.next());
    //     assertEquals(Integer.valueOf(10), iterator.next());
    // }
}