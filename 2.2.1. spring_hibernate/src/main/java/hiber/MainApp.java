package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        User user5 = new User("User4", "Lastname4", "user4@mail.ru");

        Car car1 = new Car("car1", 100);
        Car car2 = new Car("car2", 200);
        Car car3 = new Car("car3", 300);
        Car car4 = new Car("car4", 400);
        Car car5 = new Car("car5", 500);


        userService.add(user1.setCar(car1).setUser(user1));
        userService.add(user2.setCar(car2).setUser(user2));
        userService.add(user3.setCar(car3).setUser(user3));
        userService.add(user4.setCar(car4).setUser(user4));
        userService.add(user5.setCar(car5).setUser(user5));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car Model = " + user.getCar().getModel());
            System.out.println("Car Series = " + user.getCar().getSeries());
            System.out.println();
        }

        System.out.println(userService.getUserCar("car1", 100));
        System.out.println(userService.getUserCar("car2", 200));
        System.out.println(userService.getUserCar("car3", 300));
        System.out.println(userService.getUserCar("car4", 400));
        System.out.println(userService.getUserCar("car5", 500));

        context.close();
    }
}
