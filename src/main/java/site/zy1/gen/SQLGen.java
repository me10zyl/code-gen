package site.zy1.gen;

import java.util.List;

import org.springframework.stereotype.Component;

import site.zy1.entity.Field;
import site.zy1.entity.Pojo;
import site.zy1.util.Tool;

@Component
public class SQLGen {

	public String generate(Pojo pojo) {
		List<Field> fields = pojo.getFields();
		StringBuilder stringBuilder = new StringBuilder(" WHERE 1 = 1\n");
		for (Field f : fields) {
			String variable = f.getVariable();
			stringBuilder.append(" #IF($" + variable + ")\n");
			String field = variable;
			if (f.isUnderlineName()) {
				field = Tool.underLineName(field).toUpperCase();
			}
			stringBuilder.append("    AND " + field + " = :" + variable + "\n");
			stringBuilder.append(" #END\n");
		}
		return stringBuilder.toString();
	}

}
