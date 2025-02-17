package ma.mohamedstifi.sdl.eitc.resumeparser.parser.models;

import jakarta.persistence.*;

@Entity
public class Resume {
    public enum State {
        WAITING,
        OCR_QUEUED, OCR_IN_PROGRESS, OCR_DONE, OCR_FAILED,
        PARSE_IN_PROGRESS, PARSE_DONE, PARSE_FAILED
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String objectPath;

    private String ocrResult;

    private String parseResult;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private State state;

    public Long getId() {
        return id;
    }

    public String getObjectPath() {
        return objectPath;
    }

    public String getOcrResult() {
        return ocrResult;
    }

    public String getParseResult() {
        return parseResult;
    }

    public State getState() {
        return state;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setObjectPath(String objectPath) {
        this.objectPath = objectPath;
    }

    public void setOcrResult(String ocrResult) {
        this.ocrResult = ocrResult;
    }

    public void setParseResult(String parseResult) {
        this.parseResult = parseResult;
    }

    public void setState(State state) {
        this.state = state;
    }
}