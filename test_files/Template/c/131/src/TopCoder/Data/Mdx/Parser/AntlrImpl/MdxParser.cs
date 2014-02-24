/// This class is generated from Mdx.g file by following the steps outlined in the algorithms section of the component specification. See the algorithms section of the component specification for information about the EBNF grammar implemented by this class.
/// 
/// Instances of this class are mutable. Their use in multithreaded environments should be restricted to a single thread.
using ;
namespace TopCoder.Data.Mdx.Parser.AntlrImpl {
public class MdxParser{
/// This field holds the buider used to build MdxElement objects the parser returns. The parser calls Start/End/Fold methods of the builder, and the builder creates a tree of MdxElement objects in return.
/// 
/// This field is included in the @parser::members section of Mdx.g.
private const MdxElementBuilder builder = new MdxElementBuilder();
/// This method returns the singular result currently available in the builder.
/// 
/// This property is included in the @parser::members section of Mdx.g.
/// 
/// public MdxElement Result {
///     get {
///         return builder.Result;
///     }
/// }
public MdxElement Result;
/// This getter returns the results currently available in the builder.
/// 
/// This property is included in the @parser::members section of Mdx.g.
/// 
/// public IList<MdxElement> Results {
///     get {
///         return builder.Results;
///     }
/// }
public IList<MdxElement> Results;
/// This method makes a new instance of the parser, which uses a case-insensitive stream.
/// This method is included in the @parser::members section of Mdx.g.
/// 
/// This method will not return null.
/// 
/// private static MdxParser PrepareParser(string input) {
///     MdxLexer lexer = new MdxLexer(new CaseInsensitiveStream(input));
///     return new MdxParser(new CommonTokenStream(lexer));
/// }
/// <param name="input">
/// The input string (not validated).
/// </param>
/// <param name="Return">
/// The root MdxElement representing the parsed statement.
/// </param>
<returns>
The root MdxElement representing the parsed statement.
</returns>
private static MdxParser PrepareParser(string input) {
return null;
}
/// This method prepares the parser, calls its method to parse multiple queries, and returns the results to the caller.
/// 
/// This method is included in the @parser::members section of Mdx.g.
/// 
/// This method will never return null. It will return an empty list for an empty input.
/// 
/// public static IList<MdxElement> Parse(string input) {
///     MdxParser parser = PrepareParser(input);
///     parser.queries();
///     return parser.Results;
/// }
/// <param name="input">
/// The input to parse.
/// </param>
/// <param name="Return">
/// The list of MdxElement objects representing queries in the order they are encountered in the input.
/// </param>
<returns>
The list of MdxElement objects representing queries in the order they are encountered in the input.
</returns>
private static IList<MdxElement> Parse(string input) {
return null;
}
/// This method prepares the parser, and calls its method to parse a single query. When the parser returns, this method returns the parsing result to the caller.
/// 
/// This method is included in the @parser::members section of Mdx.g.
/// 
/// This method will never return null. It will throw ParseException for an empty input.
/// 
/// public static MdxElement ParseSingle(string input) {
///     MdxParser parser = PrepareParser(input);
///     parser.singleQuery();
///     return parser.Result;
/// }
/// <param name="input">
/// The input to parse
/// </param>
/// <param name="Return">
/// The result of parsing a single Mdx select statement.
/// </param>
<returns>
The result of parsing a single Mdx select statement.
</returns>
private static MdxElement ParseSingle(string input) {
return null;
}
}
}

