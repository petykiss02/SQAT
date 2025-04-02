/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.Test;
import static org.junit.Assert.*;

public class WalrusTest {
    @Test public void appHasAGreeting() {

    }

    // Write a test to see how much a Walrus can eat
    // Answer: A Walrus can eat a lot of food
    @Test public void testWalrusCanEatLotsOfFood() {
        Walrus walrus = new Walrus();
        int numberOfFoodItems = 10000;

        for (int i = 0; i < numberOfFoodItems; i++) {
            WalrusFood food = new WalrusFood();
            walrus.addToStomach(food);

            assertTrue(walrus.hasEaten(food));
        }
    }

    // Write a test to check if a Walrus gets the right food
    @Test public void testWalrusGetsTheRightFood() {
        Walrus walrus = new Walrus();
        WalrusFood intendedFood = new WalrusFood();
        WalrusFood differentFood1 = new WalrusFood();
        WalrusFood differentFood2 = new WalrusFood();
        walrus.addToStomach(intendedFood);

        assertTrue("Walrus should have eaten the intended food", walrus.hasEaten(intendedFood));

        assertFalse("Walrus should not have eaten different food", walrus.hasEaten(differentFood1));
        assertFalse("Walrus should not have eaten different food", walrus.hasEaten(differentFood2));

        WalrusFood cannedFoodContent = new WalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(cannedFoodContent);
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus, cannedFood);

        assertTrue("Walrus should have eaten the food from the can", walrus.hasEaten(cannedFoodContent));
    }

    // Write a test to check opening a can will return food
    @Test public void testOpeningCanReturnsFood() {
        WalrusFood originalFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(originalFood);
        OpensCan canOpener = new OpensCan();
        WalrusFood extractedFood = canOpener.open(can);

        assertSame("The food extracted from the can should be the same as the one put in",
                originalFood, extractedFood);

        WalrusFood secondExtraction = can.extractContents();

        assertNull("After extracting contents, the can should be empty", secondExtraction);
    }

    // Write a test to check on how a Walrus can eat
    @Test public void testHowWalrusCanEat() {
        Walrus walrus = new Walrus();

        // Direct feeding
        WalrusFood directFood = new WalrusFood();
        walrus.addToStomach(directFood);
        assertTrue("Walrus should eat food added directly to stomach", walrus.hasEaten(directFood));

        // Feeding through the FeedsWalrus class
        WalrusFood cannedFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(cannedFood);
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus, can);
        assertTrue("Walrus should eat food from a can", walrus.hasEaten(cannedFood));

        // Feeding from an empty can
        CannedWalrusFood emptyCan = new CannedWalrusFood();
        feeder.feed(walrus, emptyCan);
        // no exceptions are thrown

        // Feeding from an already opened can
        WalrusFood foodInCan = new WalrusFood();
        CannedWalrusFood openedCan = new CannedWalrusFood(foodInCan);
        openedCan.extractContents();
        feeder.feed(walrus, openedCan);
    }

    static class VegetableFood extends WalrusFood {
    }

    // Write a test making a Walrus accept non-Walrus food
    @Test public void testWalrusAcceptsNonWalrusFood() {
        Walrus walrus = new Walrus();
        WalrusFood vegetableFood = new VegetableFood();
        walrus.addToStomach(vegetableFood);

        assertTrue("Walrus should eat vegetable food", walrus.hasEaten(vegetableFood));
    }

}
