package com.pk10.util;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dengfengdecao on 16/10/15.
 */
public class ListTest {

    @Test
    public void testList() {
        List list1 = new LinkedList();
        list1.add("list1");
        list1.add("list2");
        list1.add("list3");
        list1.add("list4");
        list1.add("list5");
        List list2 = new LinkedList();
        list2.add(list1);

        System.out.println("ListTest.testList list2 <== " + list2);
    }
}
