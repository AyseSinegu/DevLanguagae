package kodlama.io.devLanguage.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.devLanguage.entities.concretes.ProgrammingLanguages;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguages, Integer> {
	

}
