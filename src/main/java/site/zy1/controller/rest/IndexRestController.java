package site.zy1.controller.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;

import site.zy1.entity.Field;
import site.zy1.entity.Pojo;
import site.zy1.gen.HTMLGen;
import site.zy1.gen.SQLGen;

@RestController
@RequestMapping(value = "/api")
public class IndexRestController {
	@Autowired
	private SQLGen sqlGen;
	@Autowired
	private HTMLGen htmlGen;

	@RequestMapping(value = "/format", method = RequestMethod.POST)
	public String format(@RequestBody Pojo java) throws ParseException {
		InputStream in = new ByteArrayInputStream(java.getSource().getBytes());
		CompilationUnit cu = JavaParser.parse(in);
		return cu.toString();
	}
	
	@RequestMapping(value = "/genSQL", method = RequestMethod.POST)
	public String genSQL(@RequestBody Pojo java){
		return sqlGen.generate(java);
	}
	
	@RequestMapping(value = "/genCOMBOGRID", method = RequestMethod.POST)
	public String genCOMBOGRID(@RequestBody Pojo java) throws VelocityException, IOException{
		return htmlGen.generateComboGrid(java);
	}
	
	@RequestMapping(value = "/genSEARCH", method = RequestMethod.POST)
	public String genSEARCH(@RequestBody Pojo java) throws VelocityException, IOException{
		return htmlGen.generateSearch(java);
	}

	@RequestMapping(value = "/fields", method = RequestMethod.POST)
	public List<String> fields(@RequestBody Pojo java) throws ParseException, IOException {
		InputStream in = new ByteArrayInputStream(java.getSource().getBytes());
		CompilationUnit cu = JavaParser.parse(in);
		List<TypeDeclaration> types = cu.getTypes();
		List<VariableDeclarator> variablesArray = new ArrayList<VariableDeclarator>();
		for (TypeDeclaration type : types) {
			List<BodyDeclaration> members = type.getMembers();
			for (BodyDeclaration member : members) {
				if (member instanceof FieldDeclaration) {
					FieldDeclaration field = (FieldDeclaration) member;
					List<VariableDeclarator> variables = field.getVariables();
					variablesArray.add(variables.get(0));
				}
			}
		}
		List<String> fields = new ArrayList<String>();
		for(VariableDeclarator var : variablesArray){
			fields.add(var.toStringWithoutComments());
		}
		return fields;
	}
}
