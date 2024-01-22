package users.infrastructure;

import users.application.caseCreateUser;
import users.application.createUserApplication;
import users.domain.createUserRepository;

public class webCreateUser {
    public static void main(String[] args) throws Exception {
        createUserRepository userDataStorage = new createUserInfrastructor();
        caseCreateUser createUserData = new createUserApplication(userDataStorage);

        createUserData.createDatauser("juan", "1234");
    }
}
