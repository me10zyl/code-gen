package site.zy1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javaparser.ast.body.FieldDeclaration;

public class Field {
	private String variable;
	private String variableDeclarator;
	private boolean isUnderlineName;
	private String comment;
	private boolean isDate;
	private String type;
	@JsonIgnore
	private FieldDeclaration fieldDeclaration;

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isDate() {
		return isDate;
	}

	public void setDate(boolean isDate) {
		this.isDate = isDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public FieldDeclaration getFieldDeclaration() {
		return fieldDeclaration;
	}

	public void setFieldDeclaration(FieldDeclaration fieldDeclaration) {
		this.fieldDeclaration = fieldDeclaration;
	}

	public boolean isUnderlineName() {
		return isUnderlineName;
	}

	public void setUnderlineName(boolean isUnderlineName) {
		this.isUnderlineName = isUnderlineName;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public String getVariableDeclarator() {
		return variableDeclarator;
	}

	public void setVariableDeclarator(String variableDeclarator) {
		this.variableDeclarator = variableDeclarator;
	}

}
