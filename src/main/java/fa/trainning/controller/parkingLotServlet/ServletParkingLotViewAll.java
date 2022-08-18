package fa.trainning.controller.parkingLotServlet;

import fa.trainning.entities.ParkingLot;
import fa.trainning.services.ParkingLotService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletParkingLotViewAll", value = "/ServletParkingLotViewAll")
public class ServletParkingLotViewAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (ParkingLotService parkingLotService = new ParkingLotService()) {
            List<ParkingLot> listParkingLot = parkingLotService.viewAllParkingLotService();
            request.setAttribute("listParkingLot", listParkingLot);
            RequestDispatcher dispatcher = request.getRequestDispatcher("assets/views/parking-lot-views/parking-lot-view-all.jsp");
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
