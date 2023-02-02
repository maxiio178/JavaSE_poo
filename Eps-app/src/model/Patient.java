package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User{
    //Atrivutos
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();

    //Constructor
    public Patient(String name, String email){
        super(name, email);
    }

    // methodos
    public String getWeight() {
        return this.weight + " kg." ;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getHeight() {
        return this.height + " Mt.";
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getBlood() {
        return blood;
    }
    public void setBlood(String blood) {
        this.blood = blood;
    }

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.scheaduble(date,time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Age: " + birthday + "\n" +
                "Peso: " + getWeight() + "\n" + "Altura: " + getHeight();
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial clinico desde nacimiento.");
    }
}
