package com.ikozm.petclinic.services;

import com.ikozm.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
