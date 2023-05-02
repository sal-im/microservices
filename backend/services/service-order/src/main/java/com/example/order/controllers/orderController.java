package com.example.order.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.order.entities.OrderEntity;
import com.example.order.services.IOrderService;
import com.example.order.services.OrderServiceImpl;

import java.util.List;

/**
 * This class represents the REST controller for managing order resources.
 *
 * @author Mejda Sliman _ mejda.sliman@esprit.tn 2ALINFO3
 */
@RestController
@RequestMapping("/orders")
public class orderController {
    /**
     * The service implementation for order management.
     */
    @Autowired
    private IOrderService orderService;

    /**
     * Returns a list of all orders.
     *
     * @return A list of all orders.
     */
    @GetMapping("/list")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }
    /**
     * Returns the order with the specified ID.
     *
     * @param id The ID of the order to return.
     * @return The order with the specified ID, or null if no such order exists.
     */
    @GetMapping("/list/{id}")
    public OrderEntity getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    /**
     * Creates a new order.
     *
     * @param orderEntity The order to create.
     * @return The newly created order.
     */
    @PostMapping("/list/create")
    public OrderEntity createOrder(@RequestBody OrderEntity orderEntity) {
        return orderService.createOrder(orderEntity);
    }
    /**
     * Updates the order with the specified ID.
     *
     * @param id         The ID of the order to update.
     * @param orderEntity The new order data.
     * @return The updated order, or null if no such order exists.
     */
    @PutMapping("/list/update/{id}")
    public OrderEntity updateOrder(@PathVariable Long id, @RequestBody OrderEntity orderEntity) {
        return orderService.updateOrder(id, orderEntity);
    }

    /**
     * Deletes the order with the specified ID.
     *
     * @param id The ID of the order to delete.
     */
    @DeleteMapping("/list/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
