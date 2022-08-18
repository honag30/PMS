package fa.trainning.controller.parkingLotServlet;

import fa.trainning.entities.ParkingLot;
import fa.trainning.services.ParkingLotService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletParkingLotCreate", value = "/ServletParkingLotCreate")
public class ServletParkingLotCreate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (ParkingLotService parkingLotService = new ParkingLotService()) {

            long parkArea = Long.parseLong(request.getParameter("parkArea"));
            String parkName = request.getParameter("parkName");
            String parkPlace = request.getParameter("parkPlace");
            long parkPrice = Long.parseLong(request.getParameter("parkPrice"));

            ParkingLot newParkingLot = new ParkingLot(parkArea, parkName, parkPlace, parkPrice);
            System.out.println("In controller update: " + newParkingLot.toString());
            boolean created = parkingLotService.createParkingLotService(newParkingLot);

            if (created){
                request.setAttribute("successMessage", "Create Success!");
            } else {
                request.setAttribute("warningMessage", "Create Fail!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletParkingLotViewAll");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
