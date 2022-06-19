package gourav.example.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dimension {
    private int id;
    private String name;
    private int value;
}
