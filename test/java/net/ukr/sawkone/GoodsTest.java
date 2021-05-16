package net.ukr.sawkone;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoodsTest {
    private Goods goods;

    @Before
    public void setUp() {
        goods = new Goods('A', 10.00, 12.00, 5);
    }

    @After
    public void destroy() {
        goods = null;
    }

    @Test
    public void Goods_happyPath() {
        double epsilon = 0.000000001;
        Assert.assertEquals(goods.getGoodsId(), 'A');
        Assert.assertEquals(goods.getPrise(), 10.00, epsilon);
        Assert.assertEquals(goods.getPromotionalPrice(), 12.00, epsilon);
        Assert.assertEquals(goods.getPromotionalQuantityGoods(), 5);
    }


    @Test
    public void testToString_happyPath() {
        String expected = goods.toString();
        String actual = "Goods{goodsId=A, prise=10.0, promotionalPrice=12.0, promotionalQuantityGoods=5}";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals_happyPath() {
        Goods expected = goods;
        Goods actual = new Goods('A', 10.00, 12.00, 5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHashCode_happyPath() {
        Goods expected = new Goods('A', 10.00, 12.00, 5);
        Goods actual = new Goods('A', 10.00, 12.00, 5);
        Assert.assertEquals(expected.hashCode(), actual.hashCode());
    }
}
