Here are some of the most commonly used validation annotations in Spring Boot, especially for ensuring data integrity and enforcing business rules in applications:

1. NotNull

Ensures that a field is not null. This is one of the most commonly used validations.

@NotNull(message = "Name cannot be null")
private String name;

2. Size

Used to check the length of a string, array, or collection. It is useful for fields like names, descriptions, etc.

@Size(min = 5, max = 100, message = "Username must be between 5 and 100 characters")
private String username;

3. Min and Max

These are used for numeric fields to ensure the value is within a specified range.

@Min(value = 18, message = "Age must be at least 18")
private int age;

@Max(value = 100, message = "Value cannot be more than 100")
private int score;

4. Email

Validates if a field contains a valid email address.

@Email(message = "Please provide a valid email address")
private String email;

5. Pattern

Validates if a string matches a specified regular expression pattern. This is useful for custom patterns like phone numbers, ZIP codes, etc.

@Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be valid")
private String phoneNumber;

6. NotBlank

Ensures that a field is not null and also not empty (i.e., it should contain at least one non-whitespace character).

@NotBlank(message = "Password cannot be blank")
private String password;

7. NotEmpty

Validates that a collection or array is not empty.

@NotEmpty(message = "List cannot be empty")
private List<String> items;

8. AssertTrue and AssertFalse

Used to validate boolean expressions. AssertTrue ensures that the expression evaluates to true, while AssertFalse ensures it evaluates to false.

@AssertTrue(message = "The account must be active")
private boolean active;

9. Future and Past

Validates that a date is in the future or past, respectively.

@Future(message = "Event date must be in the future")
private LocalDate eventDate;

@Past(message = "Birthdate must be in the past")
private LocalDate birthDate;

10. DecimalMin and DecimalMax

These annotations are used to validate BigDecimal or double values to ensure they are within a specific range.

@DecimalMin(value = "0.01", message = "Amount must be greater than zero")
private BigDecimal amount;

@DecimalMax(value = "10000.00", message = "Amount cannot exceed 10000")
private BigDecimal maxAmount;

11. Valid

This annotation is used to validate nested objects or collections of objects. It triggers the validation of fields in related objects.

public class User {
@Valid
private Address address;
}

public class Address {
@NotNull
private String street;
}

12. Custom Validations

Sometimes built-in annotations aren’t enough, and you need to create custom validation logic. You can do this by implementing the ConstraintValidator interface.

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomValidator.class)
public @interface ValidPassword {
String message() default "Invalid password";
Class<?>[] groups() default {};
Class<? extends Payload>[] payload() default {};
}

public class CustomValidator implements ConstraintValidator<ValidPassword, String> {
@Override
public boolean isValid(String value, ConstraintValidatorContext context) {
return value != null && value.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$");
}
}

When to Use These Validations
•	NotNull, Size, Min, Max: These are used for basic field-level validations such as ensuring a name isn’t empty, an age is within a range, or a string is of a specific length.
•	Email, Pattern: Used when the field format needs to match a specific structure, like email addresses or phone numbers.
•	AssertTrue, AssertFalse: Used for boolean conditions that must be met.
•	NotEmpty, NotBlank: Used for ensuring that a field is not empty or just whitespace.
•	Valid: For nested object validation.
•	Custom Validations: Used when you have business rules that are more complex than what the built-in annotations can handle.
