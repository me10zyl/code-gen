package site.zy1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.javaparser.ASTHelper;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.AnnotationDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.ModifierSet;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class TestJavaParser {

	@Test
	public void test() throws ParseException, IOException {
		/*FileInputStream in = new FileInputStream(
				"E:\\JavaEE\\code-generator\\src\\test\\java\\site\\zy1\\data\\TCmcardModel.java");

		CompilationUnit cu;
		try {
			// parse the file
			cu = JavaParser.parse(in);
		} finally {
			in.close();
		}

		// prints the resulting compilation unit to default system output
		new MethodVisitor().visit(cu, null);*/
		// System.out.println(cu.toString());
	}

	private static class MethodVisitor extends VoidVisitorAdapter {

		@Override
		public void visit(FieldDeclaration n, Object arg) {
			// TODO Auto-generated method stub
			AnnotationExpr ano = new MarkerAnnotationExpr();
			ano.setName(new NameExpr("test"));
			ArrayList<AnnotationExpr> anos = new ArrayList<AnnotationExpr>();
			anos.add(ano);
			n.setAnnotations(anos);
			super.visit(n, arg);
			System.out.println(n);
		}
	}

}
