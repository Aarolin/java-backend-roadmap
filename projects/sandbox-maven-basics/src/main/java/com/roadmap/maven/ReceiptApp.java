package com.roadmap.maven;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReceiptApp {

    public static void main(String[] args) {
        Properties properties = loadProperties();

        String appName = properties.getProperty("app.name", "Unknown App");
        String currency = properties.getProperty("app.currency", "EUR");

        String customerName = normalizeCustomerName("   Alexey   ");

        String[] productNames = {"Keyboard", "Mouse", "Monitor"};
        int[] quantities = {2, 5, 1};
        int[] pricesCents = {4999, 1599, 12999};

        int subtotalCents = calculateSubtotal(quantities, pricesCents);
        int discountCents = calculateDiscount(subtotalCents, 10);
        int totalCents = subtotalCents - discountCents;

        printReceipt(
                appName,
                customerName,
                currency,
                productNames,
                quantities,
                pricesCents,
                subtotalCents,
                discountCents,
                totalCents
        );
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();

        try (InputStream inputStream = ReceiptApp.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (inputStream == null) {
                throw new IllegalStateException("application.properties was not found in classpath");
            }

            properties.load(inputStream);
            return properties;
        } catch (IOException exception) {
            throw new IllegalStateException("Failed to load application.properties", exception);
        }
    }

    private static String normalizeCustomerName(String rawName) {
        String trimmedName = StringUtils.trimToEmpty(rawName);

        if (StringUtils.isBlank(trimmedName)) {
            return "Guest";
        }

        return trimmedName;
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
            String appName,
            String customerName,
            String currency,
            String[] productNames,
            int[] quantities,
            int[] pricesCents,
            int subtotalCents,
            int discountCents,
            int totalCents
    ) {
        System.out.println(appName);
        System.out.println("Customer: " + customerName);
        System.out.println("Receipt");
        System.out.println("-------");

        for (int i = 0; i < productNames.length; i++) {
            int lineTotal = quantities[i] * pricesCents[i];

            System.out.println(
                    productNames[i]
                            + " x "
                            + quantities[i]
                            + " = "
                            + formatMoney(lineTotal, currency)
            );
        }

        System.out.println("-------");
        System.out.println("Subtotal: " + formatMoney(subtotalCents, currency));
        System.out.println("Discount: " + formatMoney(discountCents, currency));
        System.out.println("Total: " + formatMoney(totalCents, currency));
    }

    private static String formatMoney(int cents, String currency) {
        int euros = cents / 100;
        int remainingCents = cents % 100;

        return euros + "." + String.format("%02d", remainingCents) + " " + currency;
    }
}