//package SpringBoot.CarWebsite.Config;
//
//import SpringBoot.CarWebsite.Model.Car;
//import SpringBoot.CarWebsite.Model.User;
//import SpringBoot.CarWebsite.Repository.CarRepository;
//import SpringBoot.CarWebsite.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class DBOperationRunner implements CommandLineRunner {
//
//    UserRepository userRepository;
//    PasswordEncoder passwordEncoder;
//    CarRepository carRepository;
//
//    public DBOperationRunner(UserRepository userRepository, PasswordEncoder passwordEncoder,   CarRepository carRepository) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.carRepository = carRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        userRepository.deleteAll();
//        User alex = new User("Alexandru", "user", passwordEncoder.encode("user") ,"ROLE_USER");
//        User andrei =  new User("Andrei", "admin", passwordEncoder.encode("admin") ,"ROLE_ADMIN");
//        User dorin =  new User("Dorin", "dorin", passwordEncoder.encode("admin") ,"ROLE_ADMIN");
//        userRepository.saveAllAndFlush(List.of( alex, andrei, dorin ));
//        carRepository.saveAndFlush(
//                new Car("TM42BEM", andrei.getUserId(),"Mitsubishi","Lancer","Rosie",2010,1599,"Benzina",92,100,250,5000
//        ));
//    }
//}
