package com.pk10.util;

import org.junit.Test;

import java.util.Random;

/**
 * Created by dengfengdecao on 16/9/20.
 */
public class RandomTest {

    @Test
    public void testGenerateCaptcha() {
        Random random = new Random();
        int value[] = {random.nextInt(9), random.nextInt(9),
                random.nextInt(9), random.nextInt(9)};

        StringBuffer captcha = new StringBuffer();
        for (int i = 0; i < value.length; i++) {
            captcha.append(value[i]);
        }
        System.out.println("RandomTest.testGenerateCaptcha: " + captcha.toString());
    }
}
