package net.ukr.sawkone;

import java.util.Objects;

public class Goods {
    private final char goodsId;
    private final double prise;
    private final double promotionalPrice;
    private final int promotionalQuantityGoods;

    public Goods(char goodsId, double prise, double promotionalPrice, int promotionalQuantityGoods) {
        this.goodsId = goodsId;
        this.prise = prise;
        this.promotionalPrice = promotionalPrice;
        this.promotionalQuantityGoods = promotionalQuantityGoods;
    }

    public double getPrise() {
        return prise;
    }

    public double getPromotionalPrice() {
        return promotionalPrice;
    }

    public int getPromotionalQuantityGoods() {
        return promotionalQuantityGoods;
    }

    public char getGoodsId() {
        return goodsId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", prise=" + prise +
                ", promotionalPrice=" + promotionalPrice +
                ", promotionalQuantityGoods=" + promotionalQuantityGoods +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return goodsId == goods.goodsId && Double.compare(goods.prise, prise) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, prise);
    }
}