package com.discount.engine;


import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DiscountEngine {
    
    public static final Function<Double, Double> TEN_PERCENT_OFF = price -> price * 0.90;
    public static final Function<Double, Double> FLAT_FIVE_OFF = price -> Math.max(0, price - 5.0);
    public static final Function<Double, Double> VIP_HALF_PRICE = price -> price * 0.50;

    
    public List<Double> applyDiscount(List<Double> prices, Function<Double, Double> discountStrategy) {
        return prices.stream()
                .map(discountStrategy)
                .collect(Collectors.toList());
    }
}

