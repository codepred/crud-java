package pl.infinitetech.crudjava.client.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.infinitetech.crudjava.client.model.UserEntity;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class UserListResponse {

    List<UserEntity> data;
}
