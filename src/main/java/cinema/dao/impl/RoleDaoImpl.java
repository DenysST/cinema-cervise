package cinema.dao.impl;

import java.util.Optional;

import cinema.exception.DataProcessingException;
import cinema.model.Role;
import cinema.dao.AbstractDao;
import cinema.dao.RoleDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(String name) {
        try (Session session = factory.openSession()) {
            Query<Role> getByName = session.createQuery(
                    "FROM Role r WHERE r.name = :name", Role.class);
            getByName.setParameter("name", name);
            return Optional.ofNullable(getByName.getSingleResult());
        } catch (Exception e) {
            throw new DataProcessingException("Can't get "
                    + Role.class.getSimpleName() + ", name: " + name, e);
        }
    }
}
