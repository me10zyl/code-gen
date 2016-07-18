package site.zy1.gen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;

import site.zy1.entity.Field;
import site.zy1.entity.Pojo;

@Component
public class HTMLGen {
	@Autowired
	VelocityEngineFactoryBean velocityEngine;

	public String generateComboGrid(Pojo pojo) throws VelocityException, IOException {
		Map<String, Object> params = new HashMap<String,Object>();
		List<Field> fields = pojo.getFields();
		params.put("list", fields);
		params.put("width", 100 / (fields.size() + 1));
		String mergeTemplateIntoString = VelocityEngineUtils
				.mergeTemplateIntoString(velocityEngine.createVelocityEngine(), "combogrid.vm", "UTF-8", params);
		return mergeTemplateIntoString;
	}
	
	public String generateSearch(Pojo pojo) throws VelocityException, IOException {
		Map<String, Object> params = new HashMap<String,Object>();
		List<Field> fields = pojo.getFields();
		params.put("list", fields);
		String mergeTemplateIntoString = VelocityEngineUtils
				.mergeTemplateIntoString(velocityEngine.createVelocityEngine(), "search.vm", "UTF-8", params);
		return mergeTemplateIntoString;
	}
}
