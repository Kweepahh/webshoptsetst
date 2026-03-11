package org.example.zaalschoenenwebshop.utils;


import org.example.zaalschoenenwebshop.dao.CategoryRepository;
import org.example.zaalschoenenwebshop.dao.ZaalSchoenRepository;
import org.example.zaalschoenenwebshop.models.Category;
import org.example.zaalschoenenwebshop.models.ZaalSchoen;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Seeder {

    private ZaalSchoenRepository zaalSchoenRepository;
    private CategoryRepository categoryRepository;

    public Seeder(ZaalSchoenRepository zaalSchoenRepository, CategoryRepository categoryRepository) {
        this.zaalSchoenRepository = zaalSchoenRepository;
        this.categoryRepository = categoryRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        this.seedZaalSchoenen();
    }

    private void seedZaalSchoenen(){
        Category basketbalSchoenen = new Category("Basketbal Schoenen");
        this.categoryRepository.save(basketbalSchoenen);

        this.zaalSchoenRepository.save(new ZaalSchoen("Gel-court Hunter 3", "Zaalschoen", basketbalSchoenen, "Mizuno"));
    }
}
