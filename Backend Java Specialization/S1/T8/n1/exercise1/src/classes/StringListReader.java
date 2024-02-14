package S1.T8.n1.exercise1.src.classes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListReader {
    protected static List<String> randomNames = Arrays.asList(
            "Oliver Reynolds",
            "Maya Turner",
            "Sebastian Walsh",
            "Harper Mitchell",
            "Lucas Parker",
            "Stella Bennett",
            "Elijah Hayes",
            "Grace Thompson",
            "Levi Fisher",
            "Scarlett Carter",
            "Caleb Foster",
            "Ava Coleman",
            "Owen Jordan",
            "Zoe Harrison",
            "Liam Sullivan",
            "Penelope Taylor",
            "Mason Brooks",
            "Isabella Morgan",
            "Jackson Reed",
            "Sophia Patel",
            "Wyatt Nelson",
            "Mia Stewart",
            "Noah Ramirez",
            "Aria Kim",
            "Benjamin Chen",
            "Chloe Wright",
            "Ethan Richardson",
            "Emma Nguyen",
            "Samuel Rodriguez",
            "Amelia Turner",
            "Henry Collins",
            "Ella Williams",
            "Alexander Lee",
            "Lily Adams",
            "Isaac Cooper",
            "Abigail Martinez",
            "Jack Anderson",
            "Madison Foster",
            "Logan Price",
            "Grace Walker",
            "Caleb Powell",
            "Zoey Baker",
            "Daniel Phillips",
            "Olivia Davis",
            "Lucas Ward",
            "Ava Hughes",
            "Noah Rodriguez",
            "Isabella Turner",
            "William Rivera",
            "Sophia Patel"
    );
    protected static List<String> StringListReaderMethod(){
        return randomNames.stream()
                .filter(randomNames -> randomNames.toLowerCase().contains(("o")))
                .collect(Collectors.toList());
    }
}
