package kodlama.io.devLanguage.business.concretes;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devLanguage.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devLanguage.business.requests.CreatePLanguageRequest;
import kodlama.io.devLanguage.business.requests.DeletePLanguageRequest;
import kodlama.io.devLanguage.business.requests.UpdatePLanguageRequest;
import kodlama.io.devLanguage.business.responses.GetAllPLanguagesResponse;
import kodlama.io.devLanguage.business.responses.GetIdPLanguagesResponse;
import kodlama.io.devLanguage.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devLanguage.entities.concretes.ProgrammingLanguages;


@Service
public class ProgrammingManager implements ProgrammingLanguageService{
	private ProgrammingLanguageRepository pLanguagesRepository;
	
     @Autowired
	public ProgrammingManager(ProgrammingLanguageRepository pLanguagesRepository) {
		
		this.pLanguagesRepository = pLanguagesRepository;
	}

	@Override
	public List<GetAllPLanguagesResponse> getAll() {
	    List<ProgrammingLanguages> rProggramingLanguages = pLanguagesRepository.findAll();
	    List<GetAllPLanguagesResponse> pLanguagesResponses = new ArrayList<>();
	     for (ProgrammingLanguages pLanguages : rProggramingLanguages) {
	         GetAllPLanguagesResponse rLanguages = new GetAllPLanguagesResponse();
	          rLanguages.setId(pLanguages.getId());
	          rLanguages.setName(pLanguages.getName());
	          pLanguagesResponses.add(rLanguages);            
	        }
		
		return pLanguagesResponses;
	}

	@Override
	public GetIdPLanguagesResponse getId(int id)  {
		
		ProgrammingLanguages pLanguages = pLanguagesRepository.getReferenceById(id);
        GetIdPLanguagesResponse gIdPLanguagesResponse = new GetIdPLanguagesResponse();
        gIdPLanguagesResponse.setId(pLanguages.getId());
        gIdPLanguagesResponse.setName(pLanguages.getName());
		
		return gIdPLanguagesResponse;
	}

	@Override
	public void pLanguageAdd(CreatePLanguageRequest createPLanguageRequest) throws Exception {
		
		ProgrammingLanguages pLanguage = new ProgrammingLanguages();
        pLanguage.setName(createPLanguageRequest.getName());
		if(pLangControl(createPLanguageRequest)) {
			throw new Exception("Boş ve Aynı Olamaz!");
		}
		this.pLanguagesRepository.pLanguageAdd(pLanguage);
		
	}
	public boolean pLangControl(CreatePLanguageRequest createPLanguageRequest) {
		List<ProgrammingLanguages> pLanguages=pLanguagesRepository.findAll();
		for (ProgrammingLanguages programmingLanguages : pLanguages) {
			if(programmingLanguages.getName().equalsIgnoreCase(createPLanguageRequest.getName()) 
			|| createPLanguageRequest.getName().equals("")){
				return true;
			}
			
		}
		return false;
		}

	@Override
	public void pLanguageUpdate(UpdatePLanguageRequest updatePLanguageRequest)throws Exception {
		ProgrammingLanguages pLanguages = new ProgrammingLanguages();
        pLanguages.setName(updatePLanguageRequest.getName());
        pLanguages.setId(updatePLanguageRequest.getId());
         if (pLangControl(updatePLanguageRequest)) {
            throw new Exception("Programlama Dili Aynı veya Boş Olamaz");
        }
		this.pLanguagesRepository.pLanguageUpdate(pLanguage);
		
	}
    private boolean pLangControl(UpdatePLanguageRequest updatePLanguageRequest) {
	     List<ProgrammingLanguages> pLanguages = pLanguagesRepository.findAll();
	      for (ProgrammingLanguages pLanguages1 : pLanguages) {
	       if (pLanguages1.getName().equalsIgnoreCase(updatePLanguageRequest.getName()) 
	         || updatePLanguageRequest.getName().equals("")) {
	            return true;
	          }
	       }
	       return false;
	    }

	@Override
	public void pLanguageDelete(DeletePLanguageRequest deletePLanguageRequest) {
		ProgrammingLanguages pLanguages = new ProgrammingLanguages();
	    pLanguages.setId(deletePLanguageRequest.getId());
	    pLanguagesRepository.pLanguageDelete(pLanguages);
				
	}
	
	

}
