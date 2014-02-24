/// This class provides an implementation of the IMdxFormatter interface. The implementation is based on an IDictionary of formatters for individual element types. The class looks up the formatter delegate, and uses it to format the element. The delegate may call the formatter back to format its subelements in a chain of recursive calls.
/// 
/// Instances of this class are immutable and therefore are safe for concurrent use in multithreaded environments.
using ;
namespace TopCoder.Data.Mdx.Formatter {
public class MdxFortmatter{
/// This is an IDictionary mapping element types to the formatting delegate for the type. This field is set to a new Dictionary in the static initializer, and does not change after that. The dictionary will not contain null keys or null values.
/// 
/// Static constructor loads the values into this dictionary. See UML documentation of the static constructor for more details on what goes into this Dictionary.
private static const IDictionary<string,FormatDelegate> formatters = new Dictionary<string,FormatDelegate>();
/// This is an empty default constructor. It does nothing.
public MdxFortmatter() {
}
/// This static constructor loads formatters for individual element types into the formatters IDictionary.
/// 
/// This is how the method will look (the actual implementation will create formatters for all elements reported by the parser, some of which are not included in the skeletal implementation below):
/// 
/// static MdxFortmatter() {
///     FormatDelegate simpleUnwrap = new Unwrap("", "", "").Format;
///     formatters["prefix"] = delegate(TextWriter writer, MdxElement element) {
///         writer.Write(element.Attribute["operator"].Value);
///         writer.Write("");
///         foreach (MdxElement subelement in element.Subelements) {
///             MdxFortmatter.Format(writer, subelement);
///         }
///     };
///     formatters["infix"] = delegate(TextWriter writer, MdxElement element) {
///         writer.Write("(");
///         int n = 0;
///         int last = element.SubelementCount-1;
///         foreach (MdxElement subelement in element.Subelements) {
///             MdxFortmatter.Format(writer, subelement);
///             if (n != last) {
///                 writer.Write("");
///                 writer.Write(element.Attribute["operator" + (n++)].Value);
///                 writer.Write("");
///             }
///         }
///         writer.Write(")");
///     };
///     formatters["query"] = simpleUnwrap;
///     formatters["with"] = new Unwrap("WITH ", "", "\n").Format;
///     formatters["select"] = new Unwrap("SELECT ", ",\n", "\n").Format;
///     formatters["axisClause"] = delegate(TextWriter writer, MdxElement element) {
///         MdxAttribute nonEmpty = element.Attribute["nonEmpty"];
///         if (nonEmpty != null && nonEmpty.Value.Equals("true")) {
///             writer.Write("NON EMPTY ");
///         }
///         MdxFortmatter.Format(writer, element.Subelement["expression"]);
///         MdxElement prop = element.Subelement["dimensionProperties"];
/// 
///         MdxFortmatter.Format(writer, element.Subelement["axis"]);
///     };
///     formatters["expression"] = simpleUnwrap;
///     formatters["tuple"] = new Unwrap("(", ", ", ")").Format;
///     formatters["set"] = new Unwrap("{", ", ", "}").Format;
///     formatters["call"] = delegate(TextWriter writer, MdxElement element) {
///         writer.Write(element.Attribute["name"].Value);
///         writer.Write("(");
///         bool isFirst = true;
///         foreach (MdxElement arg in element.Subelements) {
///             if (!isFirst) {
///                 writer.Write(", ");
///             } else {
///                 isFirst = false;
///             }
///             MdxFortmatter.Format(writer, arg);
///         }
///         writer.Write(")");
///     };
///     formatters["reference"] = delegate(TextWriter writer, MdxElement element) {
///         writer.Write(element.Attribute["name"].Value);
///     };
///     formatters["dotExpression"] = new Unwrap("", ".", "").Format;
///     formatters["axis"] = delegate(TextWriter writer, MdxElement element) {
///         writer.Write(" ON ");
///         MdxAttribute name = element.Attribute["name"];
///         if (name != null) {
///             writer.Write(name.Value);
///         } else {
///             writer.Write("AXIS(");
///             writer.Write(element.Attribute["number"].Value);
///             writer.Write(")");
///         }
///     };
///     formatters["from"] = delegate(TextWriter writer, MdxElement element) {
///         writer.Write("FROM ");
///         writer.WriteLine(element.Attribute["cubeName"].Value);
/// 
///     };
///     formatters["dimensionProperty"] = delegate(TextWriter writer, MdxElement element) {
///         writer.Write(element.Attribute["name"].Value);
///     };
///     formatters["dimensionProperties"] = new Unwrap("", ", ", "").Format;
///     formatters["where"] = new Unwrap("where ", "", "").Format;
/// }
public static MdxFortmatter() {
}
/// This method looks up the formatter by element's type, and calls it to perform the actual formatting.
/// 
/// The method throws ArgumentNullException if any argument is null. It throws an ArgumentException if the element is of an unknown type.
/// 
/// internal static void Format(TextWriter writer, MdxElement element) {
///     if (formatters.ContainsKey(element.Type)) {
///         formatters[element.Type](writer, element);
///     } else {
///         throw new ArgumentException("Element of unknown type: " + element.Type);
///     }
/// }
/// <@throws>
/// ArgumentException if the element is of an unknown type.
/// </@throws>
/// <param name="element">
/// The element to format.
/// </param>
/// <param name="writer">
/// The writer into which to format the objects.
/// </param>
/// <param name="Return">
/// ArgumentNullException if the element or the writer is null.
/// </param>
static void Format(TextWriter writer, MdxElement element) {
}
/// This method iterates over the values in the enumerable, passing each one of them in turn to the static Format method.
/// 
/// public void Format(TextWriter writer, IEnumerable<MdxElement> elements) {
///     foreach (MdxElement element in elements) {
///         Format(writer, element);
///     }
/// }
/// <@throws>
/// ArgumentNullException if any of the arguments is null.
/// </@throws>
/// <@throws>
/// ArgumentException if the array contains nulls.
/// </@throws>
/// <param name="writer">
/// The writer into which to format the objects.
/// </param>
/// <param name="Return">
/// void
/// </param>
/// <param name="elements">
/// The elements to be formatted.
/// </param>
public void Format(TextWriter writer, IEnumerable<MdxElement> elements) {
}
/// This version of the method passes the call onto the IEnumerable version of the method:
/// 
/// public void Format(TextWriter writer, params MdxElement[] elements) {
///     Format(writer, (IEnumerable<MdxElement>)elements);
/// }
/// <@throws>
/// ArgumentNullException if any of the arguments is null.
/// </@throws>
/// <@throws>
/// ArgumentException if the array contains nulls.
/// </@throws>
/// <param name="writer">
/// The writer into which to format the objects.
/// </param>
/// <param name="Return">
/// void
/// </param>
/// <param name="elements">
/// The elements to be formatted.
/// </param>
public void Format(TextWriter writer, MdxElement[] elements) {
}
}
}

