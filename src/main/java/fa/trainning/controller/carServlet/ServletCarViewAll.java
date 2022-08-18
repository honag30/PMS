package fa.trainning.controller.carServlet;

import fa.trainning.entities.Car;
import fa.trainning.services.CarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletCarViewAll", value = "/ServletCarViewAll")
public class ServletCarViewAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (CarService carService = new CarService()) {
            List<Car> listCar = carService.viewAllCarService();
            request.setAttribute("listCar", listCar);
            RequestDispatcher dispatcher = request.getRequestDispatcher("assets/views/car-views/car-view-all.jsp");
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
