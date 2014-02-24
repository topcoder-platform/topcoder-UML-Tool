To compile and test, please note :

1. Package name is changed.
   see https://software.topcoder.com/forum/c_forum_message.jsp?f=25990064&r=26230540
   The package name should be:
	com.topcoder.xmi.writer.transformers.diagram
	com.topcoder.xmi.writer.transformers.diagram.elementtransformers
   

2. Diagram is extending GraphNode, not DiagramElement
	see	https://software.topcoder.com/forum/c_forum_message.jsp?f=25990064&r=26260829
==============
	Good point, the Diagram XMI extends the GraphNode XMI.
	Please make this inheritance change. [DiagramTransformer extending GraphNodeTransformer]
	I believe the only change needed is in the 'extends' line of the class declaration, the transform() method itself
	should take care of the rest automatically.   
============== by sql_lall (designer)
	

3. Design Change: Diagram2XMITransformer
	The ctors are changed to :
		ctor(map,map<string,string>)
		and
		ctor(map,map<string,string>,Transformer,boolean)
	see https://software.topcoder.com/forum/c_forum_message.jsp?f=25990064&r=26269703

4. semanticModel in GraphElement
 	please this thread : https://software.topcoder.com/forum/c_forum_message.jsp?f=25990064&r=26287819
 	in di-schema.xsd,
	The semanticModel of GraphElement is below:
	      <xsd:element name="semanticModel" type=
        	"org.omg.uml2.diagram_interchange:SimpleSemanticModelElement"/>
	But the cs provided by designer, shows that :
	tmp = document.createElement("UML:GraphElement.semanticModel");
	tmp.appendChild(caller.transform(element.getSemanticModel(), document)); // if not null
	ret.appendChild(tmp);
   I think the designer's answer is quite blurry and too late, and In XMI Reader Diagram interchange, it seems that they
   use a configuration arg to determine the type of the semanticModel in GraphElement when they read it. so here It may be
   something confused for us. furthermore, because of the closeness until the close of the submission phase, I suggest that  we let
   this problem solved in the final fixed phases.And I think it is the safest for me to follow the original design.
========
Thanks for your review job!
  
   



	
