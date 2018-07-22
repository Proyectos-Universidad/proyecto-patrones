package ac.cr.ucenfotec.workflowengine.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value="/")
	public String get() {
		return "index.html";
	}
}
