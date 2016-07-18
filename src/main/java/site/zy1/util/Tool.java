package site.zy1.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.ModifierSet;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.type.Type;

import site.zy1.entity.Field;
import site.zy1.entity.Pojo;

public class Tool {
	public static String underLineName(String camelName) {
		char[] charArray = camelName.toCharArray();
		StringBuilder underLineName = new StringBuilder();
		for (int i = 0; i < charArray.length; i++) {
			char singleChar = charArray[i];
			if (i - 1 >= 0 && charArray[i - 1] >= 'a' && charArray[i - 1] <= 'z' && singleChar >= 'A'
					&& singleChar <= 'Z') {
				underLineName.append(("_" + singleChar).toLowerCase());
			} else {
				underLineName.append(singleChar);
			}
		}
		return underLineName.toString();
	}

	public static void preprocessing(Pojo pojo) throws ParseException {
		String source = pojo.getSource();
		InputStream in = new ByteArrayInputStream(source.getBytes());
		CompilationUnit cu = JavaParser.parse(in);
		List<TypeDeclaration> types = cu.getTypes();
		List<FieldDeclaration> array = new ArrayList<FieldDeclaration>();
		for (TypeDeclaration type : types) {
			List<BodyDeclaration> members = type.getMembers();
			for (BodyDeclaration member : members) {
				if (member instanceof FieldDeclaration) {
					FieldDeclaration field = (FieldDeclaration) member;
					array.add(field);
				}
			}
		}
		List<Field> fields = pojo.getFields();
		for (Field f : fields) {
			String variableDeclarator = f.getVariableDeclarator();
			String[] splits = variableDeclarator.split("=");
			if (splits.length > 1) {
				f.setVariable(splits[0].trim());
			} else {
				f.setVariable(variableDeclarator.trim());
			}
			for(FieldDeclaration field : array){
				if(field.getVariables().get(0).toStringWithoutComments().startsWith(f.getVariable())){
					f.setFieldDeclaration(field);
					if(field.hasComment()){
						f.setComment(field.getComment().getContent().replace("*", "").trim());
					}
					Type type = field.getType();
					f.setType(type.toString());
					if("Date".equals(type.toString())){
						f.setDate(true);
					}
					break;
				}
			}
			
		}
	}

}
