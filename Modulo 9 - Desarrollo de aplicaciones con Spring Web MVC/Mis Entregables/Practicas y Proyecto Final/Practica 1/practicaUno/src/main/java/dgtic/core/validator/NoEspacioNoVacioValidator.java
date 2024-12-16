package dgtic.core.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoEspacioNoVacioValidator implements ConstraintValidator<NoEspacioNoVacio, String> {

    @Override
    public void initialize(NoEspacioNoVacio constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.regionMatches(0, " ", 0, 1) || s.isEmpty()) {
            return false;
        }
        return true;
    }

}
