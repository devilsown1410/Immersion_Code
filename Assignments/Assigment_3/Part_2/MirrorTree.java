public class MirrorTree {
        // Function to convert a binary tree into its mirror tree.
        void mirror(Node node) {
            // Your code here
            if(node==null){
                return;
            }
            if(node.left==null && node.right==null){
                return;
            }
            Node t=node.left;
            node.left=node.right;
            node.right=t;
            mirror(node.left);
            mirror(node.right);
        }
}
