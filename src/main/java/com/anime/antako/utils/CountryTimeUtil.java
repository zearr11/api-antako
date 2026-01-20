package com.anime.antako.utils;

import com.anime.antako.entities.db.enums.Country;
import com.anime.antako.entities.db.enums.EmisionDay;
import com.anime.antako.entities.db.models.catalog.CountryTime;
import java.time.LocalTime;

public class CountryTimeUtil {

    private static final EmisionDay[] VALID_DAYS = {
            EmisionDay.LUNES,
            EmisionDay.MARTES,
            EmisionDay.MIERCOLES,
            EmisionDay.JUEVES,
            EmisionDay.VIERNES,
            EmisionDay.SABADO,
            EmisionDay.DOMINGO
    };

    private static EmisionDay previousDay(EmisionDay day) {
        if (day == EmisionDay.NO_DEFINIDO) {
            return EmisionDay.NO_DEFINIDO;
        }

        int index = java.util.Arrays.asList(VALID_DAYS).indexOf(day);
        return index == 0 ? VALID_DAYS[VALID_DAYS.length - 1] : VALID_DAYS[index - 1];
    }

    private static EmisionDay nextDay(EmisionDay day) {
        if (day == EmisionDay.NO_DEFINIDO) {
            return EmisionDay.NO_DEFINIDO;
        }

        int index = java.util.Arrays.asList(VALID_DAYS).indexOf(day);
        return index == VALID_DAYS.length - 1 ? VALID_DAYS[0] : VALID_DAYS[index + 1];
    }

    public static CountryTime createCountryTime(
            Country country,
            EmisionDay emisionDay,
            LocalTime emisionTime
    ) {
        LocalTime newLocalTime = emisionTime;
        EmisionDay newEmisionDay = emisionDay;

        switch (country) {
            case JAPON:
                // No se cambia (ya está en hora de Japón)
                break;

            case PERU:
            case COLOMBIA:
            case ECUADOR:
            case PANAMA:
                // Japón (UTC+9) -> Países en UTC-5 => restar 14 horas
                newLocalTime = emisionTime.minusHours(14);
                break;

            case MEXICO:
            case NICARAGUA:
            case EL_SALVADOR:
                // Japón (UTC+9) -> Países en UTC-6 => restar 15 horas
                newLocalTime = emisionTime.minusHours(15);
                break;

            case CHILE:
            case VENEZUELA:
                // Japón (UTC+9) -> Países en UTC-4 => restar 13 horas
                newLocalTime = emisionTime.minusHours(13);
                break;

            case ARGENTINA:
            case URUGUAY:
            case PARAGUAY:
                // Japón (UTC+9) -> Países en UTC-3 => restar 12 horas
                newLocalTime = emisionTime.minusHours(12);
                break;

            default:
                break;
        }

        // Ajustar el día de emisión si corresponde cruzar medianoche
        if (newLocalTime.getHour() > emisionTime.getHour()) {
            // Cruzó al día anterior
            newEmisionDay = previousDay(emisionDay);
        } else if (newLocalTime.getHour() < emisionTime.getHour() &&
                Math.abs(emisionTime.until(newLocalTime, java.time.temporal.ChronoUnit.HOURS)) > 12) {
            // Cruzó hacia el día siguiente
            newEmisionDay = nextDay(emisionDay);
        }

        return new CountryTime(
                null,
                country,
                newLocalTime,
                newEmisionDay,
                null
        );
    }

}
