package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.exceptions.custom;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.enums.BranchType;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@SuppressWarnings({"unused", "LombokGetterMayBeUsed"})
public class NullBranchTypeException extends RuntimeException {
    @Getter
    private final BranchType type;
    public NullBranchTypeException(BranchType type) {
        super("Error adding branch on service layer.");
        this.type = type;
    }

    public NullBranchTypeException(String message, BranchType type) {
        super(message);
        this.type = type;
    }

    public NullBranchTypeException(Throwable cause, BranchType type) {
        super("Error adding branch on service layer.", cause);
        this.type = type;
    }

    public NullBranchTypeException(String message, Throwable cause, BranchType type) {
        super(message, cause);
        this.type = type;
    }
}
