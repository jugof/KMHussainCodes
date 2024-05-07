using System.Reflection;

namespace DemoApp.Hosting;

public class ServiceContainer
{
    public static I GetService<I, J>() where J: class, I, new()
    {
        Type impl = typeof(J);
        Console.WriteLine("Configuring environment for {0} service...", impl.Name);
        if(impl.IsDefined(typeof(OnePerCallAttribute), false))
        {
            return DispatchProxy.Create<I, OnePerCallProxy<J>>();
        }
        return new J();
    }

    class OnePerCallProxy<S> : DispatchProxy
    {
        protected override object Invoke(MethodInfo targetMethod, object[] args)
        {
            S targetObject = Activator.CreateInstance<S>();
            try
            {
                return targetMethod.Invoke(targetObject, args);
            }
            finally
            {
                if(targetObject is IDisposable d)
                    d.Dispose();
            }
        }
    }
}