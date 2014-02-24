/// This generic class provides access to elements of an IList<T> using a key of type K and a delegate that takes T and returns its key K. The class is used to implement single-element access for MdxElement and MdxAttribute objects.
/// 
/// Instances of this class are immutable. However, they may return references to mutable objects, so their use in concurrent environments should be restricted to a single thread.
using ;
namespace TopCoder.Data.Mdx.Representation {
public class MdxElement::AccessByKey<K,T>{
/// This field represents the list being searched. This field is set to a non-null value in the constructor, and does not change after that. The constructor does not check values of this list, although it expects them to be non-null.
private const IList<T> list;
/// The GetKey delegate used to get keys out of elements. This field is assigned a non-null value in the constructor, and does not change after that. Lookup methods use this field to get the value of the key K from the value T.
private const GetKeyDelegate getKey;
/// This method checks its arguments and assigns them to the fields of this class.
/// 
/// public AccessByKey(IList<T> list, GetKeyDelegate getKey) {
///     this.list = list;
///     this.getKey = getKey;
/// }
/// <@throws>
/// ArgumetnNullException if any argument is null.
/// </@throws>
/// <param name="list">
/// The list in which to do the search.
/// </param>
/// <param name="getKey">
/// The delegate to pull keys out of elements.
/// </param>
public AccessByKey(IList<T> list, GetKeyDelegate getKey) {
}
/// This indexer takes a key and returns the first value with that key or null if the value is not in the list. If there are multiple values with the same key, the rest of the values are ignored for the purpose of this method.
/// 
/// The method throws ArgumentNullException if its argument is null.
/// 
/// See skeletal implementation below:
/// 
/// public T this[K key] {
///     get {
///         foreach (T val in list) {
///             if (key.Equals(getKey(val))) {
///                 return val;
///             }
///         }
///         return default(T);
///     }
/// }
/// <param name="key">
/// The key the value for which to look up.
/// </param>
/// <param name="Return">
/// The value with the key K.
/// </param>
<returns>
The value with the key K.
</returns>
public T this(K key) {
return null;
}
}
}

