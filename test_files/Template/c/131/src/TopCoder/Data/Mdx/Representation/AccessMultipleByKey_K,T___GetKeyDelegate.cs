/// This delegate is used in its enclosing generic class to get attributes of type K from elements of type T. For example, this delegate for MdxAttribute returns attribute.Name; for MdxElement it returns element.Type.
/// 
/// Instances of this class are immutable, and can be shared among multiple threads.
using ;
namespace TopCoder.Data.Mdx.Representation {
public class AccessMultipleByKey<K,T>::GetKeyDelegate{
/// Implementations of this delegate will take T, and return its key K. For example, implementations for MdxElement will return element.Type; implementations for MdxAttribute will return attribute.Name.
/// 
/// Since this delegate is called in a tight loop, implementations do not check its arguments for null for efficiency.
/// <param name="val">
/// The value the key for which to obtain.
/// </param>
/// <param name="Return">
/// The key for the value.
/// </param>
<returns>
The key for the value.
</returns>
public K GetKey(T val) {
return null;
}
}
}

