package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto;

import io.swagger.annotations.ApiModel;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


@ApiModel("Enum containing all current members of the EU.")
@SuppressWarnings("unused")
public enum EUCountries {
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

    private static final Set<String> euCountryNames = Arrays.stream(EUCountries.values())
            .map(Enum::name)
            .map(String::toLowerCase)
            .collect(Collectors.toSet());


    public boolean isEuCountry(String country) {
        if (country == null) {
            return false; // Or throw an IllegalArgumentException
        }
        return euCountryNames.contains(country.toLowerCase());
    }
}