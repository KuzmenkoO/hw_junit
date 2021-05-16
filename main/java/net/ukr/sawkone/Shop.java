package net.ukr.sawkone;

import java.util.HashMap;
import java.util.Map;

public class Shop {
    private static final Map<Character, Goods> PRODUCTS = new HashMap<>();

    static {
        PRODUCTS.put('A', new Goods('A', 1.25, 3, 3));
        PRODUCTS.put('B', new Goods('B', 4.25, 0, 0));
        PRODUCTS.put('C', new Goods('C', 1.00, 5, 6));
        PRODUCTS.put('D', new Goods('D', 0.75, 0, 0));
    }

    private int countA = 0;
    private int countB = 0;
    private int countC = 0;
    private int countD = 0;
    private final double costOfBasket = 0.00;

    public double calculateTotalCost(String goodsInBasket) {
        if (goodsInBasket == null) {
            return costOfBasket;
        } else {
            char[] goods = goodsInBasket.toUpperCase().toCharArray();
            for (char x : goods) {
                quantityOfEachProduct(x);
            }
            return getCost();
        }
    }

    public double calculateTotalCost() {
        return costOfBasket;
    }

    private void quantityOfEachProduct(char x) {
        switch (x) {
            case 'A':
                countA++;
                break;
            case 'B':
                countB++;
                break;
            case 'C':
                countC++;
                break;
            case 'D':
                countD++;
                break;
            default:
                try {
                    throw new Throwable("Product - " + x + " is not in the store");
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
        }
    }

    private double getCost() {
        double cost = costOfGoods(countA, PRODUCTS.get('A'));
        cost += costOfGoods(countB, PRODUCTS.get('B'));
        cost += costOfGoods(countC, PRODUCTS.get('C'));
        cost += costOfGoods(countD, PRODUCTS.get('D'));
        return cost;
    }

    private double costOfGoods(int count, Goods goods) {
        int promotionalQuantity;
        if (goods.getPromotionalQuantityGoods() == 0) {
            return count * goods.getPrise();
        } else if (count / goods.getPromotionalQuantityGoods() > 0) {
            promotionalQuantity = count / goods.getPromotionalQuantityGoods();
            return promotionalQuantity * goods.getPromotionalPrice()
                    + count % goods.getPromotionalQuantityGoods() * goods.getPrise();
        } else {
            return count * goods.getPrise();
        }
    }
}