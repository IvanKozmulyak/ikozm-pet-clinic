package com.ikozm.petclinic.bootstrap;

import com.ikozm.petclinic.model.Owner;
import com.ikozm.petclinic.model.Vet;
import com.ikozm.petclinic.services.OwnerService;
import com.ikozm.petclinic.services.VetService;
import com.ikozm.petclinic.services.map.OwnerServiceMap;
import com.ikozm.petclinic.services.map.VetServiceMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService   vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Ivan");
        owner2.setLastName("Kozmuliak");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Shenkariuk");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jon");
        vet2.setLastName("Prodan");

        vetService.save(vet2);

        System.out.println("Loaded Data");
    }
}
