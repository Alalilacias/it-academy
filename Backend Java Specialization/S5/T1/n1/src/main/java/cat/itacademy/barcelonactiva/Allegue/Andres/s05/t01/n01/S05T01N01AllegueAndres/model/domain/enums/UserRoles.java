package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.enums;

import lombok.Getter;

@Getter
@SuppressWarnings("unused")
public enum UserRoles {
    ADMIN(0),
    USER(1);

    private final int value;

    UserRoles(int value) {
        this.value = value;
    }

    public static UserRoles fromValue(int value) {
        for (UserRoles role : UserRoles.values()) {
            if (role.getValue() == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid UserRole value: " + value);
    }
}
