package org.example.zaalschoenenwebshop.utils;

import org.example.zaalschoenenwebshop.dao.CategoryRepository;
import org.example.zaalschoenenwebshop.dao.OrderRepository;
import org.example.zaalschoenenwebshop.dao.UserRepository;
import org.example.zaalschoenenwebshop.dao.ZaalSchoenRepository;
import org.example.zaalschoenenwebshop.models.Category;
import org.example.zaalschoenenwebshop.models.CustomUser;
import org.example.zaalschoenenwebshop.models.Order;
import org.example.zaalschoenenwebshop.models.ZaalSchoen;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Seeder {

    private final PasswordEncoder passwordEncoder;
    private final ZaalSchoenRepository zaalSchoenRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public Seeder(
            ZaalSchoenRepository zaalSchoenRepository,
            CategoryRepository categoryRepository,
            UserRepository userRepository,
            OrderRepository orderRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.zaalSchoenRepository = zaalSchoenRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        this.seedZaalSchoenen();
        this.seedUsers();
        this.seedOrder();
    }

    private void seedZaalSchoenen(){

        Category basketbalSchoenen = new Category("Basketbal Schoenen");
        categoryRepository.save(basketbalSchoenen);

        zaalSchoenRepository.save(new ZaalSchoen("Gel-court Hunter 3", "Zaalschoen", basketbalSchoenen, "Mizuno", 149.99));
        zaalSchoenRepository.save(new ZaalSchoen("Wave Momentum 3", "Zaalschoen", basketbalSchoenen, "Mizuno", 85.00));
        zaalSchoenRepository.save(new ZaalSchoen("Wave Luminous 3", "Zaalschoen", basketbalSchoenen, "Mizuno", 105.00));
        zaalSchoenRepository.save(new ZaalSchoen("Hyperice Hyperboot", "HyperIce", basketbalSchoenen, "Nike", 749.99));
    }

    private void seedUsers(){

        CustomUser user = new CustomUser(
                "test14321@gmail.com",
                passwordEncoder.encode("Test123.")
        );

        userRepository.save(user);
    }

    private void seedOrder(){

        CustomUser user = userRepository.findByEmail("test14321@gmail.com");

        if(user == null) return;

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalPrice(149.99);

        orderRepository.save(order);
    }
}