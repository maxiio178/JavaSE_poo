package model;

import ui.UiDoctor;
import ui.UiMenu;

import java.util.*;

public class UiPatient {
    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome" + UiMenu.patientLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response){
                case 1:
                    showBookAnAppointment();
                    break;
                case 2:
                    showPatientMyAppointment();
                    break;
                case 0:
                    UiMenu.showMenu();
                    break;
            }
        }while (response != 0);
    }
    private static void showBookAnAppointment () {
        int response = 0;
        do {
            System.out.println("::Book an appointment");
            System.out.println("::Select date");
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            for (int i = 0; i < UiDoctor.doctorsAvaliableAppointment.size(); i++) {
                int k = 0;
                ArrayList<Doctor.AvalilableAppointment> avalilableAppointments =
                        UiDoctor.doctorsAvaliableAppointment.get(i).getAvalilableAppointments();

                Map<Integer, Doctor> doctorsAppointments = new TreeMap<>();

                for (int j = 0; j < avalilableAppointments.size() ; j++) {
                    k++;
                    System.out.println(k + ". " + avalilableAppointments.get(j).getDate());
                    doctorsAppointments.put(Integer.valueOf(j), UiDoctor.doctorsAvaliableAppointment.get(i));

                    doctors.put(Integer.valueOf(k), doctorsAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int dateSelectResponse = Integer.parseInt(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(dateSelectResponse);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");

            for (Map.Entry<Integer, Doctor> doc:doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    ". DATE: " + doctorSelected.getAvalilableAppointments().get(indexDate).getDate() +
                    ". TIME: " + doctorSelected.getAvalilableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment: \n1. YES \n2. Change Data.");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1) {
                UiMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvalilableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvalilableAppointments().get(indexDate).getTime());

                showPatientMenu();
            }
        }while (response !=0);
    }
    private static void showPatientMyAppointment () {
        int response = 0;
        do{
            System.out.println("::My Appointment");
            if (UiMenu.patientLogged.getAppointmentDoctors().size() == 0) {
                System.out.println("Don´t have appointments");
                break;
            }
            for (int i = 0; i < UiMenu.patientLogged.getAppointmentDoctors().size(); i++) {
               int j = i + 1;
                System.out.println(j + ". "+
                        "DATE: " + UiMenu.patientLogged.getAppointmentDoctors().get(i).getDate()+
                        "TIME: " + UiMenu.patientLogged.getAppointmentDoctors().get(i).getTime()+
                        "Doctor: " + UiMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor());
            }
        }while (response!=0);

    }
}
