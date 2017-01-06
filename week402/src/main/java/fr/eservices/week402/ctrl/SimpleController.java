package fr.eservices.week402.ctrl;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.eservices.week402.model.TimeObject;

@RestController
@RequestMapping("/simple")
public class SimpleController {
	
	@RequestMapping("/add")
	public String add(
			@RequestParam(value="a", required=true)int a,
			@RequestParam(value="b", required=true)int b) {
		return Integer.toString(a + b);
	}
	
	@RequestMapping("/time")
	public TimeObject getTime() {
		TimeObject t = new TimeObject();
		Date now = new Date();
		t.day = DateFormat.getDateInstance(DateFormat.SHORT).format(now);
		t.time = DateFormat.getTimeInstance(DateFormat.SHORT).format(now);
		t.locale = Locale.getDefault().toString();
		t.timestamp = (long) (now.getTime() / 1000);
		return t;
	}
}
