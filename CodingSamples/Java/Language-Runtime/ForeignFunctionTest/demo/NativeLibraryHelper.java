import java.lang.invoke.*;
import java.lang.foreign.*;

class NativeLibraryHelper {

	public static MethodHandle importFunction(SymbolLookup lookup, MemoryLayout result, String func, MemoryLayout... parameters) {
		if(lookup == null)
			lookup = SymbolLookup.loaderLookup();
		return Linker.nativeLinker().downcallHandle(
			lookup.find(func).get(), FunctionDescriptor.of(result, parameters));
	}
	
	public static MemorySegment exportMethod(Arena scope, Object target, MemoryLayout result, String method, MemoryLayout... parameters) {
		if(scope == null)
			scope = Arena.global();
		var fd = FunctionDescriptor.of(result, parameters);
		try{
			if(target instanceof Class<?>){
				var mh = MethodHandles.lookup().findStatic((Class<?>)target, method, fd.toMethodType());
				return Linker.nativeLinker().upcallStub(mh, fd, scope);
			}
			var mh = MethodHandles.lookup().findVirtual(target.getClass(), method, fd.toMethodType());
			return Linker.nativeLinker().upcallStub(mh.bindTo(target), fd, scope);
		}catch(Exception e){
			throw new UnsatisfiedLinkError(e.toString());
		}
	}

	private NativeLibraryHelper() {}
}

