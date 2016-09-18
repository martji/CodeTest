/**
 * Created by Guoqing on 2016/8/1.
 */
public class Tree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int getDis(TreeNode root) {
        // write code here
        prepare(root, '0', new StringBuffer());

        int len = Math.min(maxBuffer.length(), minBuffer.length());
        int i = 0;
        for (; i <= len; i++) {
            if (maxBuffer.charAt(i) != minBuffer.charAt(i)) {
                break;
            }
        }

        return maxBuffer.length() - i + minBuffer.length() - i;
    }

    StringBuffer maxBuffer;
    StringBuffer minBuffer;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public void prepare(TreeNode p, char c, StringBuffer stringBuffer) {
        stringBuffer.append(c);

        if (p.left == null && p.right == null) {
            if (p.val > max) {
                max = p.val;
                maxBuffer = stringBuffer;
            }
            if (p.val < min) {
                min = p.val;
                minBuffer = stringBuffer;
            }
        }

        if (p.left != null) {
            prepare(p.left, '0', new StringBuffer(stringBuffer));
        }
        if (p.right != null) {
            prepare(p.right, '1', new StringBuffer(stringBuffer));
        }
    }
}
