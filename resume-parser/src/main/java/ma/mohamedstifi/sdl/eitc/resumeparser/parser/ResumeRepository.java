package ma.mohamedstifi.sdl.eitc.resumeparser.parser;
import ma.mohamedstifi.sdl.eitc.resumeparser.parser.models.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
}