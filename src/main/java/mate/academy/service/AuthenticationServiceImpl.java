package mate.academy.service;

import lombok.extern.slf4j.Slf4j;
import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;

@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public User login(String login, String password) throws AuthenticationException {

        log.info("Method login was called with login = {}", login);

        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Username or password are incorrect");
        }
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        // this user identifier should be set by DB. We will use dummy data for this example
        user.setUserId(2L);
        return user;
    }
}
