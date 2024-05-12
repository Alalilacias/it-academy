package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public enum EuCountries {
    AUSTRIA,
    BELGIUM,
    BULGARIA,
    CROATIA,
    CYPRUS,
    CZECH_REPUBLIC,
    DENMARK,
    ESTONIA,
    FINLAND,
    FRANCE,
    GERMANY,
    GREECE,
    HUNGARY,
    IRELAND,
    ITALY,
    LATVIA,
    LITHUANIA,
    LUXEMBOURG,
    MALTA,
    NETHERLANDS,
    POLAND,
    PORTUGAL,
    ROMANIA,
    SLOVAKIA,
    SLOVENIA,
    SPAIN,
    SWEDEN;

    private static final Set<String> euCountryNames = Arrays.stream(EuCountries.values())
            .map(Enum::name)
            .map(String::toLowerCase)
            .collect(Collectors.toSet());


    public static String getFlowerType(String country) {
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }
        if (euCountryNames.contains(country.toLowerCase())) {
            return "EU";
        } else {
            return "NON_EU";
        }
    }
}
