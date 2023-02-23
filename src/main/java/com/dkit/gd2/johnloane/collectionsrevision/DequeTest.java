package com.dkit.gd2.johnloane.collectionsrevision;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest
{
    public static void main(String[] args)
    {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("one");
        stack.push("two");
        System.out.println(stack.pop());
    }
}
