package Service;

import Entity.UserEntity;
import Repository.LoginRepository;

public class LoginServiceImpl implements LoginService{
    LoginRepository loginRepository=new LoginRepository();
    @Override
    public boolean checkLoginDetails(String username, String password) {
        UserEntity userEntity=loginRepository.checkUserNameandPassword(username, password);

        if (userEntity.getUsername().equals(username)&&
        userEntity.getPassword().equals(password)){
            return  true;
        }
        return  false;

    }
}
