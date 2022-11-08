package kodlama.io.devLanguage.business.abstracts;

import java.util.List;

import kodlama.io.devLanguage.business.requests.CreatePLanguageRequest;
import kodlama.io.devLanguage.business.requests.DeletePLanguageRequest;
import kodlama.io.devLanguage.business.requests.UpdatePLanguageRequest;
import kodlama.io.devLanguage.business.responses.GetAllPLanguagesResponse;
import kodlama.io.devLanguage.business.responses.GetIdPLanguagesResponse;


public interface ProgrammingLanguageService {
	List<GetAllPLanguagesResponse> getAll();
	GetIdPLanguagesResponse getId(int id);
	void pLanguageAdd(CreatePLanguageRequest createPLanguageRequest)throws Exception;
    void pLanguageUpdate(UpdatePLanguageRequest updatePLanguageRequest)throws Exception;
    void pLanguageDelete(DeletePLanguageRequest deletePLanguageRequest);
	

    

}
