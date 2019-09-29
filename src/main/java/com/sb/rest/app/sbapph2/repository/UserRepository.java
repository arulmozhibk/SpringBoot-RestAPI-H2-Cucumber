package com.sb.rest.app.sbapph2.repository;

import com.sb.rest.app.sbapph2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User save(User user);
    //User getUser(User user);
    //User getUserByAppIdGroupIdUserId(String AppId, String AroupId, String UserId);

}
