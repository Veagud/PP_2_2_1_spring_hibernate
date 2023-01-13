package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import javax.management.Query;
import java.util.List;

public interface UserService {
    void add(User user);

    void addCar(Car car);

    List<User> listUsers();

    User getUserByCar(String model, int series);
}
