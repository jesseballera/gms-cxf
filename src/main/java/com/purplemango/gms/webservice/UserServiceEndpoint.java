package com.purplemango.gms.webservice;

import com.purplemango.gms.gen.GetUserRequest;
import com.purplemango.gms.gen.GetUserResponse;
import com.purplemango.gms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.Collection;

@Endpoint
public class UserServiceEndpoint {

    private static final String NAMESPACE_URI = "http://www.purplemango.com/gms/gen";
    private UserRepository userRepository;

    @Autowired
    public UserServiceEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public Collection<GetUserResponse> getUsers() {
//        Collection<GetUserResponse> response = new ArrayList<>();
//        response.
//        return response;
//    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserByUsername(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userRepository.getUsersByUsername(request.getName()));
        return response;
    }
}
