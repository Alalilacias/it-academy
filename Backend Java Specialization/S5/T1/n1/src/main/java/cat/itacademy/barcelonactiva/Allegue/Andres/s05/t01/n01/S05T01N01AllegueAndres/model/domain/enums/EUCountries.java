package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.enums;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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


    public static BranchType getBranchType(String country) {
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }
        if (euCountryNames.contains(country.toLowerCase())) {
            return BranchType.EU;
        } else {
            return BranchType.NON_EU;
        }
    }
}