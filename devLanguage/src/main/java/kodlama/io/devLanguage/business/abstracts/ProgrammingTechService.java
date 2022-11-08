package kodlama.io.devLanguage.business.abstracts;

import java.util.List;

import kodlama.io.devLanguage.business.requests.CreatePTechnologyRequest;
import kodlama.io.devLanguage.business.requests.DeletePTechnologyRequest;
import kodlama.io.devLanguage.business.requests.UpdatePTechnologyRequest;
import kodlama.io.devLanguage.business.responses.GetAllPTechnologiesResponse;
import kodlama.io.devLanguage.business.responses.GetIdPTechnologiesResponse;

public interface ProgrammingTechService {
	
	List<GetAllPTechnologiesResponse> getAll();
    GetIdPTechnologiesResponse getId(int id);
    void pLanguageTechAdd(CreatePTechnologyRequest createPTechnologyRequest)throws Exception;
    void pLanguageTechUpdate(UpdatePTechnologyRequest updatePTechnologyRequest)throws Exception;
    void pLanguageTechDelete(DeletePTechnologyRequest deletePTechnologyRequest);

}
