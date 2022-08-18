package fa.trainning.controller.carServlet;

import fa.trainning.entities.Car;
import fa.trainning.entities.ParkingLot;
import fa.trainning.services.CarService;
import fa.trainning.services.ParkingLotService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCarCreate", value = "/ServletCarCreate")
public class ServletCarCreate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (CarService carService = new CarService();
             ParkingLotService parkingLotService = new ParkingLotService()) {

            String licensePlate = request.getParameter("licensePlate");
            String carColor = request.getParameter("carColor");
            String carType = request.getParameter("carType");
            String company = request.getParameter("company");
            String parkName = request.getParameter("parkName");
            ParkingLot parkingLot = parkingLotService.getParkingLotByNameService(parkName);

            Car checkExistedCar = carService.getCarByLicensePlateService(licensePlate);
            if (checkExistedCar != null){
                request.setAttribute("message", "License plate '"+licensePlate+"' already existed!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("assets/views/car-views/car-form.jsp");
                dispatcher.forward(request, response);
            }

            Car newCar = new Car(licensePlate, carColor, carType, company, parkingLot.getParkId());
            boolean created = carService.createCarService(newCar);

            if (created){
                request.setAttribute("successMessage", "Create Success!");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletCarViewAll");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
