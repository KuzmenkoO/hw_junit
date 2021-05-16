package net.ukr.sawkone;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShopTest {
    private Shop shop;
    private final double EPSILON = 0.000000001;

    @Before
    public void setUp(){
        shop = new Shop();
    }
    @After
    public void destroy (){
        shop.calculateTotalCost();
    }
    @Test
    public void testCalculateTotalCost_happyPath (){
        double expected = 7.25;
        double actual = shop.calculateTotalCost("ABCD");
        Assert.assertEquals(expected,actual,EPSILON);
    }
    @Test
    public void testCalculateTotalCost_basketIsNull (){
        double expected = 0.00;
        double actual = shop.calculateTotalCost(null);
        Assert.assertEquals(expected,actual, EPSILON);
    }
    @Test
    public void testCalculateTotalCost_basketIsEmpty (){
        double expected = 0.0;
        double actual = shop.calculateTotalCost();
        Assert.assertEquals(expected,actual,EPSILON);
    }
    @Test
    public void testCalculateTotalCost_missingProductInStore (){
        double expected = 7.25;
        double actual = shop.calculateTotalCost("ABCDE");
        Assert.assertEquals(expected,actual,EPSILON);
    }
    @Test
    public void testCalculateTotalCost_productIsNumber (){
        double expected = 0.00;
        double actual = shop.calculateTotalCost("12345");
        Assert.assertEquals(expected,actual,EPSILON);
    }

    @Test
    public void testCalculateTotalCost_productIsSymbol (){
        double expected = 0.00;
        double actual = shop.calculateTotalCost("+-*/!");
        Assert.assertEquals(expected,actual,EPSILON);
    }
    @Test
    public void testCalculateTotalCost_atPromotionalPrice(){
        double expected = 35.50;
        double actual = shop.calculateTotalCost("AAAAABBBBBCCCCCDDDDD");
        Assert.assertEquals(expected,actual,EPSILON);
    }
}
