package com.koror.app.endpoint;

import com.koror.app.dto.Result;
import com.koror.app.dto.SessionDTO;
import com.koror.app.entity.Session;
import com.koror.app.service.SessionService;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class SessionEndpoint {

    @Inject
    private SessionService sessionService;

    @WebMethod
    public Result deleteSession(
            @WebParam(name = "session", partName = "session") @Nullable SessionDTO sessionDTO,
            @WebParam(name = "userSession", partName = "userSession") @Nullable SessionDTO userSessionDTO) {
        sessionService.validate(sessionDTO.getSignature());
        Session session = sessionService.getBySignature(sessionDTO.getSignature());
        sessionService.delete(session);
        final Result result = new Result();
        result.success();
        return result;
    }

    @WebMethod
    public Result deleteByUserSession(@WebParam(name = "session", partName = "session") @Nullable SessionDTO sessionDTO) {
        sessionService.validate(sessionDTO.getSignature());
        final Session session = sessionService.getBySignature(sessionDTO.getSignature());
        sessionService.deleteByUserId(session.getUser().getId());
        final Result result = new Result();
        result.success();
        return result;
    }

    @WebMethod
    public SessionDTO getByIdSession(
            @WebParam(name = "id", partName = "id") @Nullable String id,
            @WebParam(name = "session", partName = "session") @Nullable SessionDTO sessionDTO) {
        sessionService.validate(sessionDTO.getSignature());
        return new SessionDTO(sessionService.getById(id));
    }

    @WebMethod
    public List<SessionDTO> getListSession(@WebParam(name = "session", partName = "session") @Nullable SessionDTO sessionDTO) {
        sessionService.validate(sessionDTO.getSignature());
        final List<SessionDTO> dtoList = new ArrayList<>();
        for (Session sessionTemp : sessionService.getList()) {
            dtoList.add(new SessionDTO(sessionTemp));
        }
        return dtoList;
    }

    @WebMethod
    public Result updateSession(@WebParam(name = "session", partName = "session") @Nullable SessionDTO sessionDTO) {
        sessionService.validate(sessionDTO.getSignature());
        final Session session = sessionService.getBySignature(sessionDTO.getSignature());
        sessionService.update(session);
        final Result result = new Result();
        result.success();
        return result;
    }

}
