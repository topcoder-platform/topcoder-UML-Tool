/// This interface defines the contract for traversing MDX elements using push-style API (similar to SAX2 APIs for XML).
/// 
/// Implementations of this class are not required to be mutable or immutable ¨C the component is going to use them on a single thread, so it does not matter.
using ;
namespace TopCoder.Data.Mdx.Representation {
public interface IMdxElementVisitor{
/// The component calls this method to signal the beginning of  an element or one of its subelements.
/// 
/// Implementations are not expected to throw any exceptions from this method.
/// <param name="element">
/// The element being visited. The component ensures that this is never null.
/// </param>
/// <param name="Return">
/// void
/// </param>
public void StartElement(MdxElement element) {
}
/// The component calls this method to signal the ending of  an element or one of its subelements. The element passed to this method will always be the last unclosed element from the StartElement call.
/// 
/// Implementations are not expected to throw any exceptions from this method.
/// <param name="element">
/// The element being visited. The component ensures that this is never null.
/// </param>
/// <param name="Return">
/// void
/// </param>
public void EndElement(MdxElement element) {
}
}
}

