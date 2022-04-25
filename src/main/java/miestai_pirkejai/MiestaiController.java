package miestai_pirkejai;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MiestaiController {
	

	@Autowired
	private MiestaiRepository miestai_repository;
	
	@RequestMapping(path="/miestai", method={ RequestMethod.GET, RequestMethod.POST })
    public String pirkejai(@RequestParam(name="id", required=false, defaultValue="0") Integer id 
			, @RequestParam(name="vardas", required=false, defaultValue="") String vardas
			, @RequestParam(name="pavarde", required=false, defaultValue="") String pavarde
			, @RequestParam(name="miestas", required=false, defaultValue="") String miestas
			, @RequestParam(name="prideti", required=false, defaultValue="neprideti") String prideti
			, Model model) {
		
Miestai miestai = new Miestai();
		
		if ( prideti.equals( "prideti" ) ) {
			
			if (id > 0) {
				
				Optional <Miestai> found = miestai_repository.findById( id );
				
				if ( found.isPresent() ) {
					
					miestai = found.get();
					miestai.setId(id);
					
				}
				
			}
			
			miestai.setVardas(vardas);
			miestai.setPavarde(pavarde);
			miestai.setMiestas(miestas);
		
			  miestai_repository.save ( miestai );
			
		}
		
		model.addAttribute("miestai", miestai_repository.findAll());
		
		return "miestai";
	}
	
	@RequestMapping(path="/miestas")	
	public @ResponseBody Miestai miestaiDuom(@RequestParam(name="id", required=true, defaultValue="0") Integer id ) throws IOException {

		Miestai miestai = new Miestai();
		
		if (id > 0) {
			
			Optional <Miestai> found = miestai_repository.findById( id );
		
			if ( found.isPresent() ) {
			
			   miestai = found.get();
			   miestai.setId ( id );
			   
			} 
		}		
		
		return miestai;

	}
	
	@RequestMapping(path="/salinti-miesta")
	public  String salintiMiesta (@RequestParam(name="id_iraso", required=true, defaultValue="0") Integer id 
			, @RequestParam(name="salinti", required=false, defaultValue="0") String salinti
			) {
		
		Miestai miestai = new Miestai();
		
		if ( salinti.equals( "salinti" ) ) {
			System.out.println(id);
			Optional <Miestai> found = miestai_repository.findById( id );
			
				if ( found.isPresent() ) {
					
					   miestai = found.get();
					   miestai_repository.deleteById(id);

				}
			
		}
		return "redirect:miestai";
	}
	
}


