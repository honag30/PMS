package fa.trainning.controller.parkingLotServlet;

import fa.trainning.services.ParkingLotService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletParkingLotDelete", value = "/ServletParkingLotDelete")
public class ServletParkingLotDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (ParkingLotService parkingLotService = new ParkingLotService()) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean deleted = parkingLotService.deleteParkingLotService(id);

            if (deleted){
                request.setAttribute("warningMessage", "Delete Success!");
            } else {
                request.setAttribute("warningMessage", "Delete Fail!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletParkingLotViewAll");
            dispatcher.forward(request, response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
