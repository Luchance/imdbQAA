package com.imdbTest.utility.waiter;

import com.codeborne.selenide.SelenideElement;

public class WaitUtils {

    /**
     * Wait until the element's position stops changing, indicating scrolling or animation is finished.
     * @param element SelenideElement to monitor
     * @param timeoutSeconds max seconds to wait
     */

    public static void waitUntilElementStopsMoving(SelenideElement element, int timeoutSeconds) {
        int attempts = timeoutSeconds * 5; // check every 200ms

        int prevX = -1, prevY = -1;

        while (attempts > 0) {
            int currentX = element.getLocation().getX();
            int currentY = element.getLocation().getY();

            if (currentX == prevX && currentY == prevY) {
                // Position stable, scroll likely finished
                return;
            }

            prevX = currentX;
            prevY = currentY;

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            attempts--;
        }
    }
}
