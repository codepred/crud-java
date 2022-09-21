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
public class ComplaintRequest {

    @NotNull
    private Date data_wplywu;
    @NotNull
    private String nadawca;
    @NotNull
    private String data_i_nr_dokumentu;
    @NotNull
    private int ilosc;
    @NotNull
    private String typ;
    @NotNull
    private int nr_serii;
    @NotNull
    private int nr_modulu_radiowego;
    @NotNull
    private int stan_licznika;
    @NotNull
    private String opis_reklamacji;
    @NotNull
    private String dokad_skierowano_dzial;





}
