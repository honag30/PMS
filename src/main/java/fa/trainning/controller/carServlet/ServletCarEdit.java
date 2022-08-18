package fa.trainning.controller.carServlet;

import fa.trainning.entities.Car;
import fa.trainning.services.CarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCarEdit", value = "/ServletCarEdit")
public class ServletCarEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (CarService carService = new CarService()) {
            String licencePlate = request.getParameter("licencePlate");
            Car existingCar = carService.getCarByLicensePlateService(licencePlate);
            request.setAttribute("existingCar", existingCar);

            HttpSession session = request.getSession(false);
            String message = (String)session.getAttribute("updateMessage");
            if (message != null){
                request.setAttribute("message", message);
                session.removeAttribute("updateMessage");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("assets/views/car-views/car-form.jsp");
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
