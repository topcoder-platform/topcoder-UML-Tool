/// This generic class provides access to multiple elements of an IList<T> using a key of type K and a delegate that takes T and returns its key K. The class is used to implement single-element access for MdxElement and MdxAttribute objects.
/// 
/// Instances of this class are immutable. However, they return iterators that use yield-return feature, so their use in concurrent environments should be restricted to a single thread.
using ;
namespace TopCoder.Data.Mdx.Representation {
public class MdxElement::AccessMultipleByKey<K,T>{
/// This field represents the list being searched. This field is set to a non-null value in the constructor, and does not change after that. The constructor does not check values of this list, although it expects them to be non-null.
private const IList<T> list;
/// The GetKey delegate used to get keys out of elements. This field is assigned a non-null value in the constructor, and does not change after that. Lookup methods use this field to get the value of the key K from the value T.
private const GetKeyDelegate getKey;
/// This method checks its arguments and assigns them to the fields of this class.
/// 
/// public AccessMultipleByKey(IList<T> list, GetKeyDelegate getKey) {
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
public AccessMultipleByKey(IList<T> list, GetKeyDelegate getKey) {
}
/// This indexer takes a key and returns the ListEnumerable for that key.
/// 
/// The method throws ArgumentNullException if its argument is null.
/// 
/// See skeletal implementation below:
/// 
/// public ListEnumerable this[K key] {
///     get {
///         return new ListEnumerable(list, getKey, key);
///     }
/// }
/// <param name="key">
/// The key for which to get ListEnumerable.
/// </param>
/// <param name="Return">
/// ListEnumerable for the given key.
/// </param>
<returns>
ListEnumerable for the given key.
</returns>
public ListEnumerable<K,T> this(K key) {
return null;
}
/// This method yield-returns all elements on the proxied list.
/// 
/// public IEnumerator<T> GetEnumerator() {
///     foreach (T val in list) {
///         yield return val;
///     }
/// }
/// <param name="Return">
/// The enumerator for elements on the list proxied by this item.
/// </param>
<returns>
The enumerator for elements on the list proxied by this item.
</returns>
public IEnumerator<T> GetEnumerator() {
return null;
}
/// This is the non-generic version of the above method. It forwards the call to a generic implementation, as follows:
/// 
/// System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator() {
///     return ((IEnumerable<T>)this).GetEnumerator();
/// }
/// 
/// This method never returns null.
/// <param name="Return">
/// The enumerator for elements on the list proxied by this item.
/// </param>
<returns>
The enumerator for elements on the list proxied by this item.
</returns>
public IEnumerator GetEnumerator() {
return null;
}
}
}

