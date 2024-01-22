package users.application;

import users.domain.createUserRepository;
import users.domain.userInterface;

public class createUserApplication implements caseCreateUser{

    private final createUserRepository _createUserRepository;

    public createUserApplication(createUserRepository _createUserRepository){
        this._createUserRepository = _createUserRepository;
    }

    @Override
    public void createDatauser(String user, String password) {
        userInterface userEntity = new users.domain.user();
        userEntity.setUser(user);
        userEntity.setPassword(password);
        _createUserRepository.saveUser(userEntity);

        System.out.println("Se ingreso al usuario: " + user);
    }

}
