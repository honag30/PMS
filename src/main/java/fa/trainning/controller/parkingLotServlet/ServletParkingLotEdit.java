package fa.trainning.controller.parkingLotServlet;

import fa.trainning.entities.ParkingLot;
import fa.trainning.services.ParkingLotService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletParkingLotEdit", value = "/ServletParkingLotEdit")
public class ServletParkingLotEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (ParkingLotService parkingLotService = new ParkingLotService()) {
            int id = Integer.parseInt(request.getParameter("id"));
            ParkingLot existingParkingLot = parkingLotService.getParkingLotByIdService(id);
            request.setAttribute("existingParkingLot", existingParkingLot);

            RequestDispatcher dispatcher = request.getRequestDispatcher("assets/views/parking-lot-views/parking-lot-form.jsp");
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
