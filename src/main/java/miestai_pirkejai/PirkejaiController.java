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
public class PirkejaiController {
	

	@Autowired
	private PirkejaiRepository pirkejai_repository;
	
	@Autowired
	private MiestaiRepository miestai_repository;
	
	@RequestMapping(path="/pirkejai", method={ RequestMethod.GET, RequestMethod.POST })
    public String pirkejai(@RequestParam(name="id", required=false, defaultValue="0") Integer id 
			, @RequestParam(name="vardas", required=false, defaultValue="") String vardas
			, @RequestParam(name="pavarde", required=false, defaultValue="") String pavarde
			, @RequestParam(name="miestas", required=false, defaultValue="") String miestas
			, @RequestParam(name="prideti", required=false, defaultValue="neprideti") String prideti
			, Model model) {
		
Pirkejai pirkejai = new Pirkejai();
		
		if ( prideti.equals( "prideti" ) ) {
			
			if (id > 0) {
				
				Optional <Pirkejai> found = pirkejai_repository.findById( id );
				
				if ( found.isPresent() ) {
					
					pirkejai = found.get();
					pirkejai.setId(id);
					
				}
				
			}
			
			pirkejai.setVardas(vardas);
			pirkejai.setPavarde(pavarde);
			pirkejai.setMiestas(miestas);
		
			  pirkejai_repository.save ( pirkejai );
			
		}
		
		model.addAttribute("pirkejai", pirkejai_repository.findAll());
		model.addAttribute("lst_miestai", miestai_repository.findAll());
		
		return "pirkejai";
	}
	
	@RequestMapping(path="/pirkejas")	
	public @ResponseBody Pirkejai parduotuveDuom(@RequestParam(name="id", required=true, defaultValue="0") Integer id ) throws IOException {

		Pirkejai pirkejai = new Pirkejai();
		
		if (id > 0) {
			
			Optional <Pirkejai> found = pirkejai_repository.findById( id );
		
			if ( found.isPresent() ) {
			
			   pirkejai = found.get();
			   pirkejai.setId ( id );
			   
			} 
		}		
		
		return pirkejai;

	}
	
	@RequestMapping(path="/salinti-vartotoja")
	public  String salintiVartotoja (@RequestParam(name="id_iraso_del", required=true, defaultValue="0") Integer id 
			, @RequestParam(name="salinti", required=false, defaultValue="0") String salinti
			) {
		
		Pirkejai pirkejai = new Pirkejai();
		
		if ( salinti.equals( "salinti" ) ) {
			System.out.println(id);
			Optional <Pirkejai> found = pirkejai_repository.findById( id );
			
				if ( found.isPresent() ) {
					
					   pirkejai = found.get();
					   pirkejai_repository.deleteById(id);

				}
			
		}
		return "redirect:pirkejai";
	}
	
	@RequestMapping(path="/redaguoti-vartotoja")
	public  String redaguotiVartotoja (@RequestParam(name="id_iraso", required=true, defaultValue="0") Integer id 
			, @RequestParam(name="redaguoti", required=false, defaultValue="0") String redaguoti
			) {
		
		Pirkejai pirkejai = new Pirkejai();
		
		if ( redaguoti.equals( "redaguoti" ) ) {
			System.out.println(id);
			Optional <Pirkejai> found = pirkejai_repository.findById( id );
			
				if ( found.isPresent() ) {
					
					   pirkejai = found.get();
					   pirkejai_repository.deleteById(id);

				}
			
		}
		return "redirect:pirkejai";
	}
	
}


