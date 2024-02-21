package com.redone.aftas.dto.authDto;

import com.redone.aftas.models.enums.IdentityDocumentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "First name shouldn't be blank")
    private String firstName;

    @NotBlank(message = "last name shouldn't be blank")
    private String lastName;

    @NotNull(message = "nationality cannot be null.")
    @NotBlank(message = "nationality cannot be blank.")
    private String nationality;

    @NotNull(message = "identity number cannot be null.")
    @NotBlank(message = "identity number cannot be blank.")
    private String identityNumber;

    @NotNull(message = "identity document cannot be null")
    private IdentityDocumentType identityDocumentType;

    @NotBlank(message = "Password shouldn't be blank")
    private String password;

    @NotBlank(message = "Email Cannot Be blank")
    private String email;
}
