package com.pedrosaez.englishtrainer.session;

import com.pedrosaez.englishtrainer.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class SessionManager {

    private User currentUser;

    public void login(User user) {
        this.currentUser = user;
    }

    public void logout() {
        this.currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
}
