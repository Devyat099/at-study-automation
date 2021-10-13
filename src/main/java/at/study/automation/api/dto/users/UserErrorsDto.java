package at.study.automation.api.dto.users;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class UserErrorsDto {

    private List<String> errors;
}
