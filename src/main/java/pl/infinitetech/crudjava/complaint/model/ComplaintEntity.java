package pl.infinitetech.crudjava.complaint.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Complaint")
@NoArgsConstructor
@Getter
@Setter
public class ComplaintEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="data_wplywu", nullable = false)
    private Date data_wplywu;

    @Column(name="nadawca")
    private String nadawca;

    @Column(name="data_i_nr_dokumentu")
    private String data_i_nr_dokumentu;

    // IDNETYIKFKACJA WODOMIERZA
    @Column(name="ilosc")
    private int ilosc;

    @Column(name="typ")
    private String typ;

    @Column(name="nr_serii")
    private int nr_serii;

    @Column(name="nr_modulu_radiowego")
    private int nr_modulu_radiowego;

    @Column(name="stan_licznika")
    private int stan_licznika;

    @Column(name="opis_reklamacji")
    private String opis_reklamacji;

    @Column(name="dokad_skierowano_dzial")
    private String dokad_skierowano_dzial;

    @Column(name="data")
    private Date data;

    @Column(name="przyczyna_reklamacji")
    private String przyczyna_reklamacji;

    @Column(name="sposob_rozpatrzenia_reklamacji")
    private String sposob_rozpatrzenia_reklamacji;

    @Column(name="termin_i_sposob_wysylki")
    private String termin_i_sposob_wysylki;

}
