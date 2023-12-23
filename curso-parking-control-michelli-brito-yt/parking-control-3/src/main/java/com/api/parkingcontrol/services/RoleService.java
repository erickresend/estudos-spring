package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.RoleModel;
import com.api.parkingcontrol.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Page<RoleModel> findAllRoles(Pageable pageable){
        return roleRepository.findAll(pageable);
    }
}
