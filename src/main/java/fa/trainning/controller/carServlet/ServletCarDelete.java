package fa.trainning.controller.carServlet;

import fa.trainning.services.CarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCarDelete", value = "/ServletCarDelete")
public class ServletCarDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (CarService carService = new CarService()) {
            String licensePlate = request.getParameter("id");
            boolean deleted = carService.deleteCarService(licensePlate);

            if (deleted){
                request.setAttribute("warningMessage", "Delete Success!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletCarViewAll");
            dispatcher.forward(request, response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
