/// This class provides case-insensitive lookup capabilities to MdxLexer. This is ANTLR-recommended approach to implementing case-insensitive keywords in grammars.
/// This class overrides the LA(i) method used for lookup of the next character. The overriding version converts characters to lower case before returning them to the lookup service of the lexer. Since all keyword tokens are defined as lower-case strings in the grammar, the lookahead is going to succeed regardless of the case of characters in the input.
/// 
/// Instances of this class are mutable, and should not be used concurrently. This component does not share instances of this class.
using ;
namespace TopCoder.Data.Mdx.Parser.AntlrImpl {
class CaseInsensitiveStream : ANTLRStringStream{
/// This method passes the source to its base without performing any additional checking.
/// 
/// public CaseInsensitiveStream(string source) : base(source) {
/// }
/// <param name="source">
/// The source data of this stream.
/// </param>
public CaseInsensitiveStream(string source) {
}
/// This override checks the value returned by the superclass for EOF, which must be returned unchanged. All other values are converted to lower case.
/// 
/// public override int LA(int i) {
///     int res = base.LA(i);
///     if (res != (int)CharStreamConstants.EOF) {
///         return Char.ToLowerInvariant((char)res);
///     } else {
///         return res;
///     }
/// }
/// <param name="i">
/// The index of the look-ahead. This field is not validated in this method.
/// </param>
/// <param name="Return">
/// The next character in the buffer converted to lower case, or EOF.
/// </param>
<returns>
The next character in the buffer converted to lower case, or EOF.
</returns>
public int LA(int i) {
return 0;
}
}
}

