
package blood_bank;

import blood_bank.entity.BloodStock;
import blood_bank.repository.BloodStockRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BloodStockController {

    private final BloodStockRepository bloodStockRepository;

    public BloodStockController(BloodStockRepository bloodStockRepository) {
        this.bloodStockRepository = bloodStockRepository;
    }

    @GetMapping("/blood-stock")
    public String showBloodStock(Model model) {
        List<BloodStock> stock = bloodStockRepository.findAll();
        model.addAttribute("stock", stock);
        return "bloodStock";
    }

    @PostMapping("/blood-stock/update")
    public String updateBloodStock(
            @RequestParam String bloodGroup,
            @RequestParam int unitsAvailable,
            RedirectAttributes redirectAttributes) {

        if (unitsAvailable < 0) {
            redirectAttributes.addFlashAttribute(
                    "message", "Units cannot be negative.");
            return "redirect:/blood-stock";
        }

        BloodStock stock = bloodStockRepository.findById(bloodGroup)
                .orElse(null);

        if (stock == null) {
            redirectAttributes.addFlashAttribute(
                    "message", "Blood group not found.");
            return "redirect:/blood-stock";
        }

        stock.setUnitsAvailable(unitsAvailable);
        bloodStockRepository.save(stock);

        redirectAttributes.addFlashAttribute(
                "message", "Blood stock updated successfully!");

        return "redirect:/blood-stock";
    }
}
