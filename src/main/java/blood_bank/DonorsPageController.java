
package blood_bank;

import blood_bank.entity.Donor;
import blood_bank.repository.DonorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DonorsPageController {

    private final DonorRepository donorRepository;

    public DonorsPageController(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @GetMapping("/donors")
    public String donorsPage(
            @RequestParam(required = false) String bloodGroup,
            @RequestParam(required = false) String city,
            Model model) {

        List<Donor> donors = donorRepository.findAll();

        // Filter by blood group if entered
        if (bloodGroup != null && !bloodGroup.isBlank()) {
            donors = donors.stream()
                    .filter(d -> d.getBloodGroup() != null
                            && d.getBloodGroup()
                                .equalsIgnoreCase(bloodGroup.trim()))
                    .collect(Collectors.toList());
        }

        // Filter by city if entered
        if (city != null && !city.isBlank()) {
            donors = donors.stream()
                    .filter(d -> d.getCity() != null
                            && d.getCity().toLowerCase()
                                .contains(city.trim().toLowerCase()))
                    .collect(Collectors.toList());
        }

        model.addAttribute("donors", donors);
        model.addAttribute("selectedBloodGroup",
                bloodGroup == null ? "" : bloodGroup);
        model.addAttribute("selectedCity",
                city == null ? "" : city);

        return "donorsPage";
    }
}
