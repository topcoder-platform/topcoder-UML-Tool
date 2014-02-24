/// This class provides facilities for building MdxElement hierarchies using a stack. The class provides methods to start an element, to end an element, and to ¡°fold¡± the content of the current element into its parent before removing the element. This class is used from the generated MdxParser to build MDX structures from MdxElement object.
/// 
/// Instances of this class are mutable. Their use in multithreaded environments should be restricted to a single thread.
using ;
namespace TopCoder.Data.Mdx.Parser {
public class MdxElementBuilder{
/// This is the stack of MdxElements used during the building process. When an element is started, an MdxElement is pushed onto the stack. When an element ends, it is added to its parent element, or moved over to the list if it's the last element on the stack.
/// 
/// This collection will not contain null elements.
private const Stack<MdxElement> stack = new Stack<MdxElement>();
/// This list contains results of the processing. When EndElement or FoldElement is called on the last item on the stack, the item or its children are passed onto this list.
/// 
/// The Results properties get items from this list.
/// 
/// This collection will not contain null elements.
private const IList<MdxElement> results = new List<MdxElement>();
/// This method ensures that the list contains exactly one element, and returns it to the caller.
/// 
/// public MdxElement Result {
///     get {
///         if (results.Count != 1) {
///             throw new InvalidOperationException("Not a singleton result.");
///         }
///         return results[0];
///     }
/// }
public MdxElement Result;
/// This method gets the build results form the list. The list returned from this method may be empty, but may not be null.
/// 
/// public IList<MdxElement> Results {
///     get {
///         return new ReadOnlyCollection<MdxElement>(results);
///     }
/// }
public IList<MdxElement> Results;
/// This is an empty default constructor. It does nothing.
public MdxElementBuilder() {
}
/// This method creates a new MdxElement and pushes it onto the stack. This method does not perform additional argument checking, and rethrows the exception thrown by MdxElement's constructor.
/// 
/// public void StartElement(string type) {
///     stack.Push(new MdxElement(type));
/// }
/// <@throws>
/// ArgumentException if one is thrown by MdxElement's constructor,
/// </@throws>
/// <param name="type">
/// The type of the element. The value of this argument must be compatible with the type argument of MdxElement.
/// </param>
/// <param name="Return">
/// void
/// </param>
public void StartElement(string type) {
}
/// This method adds an attribute to the element at the top of the stack.
/// No separate argument checking is done - the arguments must be compatible with MdxAttribute's constructor.
/// 
/// public void AddAttribute(string name, AttributeType type, string val) {
///     if (stack.Count == 0) {
///         throw new InvalidOperationException("Need an element to add an attribute.");
///     }
///     stack.Peek().AddAttribute(name, type, val);
/// }
/// <@throws>
/// InvalidOperationException if the stack is empty.
/// </@throws>
/// <@throws>
/// ArgumentException if one is thrown by MdxAttribute's constructor,
/// </@throws>
/// <param name="val">
/// The value of the attribute being added.
/// </param>
/// <param name="type">
/// The type of the attribute being added.
/// </param>
/// <param name="name">
/// The name of the attribute being added.
/// </param>
/// <param name="Return">
/// void
/// </param>
public void AddAttribute(string name, AttributeType type, string val) {
}
/// This method pops the element off the stack, and adds it either to the element prior to it on the stack, or to the result list if this is the last element.
/// 
/// public void EndElement() {
///     MdxElement top = stack.Pop();
///     if (stack.Count == 0) {
///         results.Add(top);
///     } else {
///         stack.Peek().AddSubelement(top);
///     }
/// }
/// <param name="Return">
/// void
/// </param>
public void EndElement() {
}
/// This method removes the element from the chain, adding all its children to the element prior to it on the stack or to the result list.
/// 
/// public void FoldElement() {
///     MdxElement top = stack.Pop();
///     IList<MdxElement> subelements = new List<MdxElement>(top.Subelements);
///     foreach (MdxElement subelement in subelements) {
///         top.RemoveSubelement(subelement);
///     }
///     if (stack.Count == 0) {
///         foreach (MdxElement e in subelements) {
///             results.Add(e);
///         }
///     } else {
///         foreach (MdxElement e in subelements) {
///             stack.Peek().AddSubelement(e);
///         }
///     }
/// }
/// <param name="Return">
/// void
/// </param>
public void FoldElement() {
}
/// This method clears the builder, and prepares it to the next set of operations. This method is called after harvesting the results from the builder.
/// 
/// public void Clear() {
///     results.Clear();
///     stack.Clear();
/// }
/// <param name="Return">
/// void
/// </param>
public void Clear() {
}
}
}

