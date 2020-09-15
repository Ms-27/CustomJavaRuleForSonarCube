package org.sonar.samples.java.checks;
 
import com.google.common.collect.ImmutableList;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol.MethodSymbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.VariableTree;

import java.util.List;
 
  @Rule(
    key = "MyFirstCustomCheck",
    name = "Z rule",
    description = "si une méthode contient un ou plusieurs paramètres, alors tous les paramètres doivent commencer par la lettre z.",
    priority = Priority.MINOR,
    tags = {"code smell"})
  public class MyFirstCustomCheck extends IssuableSubscriptionVisitor {
 
  @Override
  public List<Kind> nodesToVisit() {
	  return ImmutableList.of(Kind.METHOD);
  }
  
  @Override
  public void visitNode(Tree tree) {
	  MethodTree method = (MethodTree) tree;
	  if (method.parameters().size() > 0) {
		  for (VariableTree parameter:method.parameters()) {
			  String name = parameter.simpleName().name();
			  System.out.println(name);
			  
			  if(!name.toUpperCase().startsWith("Z")) {
				  reportIssue(method.simpleName(), "Never do that!"); 
			  }
	      }
	  }
  }
 
}