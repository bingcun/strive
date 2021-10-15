package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/24 22:09
 * @Version 1.0
 */
public class offer12 {
    /**
     * dfs+剪枝操作
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    /**
     * 深度遍历
     * @param board
     * @param word
     * @param i
     * @param j
     * @param k
     * @return
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //返回
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        //处理节点
        board[i][j] = '\0';
        //递归
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

    @Test
    public void test() {
        char[] arr01 = new char[]{'A','B','C','E'};
        char[] arr02 = new char[]{'S','F','C','S'};
        char[] arr03 = new char[]{'A','D','E','E'};

        char[][] chars = new char[][]{arr01,arr02,arr03};
        String word = "ABCCED";
        System.out.println(exist(chars, word));


    }

}
