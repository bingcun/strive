package ai.yuhan.demo.datastructure.careers.easy;

import org.apache.logging.log4j.util.Strings;

import java.util.Stack;

/**
 * @description: 括号序列
 * 题目描述
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 * 输入
 * "["
 * 返回值
 * false
 *
 * @author: bingcun.chen
 * @Date: 2021/5/11 20:56
 * @Version 1.0
 */
public class NC52 {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        // write code here
        if(Strings.isBlank(s))return false;
        Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            switch (c){
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if(stack.isEmpty() || stack.pop()!=c)return false;
            }
        }
        return stack.isEmpty();
    }
}
