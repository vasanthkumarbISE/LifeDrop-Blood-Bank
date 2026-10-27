
package blood_bank.controller;

import blood_bank.entity.Donor;
import blood_bank.repository.DonorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
@CrossOrigin(origins = "*")
public class DonorController {

    private final DonorRepository donorRepository;

    public DonorController(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @PostMapping
    public Donor addDonor(@RequestBody Donor donor) {
        return donorRepository.save(donor);
    }

    @GetMapping
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    // Search donors by blood group and/or city
    @GetMapping("/search")
    public List<Donor> searchDonors(
            @RequestParam(required = false) String bloodGroup,
            @RequestParam(required = false) String city) {

        if (bloodGroup != null && !bloodGroup.isBlank()
                && city != null && !city.isBlank()) {

            return donorRepository.findByBloodGroupIgnoreCase(bloodGroup)
                    .stream()
                    .filter(donor -> donor.getCity() != null
                            && donor.getCity().equalsIgnoreCase(city))
                    .toList();
        }

        if (bloodGroup != null && !bloodGroup.isBlank()) {
            return donorRepository.findByBloodGroupIgnoreCase(bloodGroup);
        }

        if (city != null && !city.isBlank()) {
            return donorRepository.findByCityContainingIgnoreCase(city);
        }

        return donorRepository.findAll();
    }
}
