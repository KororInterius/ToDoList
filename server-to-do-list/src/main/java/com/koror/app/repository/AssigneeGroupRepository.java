package com.koror.app.repository;

import com.koror.app.api.repository.IAssigneeGroupRepository;
import com.koror.app.entity.AssigneeGroup;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AssigneeGroupRepository extends AbstractRepository<AssigneeGroup> implements IAssigneeGroupRepository {

    @Override
    public void delete(String id) {
        hibernateSession.beginTransaction();
        AssigneeGroup entity = hibernateSession.get(AssigneeGroup.class, id);
        hibernateSession.delete(entity);
        hibernateSession.getTransaction().commit();
    }

    @Override
    public AssigneeGroup getById(String id) {
        hibernateSession.beginTransaction();
        AssigneeGroup entity = hibernateSession.get(AssigneeGroup.class, id);
        hibernateSession.getTransaction().commit();
        return entity;
    }

    @Override
    public List<AssigneeGroup> getList() {
        CriteriaBuilder builder = hibernateSession.getCriteriaBuilder();
        CriteriaQuery<AssigneeGroup> criteria = builder.createQuery(AssigneeGroup.class);
        criteria.from(AssigneeGroup.class);
        return hibernateSession.createQuery(criteria).getResultList();
    }

    @Override
    public AssigneeGroup getAssigneeByUserId(String userId) {
        hibernateSession.beginTransaction();
        AssigneeGroup entity = hibernateSession.get(AssigneeGroup.class, userId);
        hibernateSession.getTransaction().commit();
        return entity;
    }

}
