/// This class provides an enumerator for accessing all elements of IList<T> with the specific key passed to the constructor of the class. AccessMultipleByKey returns instances of this class to its callers when they access a particular key.
/// 
/// Instances of this class are immutable. However, they return iterators that use yield-return feature, so their use in concurrent environments should be restricted to a single thread.
using ;
namespace TopCoder.Data.Mdx.Representation {
public class ListEnumerable<K,T>{
/// This field represents the list being searched. This field is set to a non-null value in the constructor, and does not change after that. The constructor does not check values of this list, although it expects them to be non-null.
private const IList<T> list;
/// The GetKey delegate used to get keys out of elements. This field is assigned a non-null value in the constructor, and does not change after that. Lookup methods use this field to get the value of the key K from the value T.
private const GetKeyDelegate getKey;
/// This field represents the key being looked up. This field is set to a non-null value in the constructor, and does not change after that. The enumerators use this field to compare against values returned from GetKeyDelegate.
private const K key;
/// This property returns the number of elements on the list, such that their key matches the key stored in this class.
/// 
/// Here is the skeletal implementation of this getter:
/// 
/// public int Count {
///     get {
///         int res = 0;
///         foreach (T value in list) {
///             if (key.Equals(getKey(value))) {
///                 res++;
///             }
///         }
///         return res;
///     }
/// }
public int Count;
/// This method checks its arguments and assigns them to the fields of this class.
/// 
/// internal ListEnumerable(IList<T> list, GetKeyDelegate getKey, K key) {
///      this.list = list;
///      this.getKey = getKey;
///      this.key = key;
/// }
/// <@throws>
/// ArgumetnNullException if any argument is null.
/// </@throws>
/// <param name="key">
/// The key to look up in the list.
/// </param>
/// <param name="list">
/// The list in which to do the search.
/// </param>
/// <param name="getKey">
/// The delegate to pull keys out of elements.
/// </param>
public ListEnumerable(IList<T> list, GetKeyDelegate getKey, K key) {
}
/// This method yield-returns all elements with the value of key matching that stored in this element.
/// This method never returns null.
/// 
/// See the skeletal implementation below:
/// 
/// IEnumerator<T> IEnumerable<T>.GetEnumerator() {
///     foreach (T val in list) {
///         if (key.Equals(getKey(val))) {
///             yield return val;
///         }
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

