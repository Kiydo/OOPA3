import treeImplementation.BSTree;
import utilities.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        BSTree<Integer> bst = new BSTree<>();
            bst.add(10);
            bst.add(5);
            bst.add(15);

            Iterator<Integer> postOrderIterator = bst.postorderIterator();
            while (postOrderIterator.hasNext()) {
                System.out.println(postOrderIterator.next());
            }
    }
}
