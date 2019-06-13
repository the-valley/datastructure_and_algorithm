package com.wy.leetcode.question337;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyong
 * @date 2019/6/13
 * @description 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * <p>
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 *      3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class Solution {
    Map<TreeNode, Integer> cache = new HashMap<>();
    /**
     * 单纯的递归会超时,所以采用递归加缓存
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        int withRoot = maxWithRoot(root);
        int withoutRoot = maxWithoutRoot(root);
        int value = withRoot > withoutRoot ? withRoot : withoutRoot;
        cache.put(root, value);
        return value;
    }

    /**
     * 如果包含root，子节点必然不包含
     * @param root
     * @return
     */
    private int maxWithRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + maxWithoutRoot(root.left) + maxWithoutRoot(root.right);
    }

    /**
     * 如果不包含root，那子节点可以包含也可以不包含
     * @param root
     * @return
     */
    private int maxWithoutRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return rob(root.left) + rob(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}