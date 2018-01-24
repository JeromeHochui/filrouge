
package fr.dta.filrouge.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.dta.filrouge.exceptions.NotFoundException;

@RestController
@Transactional
@RequestMapping(value = "/api/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@CrossOrigin
	@RequestMapping(value = {"{id}", "{name}", "{type}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> get(@PathVariable(required=false) Long id, @PathVariable(required=false) String name, @PathVariable(required=false) Type type) {
		List<Product> product = service.getByCriteria(name, id, type);
		
		if(product == null) {
			throw new NotFoundException();
		}else {
			return product;
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getOne(@PathVariable Long id) {
		Product product = service.getById(id);
		if (product == null) {
			throw new NotFoundException();
		}
		return product;
	}
	
	@CrossOrigin
	@RequestMapping(path = "create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Product create (@RequestBody Product product) {
		service.create(product);
		return product;
	}
	
	@CrossOrigin
	@RequestMapping(path = "update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Product update (@RequestBody Product product) {
		service.update(product);		
		return product;
	}
	
	@CrossOrigin
	@RequestMapping(path = "delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void delete (@RequestBody Product product) {	
		
		
		
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

