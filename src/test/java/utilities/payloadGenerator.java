package utilities;

import com.github.javafaker.Faker;
import userPayload.UserPojo;

import java.util.HashMap;
import java.util.Map;

public class payloadGenerator {

    private static String generatedUsername;

    public static Map<String,Object> getPayload(){
        Faker faker = new Faker();
        UserPojo userPojo = new UserPojo();

        userPojo.setFirstName(faker.name().firstName());
        userPojo.setLastName(faker.name().lastName());
        userPojo.setUsername(userPojo.getFirstName()+"."+userPojo.getLastName());
        userPojo.setEmail(faker.internet().emailAddress());
        userPojo.setPassword(faker.internet().password());
        userPojo.setPhone(faker.phoneNumber().cellPhone());
        userPojo.setUserStatus(0);

        Map<String, Object> userPayload = new HashMap<>();
        userPayload.put("id", userPojo.getId());
        userPayload.put("username", userPojo.getUsername());
        userPayload.put("firstName", userPojo.getFirstName());
        userPayload.put("lastName", userPojo.getLastName());
        userPayload.put("email", userPojo.getEmail());
        userPayload.put("password", userPojo.getPassword());
        userPayload.put("phone", userPojo.getPhone());
        userPayload.put("userStatus", userPojo.getUserStatus());

        return userPayload;
    }


}