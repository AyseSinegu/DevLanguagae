package kodlama.io.devLanguage.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPTechnologiesResponse {
	 private int id;
	 private String name;
	 private String programmingLanguage;

}
