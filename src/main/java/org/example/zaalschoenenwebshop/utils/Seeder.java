package org.example.zaalschoenenwebshop.utils;


import org.example.zaalschoenenwebshop.dao.CategoryRepository;
import org.example.zaalschoenenwebshop.dao.UserRepository;
import org.example.zaalschoenenwebshop.dao.ZaalSchoenRepository;
import org.example.zaalschoenenwebshop.models.Category;
import org.example.zaalschoenenwebshop.models.CustomUser;
import org.example.zaalschoenenwebshop.models.ZaalSchoen;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Seeder {

    private final PasswordEncoder passwordEncoder;
    private ZaalSchoenRepository zaalSchoenRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;

    public Seeder(ZaalSchoenRepository zaalSchoenRepository, CategoryRepository categoryRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.zaalSchoenRepository = zaalSchoenRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        this.seedZaalSchoenen();
    }


    private void seedZaalSchoenen(){
        Category basketbalSchoenen = new Category("Basketbal Schoenen");
        this.categoryRepository.save(basketbalSchoenen);

        this.zaalSchoenRepository.save(new ZaalSchoen("Gel-court Hunter 3", "Zaalschoen", basketbalSchoenen, "Mizuno", 149.99));
        this.zaalSchoenRepository.save(new ZaalSchoen("Wave Momentum 3", "ZaalSchoen", basketbalSchoenen, "Mizuno", 85.00));
        this.zaalSchoenRepository.save(new ZaalSchoen("Wave Luminmous 3", "Zaalschoen", basketbalSchoenen, "Mizuno", 105.00));
        this.zaalSchoenRepository.save(new ZaalSchoen("Hyperice Hyperboot", "HyperIce", basketbalSchoenen, "Nike", 749.99));


        this.userRepository.save(new CustomUser(
                "test14321@gmail.com",
                passwordEncoder.encode("Test123.")
        ));
    }


}
