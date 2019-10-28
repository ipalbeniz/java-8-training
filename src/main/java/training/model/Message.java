package training.model;

import java.util.Optional;

public class Message {

    private final String content;

    public Message(final String content) {
        this.content = content;
    }

    public Optional<String> getContent() {
        return Optional.ofNullable(content);
    }
}