package com.sb.rest.app.sbapph2.controller;

import com.sb.rest.app.sbapph2.dao.ClientDAO;
import com.sb.rest.app.sbapph2.model.dto.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("client")
public class ClientController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ClientDAO clientDAO;

    @PostMapping("createclient")
    public ResponseEntity createClient(@RequestBody Client client)
    {
        logger.info("Begin create client ");
        logger.debug("Controller Request in createclient "+client);
        client=clientDAO.createClient(client);
        logger.debug("Controller Response in createclient "+client);
        logger.info("End create client ");
        return ResponseEntity.ok().body(client);
    }
}
