package pl.infinitetech.crudjava.complaint.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.infinitetech.crudjava.client.model.UserEntity;
import pl.infinitetech.crudjava.complaint.model.ComplaintEntity;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ComplaintListResponse {
    List<ComplaintEntity> data;
}
