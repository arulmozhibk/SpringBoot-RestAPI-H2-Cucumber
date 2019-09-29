package com.sb.rest.app.sbapph2.dao;

import com.sb.rest.app.sbapph2.model.dto.Client;
import com.sb.rest.app.sbapph2.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientDAO {
    @Autowired
    ClientRepository clientRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Client createClient(Client clientInput){
        Client clientInfo=new Client();
        if(clientInput!=null) {
            clientInfo = clientRepository.save(clientInput);
            if(clientInfo.getClientId()!=null) {
                logger.info("Client Created successfully!!!");
                logger.debug("After client creation :"+clientInfo);
            }else{    logger.error("Client creation failed.");
            }
        }else{  logger.error("Invalid Client input, please check.");
        }
    return clientInfo;
    }

}
