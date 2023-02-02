package model;

public class Nurse extends User{
    //Atrivitos
    private String Speciality;

    //Constructor
    public Nurse (String name, String email) {
        super(name, email);
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Verde.");
        System.out.println("Departamento: Cancelorogia, Pediatria, Nutricion");
    }

    //Metodos
    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }
}
