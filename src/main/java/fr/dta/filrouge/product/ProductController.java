package fr.dta.filrouge.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.x509;

import java.util.List;
import fr.dta.filrouge.exceptions.NotFoundException;

@RestController
@Transactional
@RequestMapping(value = "/api/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping(value = {"{id}", "{name}", "{type}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> get(@PathVariable(required=false) Long id, @PathVariable(required=false) String name, @PathVariable(required=false) Type type) {
		List<Product> product = service.getByCriteria(name, id, type);
		
		if(product == null) {
			throw new NotFoundException();
		}else {
			return product;
		}
	}

    @PostMapping("/upload/{id}")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @PathVariable Long id,
            RedirectAttributes redirectAttributes) {

    	service.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

}
