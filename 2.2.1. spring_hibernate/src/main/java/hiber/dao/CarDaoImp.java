package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImp implements CarDao {
    private final SessionFactory sessionFactory;

    public User getUserByCar(String model, int series) {
        Query query = sessionFactory.openSession()
                .createQuery("from User where car.model = :name" +
                        " and car.series= :series");
        query.setParameter("name", model);
        query.setParameter("series", series);
        User user = (User) query.getResultList().get(0);
        return user;
    }

    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> getCar() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();

    }
}
