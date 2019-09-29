package com.sb.rest.app.sbapph2.controller;

import com.sb.rest.app.sbapph2.consts.Constants;
import com.sb.rest.app.sbapph2.dao.UserDAO;
import com.sb.rest.app.sbapph2.model.User;
import com.sb.rest.app.sbapph2.model.dto.*;
import com.sb.rest.app.sbapph2.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserDAO userDao;

    @PostMapping("/userlist")
    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();
        userList = userDao.findAllUser();
        System.out.println("Controller size : " + userList.size());
        return userList;
    }

    @GetMapping("/userbyid/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") String userId) {
        User user = userDao.findOne(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        System.out.println(" getUserById =" + user);
        /*RestTemplate restTemplate = CommonUtils.prepareRestTemplate();
        HttpEntity<User> requestUser=new HttpEntity<>(User);
        String url="";
        ResponseEntity<List> responseEntity=restTemplate.getForObject(ResponseEntity.ok().body(user),User);*/
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/userbyuserid/{id}")
    public UserResponse getUserByUserId(@PathVariable(value = "id") String userId) {
        UserResponse userResponse = new UserResponse();
        User user = userDao.findOne(userId);
        if (user != null) {
            System.out.println(" getUserById =" + user);
            userResponse.setStatusCode(new StatusCode(Constants.OPERATION_SUCCESS, "Listed successfully"));
            userResponse.setUserInfo(user);
            return userResponse;
        } else {
            userResponse.setStatusCode(new StatusCode(Constants.OPERATION_FAILED, "No Records found"));
            return userResponse;
        }
    }

    @PostMapping("/createuser")
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        logger.info("Begin Create user operation ");
        logger.debug("Print User Request (userRequest): " + userRequest);
        logger.debug("Print User Request (userRequest.getUserInfo()): " + userRequest.getUserInfo());
        logger.debug("Print User Request (userRequest.getUserInfo().toString): " + userRequest.getUserInfo().toString());
        // AdminDTO adminDto=userRequest.getAdminInfo(); //Admin login using AGUID.
        UserResponse userResponse = new UserResponse();
        User adminInfo = new User();
        boolean isUserValid = false;
        boolean isUserAuthenticated = false;
        boolean isValidAdminRole = false;
        boolean validAdmin = true;
        User adminRequest = new User();
        adminRequest = userRequest.getClientInfo();
        logger.info("adminRequest user : " + adminRequest);
        adminInfo = userDao.findOne(adminRequest.getUserId());
        if (adminInfo != null) {
            isUserValid = true;
            if (isUserValid) {
                logger.debug("isUserValid " + isUserValid);
                logger.debug("Print admin details  " + adminInfo);
                if ((userRequest.getClientInfo().getUserId().equalsIgnoreCase(adminInfo.getUserId())) && (userRequest.getClientInfo().getPassword().equalsIgnoreCase(adminInfo.getPassword()))) {
                    isUserAuthenticated = true;
                    logger.info("Is user Authenticated successfully " + isUserAuthenticated);
                    logger.debug(" User appid "+userRequest.getUserInfo().getAppId()+" , Admin appid "+adminInfo.getRoleId()+ "Is equals "+adminInfo.getRoleId().equals(Constants.GIT_ADMIN_ROLE));

                    if ((userRequest.getUserInfo().getAppId().equals(Constants.APP_GROUP_GIT)) && (adminInfo.getRoleId().equals(Constants.GIT_ADMIN_ROLE))) {
                        isValidAdminRole = true;
                        logger.info("Correct Admin role to create GIT Group user " + "validAdmin Role: " + isValidAdminRole);
                    } else if ((userRequest.getUserInfo().getAppId().equals(Constants.APP_GROUP_GIM)) && (adminInfo.getRoleId().equals(Constants.GIM_ADMIN_ROLE))) {
                        isValidAdminRole = true;
                        logger.info("Correct Admin role to create GIM Group user " + "validAdmin Role: " + isValidAdminRole);
                    } else {
                        isValidAdminRole = false;
                        logger.info("Admin is not in valid role to create GIM/GIT Group user " + "validAdmin Role: " + isValidAdminRole);
                        userResponse.setStatusCode(new StatusCode(Constants.INVALID_ADMIN_USER, "Admin is not eligible to create this user"));
                    }
                } else {
                    logger.info("User authentication failled");
                    userResponse.setStatusCode(new StatusCode(Constants.USER_AUTHENTICATION_FAILED, "Invalid Username and Password"));
                }
            } else {
                userResponse.setStatusCode(new StatusCode(Constants.USERID_INVALID, "Invalid User ID"));
            }
        }
        if (isValidAdminRole) {
            User newUser = userDao.saveUser(userRequest.getUserInfo());
            userResponse.setStatusCode(new StatusCode(Constants.OPERATION_SUCCESS, "Created successfully"));
            userResponse.setUserInfo(newUser);
        } else {
            // userResponse.setStatusCode(new StatusCode(Constants.OPERATION_FAILED, "Invalid Admin login, and Failed to create user"));
        }
        logger.info("Printing user response : " + userResponse.toString());
        logger.info("Printing  Status Info - response : " + userResponse.getStatusCode().getResponseCode());

        logger.info("End of User registration operation.");
        return userResponse;
    }

    @PostMapping("/CreateAdminUser")
    public ResponseEntity<User> createAdminUser(@RequestBody MultiUserRequest mreq) {
        logger.info("Beginning of CreateAdminUser");

        logger.debug("Request toString() : " + mreq.toString());
        logger.debug("getUserroot.toString() : " + mreq.getUser().toString());
        return ResponseEntity.ok().body(mreq.getUser());
    }

    @PostMapping("/deleteuser/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") String userId) {
        User delUser = userDao.findOne(userId);
        if (delUser == null) {
            return ResponseEntity.notFound().build();
        }
        userDao.deleteUser(delUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") String userId, @Valid @RequestBody User userUpdate) {

        User updateOldUser = userDao.findOne(userId);
        if (updateOldUser == null) {
            return ResponseEntity.notFound().build();
        }
        updateOldUser.setAppId(userUpdate.getAppId());
        updateOldUser.setGroupId(userUpdate.getGroupId());
        updateOldUser.setRoleId(userUpdate.getRoleId());
        updateOldUser.setAddress(userUpdate.getAddress());
        updateOldUser.setEmail(userUpdate.getEmail());
        updateOldUser.setModifiedDate(userUpdate.getModifiedDate());
        System.out.println("Updated user details : User =" + userUpdate);
        return ResponseEntity.ok().body(userUpdate);
    }


/*
    @PostMapping("/GetUserEmailByUserId")
    public ResponseEntity<User> getUserEmailByUserId(@PathVariable(value="id") Long userId)
    {
        User user=userDao.findOne(userId);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        System.out.println(" getUserById ="+user);
        */
/*RestTemplate restTemplate = CommonUtils.prepareRestTemplate();
        HttpEntity<User> requestUser=new HttpEntity<>(User);
        String url="";
        ResponseEntity<List> responseEntity=restTemplate.getForObject(ResponseEntity.ok().body(user),User);*//*

        return ResponseEntity.ok().body(user);
    }
*/

}
