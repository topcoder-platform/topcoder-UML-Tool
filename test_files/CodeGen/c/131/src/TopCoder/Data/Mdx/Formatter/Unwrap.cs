/// This class implements a method for formatting an MdxElement by writing a prefix, then writing all subelements separated with a specific separator, and finally writing a suffix. For example, a set formatter can be defined as an Unwrap with the prefix of "{", the suffix of "}", and the separator of ", ".
/// 
/// Instances of this class are immutable, and therefore are safe for concurrent use in multithreaded environments.
using ;
namespace TopCoder.Data.Mdx.Formatter {
public class Unwrap{
/// The prefix - this string is added to the output before any subelements of the element.
/// 
/// This fiels is set to a non-null but possibly empty string value in the constructor, and does not change after that.
private const string prefix;
/// The separator - this string is added to the output between each pair of successive subelements.
/// 
/// This fiels is set to a non-null but possibly empty string value in the constructor, and does not change after that.
private const string separator;
/// The suffix - this string is added to the output after the last subelement of the element.
/// 
/// This fiels is set to a non-null but possibly empty string value in the constructor, and does not change after that.
private const string suffix;
/// This constructor sets the values of the fields into the object after checking them for validity.
/// 
/// public Unwrap(string prefix, string separator, string suffix) {
///     this.prefix = prefix;
///     this.separator = separator;
///     this.suffix = suffix;
/// }
/// <@throws>
/// ArgumentNullException if any argument is null.
/// </@throws>
/// <param name="suffix">
/// The suffix to put after the last element.
/// </param>
/// <param name="separator">
/// The separator to put between elements.
/// </param>
/// <param name="prefix">
/// The prefix string to put before first element.
/// </param>
public Unwrap(string prefix, string separator, string suffix) {
}
/// This method formats the element by printing the prefix, formatting subelements separated by the separator, and then adding the suffix after the last element.
/// 
/// The implementation is straightforward. isFirst flag is used to determine if this is the first subelement or not, for the purpose of placing a separator.
/// 
/// public void Format(TextWriter writer, MdxElement element) {
///     writer.Write(prefix);
///     bool isFirst = true;
///     foreach (MdxElement subelement in element.Subelements) {
///         if (!isFirst) {
///             writer.Write(separator);
///         } else {
///             isFirst = false;
///         }
///         MdxFortmatter.Format(writer, subelement);
///     }
///     writer.Write(suffix);
/// }
/// <param name="element">
/// The element to format.
/// </param>
/// <param name="writer">
/// The writer into which to format the objects.
/// </param>
/// <param name="Return">
/// void
/// </param>
public void Format(TextWrter writer, MdxElement element) {
}
}
}

