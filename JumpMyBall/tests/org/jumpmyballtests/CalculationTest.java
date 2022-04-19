package org.jumpmyballtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.Calculation;

public class CalculationTest {

    private Calculation calculation = new Calculation();

    @Test
    @DisplayName("Тестирование количества без входящего типа продукта")
    public void GetQuantityForProduct_NonExistentProductType() {
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(4, 1, 1, 1, 1));
    }

    @Test
    @DisplayName("Тестирование количества с входящим типом продукта")
    public void GetQuantityForProduct_ExistentProductType(){
        Assertions.assertEquals(152197, calculation.getQuantityForProduct(3, 1, 20, 30,30));
    }


}
