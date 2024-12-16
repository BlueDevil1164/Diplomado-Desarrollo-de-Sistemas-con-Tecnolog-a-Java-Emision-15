package edu.dgtic.srp;

public class UserPersistenceService {

    private Store store = new Store();

    public String saveUser(User user) {
        UserValidator validator = new UserValidator();
        if (!validator.validateUser(user)) {
            return "FALLASTE :(";
        }
        store.store(user);
        return "VICTORIA!";
    }
}
