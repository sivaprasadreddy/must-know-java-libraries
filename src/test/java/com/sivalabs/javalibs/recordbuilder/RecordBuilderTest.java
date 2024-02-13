package com.sivalabs.javalibs.recordbuilder;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RecordBuilderTest {

    @Test
    void canCreateRecordUsingAllArgsConstructor() {
        Customer customer = new Customer(1, "Siva");

        assertAll("Verify Customer properties",
                () -> assertEquals(1, customer.id()),
                () -> assertEquals("Siva", customer.name()));
    }

    @Test
    void canCreateRecordUsingMethodCallChain() {
        Customer customer = CustomerBuilder.builder()
                .id(1)
                .name("Siva")
                .build();

        assertAll("Verify Customer properties",
                () -> assertEquals(1, customer.id()),
                () -> assertEquals("Siva", customer.name()));
    }

    @Test
    void canCreateRecordFromAnotherRecord() {
        Address address1 = new Address(
                "KPHB", "Hyderabad", "Telangana", "India");

        Address address2 = AddressBuilder.builder(address1)
                .street("Ameerpet")
                .state("TS")
                .build();

        assertAll("Verify Address properties",
                () -> assertEquals("Ameerpet", address2.street()),
                () -> assertEquals("Hyderabad", address2.city()),
                () -> assertEquals("TS", address2.state()),
                () -> assertEquals("India", address2.country()));
    }

    @Test
    void canCreateRecordFromAnotherRecordUsingWith() {
        Address address1 = new Address("KPHB", "Hyderabad", "Telangana", "India");

        Address address2 = address1.withStreet("Ameerpet").withState("TS");

        assertAll("Verify Address properties",
                () -> assertEquals("Ameerpet", address2.street()),
                () -> assertEquals("Hyderabad", address2.city()),
                () -> assertEquals("TS", address2.state()),
                () -> assertEquals("India", address2.country()));
    }

    @Test
    void canCreateRecordUsingBuilderFor3rdPartyCode() {
        Product product = ProductBuilder.builder()
                .id(1L)
                .name("Product1")
                .description("Product1 Desc")
                .price(new BigDecimal("100.00"))
                .build();

        assertAll("Verify Product properties",
                () -> assertEquals(1L, product.id()),
                () -> assertEquals("Product1", product.name()),
                () -> assertEquals("Product1 Desc", product.description()),
                () -> assertEquals(new BigDecimal("100.00"), product.price()));
    }
}