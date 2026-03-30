package org.example.zaalschoenenwebshop.dao;

import org.example.zaalschoenenwebshop.dto.OrderDTO;
import org.example.zaalschoenenwebshop.dto.OrderItemDTO;
import org.example.zaalschoenenwebshop.models.CustomUser;
import org.example.zaalschoenenwebshop.models.Order;
import org.example.zaalschoenenwebshop.models.OrderItem;
import org.example.zaalschoenenwebshop.models.ZaalSchoen;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDAO {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final ZaalSchoenRepository zaalSchoenRepository;

    public OrderDAO(OrderRepository orderRepository,
                    OrderItemRepository orderItemRepository,
                    UserRepository userRepository,
                    ZaalSchoenRepository zaalSchoenRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.userRepository = userRepository;
        this.zaalSchoenRepository = zaalSchoenRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public void createOrder(OrderDTO dto) {

        CustomUser user = userRepository.findByEmail(dto.email);

        if (user == null) {
            user = new CustomUser();
            user.setEmail(dto.email);
            user.setPassword(null);
            userRepository.save(user);
        }

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setOrderAdress(dto.orderAddress);
        order.setTotalPrice(dto.orderPrice);

        List<OrderItem> items = new ArrayList<>();

        for (OrderItemDTO itemDTO : dto.items) {

            ZaalSchoen product = zaalSchoenRepository.findByName(itemDTO.productName);

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(itemDTO.quantity);
            item.setPrice(itemDTO.price);

            items.add(item);
        }

        order.setOrderItems(items);

        orderRepository.save(order);
    }

    public List<Order> getOrdersByEmail(String email) {

        CustomUser user = userRepository.findByEmail(email);

        return orderRepository.findByUserId(user.getId());
    }


}