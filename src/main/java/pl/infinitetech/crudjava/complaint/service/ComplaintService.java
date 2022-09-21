package pl.infinitetech.crudjava.complaint.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.infinitetech.crudjava.client.model.UserEntity;
import pl.infinitetech.crudjava.complaint.dto.ComplaintBossRequest;
import pl.infinitetech.crudjava.complaint.dto.ComplaintRequest;
import pl.infinitetech.crudjava.complaint.model.ComplaintEntity;
import pl.infinitetech.crudjava.complaint.repository.ComplaintRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ComplaintEntity> getComplaintList(){
        return (List<ComplaintEntity>) complaintRepository.findAll();
    }
    public ComplaintEntity addComplaint(ComplaintRequest complaintRequest) {
        ComplaintEntity complaintEntity = this.modelMapper.map(complaintRequest, ComplaintEntity.class);
        return complaintRepository.save(complaintEntity);
    }

    public ComplaintEntity update(ComplaintBossRequest complaintRequest, Long id) {
        Optional<ComplaintEntity> complaintEntity = complaintRepository.findById(id);
        complaintEntity.get().setData(complaintRequest.getData());
        complaintEntity.get().setPrzyczyna_reklamacji(complaintRequest.getPrzyczyna_reklamacji());
        complaintEntity.get().setSposob_rozpatrzenia_reklamacji(complaintRequest.getSposob_rozpatrzenia_reklamacji());
        complaintEntity.get().setTermin_i_sposob_wysylki(complaintRequest.getTermin_i_sposob_wysylki());
        return complaintRepository.save(complaintEntity.get());


    }
}