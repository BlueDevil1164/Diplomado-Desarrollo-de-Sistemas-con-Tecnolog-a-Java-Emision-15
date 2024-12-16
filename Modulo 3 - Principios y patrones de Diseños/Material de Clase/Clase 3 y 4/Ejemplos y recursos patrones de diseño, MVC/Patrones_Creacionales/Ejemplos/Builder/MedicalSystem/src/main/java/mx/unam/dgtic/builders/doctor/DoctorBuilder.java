package mx.unam.dgtic.builders.doctor;

import mx.unam.dgtic.models.Doctor;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class DoctorBuilder implements Builder{
    private String name;
    private int age;
    private String speciality;
    private String dni;
    private String uuid;
    @Override
    public void fullName(String name) {
        this.name=name;
    }

    @Override
    public void age(int age) {
        this.age=age;
    }

    @Override
    public void speciality(String speciality) {
        this.speciality=speciality;
    }

    @Override
    public void dni(String dni) {
        this.dni=dni;
    }

    @Override
    public void uuid(String uuid) {
        this.uuid=uuid;
    }

    /**
     * @return
     */
    @Override
    public Doctor getResult() {
        return new Doctor(name,age,speciality,dni,uuid);
    }
}
