package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UiDoctor {
    public static ArrayList<Doctor> doctorsAvaliableAppointment = new ArrayList<>();
    public static void showDoctorMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Wolcome " + UiMenu.doctorLogged.getEmail());
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Scheduled appointment");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UiMenu.showMenu();
                    break;
            }
        } while (response != 0);
    }

    private static void showAddAvailableAppointmentsMenu() {
        int response = 0;
        do {
            System.out.println();
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select a Month");

            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". " + UiMenu.MONTHS[i]);
            }
            System.out.println("0. Return");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4) {
                //1.2.3
                int monthSelected = response;
                System.out.println(monthSelected + " . " + UiMenu.MONTHS[monthSelected-1]);

                System.out.println("Insert the date available: [dd/mm/yyy]");
                String date = sc.nextLine();


                System.out.println("Your data is " + date + "\n1. Correct" + "\n2. Change data");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time avalaible for date: " + date + "[13:00]");;
                    time = sc.nextLine();
                    System.out.println("You time is: " + time + "\n1. Correct \n2. Change");
                    responseTime = Integer.valueOf(sc.nextLine());

                    UiMenu.doctorLogged.setAvalilableAppointment(date,time);
                }while (responseTime == 2);
            }else if (response == 0){
                showDoctorMenu();
            }
        } while (response != 0);
    }
    private static void checkDoctorAvaliableAppointment(Doctor doctor){
        if (doctor.getAvalilableAppointments().size() >0
        && !doctorsAvaliableAppointment.contains(doctor)){
            doctorsAvaliableAppointment.add(doctor);
        }
    }
}
