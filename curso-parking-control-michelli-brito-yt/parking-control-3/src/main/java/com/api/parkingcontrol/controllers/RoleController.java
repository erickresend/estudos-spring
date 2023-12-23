package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.models.RoleModel;
import com.api.parkingcontrol.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public ResponseEntity<Page<RoleModel>> getAllRoles(@PageableDefault Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(roleService.findAllRoles(pageable));
    }
}
