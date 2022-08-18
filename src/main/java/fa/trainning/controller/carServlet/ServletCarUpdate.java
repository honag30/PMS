package fa.trainning.controller.carServlet;

import fa.trainning.entities.Car;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletCarUpdate", value = "/ServletCarUpdate")
public class ServletCarUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (CarService carService = new CarService()) {
            String licensePlate = request.getParameter("licensePlate");
            String carColor = request.getParameter("carColor");
            String carType = request.getParameter("carType");
            String company = request.getParameter("company");
            String parkName = request.getParameter("parkName");

            ParkingLotService parkingLotService = new ParkingLotService();
            ParkingLot parkingLot = parkingLotService.getParkingLotByNameService(parkName);

            Car newCar = new Car(licensePlate, carColor, carType, company, parkingLot.getParkId());
            Car checkExistedCar = carService.getCarByLicensePlateService(newCar.getLicensePlate());
            boolean updated = false;

            try {
                updated = carService.updateCarService(newCar);
                if (updated) {
                    request.setAttribute("successMessage", "Update Success!");
                } else {
                    request.setAttribute("warningMessage", "Update Fail!");
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletCarViewAll");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                if (checkExistedCar != null) {
                    HttpSession session = request.getSession(false);
                    session.setAttribute("updateMessage", "License plate '" + licensePlate + "' already existed!");
                    response.sendRedirect(request.getContextPath() + "/ServletCarEdit?id=" + newCar.getLicensePlate());
                } else {
                    if (updated) {
                        request.setAttribute("successMessage", "Update Success!");
                    } else {
                        request.setAttribute("warningMessage", "Update Fail!");
                    }
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletCarViewAll");
                    dispatcher.forward(request, response);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
