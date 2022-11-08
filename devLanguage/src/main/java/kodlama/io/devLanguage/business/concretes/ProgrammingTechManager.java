package kodlama.io.devLanguage.business.concretes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlama.io.devLanguage.business.abstracts.ProgrammingTechService;
import kodlama.io.devLanguage.business.requests.CreatePTechnologyRequest;
import kodlama.io.devLanguage.business.requests.DeletePTechnologyRequest;
import kodlama.io.devLanguage.business.requests.UpdatePTechnologyRequest;
import kodlama.io.devLanguage.business.responses.GetAllPLanguagesResponse;
import kodlama.io.devLanguage.business.responses.GetAllPTechnologiesResponse;
import kodlama.io.devLanguage.business.responses.GetIdPTechnologiesResponse;
import kodlama.io.devLanguage.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devLanguage.dataAccess.abstracts.ProgrammingTechnologiesRepository;
import kodlama.io.devLanguage.entities.concretes.ProgrammingLanguages;
import kodlama.io.devLanguage.entities.concretes.ProgrammingTechnologies;


public class ProgrammingTechManager implements ProgrammingTechService{
	private ProgrammingTechnologiesRepository pTechnologiesRepository;
    private ProgrammingLanguageRepository pLanguagesRepository;
    
    @Autowired
    public ProgrammingTechManager(ProgrammingTechnologiesRepository pTechnologiesRepository, ProgrammingLanguageRepository pLanguagesRepository) {
        this.pTechnologiesRepository = pTechnologiesRepository;
        this.pLanguagesRepository = pLanguagesRepository;
    }
	
	
	
	@Override
	public List<GetAllPLanguagesResponse> getAll() {
	 List<ProgrammingTechnologies> rProggramingTechnologies = pTechnologiesRepository.findAll();
	      List<GetAllPTechnologiesResponse> pTechnologiesResponses = new ArrayList<>();
	       for (ProgrammingTechnologies pTechnology : rProggramingTechnologies) {
	         GetAllPTechnologiesResponse rTechnologies = new GetAllPTechnologiesResponse();
	          ProgrammingLanguages pLanguages = pLanguagesRepository.getReferenceById(pTechnology.getProgrammingLanguages().getId());
	          rTechnologies.setId(pTechnology.getId());
	          rTechnologies.setName(pTechnology.getName());
	          rTechnologies.setProgrammingLanguage(pLanguages.getName());
	          pTechnologiesResponses.add(rTechnologies);            
	        }
		
		return pLanguagesResponses;
	}

	@Override
	public GetIdPTechnologiesResponse getId(int id)  {
		
		ProgrammingTechnologies pTechnologies = pTechnologiesRepository.getReferenceById(id);
        GetIdPTechnologiesResponse getIdPTechnologiesResponse = new GetIdPTechnologiesResponse();
        getIdPTechnologiesResponse.setId(pTechnologies.getId());
        getIdPTechnologiesResponse.setName(pTechnologies.getName());

        return getIdPTechnologiesResponse;
	}

	@Override
	public void pLanguageTechAdd(CreatePTechnologyRequest createPTechnologyRequest) throws Exception {
		
	     ProgrammingTechnologies pTechnology = new ProgrammingTechnologies();
	     ProgrammingLanguages pLanguages = pLanguagesRepository.getReferenceById(createPTechnologyRequest.getProgrammingLanguageId());
	     pTechnology.setName(createPTechnologyRequest.getName());
	     pTechnology.setProgrammingLanguages(pLanguages);

	     if (pTechControl(createPTechnologyRequest)) {
	        throw new Exception("Programlama Dili Aynı veya Boş Olamaz");
	      }
	     this.pTechnologiesRepository.save(pTechnology);
	}
	
	
	public boolean pLangTechControl(CreatePTechnologyRequest createPTechnologyRequest) {
		List<ProgrammingTechnologies> pTechnologies = pTechnologiesRepository.findAll();
        for (ProgrammingTechnologies pTechnology : pTechnologies) {
            if (pTechnology.getName().equalsIgnoreCase(createPTechnologyRequest.getName()) 
            || createPTechnologyRequest.getName().equals("")) {
                return true;
            }
        }
		return false;
		}

	@Override
	public void pLanguageTechUpdate(UpdatePTechnologyRequest updatePTechnologyRequest)throws Exception {
		ProgrammingLanguages pLanguages = pLanguagesRepository.getReferenceById(updatePTechnologyRequest.getProgrammingLanguageId());

        ProgrammingTechnologies pTechnologies = new ProgrammingTechnologies();
        pTechnologies.setId(updatePTechnologyRequest.getId());
        pTechnologies.setName(updatePTechnologyRequest.getName());
        pTechnologies.setProgrammingLanguages(pLanguages);

         if (pLangControl(updatePTechnologyRequest)) {
            throw new Exception("Programlama Dili Aynı veya Boş Olamaz");
        }

        ProgrammingTechnologies upTechnologies = pTechnologiesRepository.getReferenceById(pTechnologies.getId());
		upTechnologies.setName(pTechnologies.getName());
		upTechnologies.setProgrammingLanguages(pLanguages);
		pTechnologiesRepository.save(upTechnologies);
		
	}
    private boolean pLangControl(UpdatePTechnologyRequest updatePTechnologyRequest) {
    	List<ProgrammingTechnologies> pTechnologies = pTechnologiesRepository.findAll();
        for (ProgrammingTechnologies pTechnology : pTechnologies) {
            if (pTechnology.getName().equalsIgnoreCase(updatePTechnologyRequest.getName()) 
            || updatePTechnologyRequest.getName().equals("")) {
                return true;
            }
        }
        return false;
	    }

	@Override
	public void pLanguageTechDelete(DeletePTechnologyRequest deletePTechnologyRequest) {
		 ProgrammingTechnologies pTechnologies = new ProgrammingTechnologies();
	     pTechnologies.setId(deletePTechnologyRequest.getId());
	     pTechnologiesRepository.delete(pTechnologies);
				
	}

}
