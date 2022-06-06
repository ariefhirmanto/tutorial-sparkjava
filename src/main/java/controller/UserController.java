package controller;

import com.google.gson.Gson;
import model.User;
import spark.Route;
import usecase.UserService;
import usecase.UserServiceInterface;

public class UserController {
    final UserServiceInterface userService = new UserService();

    public Route AddUser = (request, response) -> {
        response.type("application/json");

        User user = new Gson().fromJson(request.body(), User.class);
        userService.addUser(user);

        return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
    };
}
