package edu.learning.api.composite;

public class ReviewSummaryDTO {

    private final int reviewId;
    private final String author;
    private final String subject;

    public ReviewSummaryDTO(int reviewId, String author, String subject) {
        this.reviewId = reviewId;
        this.author = author;
        this.subject = subject;
    }

    public int getReviewId() {
        return reviewId;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }
}
