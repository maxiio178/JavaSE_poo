package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UiMenu {
    public static final String[] MONTHS =
            {"Enero", "Febrero","Marzo","Abril","Mayo","Junio","Julio",
                    "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor: ");
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }
    private static void authUser(int userType){
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Mario Martelo", "MarioM@mail.com"));
        doctors.add(new Doctor("Luz Martelo", "LuzM@mail.com"));
        doctors.add(new Doctor("Fabian Martelo", "FabioM@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Candelaria Periñan", "Candepemo@mail.com"));
        patients.add(new Patient("Nicolai Moreno", "NicolaiM@mail.com"));
        patients.add(new Patient("Abril Dior", "AbrilD@mail.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("Inserte su email [exple@exapel.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType == 1) {
                for (Doctor d: doctors) {
                    if (d.getEmail().equals(email)){
                        emailCorrect = true;
                        //Obtener el usuario
                        doctorLogged = d;
                        UiDoctor.showDoctorMenu();
                    }
                }
            }
            if (userType == 2) {
                for(Patient p: patients){
                    if (p.getEmail().equals(email)){
                        emailCorrect = true;
                        patientLogged = p;
                    }
                }
            }
        }while (!emailCorrect);
    }
}
