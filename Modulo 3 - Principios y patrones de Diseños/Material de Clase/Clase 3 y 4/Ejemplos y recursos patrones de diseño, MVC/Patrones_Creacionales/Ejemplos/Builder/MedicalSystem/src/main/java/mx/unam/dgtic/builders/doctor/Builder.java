package mx.unam.dgtic.builders.doctor;

import mx.unam.dgtic.models.Doctor;
import mx.unam.dgtic.models.Patient;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public interface Builder {
    void fullName(String name);
    void age(int age);
    void speciality(String speciality);
    void dni(String dni);

    void uuid(String uuid);

    Doctor getResult();

}
