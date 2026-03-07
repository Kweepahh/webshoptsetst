package org.example.zaalschoenenwebshop.dao;



import org.example.zaalschoenenwebshop.dto.ZaalSchoenDTO;
import org.example.zaalschoenenwebshop.models.Category;
import org.example.zaalschoenenwebshop.models.ZaalSchoen;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
public class ZaalSchoenDAO {

    private ZaalSchoenRepository repository;
    private CategoryRepository categoryRepository;

    public ZaalSchoenDAO(ZaalSchoenRepository repository, CategoryRepository categoryRepository ) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public List<ZaalSchoen> getAllZaalSchoenen(){
        return this.repository.findAll();
    }

    public void createZaalschoen(ZaalSchoenDTO zaalSchoenDTO){
        Optional<Category> category = this.categoryRepository.findById(zaalSchoenDTO.categoryId);
        if (category.isPresent()){
            ZaalSchoen zaalSchoen = new ZaalSchoen(zaalSchoenDTO.name, zaalSchoenDTO.description, category.get());
            this.repository.save(zaalSchoen);
            return;
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Category not found"
        );
    }

    public void updateZaalschoen(ZaalSchoenDTO zaalSchoenDTO, Long id){
        Optional<ZaalSchoen> zaalSchoen = this.repository.findById(id);

        if (zaalSchoen.isPresent()){
            zaalSchoen.get().setDescription(zaalSchoenDTO.description);
            zaalSchoen.get().setName(zaalSchoenDTO.name);

            this.repository.save(zaalSchoen.get());
        }
    }


    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}