package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.models.RoleModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private List<RoleModel> roles;
}
