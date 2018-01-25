package fr.dta.filrouge.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.dta.filrouge.exceptions.NotDeletableProductException;
import fr.dta.filrouge.exceptions.NotFoundException;

@RestController
@Transactional
@RequestMapping(value = "/api/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@CrossOrigin
	@RequestMapping(value = "search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> get(@RequestParam(value="id", required=false) Long id,
							@RequestParam(value="productName", required=false) String productName, 
							@RequestParam(value="type",required=false) Type type) {
		
		List<Product> product = service.getByCriteria(productName, id, type);
		
		if(product == null) {
			throw new NotFoundException();
		}else {
			return product;
		}
	}
	
	
	
	@CrossOrigin
	@RequestMapping(path = "create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Product create (@RequestBody Product product) {
		service.create(product);
		return product;
	}
	
	@CrossOrigin
	@RequestMapping(path = "multiple-create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public List<Product> multipleCreate (@RequestBody List<Product> productList) {
		service.multipleCreate(productList);
		return productList;
	}
	
	@CrossOrigin
	@RequestMapping(path = "update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public Product update ( @RequestBody Product product) {
		
		service.update(product);
		return product;
		
	}
	
	@CrossOrigin
	@RequestMapping(path = "delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete (@PathVariable Long id) {		
		if ( !service.delete(id) ) {
			throw new NotDeletableProductException();
		}
	}
	
	@CrossOrigin
	@RequestMapping(path = "activate", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public Product desactivateActivate (@RequestBody Product product) {	
		service.desactivateActivate(product);
		return product;		
	}
	
	@CrossOrigin
	@RequestMapping(path = "upload/{id}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	    public String handleFileUpload(@RequestBody Product product, @RequestParam(value ="file") MultipartFile file, @PathVariable Long id, 
	            RedirectAttributes redirectAttributes) {

	    	service.store(file, product);
	        redirectAttributes.addFlashAttribute("message",
	                "Le fichier  " + file.getOriginalFilename() + "a bien été envoyé !");

	        return "redirect:/";
	    }
}

