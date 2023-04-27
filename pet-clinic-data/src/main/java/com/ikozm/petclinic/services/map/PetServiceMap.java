package com.ikozm.petclinic.services.map;

import com.ikozm.petclinic.model.Pet;
import com.ikozm.petclinic.services.PetService;
import com.ikozm.petclinic.services.PetTypeService;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService{

    private final PetTypeService petTypeService;

    public PetServiceMap(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        if (object != null) {
            if (object.getPetType() != null) {
                petTypeService.save(object.getPetType());
            } else {
                throw new RuntimeException("Pet Type is required");
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }
}
