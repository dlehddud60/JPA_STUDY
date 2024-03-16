package com.example.youngJPA.member.temp;

public class OrderMain {
    public static void main(String[] args) {
        Order order = Order.builder()
                .orderNumber("order123")
                .productName("something")
                .totalPrice(1000L)
                .build();

        System.out.println("order: " + System.identityHashCode(order));

        Order.OrderBuilder orderBuilder = order.toBuilder();

        System.out.println("orderBuilder" +  System.identityHashCode(orderBuilder));

        Order updateOrder = order.toBuilder()
                .totalPrice(20000L)
                .build();

        System.out.println("updateOrder: " +System.identityHashCode(updateOrder));
    }
}
