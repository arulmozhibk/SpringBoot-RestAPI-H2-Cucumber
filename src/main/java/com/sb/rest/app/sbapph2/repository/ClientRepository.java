package com.sb.rest.app.sbapph2.repository;

import com.sb.rest.app.sbapph2.model.dto.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,String> {
}
