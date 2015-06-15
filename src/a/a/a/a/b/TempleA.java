package a.a.a.a.b;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TempleA {
	public static void one(){
		print_func("pop_width");
		print_func("pop_height");
		print_func("pop_x");
		print_func("pop_Y");
	}
	
	public static String FirstLetterUpperCase(String seg) {		
		return seg.toUpperCase().substring(0, 1) + seg.substring(1);
	}

	public static void print_func(String seg) {
		Configuration cfg = new Configuration();
		try {
			Template template = cfg.getTemplate("src/template/one.ftl");
			Map<String, String> data = new HashMap<String, String>();

			data.put("SEG_STATIC", seg.toUpperCase());
			String[] segs = seg.split("_");
			seg = "";
			for (int i = 0; i < segs.length; i++) {
				seg += FirstLetterUpperCase(segs[i]);
			}
			data.put("SEG", seg);

			Writer out = new OutputStreamWriter(System.out);
			template.process(data, out);
			out.flush();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
