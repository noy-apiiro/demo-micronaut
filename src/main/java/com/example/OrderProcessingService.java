package com.example;

import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import java.util.UUID;

@Client("${order-service.base-url}")
@Header(name = "Authorization", value = "Bearer ${app.service-token}")
@Header(name = "X-Service-Name", value = "demo-service")
@Header(name = "Accept", value = "application/json")
public interface OrderProcessingService {

    @Post("/orders/v2/create1")
    String createOrder(@Body String request);
    
    @Header(name = "Authorization", value = "Bearer ${app.service-token}")
    @Get("/orders/v2/{orderId}/details")
    String getOrderDetails(@PathVariable UUID orderId);

    @Patch("/orders/v2/{orderId}/status")
    String updateOrderStatus(@PathVariable UUID orderId);
}

