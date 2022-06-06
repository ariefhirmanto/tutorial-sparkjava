package usecase;

import exception.UserException;
import model.User;

import java.util.Collection;
import java.util.HashMap;

public class UserService implements UserServiceInterface {
    private HashMap<String, User> userMap;

    public UserService() {
        userMap = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User getUser(String id) {
        return userMap.get(id);
    }

    @Override
    public void deleteUser(String id) {
        userMap.remove(id);
    }

    @Override
    public Collection<User> getUsers() {
        return userMap.values();
    }

    @Override
    public boolean isUserExist(String id) {
        return userMap.containsKey(id);
    }

    @Override
    public User editUser(User user) throws UserException {
        try {
            if (user.getId() == null) {
                throw new UserException("ID can't be blank");
            }

            User editedUser = userMap.get(user.getId());
            if (editedUser == null) {
                throw new UserException("User can't be found");
            }

            if (user.getEmail() != null) {
                editedUser.setEmail(user.getEmail());
            }
            if (user.getFirstName() != null) {
                editedUser.setFirstName(user.getFirstName());
            }
            if (user.getLastName() != null) {
                editedUser.setLastName(user.getLastName());
            }
            if (user.getId() != null) {
                editedUser.setId(user.getId());
            }

            return editedUser;
        } catch (Exception ex) {
            throw new UserException(ex.getMessage());
        }
    }
}
