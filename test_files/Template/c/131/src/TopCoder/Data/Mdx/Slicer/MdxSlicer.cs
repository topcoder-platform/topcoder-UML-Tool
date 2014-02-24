/// This class defines the main functionality of the component ¨C the slicing of an MDX query. The class is for use by end-users of the component.
/// 
/// Users start by providing an MDX expression as the query. Then they define one or more dimensions, and add one or more member to each one of them. Then they get the result by accessing the SlicedQuery getter.
/// Instances of this class are mutable. They should not be used concurrently from multiple threads. However, all methods of the class are re-entrant, so the users can use this class in multithreaded environments as long as they do not share instances across the threads.
using TopCoder.Data.Mdx.Representation;
using ;
namespace TopCoder.Data.Mdx.Slicer {
public class MdxSlicer{
/// This is the source string representing the MDX query being sliced. It is accessed through its corresponding getter and setter. This field may be set to any value - a null, an empty string, a blank string, etc. Trying to get SliverQuert when the source is in an invalid state results in an error.
private string source;
/// This is the parser to parse the source queries. This field is set to a non-null value in the constructor, and does not change after that.
/// 
/// SlicerQuery getter uses this field to parse the input query.
private const IMdxParser parser;
/// This is the formatter to format finished slicer queries. This field is set to a non-null value in the constructor, and does not change after that.
/// 
/// SlicerQuery getter uses this field to format the resulting slicer query.
private const IMdxFormatter formatter;
/// This dictionary maps normalized dimension names to the numbers of their default axes. Users may choose not to set the default axis for a dimension, which is OK as long as it does not get in the way of constructing a slicer query (i.e. everything can go into a slicer, or there are already references in the query for each slicer dimension.
private IDictionary<string,int> dimensionDefaultAxis = new Dictionary<string,int>();
/// This dictionary holds a mapping from normalized dimension names to a list of members of that dimension. This field is initialized to a non-null Dictionary value in the initializer, and does not change after that.
/// 
/// AddSlicerMembers adds elements to this Dictionary; SlicerQuery uses this dictionary to build the slicer query.
private IDictionary<string,IList<string>> dimensionMembers = new ionary<string,IList<string>>();
/// This is a straightforward getter and setter for the MDX source field. It does not check its arguments for validity, because storing an invalid query is not an error until you try to slice it. Setting this field to null may be a valid thing to do in order to prevent holding on to an object that is no longer needed.
/// 
/// public string SourceQuery {
/// 
///     get {
///         return source;
///     }
/// 
///     set {
///         source = value;
///     }
/// 
/// }
public string SourceQuery;
/// This is the key method of the component. It parses the query, processes the configured slicers, and formats the query to form a result string.
/// 
/// This method throws ParseException if the MDX query is invalid.
/// 
/// This is the outline of the algorithm:
/// 
/// ¡¤For each slicing dimension, find all elements (axes/slicers) with references to it
/// 
/// ¡¤If there are no references and the dimension has only one member, add that member to the slicer expression; if there is no slicer in the original query, create one.
/// 
/// ¡¤If there are references, the slicer expression already contains a different member, or this dimension defines multiple members, find the axis to which to add the slicing expression. Consider these locations in order: (1) sole axis referencing the dimension, (2) an existing default axis, (3) a new axis.
/// 
/// ¡¤If the expression is added to a new axis, store that axis separately. This is important because axes must be added to the query in the correct order.
/// 
/// ¡¤Find the correct node to which to add the slicing expression by looking for the parent of the referenced dimension. The parent is either a cross-join function, or the axis expression itself.
/// 
/// ¡¤Add the slicing expression to the parent found in the previous step. Single-member slicing expressions are added by themselves; multi-member slicing expressions are enclosed in a set element.
/// 
/// ¡¤When the above steps are finished for all dimensions, examine the added axes for gaps. Axis numbers must be continuous; if they are not, trigger an error.
/// 
/// ¡¤Add the newly created axes to the statement.
/// 
/// This is a skeletal implementation of the algorithm:
/// 
/// public string SlicerQuery {
///     get {
///         MdxElement query = parser.ParseSingle(source);
///         if (query == null) {
///             // invalid query
///         }
///         MdxElement where = query.Subelement["where"];
///         MdxElement select = query.Subelement["select"];
///         if (select == null) {
///             // missing select
///         }
///         MdxElement tuples;
///         if (where == null) {
///             where = new MdxElement("where");
///             tuples = new MdxElement("tuple");
///             where.AddSubelement(tuples);
///         } else {
///             tuples = where.Subelement["tuple"];
///         }
///         MdxElement[] axes = new MdxElement[select.Subelements["axisClause"].Count];
///         int axisNum = 0;
///         foreach (MdxElement axis in select.Subelements["axisClause"]) {
///             axes[axisNum++] = axis;
///         }
///         SortedList<int,MdxElement> addedAxes = new SortedList<int,MdxElement>();
///         foreach (KeyValuePair<string,IList<string>> dim in dimensionMembers) {
///             string[] dimParts = dim.Key.Split('.');
///             IList<MdxElement>[] occurenceByAxis = new IList<MdxElement>[axes.Length];
///             int i = 0;
///             IList<int> refInAxes = new List<int>();
///             foreach (MdxElement axis in axes) {
///                 occurenceByAxis[i] = new List<MdxElement>();
///                 FindDimension(occurenceByAxis[i], axis, dimParts);
///                 if (occurenceByAxis[i].Count != 0) {
///                     refInAxes.Add(i);
///                 }
///                 i++;
///             }
///             IList<MdxElement> refInWhere = new List<MdxElement>();
///             FindDimension(refInWhere, where, dimParts);
///             bool inWhereClause = (refInWhere.Count != 0);
///             if (dim.Value.Count == 1 && !inWhereClause && refInAxes.Count == 0) {
///                 // (1) Single-member slicers 
///                 // (2) for dimensions not in the slicer and
///                 // (3) not already present in any of the axes can go into the slicer
///                 tuples.AddSubelement(
///                     MakeDotExpression(dimParts, dim.Value[0])
///                 );
///             } else {
///                 int defaultAxis = dimensionDefaultAxis[dim.Key];
///                 MdxElement toAdd;
///                 if (dim.Value.Count > 1) {
///                     toAdd = new MdxElement("set");
///                     foreach (string measure in dim.Value) {
///                         toAdd.AddSubelement(
///                             MakeDotExpression(dimParts, measure)
///                         );
///                     }
///                 } else {
///                     toAdd = MakeDotExpression(dimParts, dim.Value[0]);
///                 }
///                 if (refInAxes.Count == 0) {
///                     MdxElement destinationTuple;
///                     if (defaultAxis >= axes.Length) {
///                         // This is a new axis - see if another slicer created it
///                         if (addedAxes.ContainsKey(defaultAxis)) {
///                             destinationTuple = addedAxes[defaultAxis].Subelement["expression"].Subelement["tuple"];
///                         } else {
///                             MdxElement axis = new MdxElement("axisClause");
///                             MdxElement expr = new MdxElement("expression");
///                             axis.AddSubelement(expr);
///                             destinationTuple = new MdxElement("tuple");
///                             expr.AddSubelement(destinationTuple);
///                             addedAxes[defaultAxis] = axis;
///                             MdxElement identifier = new MdxElement("axis");
///                             identifier.AddAttribute("number", AttributeType.Number, "" + defaultAxis);
///                             axis.AddSubelement(identifier);
///                         }
///                     } else {
///                         // The default axis exists
///                         destinationTuple = axes[defaultAxis].Subelement["expression"].Subelement["tuple"];
///                     }
///                     destinationTuple.AddSubelement(toAdd);
///                 } else {
///                     IList<MdxElement> occurences;
///                     if (refInAxes.Count == 1) {
///                         // the slicer must go into an existing axis
///                         occurences = occurenceByAxis[refInAxes[0]];
///                     } else {
///                         // the slicer mentioned in multiple axes goes into its default axis
///                         if (refInAxes.IndexOf(defaultAxis) == -1) {
///                             // This is a user error
///                             throw new InvalidOperationException("default dim is not one of the existing dims");
///                         }
///                         occurences = occurenceByAxis[defaultAxis];
///                     }
///                     IList<MdxElement> bases = FindBaseExpressions(occurences, dimParts);
///                     if (bases.Count == 0) {
///                         throw new InvalidOperationException("this cannot happen");
///                     }
///                     foreach (MdxElement baseExpr in bases) {
///                         MdxElement parent = baseExpr.Parent;
///                         MdxElement intersect = new MdxElement("call");
///                         intersect.AddAttribute("name", AttributeType.BuiltIn, "INTERSECT");
///                         parent.ReplaceSubelement(baseExpr, intersect);
///                         intersect.AddSubelement(baseExpr);
///                         intersect.AddSubelement(toAdd);
///                     }
///                 }
///             }
///         }
///         // Check the added axes for gaps - couldn't do it earlier
///         // because the order of adding axes is uncertain.
///         if (addedAxes.Count != 0) {
///             int numOfAxes = axes.Length;
///             foreach (KeyValuePair<int,MdxElement> added in addedAxes) {
///                 if (added.Key != numOfAxes) {
///                     throw new InvalidOperationException("gap between axes");
///                 }
///                 select.AddSubelement(added.Value);
///                 numOfAxes++;
///             }
///         }
///         StringWriter output = new StringWriter();
///         formatter.Format(output, query);
///         return output.ToString();
///     }
/// }
/// <@throws>
/// InvalidOperationException if SlicerQuery is accessed after configuring slicers and dimensions incorrectly. Specifically, this exception is thrown when the source is null, when adding all slicer expressions results in a query with gaps between axes, or when a slicer dimension is mentioned on multiple axes none of which is configured as this dimension's default axis.
/// </@throws>
/// <@throws>
/// ParseException if the source MDX query is unparsable.
/// </@throws>
public string SlicerQuery;
/// This constructor sets the values of the fields into the object after checking them for validity.
/// 
/// public MdxSlicer(IMdxParser parser, IMdxFormatter formatter) {
///     this.parser = parser;
///     this.formatter = formatter;
/// }
/// <@throws>
/// ArgumentNullException if any of the arguments is null.
/// </@throws>
/// <param name="parser">
/// The parser instance to parse source queries.
/// </param>
/// <param name="formatter">
/// The formatter instance to format the resulting slicer queries.
/// </param>
public MdxSlicer(IMdxParser parser, IMdxFormatter formatter) {
}
/// This method sets the default axis number for the specified dimension, after normalizing its name.
/// Normalization includes adding brackets around the name.
/// 
/// public void AddSlicerDimension(string dimensionName, int defaultAxis) {
///     dimensionDefaultAxis[NormalizeName(dimensionName)] = defaultAxis;
/// }
/// <@throws>
/// ArgumentNullException if the dimension is null.
/// </@throws>
/// <@throws>
/// ArgumentException if the defaultAxis is negative.
/// </@throws>
/// <@throws>
/// ArgumentException if the dimension is empty, or starts/ends in a whitespace character.
/// </@throws>
/// <param name="dimension">
/// The dimension name.
/// </param>
/// <param name="Return">
/// void
/// </param>
/// <param name="defaultAxis">
/// The number of the default axis.
/// </param>
public void AddSlicerDimension(string dimension, int defaultAxis) {
}
/// This method adds one or more members to the specified dimension.
/// 
/// The implementation forwards the request to the overload based on IEnumerable.
/// 
/// public void AddSlicerMembers(string dimensionName, params string[] members) {
///     AddSlicerMembers(dimensionName, (IEnumerable<string>)members);
/// }
/// <@throws>
/// ArgumentNullException if any argument is null.
/// </@throws>
/// <@throws>
/// ArgumentException if members contain an invalid value, or the dimension is empty or starts/ends in a whitespace character.
/// </@throws>
/// <param name="dimension">
/// The dimension to which to add members.
/// </param>
/// <param name="members">
/// The members to add to the dimension
/// </param>
/// <param name="Return">
/// void
/// </param>
public void AddSlicerMembers(string dimension, string[] members) {
}
/// This method adds one or more members to the specified dimension.
/// 
/// The implementation first checks if the dimension exists in the dimensionMembers dictionary. If it exists, the method adds members to the list. Otherwise, new list is created with all members, and then the list is added to the dictionary.
/// 
/// public void AddSlicerMembers(string dimensionName, IEnumerable<string> members) {
///     dimensionName = NormalizeName(dimensionName);
///     IList<string> existing;
///     if (dimensionMembers.ContainsKey(dimensionName)) {
///         existing = dimensionMembers[dimensionName];
///     } else {
///         existing = new List<string>();
///         dimensionMembers[dimensionName] = existing;
///     }
///     foreach (string member in members) {
///         existing.Add(member);
///     }
/// }
/// <@throws>
/// ArgumentNullException if any argument is null.
/// </@throws>
/// <@throws>
/// ArgumentException if members contain an invalid value, or the dimension is empty or starts/ends in a whitespace character.
/// </@throws>
/// <param name="dimension">
/// The dimension to which to add members.
/// </param>
/// <param name="members">
/// The members to add to the dimension
/// </param>
/// <param name="Return">
/// void
/// </param>
public void AddSlicerMembers(string dimension, IEnumerable<string> members) {
}
/// This method clears the slicer definitions, and prepares the object to taking different dimensions and slicing members.
/// 
/// public void Clear() {
///     dimensionDefaultAxis.Clear();
///     dimensionMembers.Clear();
/// }
/// <param name="Return">
/// void
/// </param>
public void Clear() {
}
/// This private method brackets the name, trimms whitespace around dots, and converts it to lower case.
/// 
/// private static string NormalizeName(string name) {
///     if (name == null || name.Length == 0) {
///         throw new ArgumentException("name");
///     }
///     name = name.ToLower();
///     if (name[0] != '[') {
///         name = '[' + name + ']';
///     }
///     if (name.IndexOf('.') != -1) {
///         string[] parts = name.Split('.');
///         StringBuilder res = new StringBuilder();
///         bool isFirst = true;
///         foreach (string part in parts) {
///             if (!isFirst) {
///                 res.Append('.');
///             } else {
///                 isFirst = false;
///             }
///             res.Append(part);
///         }
///         name = res.ToString();
///     }
///     return name;
/// }
/// <param name="name">
/// The dimension name to be normalized.
/// </param>
/// <param name="Return">
/// The normalized name of the dimension.
/// </param>
<returns>
The normalized name of the dimension.
</returns>
private static string NormalizeName(string name) {
return 0;
}
/// This method compares the value of a "name" attribute to a string specified, and returns true if they are equal; otherwise, the method returns false.
/// 
/// private bool CompareNameAttribute(MdxAttribute attr, string name) {    if (attr == null) {
///         throw new ArgumentException("attr");
///     }
///     if (name == null || name.Length == 0) {
///         throw new ArgumentException("name");
///     }
///     if (!attr.Name.Equals("name", StringComparison.CurrentCultureIgnoreCase) || attr.Type != AttributeType.BuiltIn) {
///         return false;
///     }
///     return NormalizeName(attr.Value).Equals(NormalizeName(name));
/// }
/// <param name="attr">
/// The attribute the value of which is to be compared to a string.
/// </param>
/// <param name="name">
/// The string to compare to a value of the attribute.
/// </param>
/// <param name="Return">
/// True if the string matches the value of the attribute; false if it does not match the value of the attribute.
/// </param>
<returns>
True if the string matches the value of the attribute; false if it does not match the value of the attribute.
</returns>
private static bool CompareNameAttribute(MdxAttribute attr, string name) {
return false;
}
/// The Slicing Algorithm uses a straightforward recursive method for finding references to a dimension:
/// 
/// ¡¤If this is a dot expression, check its first N references in order to match these of the dimension being searched.
/// 
/// ¡¤If there is a match and the result list does not contain this element already, add this element to the result list.
/// 
/// ¡¤If this is not a dot expression, run this algorithm recursively on all its subelements.
/// 
/// private void FindDimension(IList<MdxElement> res, MdxElement start, params string[] path) {
///     if (start.Type.Equals("dotExpression")) {
///         int p = 0;
///         bool good = true;
///         foreach (MdxElement subelement in start.Subelements["reference"]) {
///             MdxAttribute attr = subelement.Attribute["name"];
///             good &= CompareNameAttribute(attr, path[p++]);
///             if (p == path.Length) {
///                 break;
///             }
///         }
///         if (good && p == path.Length && res.IndexOf(start) == -1) {
///             res.Add(start);
///         }
///     } else {
///         foreach (MdxElement subelement in start.Subelements) {
///             FindDimension(res, subelement, path);
///         }
///     }
/// }
/// <param name="start">
/// The element from which to start the recursive search.
/// </param>
/// <param name="path">
/// The list of dimension elements (i.e. dimension name split at the dots)
/// </param>
/// <param name="Return">
/// void
/// </param>
/// <param name="res">
/// The list of discovered references to the dimension.
/// </param>
private static void FindDimensions(IList<MdxElement> res, MdxElement start, string[] path) {
}
/// This method constructs a "dotExpression" element with the specified structure.
/// 
/// private MdxElement MakeDotExpression(string[] dimension, string measure) {
///     MdxElement dotExpr = new MdxElement("dotExpression");
///     foreach (string str in dimension) {
///         MdxElement refDim = new MdxElement("reference");
///         refDim.AddAttribute("name", AttributeType.BuiltIn, str);
///         dotExpr.AddSubelement(refDim);
///     }
///     MdxElement refMember = new MdxElement("reference");
///     refMember.AddAttribute("name", AttributeType.BuiltIn, measure);
///     dotExpr.AddSubelement(refMember);
///     MdxElement res = new MdxElement("expression");
///     res.AddSubelement(dotExpr);
///     return res;
/// }
/// <param name="dimension">
/// The dimension part of the dot expression.
/// </param>
/// <param name="Return">
/// The MdxElement with the dot expression.
/// </param>
/// <param name="measure">
/// The member part of the dot expression.
/// </param>
<returns>
The MdxElement with the dot expression.
</returns>
private static MdxElement MakeDotExpression(string[] dimension, string measure) {
return null;
}
/// This method checks if the parents of an element match an array of element types. The parent is checked against element 0, grandparent is checked against element 1, and so on.
/// 
/// private bool ParentsMatch(MdxElement e, params string[] parentTypes) {
///     if (e == null) {
///         return false;
///     }
///     for (int i = 0; i != parentTypes.Length; i++) {
///         MdxElement parent = e.Parent;
///         if (parent == null || !parent.Type.Equals(parentTypes[i])) {
///             return false;
///         }
///         e = parent;
///     }
///     return true;
/// }
/// <param name="element">
/// The element the parents of which are to be checked.
/// </param>
/// <param name="parentTypes">
/// The array of expected parent types.
/// </param>
/// <param name="Return">
/// true if the parent chain matches the types; false otherwise.
/// </param>
<returns>
true if the parent chain matches the types; false otherwise.
</returns>
private static bool ParentsMatch(MdxElement element, string[] parentTypes) {
return false;
}
}
}

