package sword2offer;
import java.util.Stack;

/**
 * 题目描述：包含min函数的栈
 *      定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min
 *      函数。在该栈中，调用min、push及pop的时间复杂度都是O(1).
 *
 * 解题思路：最直观的想法就是在栈结构中维护一个最小值，可是这个办法只能调用一次，
 *      当最小值被弹出的时候，就无法确定下一个最小值了。所以更换策略，在栈结构中
 *      再维护一个最小值栈。当数据压到数据栈的时候，要是最小值栈为空或者最顶层元素
 *      大于要压栈元素，就将这个数据压入最小值栈中，要是这个数据大于最小值栈最顶层
 *      元素的话，就将最小值栈的顶层元素的值再压栈一遍。
 *
 */
public class NO_21 {
    public static void main(String[] args) {
        MyStack mStack = new MyStack();
        System.out.println(mStack.min());
        mStack.push(3);
        mStack.push(4);
        mStack.push(4);
        mStack.push(10);
        mStack.push(11);
        System.out.println(mStack.min());
    }
}

class MyStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stackHelp;

    public MyStack() {
        stack1 = new Stack<Integer>();
        stackHelp = new Stack<Integer>();
    }

    public void push(int num) {
        stack1.push(num);
        if (stackHelp.size() == 0 || num < stackHelp.peek()) {
            stackHelp.push(num);
        } else {
            stackHelp.push(stackHelp.peek());
        }
    }

    public void pop() {
        stack1.pop();
        stackHelp.pop();
    }

    public Integer min() {
        if (stackHelp.size() == 0)
            return null;
        return stackHelp.peek();
    }
}