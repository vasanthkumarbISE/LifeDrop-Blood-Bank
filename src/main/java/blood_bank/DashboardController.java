
package blood_bank;

import blood_bank.entity.BloodStock;
import blood_bank.entity.Donor;
import blood_bank.repository.BloodStockRepository;
import blood_bank.repository.DonorRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    private final DonorRepository donorRepository;
    private final BloodStockRepository bloodStockRepository;

    public DashboardController(
            DonorRepository donorRepository,
            BloodStockRepository bloodStockRepository) {

        this.donorRepository = donorRepository;
        this.bloodStockRepository = bloodStockRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        // Get all registered donors from the database
        List<Donor> donors = donorRepository.findAll();

        // Get all blood-stock records
        List<BloodStock> stocks = bloodStockRepository.findAll();

        // Calculate the total available blood units
        int totalUnits = stocks.stream()
                .mapToInt(BloodStock::getUnitsAvailable)
                .sum();

        // Group donors by city and count the donors in each city
        Map<String, Long> cityCounts = donors.stream()
                .filter(donor -> donor.getCity() != null
                        && !donor.getCity().isBlank())
                .collect(Collectors.groupingBy(
                        donor -> donor.getCity().trim(),
                        TreeMap::new,
                        Collectors.counting()
                ));

        // Send dashboard data to the HTML page
        model.addAttribute("totalDonors", donors.size());
        model.addAttribute("totalUnits", totalUnits);
        model.addAttribute("totalBloodGroups", stocks.size());

        model.addAttribute("donors", donors);
        model.addAttribute("stocks", stocks);
        model.addAttribute("cityCounts", cityCounts);

        return "dashboard";
    }
}
