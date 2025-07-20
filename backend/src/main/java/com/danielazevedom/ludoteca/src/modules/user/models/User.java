// MODIFICATION BASED ON: Ludoteca-monorepo/backend/src/main/java/com/danielazevedom/ludoteca/src/modules/user/models/User.java
package com.danielazevedom.ludoteca.src.modules.user.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @NotBlank(message = "Google ID is mandatory")
    private String googleId;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Name is mandatory")
    private String name;
}
