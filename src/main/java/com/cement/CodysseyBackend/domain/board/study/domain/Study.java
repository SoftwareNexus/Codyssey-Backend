package com.cement.CodysseyBackend.domain.board.study.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "study")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_id")
    private Long studyId;

    // *
    @Column(name = "writer_id")
    private Long writerId;

    // *
    @Column(name = "title")
    @Setter
    private String title;

    // *
    @Column(name = "content")
    @Setter
    private String content;

    @Column(name = "save_count")
    private Long saveCount;

    // *
    @Column(name = "category")
    @Setter
    private String category;

    @Column(name = "createAt")
    @CreationTimestamp
    private Timestamp createAt;

    @Column(name = "updateAt")
    @UpdateTimestamp
    private Timestamp updateAt;

    @Column(name = "isDeleted")
    @Setter
    private boolean isDeleted;

    @Column(name = "isClosed")
    @Setter
    private boolean isClosed;

    @Builder
    public Study(
            Long writerId, String title,
            String content, String category) {

        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.saveCount = 0L;
        this.category = category;
        this.isDeleted = false;
        this.isClosed = false;
    }

}
