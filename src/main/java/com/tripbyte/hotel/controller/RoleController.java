package com.tripbyte.hotel.controller;

import com.tripbyte.hotel.exception.RoleAlreadyExistsException;
import com.tripbyte.hotel.model.Role;
import com.tripbyte.hotel.model.User;
import com.tripbyte.hotel.service.IRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.FOUND;

/**
 * @author Simpson Alfred
 */
@RestController
@RequestMapping("/roles")
// REMOVED @RequiredArgsConstructor - It was causing the error
public class RoleController {
    
    private final IRoleService roleService;

    // MANUAL CONSTRUCTOR - This tells Spring exactly how to inject the service
    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all-roles")
    public ResponseEntity<List<Role>> getAllRoles(){
        return new ResponseEntity<>(roleService.getRoles(), FOUND);
    }

    @PostMapping("/create-new-role")
    public ResponseEntity<String> createRole(@RequestBody Role theRole){
        try{
            roleService.createRole(theRole);
            return ResponseEntity.ok("New role created successfully!");
        }catch(RoleAlreadyExistsException re){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(re.getMessage());
        }
    }
    
    @DeleteMapping("/delete/{roleId}")
    public void deleteRole(@PathVariable("roleId") Long roleId){
        roleService.deleteRole(roleId);
    }
    
    @PostMapping("/remove-all-users-from-role/{roleId}")
    public Role removeAllUsersFromRole(@PathVariable("roleId") Long roleId){
        return roleService.removeAllUsersFromRole(roleId);
    }

    @PostMapping("/remove-user-from-role")
    public User removeUserFromRole(
            @RequestParam("userId") Long userId,
            @RequestParam("roleId") Long roleId){
        return roleService.removeUserFromRole(userId, roleId);
    }
    
    @PostMapping("/assign-user-to-role")
    public User assignUserToRole(
            @RequestParam("userId") Long userId,
            @RequestParam("roleId") Long roleId){
        return roleService.assignRoleToUser(userId, roleId);
    }
}