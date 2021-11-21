package cinema.security;

import java.util.Set;
import javax.annotation.PostConstruct;

import cinema.model.Role;
import cinema.model.RoleType;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setName(RoleType.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setName(RoleType.USER);
        roleService.add(userRole);
        User user = new User();
        user.setEmail("admin@gmail.com");
        user.setPassword("12345");
        user.setRoles(Set.of(adminRole));
        userService.add(user);
    }
}
