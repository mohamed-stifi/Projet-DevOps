package ma.mohamedstifi.sdl.eitc.resumeparser.parser;

import ma.mohamedstifi.sdl.eitc.resumeparser.parser.exception.NotFoundException;
import ma.mohamedstifi.sdl.eitc.resumeparser.parser.models.Resume;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;
import static ma.mohamedstifi.sdl.eitc.resumeparser.parser.common.Constants.OCR_REQUESTS_TOPIC;

@Service
public class ParserService {
    private final ResumeRepository resumeRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ParserService(ResumeRepository resumeRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.resumeRepository = resumeRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void parseResume(Long id) {
        var resume = resumeRepository.findById(id).orElseThrow(NotFoundException::new);

        kafkaTemplate.send(OCR_REQUESTS_TOPIC, resume.getId().toString());

        resume.setState(Resume.State.OCR_QUEUED);
        resumeRepository.save(resume);
    }
}