package cinema.service.impl;

import cinema.service.RoleService;
import cinema.model.Role;
import cinema.dao.RoleDao;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName).orElseThrow(() ->
                new RuntimeException("Role with name " + roleName + " doesn't exist"));
    }
}
