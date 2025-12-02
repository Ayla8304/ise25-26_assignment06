package de.seuhd.campuscoffee.api.mapper;

import de.seuhd.campuscoffee.api.dtos.UserDto; 
import de.seuhd.campuscoffee.domain.model.User;
import org.mapstruct.Mapper;    

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    //TODO: Implement user DTO mapper
    UserDto fromDomain (User user);
    User toDomain (UserDto userDto);        
}