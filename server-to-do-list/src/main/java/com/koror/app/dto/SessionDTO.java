package com.koror.app.dto;

import com.koror.app.entity.Session;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SessionDTO {

    private String signature;

    private String ip;

    private String userId;

    public SessionDTO(Session session) {
        signature = session.getSignature();
        ip = session.getIp();
        userId = session.getUser().getId();
    }

}
