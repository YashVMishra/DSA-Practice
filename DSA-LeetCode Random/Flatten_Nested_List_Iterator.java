// https://leetcode.com/problems/flatten-nested-list-iterator/description/?envType=daily-question&envId=2023-10-20

// This is an implementation based question. You just need to know how to
// implement it.
// so due to error showing I have commented the main function and the class.

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// using stack.
// public class NestedIterator implements Iterator<Integer> {
// private Stack<NestedInteger> stack;

// public NestedIterator(List<NestedInteger> nestedList) {
// stack = new Stack<>();
// for (int i = nestedList.size() - 1; i >= 0; i--) {
// stack.push(nestedList.get(i));
// }
// }

// @Override
// public Integer next() {
// int num = stack.peek().getInteger();
// stack.pop();
// }

// @Override
// public boolean hasNext() {
// while (!stack.isEmpty()) {
// NestedIterator top = stack.peek();

// if (top.isInteger()) {
// return true;
// }

// stack.pop();
// List<NestedInteger> list = top.getList();
// for (int i = list.size() - 1; i >= 0; i--) {
// stack.push(list.get(i));
// }
// }

// return false;
// }
// }

// using queue and recurison.
// public class NestedIterator_2 implements Iterator<Integer> {
// private Stack<NestedInteger> stack;
// private Queue<Integer> queue;

// public NestedIterator_2(List<NestedInteger> nestedList) {
// queue = new LinkedList<>();
// addAll(nestedList);
// }

// private void addAll(List<NestedInteger> nestedList) {
// int size = nestedList.size();

// for (int i = 0; i < size; i++) {
// NestedInteger obj = nestedList.get(i);
// if (obj.isInteger()) {
// queue.add(obj.getInteger());
// } else {
// addAll(obj.getList());
// }
// }
// }

// @Override
// public Integer next() {
// return queue.poll();
// }

// @Override
// public boolean hasNext() {
// return !queue.isEmpty();
// }
// }
