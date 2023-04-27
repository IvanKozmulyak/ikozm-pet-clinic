package com.ikozm.petclinic.bootstrap;

import com.ikozm.petclinic.model.Owner;
import com.ikozm.petclinic.model.Pet;
import com.ikozm.petclinic.model.PetType;
import com.ikozm.petclinic.model.Vet;
import com.ikozm.petclinic.services.OwnerService;
import com.ikozm.petclinic.services.PetTypeService;
import com.ikozm.petclinic.services.VetService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("12, Brickerel");
        owner1.setCity("Chernihiv");
        owner1.setTelephone("+380123456789");

        Pet mikesPet = new Pet();
        mikesPet.setOwner(owner1);
        mikesPet.setPetType(savedDog);
        mikesPet.setDateOfBirth(LocalDate.now());
        mikesPet.setName("Lucky");

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ivan");
        owner2.setLastName("Kozmuliak");
        owner2.setAddress("11, Brickerel");
        owner2.setCity("Chernihiv");
        owner2.setTelephone("+380987654321");

        Pet ivanPet = new Pet();
        ivanPet.setOwner(owner2);
        ivanPet.setPetType(savedCat);
        ivanPet.setDateOfBirth(LocalDate.now());
        ivanPet.setName("Graysi");

        owner2.getPets().add(ivanPet);

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
