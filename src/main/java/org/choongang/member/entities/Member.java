package org.choongang.member.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.global.entities.BaseEntity;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    private Long seq;

    @Column(length = 60, nullable = false, unique = true)
    private String email;

    @Column(length = 65, nullable = false)
    private String password;

    @Column(length = 40, nullable = false)
    private String userName;

}
