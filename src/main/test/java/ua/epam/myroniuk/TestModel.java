package ua.epam.myroniuk;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Vitalii on 22.07.2017.
 */
public class TestModel {
    private static Model model;

    @BeforeClass
    public static void initializeModel() {
        model = new Model();
    }

    @Test
    public void testRand1() {
        model.rand(0, 100);
        Assert.assertEquals("It should be model.getMin() = 0.", model.getMin(), 0);
    }

    @Test
    public void testRand2() {
        model.rand(0, 100);
        Assert.assertEquals("It should be model.getMax() = 100.", model.getMax(), 100);
    }

    @Test
    public void testRand3() {
        model.rand(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Assert.assertEquals("It should be model.getMin() = Integer.MIN_VALUE.", model.getMin(), Integer.MIN_VALUE);
    }

    @Test
    public void testRand4() {
        model.rand(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Assert.assertEquals("It should be model.getMax() = Integer.MAX_VALUE", model.getMax(), Integer.MAX_VALUE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRand5() {
        model.rand(0, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRand6() {
        model.rand(0, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRand7() {
        model.rand(100, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRand8() {
        model.rand(Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    @Test (timeout = 1000)
    public void testRand9() {
        do {
            model.rand(0, 100);
        } while (model.getSecretNumber() != 1);
    }

    @Test (timeout = 1000)
    public void testRand10() {
        do {
            model.rand(0, 100);
        } while (model.getSecretNumber() != 99);
    }

    @Test
    public void testCheckInputNumber1() {
        model.setMin(0);
        model.setMax(100);
        model.setSecretNumber(50);
        Assert.assertTrue(model.checkInputNumber(0) == -2);
    }

    @Test
    public void testCheckInputNumber2() {
        model.setMin(0);
        model.setMax(100);
        model.setSecretNumber(50);
        Assert.assertTrue(model.checkInputNumber(100) == -2);
    }

    @Test
    public void testCheckInputNumber3() {
        model.setMin(0);
        model.setMax(100);
        model.setSecretNumber(50);
        Assert.assertTrue(model.checkInputNumber(1) == -1);
    }

    @Test
    public void testCheckInputNumber4() {
        model.setMin(0);
        model.setMax(100);
        model.setSecretNumber(50);
        Assert.assertTrue(model.checkInputNumber(99) == 1);
    }

    @Test
    public void testCheckInputNumber5() {
        model.setMin(0);
        model.setMax(100);
        model.setSecretNumber(50);
        Assert.assertTrue(model.checkInputNumber(50) == 0);
    }
}
