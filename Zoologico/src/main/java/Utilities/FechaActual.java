/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FechaActual {

    public static String getFechaActualizada() {
        ZoneId timeZone = ZoneId.systemDefault();
        ZonedDateTime dateTime = ZonedDateTime.now(timeZone);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        String fechaActual = dateTime.format(dateFormat); // Formatea la fecha y hora actual en el formato deseado
        return fechaActual;
    }

}
