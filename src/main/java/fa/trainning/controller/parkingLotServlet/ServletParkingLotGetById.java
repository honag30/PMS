package fa.trainning.controller.parkingLotServlet;

import fa.trainning.entities.ParkingLot;
import fa.trainning.services.ParkingLotService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletParkingLotGetById", value = "/ServletParkingLotGetById")
public class ServletParkingLotGetById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (ParkingLotService parkingLotService = new ParkingLotService()) {
            int id = Integer.parseInt(request.getParameter("id"));
            ParkingLot parkingLot = parkingLotService.getParkingLotByIdService(id);
            request.setAttribute("parkingLot", parkingLot);

            RequestDispatcher dispatcher = request.getRequestDispatcher("src/main/webapp/assets/views/parking-lot-views/parking-lot-form.jsp");
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
