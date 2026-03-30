package org.example.zaalschoenenwebshop.utils;

import org.example.zaalschoenenwebshop.dao.CategoryRepository;
import org.example.zaalschoenenwebshop.dao.OrderRepository;
import org.example.zaalschoenenwebshop.dao.UserRepository;
import org.example.zaalschoenenwebshop.dao.ZaalSchoenRepository;
import org.example.zaalschoenenwebshop.models.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class Seeder {

    private final PasswordEncoder passwordEncoder;
    private final ZaalSchoenRepository zaalSchoenRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public Seeder(ZaalSchoenRepository zaalSchoenRepository,
                  CategoryRepository categoryRepository,
                  UserRepository userRepository,
                  OrderRepository orderRepository,
                  PasswordEncoder passwordEncoder) {
        this.zaalSchoenRepository = zaalSchoenRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedZaalSchoenen();
        seedUsers();
        seedOrder();
    }

    private void seedZaalSchoenen() {
        Category basketbalSchoenen = new Category("Basketbal Schoenen");
        categoryRepository.save(basketbalSchoenen);

        zaalSchoenRepository.save(new ZaalSchoen("Gel-court Hunter 3", "Zaalschoen", basketbalSchoenen, 149.99, "Mizuno"));
        zaalSchoenRepository.save(new ZaalSchoen("Wave Momentum 3", "Zaalschoen", basketbalSchoenen, 85.00, "Mizuno"));
        zaalSchoenRepository.save(new ZaalSchoen("Wave Luminous 3", "Zaalschoen", basketbalSchoenen, 105.00, "Mizuno"));
        zaalSchoenRepository.save(new ZaalSchoen("Hyperice Hyperboot", "HyperIce", basketbalSchoenen, 749.99, "Nike"));
    }

    private void seedUsers() {
        CustomUser adminUser = new CustomUser(
                "admin@gmail.com",
                passwordEncoder.encode("Test123."),
                true
        );

        userRepository.save(adminUser);

        CustomUser user = new CustomUser(
                "nonadmin@gmail.com",
                passwordEncoder.encode("Test123.")
        );
        userRepository.save(user);
    }

    private void seedOrder() {

        CustomUser user = userRepository.findByEmail("admin@gmail.com");
        if (user == null) return;

        List<ZaalSchoen> products = zaalSchoenRepository.findAll();

        ZaalSchoen p1 = products.get(0);
        ZaalSchoen p2 = products.get(1);
        ZaalSchoen p3 = products.get(2);

        Order order1 = new Order();
        order1.setUser(user);
        order1.setOrderDate(LocalDateTime.now());
        order1.setOrderAdress("lksadjflaksgj");

        OrderItem item1 = new OrderItem();
        item1.setOrder(order1);
        item1.setProduct(p1);
        item1.setQuantity(2);
        item1.setPrice(p1.getPrice());

        List<OrderItem> items1 = List.of(item1);

        order1.setOrderItems(items1);
        order1.setTotalPrice(item1.getPrice() * item1.getQuantity());

        orderRepository.save(order1);



        Order order2 = new Order();
        order2.setUser(user);
        order2.setOrderDate(LocalDateTime.now());
        order2.setOrderAdress("dflagsg");

        OrderItem item2 = new OrderItem();
        item2.setOrder(order2);
        item2.setProduct(p2);
        item2.setQuantity(1);
        item2.setPrice(p2.getPrice());

        OrderItem item3 = new OrderItem();
        item3.setOrder(order2);
        item3.setProduct(p3);
        item3.setQuantity(3);
        item3.setPrice(p3.getPrice());

        List<OrderItem> items2 = List.of(item2, item3);

        order2.setOrderItems(items2);
        order2.setTotalPrice(
                (item2.getPrice() * item2.getQuantity()) +
                        (item3.getPrice() * item3.getQuantity())
        );

        orderRepository.save(order2);
    }
}