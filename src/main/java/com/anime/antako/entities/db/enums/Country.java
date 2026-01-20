package com.anime.antako.entities.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Country {
    JAPON("Japón", "https://flagcdn.com/32x24/jp.png"),
    PERU("Perú", "https://flagcdn.com/32x24/pe.png"),
    CHILE("Chile", "https://flagcdn.com/32x24/cl.png"),
    COLOMBIA("Colombia", "https://flagcdn.com/32x24/co.png"),
    ECUADOR("Ecuador", "https://flagcdn.com/32x24/ec.png"),
    PANAMA("Panamá", "https://flagcdn.com/32x24/pa.png"),
    ARGENTINA("Argentina", "https://flagcdn.com/32x24/ar.png"),
    MEXICO("México", "https://flagcdn.com/32x24/mx.png"),
    URUGUAY("Uruguay", "https://flagcdn.com/32x24/uy.png"),
    VENEZUELA("Venezuela", "https://flagcdn.com/32x24/ve.png"),
    PARAGUAY("Paraguay", "https://flagcdn.com/32x24/py.png"),
    EL_SALVADOR("El Salvador", "https://flagcdn.com/32x24/sv.png"),
    NICARAGUA("Nicaragua", "https://flagcdn.com/32x24/ni.png");

    private final String value;
    private final String flag;
}

