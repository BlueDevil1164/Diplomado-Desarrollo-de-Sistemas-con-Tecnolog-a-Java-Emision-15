import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Fechas {
    public static void main(String[] args) {
        System.out.println("Fechas, Horas y FechaHora");
        LocalDate fecha1 = LocalDate.now();
        System.out.println("Fecha 1: "+ fecha1);

        LocalTime hora1 = LocalTime.now();
        System.out.println("Hora 1: "+ hora1);   // ???  Diferencia con la hora del equipo

        LocalDateTime fechaHora1 = LocalDateTime.now();
        System.out.println("Fecha-hora 1: "+ fechaHora1);

        // con of()
        LocalDate fecha2 = LocalDate.of(2024,6,2);
        System.out.println("Fecha 2: "+ fecha2);

        LocalTime hora2 = LocalTime.of(1,2,3);
        System.out.println("Hora 2: "+ hora2);   // ???  Diferencia con la hora del equipo

        LocalDateTime fechaHora2 = LocalDateTime.of(2020,12,7,10,9,8);
        System.out.println("Fecha-hora 2: "+ fechaHora2);

        // con parse()
        LocalDate fecha3 = LocalDate.parse ("2024-06-02");
        System.out.println("Fecha 3: "+ fecha3);

        LocalTime hora3 = LocalTime.parse ("10:06:54");
        System.out.println("Hora 3: "+ hora3);   // ???  Diferencia con la hora del equipo

        LocalDateTime fechaHora3 = LocalDateTime.parse ("1999-12-31T09:38:51");
        System.out.println("Fecha-hora 3: "+ fechaHora3);

    }
}
