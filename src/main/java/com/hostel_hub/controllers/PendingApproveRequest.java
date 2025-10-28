package com.hostel_hub.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.hostel_hub.entities.MyRoom;
import com.hostel_hub.services.MyRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hostel_hub.entities.Changes;
import com.hostel_hub.entities.User;
import com.hostel_hub.repo.ChangesRepo;
import com.hostel_hub.repo.MyRoomRepo;
import com.hostel_hub.repo.UserRepo;

@Controller
public class PendingApproveRequest {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MyRoomRepo myRoomRepo;

    @Autowired
    private MyRoomService myRoomService;

    @Autowired
    private ChangesRepo changesRepo;

    @PostMapping("/admin/approverequest")
    public String approveRequest(@RequestParam("email") String email) {
        try {
            System.out.println("Pending request controller run....................");
            User user = userRepo.findUserByUserEmail(email);
            MyRoom myRoom = myRoomRepo.findMyRoomByUser(user);

            // if room is not valid or not available
            if (!myRoomService.isValidRoom(myRoom)) {
                myRoom.setStatus("This room is not available");
                myRoomRepo.save(myRoom);
                return "redirect:/requestformadmin";
            }

            System.out.println("\n" + myRoom.getStatus() + "\n");
            System.out.println("roomid: " + myRoom.getId());
            myRoom.setStatus("Occupied");
            myRoomRepo.save(myRoom);
            System.out.println(myRoom.getStatus());
            System.out.println("pending approved...............");
            // update changes
            Changes changes = new Changes();
            changes.setDate(getCurrentDate());
            System.out.println("user id: "+user.getId());
            changes.setUserId(user.getId());
            System.out.println("user email: "+email);
            changes.setNotify("Room Status Changed! Approved " + myRoom.getBookingId());
            changes.setType("User");
            changesRepo.save(changes);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return "redirect:/requestformadmin";

    }

    public String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }

}
