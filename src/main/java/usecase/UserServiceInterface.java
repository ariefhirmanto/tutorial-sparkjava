package usecase;

import exception.UserException;
import model.User;

import java.util.Collection;

public interface UserServiceInterface {
    public void addUser(User user);
    public User getUser(String id);
    public void deleteUser(String id);
    public Collection<User> getUsers();
    public boolean isUserExist(String id);
    public User editUser(User user) throws UserException;
}
