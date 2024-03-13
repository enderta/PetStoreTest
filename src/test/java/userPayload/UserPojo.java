package userPayload;

import lombok.Data;

@Data
public class UserPojo {
    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int userStatus = 0;
}
