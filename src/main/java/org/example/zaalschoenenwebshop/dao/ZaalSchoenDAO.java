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

    public void createZaalschoen(ZaalSchoenDTO dto){
        if (dto.categoryId == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Category ID is required"
            );
        }

        Category category = this.categoryRepository
                .findById(dto.categoryId)
                .orElseThrow(() -> {
                    return new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Category not found with id: " + dto.categoryId
                    );
                });


        ZaalSchoen schoen = new ZaalSchoen(
                dto.name,
                dto.description,
                category,
                dto.price,
                dto.merk
        );

        ZaalSchoen savedSchoen = this.repository.save(schoen);

    }

    public void updateZaalschoen(ZaalSchoenDTO zaalSchoenDTO, Long id){
        Optional<ZaalSchoen> zaalSchoenOptional = this.repository.findById(id);

        if (zaalSchoenOptional.isPresent()){

            ZaalSchoen zaalSchoen = zaalSchoenOptional.get();

            if (zaalSchoenDTO.categoryId == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Category ID is required"
                );
            }

            Optional<Category> category = this.categoryRepository.findById(zaalSchoenDTO.categoryId);

            if(category.isPresent()){

                zaalSchoen.setName(zaalSchoenDTO.name);
                zaalSchoen.setDescription(zaalSchoenDTO.description);
                zaalSchoen.setPrice(zaalSchoenDTO.price);
                zaalSchoen.setMerk(zaalSchoenDTO.merk);
                zaalSchoen.setCategory(category.get());

                this.repository.save(zaalSchoen);
                return;
            }

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Category not found"
            );
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Product not found"
        );
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    public ZaalSchoen getZaalSchoenById(Long id) {
        return repository.findById(id).orElse(null);
    }
}