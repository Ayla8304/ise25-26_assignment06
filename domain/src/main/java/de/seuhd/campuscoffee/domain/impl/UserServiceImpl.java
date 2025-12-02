package de.seuhd.campuscoffee.domain.impl;

import de.seuhd.campuscoffee.domain.model.User;
import de.seuhd.campuscoffee.domain.ports.UserDataService;
import de.seuhd.campuscoffee.domain.ports.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    // TODO: Implement user service
    private final UserDataService userDataService;

    @Override
    public void clear() {
        log.info("Clearing all users");
        userDataService.clear();
    }

    @Override
    public @NonNull List<User> getAll() {
        log.debug("Retrieving all users");
        return userDataService.getAll();
    }

    @Override
    public @NonNull User getById(@NonNull Long id) {
        Objects.requireNonNull(id, "id must not be null");
        log.debug("Retrieving user with id {}", id);
        return userDataService.getById(id);
    }

    @Override
    public @NonNull User getByLoginName(@NonNull String loginName) {
        Objects.requireNonNull(loginName, "loginName must not be null");
        log.debug("Retrieving user with loginName {}", loginName);
        return userDataService.getByLoginName(loginName);
    }

    @Override
    public @NonNull User upsert(@NonNull User user) {
        Objects.requireNonNull(user, "user must not be null");
        if (user.id() == null) {
            log.info("Creating new user with loginName {}", user.loginName());
        } else {
            log.info("Updating user with id {}", user.id());
        }
        return userDataService.upsert(user);
    }

    @Override
    public void deleteById (@NonNull Long id) {
        Objects.requireNonNull(id, "id must not be null");
        log.info("Deleting user with id {}", id);
        userDataService.delete(id);
    }
}
