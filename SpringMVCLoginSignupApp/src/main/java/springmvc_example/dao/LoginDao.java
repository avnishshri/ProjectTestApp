package springmvc_example.dao;

import java.util.List;

import springmvc_example.model.UserInfo;

public interface LoginDao {

 UserInfo findUserInfo(String username);
 
 List getUserRoles(String username);
}