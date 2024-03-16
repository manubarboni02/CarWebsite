package SpringBoot.CarWebsite.Service;

import SpringBoot.CarWebsite.Model.Car;
import SpringBoot.CarWebsite.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars(){
        return carRepository.findAll();
    }
    public List<Car> findAllByKeywords(String filter1, String filter2, String filter3){
        if(filter1.isEmpty())
            filter1=null;
        if(filter2.isEmpty())
            filter2=null;
        if(filter3.isEmpty())
            filter3=null;
        return carRepository.findAllByKeywords(filter1,filter2,filter3);
    }
    public boolean addCar(Car car){
        if(carRepository.findCarByRegistrationNumber(car.getRegistrationNumber()).isEmpty()) {
            carRepository.saveAndFlush(car);
            return false;
        }
        return true;
    }
    public boolean modifyCar(Car car){
        if(carRepository.findCarByRegistrationNumber(car.getRegistrationNumber()).isPresent()) {
            carRepository.saveAndFlush(car);
            return false;
        }
        return true;
    }

    public boolean deleteCar(Car car){
        if(carRepository.findCarByRegistrationNumber(car.getRegistrationNumber()).isPresent()) {
            carRepository.delete(carRepository.findCarByRegistrationNumber(car.getRegistrationNumber()).get());
            carRepository.flush();
            return false;
        }
        return true;
    }
}
