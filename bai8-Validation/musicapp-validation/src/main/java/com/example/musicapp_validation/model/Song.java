package com.example.musicapp_validation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Không được phép để trống")
    @Size(max = 800, message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]*$", message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    String name;

    @NotBlank(message = "Không được phép để trống")
    @Size(max = 300, message = "Không vượt quá 300 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]*$", message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    String artist;

    @NotBlank(message = "Không được phép để trống")
    @Size(max = 1000, message = "Không vượt quá 1000 ký tự")
    @Pattern(regexp = "^[^@;.=+\\-]*$", message = "Ngoại trừ dấu phẩy “,” , các ký tự đặc biệt còn lại không được phép lưu vào DB")
    String genre;
}
