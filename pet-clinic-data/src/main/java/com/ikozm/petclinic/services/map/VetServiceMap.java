package com.ikozm.petclinic.services.map;

import com.ikozm.petclinic.model.Vet;
import com.ikozm.petclinic.services.SpecialityService;
import com.ikozm.petclinic.services.VetService;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialitiesService;

    public VetServiceMap(SpecialityService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object != null) {
            object.getSpecialities().forEach(specialitiesService::save);
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}
