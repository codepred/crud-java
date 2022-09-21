package pl.infinitetech.crudjava.complaint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.infinitetech.crudjava.complaint.dto.ComplaintBossRequest;
import pl.infinitetech.crudjava.complaint.dto.ComplaintListResponse;
import pl.infinitetech.crudjava.complaint.dto.ComplaintRequest;
import pl.infinitetech.crudjava.complaint.model.ComplaintEntity;
import pl.infinitetech.crudjava.complaint.service.ComplaintService;

@RestController
public class ComplaintController {
    @Autowired
    ComplaintService complaintService;

    @GetMapping("/complaint")
    public ResponseEntity<Object> getUsers(){
        ComplaintListResponse complaintListResponse = new ComplaintListResponse();
        complaintListResponse.setData(complaintService.getComplaintList());
        return ResponseEntity.status(200).body(complaintListResponse);
    }

    @PostMapping("/complaint")
    public ResponseEntity<Object> addComplaint(@RequestBody ComplaintRequest complaint) {
        ComplaintEntity complaintEntity = complaintService.addComplaint(complaint);
        return ResponseEntity.status(200).body(complaintEntity);
}

    @PutMapping("/complaintboss/{id}")
    public ResponseEntity<Object> editComplaint(@Validated @RequestBody ComplaintBossRequest complaint, @PathVariable Long id) {
        ComplaintEntity complaintEntity = complaintService.update(complaint, id);
        return ResponseEntity.status(200).body(complaintEntity);
    }
}
