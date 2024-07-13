package study.data_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class BaseEntity extends BaseTimeEntity {

    // 누가 생성했는지 ex ) 세션 ID 가져와서 유저 조회 후 저장
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    // 누가 수정했는지  ex ) 세션 ID 가져와서 유저 조회 후 저장
    @LastModifiedBy
    private String lastModifiedBy;
}
