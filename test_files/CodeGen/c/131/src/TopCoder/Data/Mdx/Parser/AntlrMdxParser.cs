/// This implementation of IMdxParser wraps an instance of ANTLR-generated MdxParser and provides an adapter for the generated class to be used as an IMdxParser. Although instances of this class are immutable, they wrap mutable instances, and therefore should not be used concurrently in multithreaded environments.
using ;
namespace TopCoder.Data.Mdx.Parser {
public class AntlrMdxParser{
/// This is an empty default constructor. It does nothing.
public AntlrMdxParser() {
}
/// Implementations of this method parse a single MDX query, and return it as an MdxElement.
/// 
/// If the input is null, ArgumentNullException is thrown. If the input is invalid in any other way (e.g. it is empty, has syntax errors, etc.), ParseException is thrown.
/// 
/// The implementation in this class calls the static method of the generated parser class, catches its exceptions, and wraps them in ParseException.
/// 
/// public MdxElement ParseSingle(string input) {
///     return MdxParser.ParseSingle(input);
/// }
/// <param name="input">
/// The input string for parsing
/// </param>
/// <param name="Return">
/// The root MdxElement representing the parsed statement.
/// </param>
<returns>
The root MdxElement representing the parsed statement.
</returns>
public MdxElement ParseSingle(string input) {
return null;
}
/// Implementations of this method parse a multiple MDX queries separated by semicolons, and return the result as a list of MdxElement objects.
/// 
/// If the input is null, ArgumentNullException is thrown. If the input is invalid in any other way (e.g. has syntax errors, etc.), ParseException is thrown.
/// 
/// The implementation in this class calls the static method of the generated parser class, catches its exceptions, and wraps them in ParseException.
/// 
/// public IList<MdxElement> Parse(string input) {
///     return MdxParser.Parse(input);
/// }
/// <param name="input">
/// The input string for parsing
/// </param>
/// <param name="Return">
/// The list of MdxElement objects representing queries in the order they are encountered in the input.
/// </param>
<returns>
The list of MdxElement objects representing queries in the order they are encountered in the input.
</returns>
public IList<MdxElement> Parse(string input) {
return null;
}
}
}

