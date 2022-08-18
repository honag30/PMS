package fa.trainning.controller.carServlet;

import fa.trainning.entities.Car;
import fa.trainning.services.CarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCarGetByLicensePlate", value = "/ServletCarGetByLicensePlate")
public class ServletCarGetByLicensePlate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (CarService carService = new CarService()) {
            String  licensePlate = request.getParameter("id");
            Car car = carService.getCarByLicensePlateService(licensePlate);
            request.setAttribute("car", car);

            RequestDispatcher dispatcher = request.getRequestDispatcher("src/main/webapp/assets/views/car-views/car-form.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
