package com.ikozm.petclinic.bootstrap;

import com.ikozm.petclinic.model.Owner;
import com.ikozm.petclinic.model.PetType;
import com.ikozm.petclinic.model.Vet;
import com.ikozm.petclinic.services.OwnerService;
import com.ikozm.petclinic.services.PetTypeService;
import com.ikozm.petclinic.services.VetService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService     vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {
        PetType dog = new PetType();
        dog.setName("Dog");

        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ivan");
        owner2.setLastName("Kozmuliak");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Shenkariuk");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jon");
        vet2.setLastName("Prodan");

        vetService.save(vet2);

        System.out.println("Loaded Data");
    }
}
