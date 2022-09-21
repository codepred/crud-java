package pl.infinitetech.crudjava.complaint.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Validated
public class ComplaintBossRequest {
    @NotNull
    private Date data;
    @NotNull
    private String przyczyna_reklamacji;
    @NotNull
    private String sposob_rozpatrzenia_reklamacji;
    @NotNull
    private String termin_i_sposob_wysylki;


}
