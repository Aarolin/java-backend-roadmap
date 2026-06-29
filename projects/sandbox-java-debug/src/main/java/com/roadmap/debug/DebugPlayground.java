package com.roadmap.debug;

public class DebugPlayground {

    public static void main(String[] args) {
        String[] productNames = {"Keyboard", "Mouse", "Monitor"};
        int[] quantities = {2, 5, 1};
        int[] pricesCents = {4999, 1599, 12999};

        int subtotalCents = calculateSubtotal(quantities, pricesCents);
        int discountCents = calculateDiscount(subtotalCents, 10);
        int totalCents = subtotalCents - discountCents;

        printReceipt(productNames, quantities, pricesCents, subtotalCents, discountCents, totalCents);
    }

    private static int calculateSubtotal(int[] quantities, int[] pricesCents) {
        int subtotal = 0;

        for (int i = 0; i < quantities.length; i++) {
            int lineTotal = quantities[i] * pricesCents[i];
            subtotal = subtotal + lineTotal;
        }

        return subtotal;
    }

    private static int calculateDiscount(int subtotalCents, int discountPercent) {
        return subtotalCents * discountPercent / 100;
    }

    private static void printReceipt(
            String[] productNames,
            int[] quantities,
            int[] pricesCents,
            int subtotalCents,
            int discountCents,
            int totalCents
    ) {
        System.out.println("Receipt");
        System.out.println("-------");

        for (int i = 0; i < productNames.length; i++) {
            int lineTotal = quantities[i] * pricesCents[i];

            System.out.println(
                    productNames[i]
                            + " x "
                            + quantities[i]
                            + " = "
                            + formatMoney(lineTotal)
            );
        }

        System.out.println("-------");
        System.out.println("Subtotal: " + formatMoney(subtotalCents));
        System.out.println("Discount: " + formatMoney(discountCents));
        System.out.println("Total: " + formatMoney(totalCents));
    }

    private static String formatMoney(int cents) {
        int euros = cents / 100;
        int remainingCents = cents % 100;

        return euros + "." + String.format("%02d", remainingCents) + " EUR";
    }
}