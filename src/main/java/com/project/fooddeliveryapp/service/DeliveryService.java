package com.project.fooddeliveryapp.service;

import com.project.fooddeliveryapp.model.Delivery;
import com.project.fooddeliveryapp.model.Order;
import com.project.fooddeliveryapp.model.User;
import com.project.fooddeliveryapp.repository.DeliveryRepository;
import com.project.fooddeliveryapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    private DeliveryRepository deliveryRepository;
    private OrderRepository orderRepository;

    public DeliveryService(DeliveryRepository deliveryRepository, OrderRepository orderRepository) {
        this.deliveryRepository = deliveryRepository;
        this.orderRepository = orderRepository;
    }

    public Delivery saveDelivery(Delivery delivery) {
        Order order = orderRepository.findById(delivery.getOrder().getOrderId()).orElseThrow(() -> new RuntimeException("Order not found"));
        delivery.setOrder(order);
        return deliveryRepository.save(delivery);
    }

    public Delivery getDeliveryById(Integer id) {
        return deliveryRepository.findById(id).orElseThrow(() -> new RuntimeException("Delivery not found"));
    }
}
