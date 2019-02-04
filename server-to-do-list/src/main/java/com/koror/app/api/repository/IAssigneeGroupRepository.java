package com.koror.app.api.repository;

import com.koror.app.entity.AssigneeGroup;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface IAssigneeGroupRepository extends EntityRepository<AssigneeGroup, String> {

    @Query("FROM AssigneeGroup a where a.user.id = ?1 and a.group.id = ?2")
    AssigneeGroup getAssigneeByParam(String userId, String groupId);

}
