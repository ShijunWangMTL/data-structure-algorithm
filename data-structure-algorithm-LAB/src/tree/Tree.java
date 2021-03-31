package tree;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    //return the treeNode that has that value
    public TreeNode get(int value) {
        if (root == null) {
            return null;
        }
        if (root.getData() == value) {
            return root;
        }
        if (root.getData() > value) {
            TreeNode current = root;
            while (current.getLeftChild() != null) {
                if (current.getLeftChild().getData() == value) {
                    return current.getLeftChild();
                }
                current = current.getLeftChild();
            }
            return null;
        } else {
            TreeNode current = root;
            while (current.getRightChild() != null) {
                if (current.getRightChild().getData() == value) {
                    return current.getRightChild();
                }
                current = current.getRightChild();
            }
            return null;
        }
    }

    public int min() {
        if (root == null) {
            throw new NullPointerException();
        }
        TreeNode current = root;
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current.getData();
    }

    public int max() {
        if (root == null) {
            throw new NullPointerException();
        }
        TreeNode current = root;
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current.getData();
    }

    /*public void deleteNode(int value) {
        if (get(value) == null) {
            throw new NullPointerException();
        }
        TreeNode tobeDelete = get(value);
        TreeNode parent = null;
        while (newNode.getRightChild() != null) {
            parent = newNode;
            newNode = newNode.getRightChild();
        }
        data = newNode.data;
        parent.setRightChild(null);
        parent.setLeftChild(leftChild);
        if (get(value).getLeftChild() == null) {
            if (get(value).getRightChild() != null) {
                get(value).setRightChild(get(value).getLeftChild().getRightChild());
//                setData(rightChild.data);
//                setLeftChild(rightChild.leftChild);
//                setRightChild(rightChild.rightChild);
            }
        }


    }*/


    public void traverseOrder(TreeNode root) {
        if (root == null) {
            throw new NullPointerException();
        } else {
            traverseOrder(root.getLeftChild());
            //Visit the node by Printing the node data
            System.out.printf("%d ", root.getData());
            traverseOrder(root.getRightChild());
        }
    }

    public TreeNode getRoot() {
        return root;
    }
}
