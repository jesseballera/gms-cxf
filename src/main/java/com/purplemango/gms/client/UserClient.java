package com.purplemango.gms.client;

import com.purplemango.gms.gen.GetUserRequest;
import com.purplemango.gms.gen.GetUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
@Slf4j
public class UserClient extends WebServiceGatewaySupport {

    public GetUserResponse getUser(String user) {
        GetUserRequest request = new GetUserRequest();
        request.setName(user);

        log.info("Requesting user info " + user);
        GetUserResponse response = (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        return response;
    }

}
