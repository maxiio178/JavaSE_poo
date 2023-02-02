package model;

import sun.java2d.pipe.SpanShapeRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    //enum class
    public enum Days{
        // Atrivustos constantes (condicion de los ennums)
        SUNDAY("Domingo"),

        MONDAY("Lunes"),

        TUESDAY("Martes"),

        WEDNESDAY("Miercoles"),

        THURSDAY("Jueves"),

        FRIDAY("Viernes"),

        SATURDAY("Sabado");

        private String spanish;

        //Constructor de el enum (Los enums son constantes estaticas asi que poseen metodos y constructores.)
        private Days(String s) {
            spanish = s;
        }

        //methodos

        public String getSpanish() {
            return spanish;
        }
    }

    // Props - Atrivutos
    String speciality;

    // Constructor
    public Doctor(String name, String email){
        super(name, email);

    }

    //Metodos - Comportamiento


    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    public void showName () {
        System.out.println("El nombre del doctor es: " + super.getName());
    }

    //Array de citas
    ArrayList<AvalilableAppointment> avalilableAppointments = new ArrayList<>();

    //Funcion para agregar citas a el array
    public void setAvalilableAppointment(String date, String time) {
        avalilableAppointments.add(new AvalilableAppointment(date,time));
    }
    //Funcion para mostrar el array

    public ArrayList<AvalilableAppointment> getAvalilableAppointments () {
        return avalilableAppointments;
    }

    // Clase anidada en la clase doctor: funcionalidad excusiva del doctor para agragar citas.


    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: " + speciality + "\nAvailavle: " + avalilableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Roja, Departamento: Nutricion");
        System.out.println("Hospital: Cruz Roja, Departamento: Nutricion");
    }

    public static class AvalilableAppointment {
        //atrivutos de la clase anidad statica
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //Constructor de la clase anidad statica
        public AvalilableAppointment(String date, String time){
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.time = time;
        }
        //metodos, clase anidada

        public int getId () {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public Date getDate(String DATE) {
            return date;
        }
        public String getDate() {
            return format.format(date);
        }


        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Avalilable Appointment" + "\n" + "Date: " + date + "\nTime: " + time;
        }
    }
}
