package dgtic.core.repositorio;

import dgtic.core.modelo.Comprador;
import dgtic.core.modelo.Electronico;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseDeDatos {
    //public static Map<String,List<Comprador>> marcas=new HashMap<>();

    public static List<Comprador> compradores=new ArrayList<>();

    static {

        Comprador comp=new Comprador("118\n","Rose\n","Alcantara\n",26,"Ra117@gmail.com\n","rosaSalvaje123\n");
        comp.setElectronico(
                new Electronico("Laptop\n",12000, 82,"abc1452amsal\n", "Azul\n", "HP\n"),
                new Electronico("Celular\n",8000, 156,"abcyqt5nat15sal\n", "Rojo\n", "LG\n"),
                new Electronico("Tablet\n",7500, 201,"aHqsh7bM1376sal\n", "Negra\n", "Apple\n"));
        compradores.add(comp);

        comp=new Comprador("119\n","Elizabeth\n","Nazario\n",15,"LizNa@1225gmail.com\n","ElizabethComs@r123\n");
        comp.setElectronico(
                new Electronico("Celular\n",8000, 156,"YUQ6W2BUGSAIUABS\n", "Negro\n", "LG"),
                new Electronico("Tablet\n",7500, 201,"fFAYF65adfyAagbujgA\n", "Blanca\n", "Apple\n"));
        compradores.add(comp);

        comp=new Comprador("120\n","Juan\n","Sanchez\n",32,"Juansitoa@143gmail.com\n","ElizabethComs@r123\n");
        comp.setElectronico(
                new Electronico("Laptop\n",12000, 143,"fyAagbujgW2BUGSA\n", "Roja\n", "Lenovo\n"),
                new Electronico("Laptop\n",12000, 201,"bjjgyqt5W2hyqt5dy\n", "Negra", "Accer\n"));
        compradores.add(comp);

        comp = new Comprador("121\n", "Carlos\n", "Lopez\n", 40, "carlos.lopez40@gmail.com\n", "carlosL123\n");
        comp.setElectronico(
                new Electronico("Smartwatch\n", 3500, 50, "smart3500cbz1\n", "Negro\n", "Samsung\n"),
                new Electronico("Laptop\n", 14000, 30, "lap14000xyz2\n", "Gris\n", "Dell\n"));
        compradores.add(comp);

        comp = new Comprador("122\n", "Mariana\n", "Gomez\n", 28, "mariana.gomez28@gmail.com\n", "marianG321\n");
        comp.setElectronico(
                new Electronico("Tablet\n", 9000, 80, "tab9000abc3\n", "Blanca\n", "Samsung\n"),
                new Electronico("Celular\n", 12000, 100, "cel12000abc4\n", "Negro\n", "Huawei\n"));
        compradores.add(comp);

        comp = new Comprador("123\n", "Roberto\n", "Martinez\n", 22, "roberto.martinez22@gmail.com\n", "robertoM567\n");
        comp.setElectronico(
                new Electronico("Celular\n", 11000, 120, "cel11000abc5\n", "Azul\n", "Xiaomi\n"),
                new Electronico("Tablet\n", 7500, 70, "tab7500abc6\n", "Negra\n", "Apple\n"));
        compradores.add(comp);

        comp = new Comprador("124\n", "Ana\n", "Hernandez\n", 35, "ana.hernandez35@gmail.com\n", "anaH678\n");
        comp.setElectronico(
                new Electronico("Laptop\n", 13000, 25, "lap13000abc7\n", "Roja\n", "HP\n"),
                new Electronico("Smartwatch\n", 4000, 45, "smart4000xyz8\n", "Verde\n", "Garmin\n"));
        compradores.add(comp);

        comp = new Comprador("125\n", "Miguel\n", "Ramirez\n", 29, "miguel.ramirez29@gmail.com\n", "miguelR890");
        comp.setElectronico(
                new Electronico("Celular\n", 10500, 90, "cel10500xyz9\n", "Blanco\n", "Sony\n"),
                new Electronico("Tablet\n", 8500, 60, "tab8500xyz10\n", "Negra\n", "Microsoft\n"));
        compradores.add(comp);

    }



    /*
    static {
        List<Comprador> compradores=new ArrayList<>();
        Comprador comp=new Comprador("117","Rose","Alcantara",26,"Ra117@gmail.com","rosaSalvaje123");
        comp.setElectronico(
                new Electronico("Laptop",12000.00, 82,"abc1452amsal", "Azul", "HP"),
                new Electronico("Celular",8000.00, 156,"abcyqt5nat15sal", "Rojo", "LG"),
                new Electronico("Tablet",7500.00, 201,"aHqsh7bM1376sal", "Negra", "Apple"));
        compradores.add(comp);
        comp=new Comprador("118","Valerie","Noyola",28,"Valgg@gmail.com","ValentineGG123");
        comp.setElectronico(
                new Electronico("Tablet",8000.00, 156,"YUQ6W2BUGSAIUABS", "Blanca", "LG"),
                new Electronico("Tablet",8000.00, 201,"aHqHGbjhdyg1376sal", "Blanca", "Huawei")
        );
        compradores.add(comp);
        marcas.put("ico",compradores);
        //////////////////////////////////
        compradores=new ArrayList<>();
        comp=new Comprador("119","Elizabeth","Nazario",15,"LizNa@1225gmail.com","ElizabethComs@r123");
        comp.setElectronico(
                new Electronico("Celular",8000.00, 156,"YUQ6W2BUGSAIUABS", "Negro", "LG"),
                new Electronico("Tablet",7500.00, 201,"fFAYF65adfyAagbujgA", "Blanca", "Apple")
        );
                compradores.add(comp);
        comp=new Comprador("120","Juan","Sanchez",32,"Juansitoa@143gmail.com","ElizabethComs@r123");
        comp.setElectronico(
                new Electronico("Laptop",12000.00, 143,"fyAagbujgW2BUGSA", "Roja", "Lenovo"),
                new Electronico("Laptop",12000.00, 201,"bjjgyqt5W2hyqt5dy", "Negra", "Accer")
        );
        compradores.add(comp);
        marcas.put("ime", compradores);

        }
     */

}
