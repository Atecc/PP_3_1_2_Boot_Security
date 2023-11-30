package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.dao.RoleDAO;


import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
    @Transactional(readOnly = true)
    @Override
    public Role findRoleByName(String name) {
        return roleDAO.findRoleByName(name);
    }
    @Transactional(readOnly = true)
    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Role findOne(Integer id) {
        return roleDAO.findOne(id);
    }
    @Transactional(readOnly = true)
    @Override
    public List<Role> findMultipleById(Collection<Integer> idCollection) {
        return roleDAO.findMultipleById(idCollection);
    }
    @Transactional(readOnly = true)
    @Override
    public Set<Role> getSetRolesByRoleNames(List<String> roleNames) {

        return roleDAO.getSetRolesByRoleNames(roleNames);
    }

    @Transactional
    @Override
    public void save(Role role) {
        roleDAO.save(role);
    }
    @Transactional
    @Override
    public void delete(Integer id) {
        roleDAO.delete(id);
    }
    @Transactional
    @Override
    public void update(Role role) {
        roleDAO.update(role);
    }
}
