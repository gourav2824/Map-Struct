package gourav.example.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dimension {
    private int id;
    private String name;
    private int value;
}
