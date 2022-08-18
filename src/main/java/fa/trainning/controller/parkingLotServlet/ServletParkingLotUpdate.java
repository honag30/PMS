package fa.trainning.controller.parkingLotServlet;

import fa.trainning.entities.ParkingLot;
import fa.trainning.services.ParkingLotService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletParkingLotUpdate", value = "/ServletParkingLotUpdate")
public class ServletParkingLotUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (ParkingLotService parkingLotService = new ParkingLotService()) {
            int id = Integer.parseInt(request.getParameter("id"));

            long parkArea = Long.parseLong(request.getParameter("parkArea"));
            String parkName = request.getParameter("parkName");
            String parkPlace = request.getParameter("parkPlace");
            long parkPrice = Long.parseLong(request.getParameter("parkPrice"));

            ParkingLot newParkingLot = new ParkingLot(id, parkArea, parkName, parkPlace, parkPrice);
            boolean updated = parkingLotService.updateParkingLotService(newParkingLot);

            if (updated){
                request.setAttribute("successMessage", "Update Success!");
            } else {
                request.setAttribute("warningMessage", "Update Fail!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletParkingLotViewAll");
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
