package kodlama.io.devLanguage.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.devLanguage.entities.concretes.ProgrammingTechnologies;

public interface ProgrammingTechnologiesRepository extends JpaRepository<ProgrammingTechnologies, Integer>{

}
