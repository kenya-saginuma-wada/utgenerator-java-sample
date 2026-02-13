package com.example.legacy;

import java.lang.reflect.Method;
import java.util.ServiceLoader;

/**
 * Test class for dynamic resolution verification.
 * Contains patterns that should be resolved by DynamicResolver.
 */
public class DynamicTestPatterns {

    /**
     * Class.forName with string literal - should be resolved.
     */
    public Object loadClassByName() throws Exception {
        // This should be detected and resolved with confidence=1.0 or 0.8
        Class<?> clazz = Class.forName("com.example.legacy.CustomerService");
        return clazz.getDeclaredConstructor().newInstance();
    }

    /**
     * getMethod with class literal - should be resolved.
     */
    public Method getMethodByLiteral() throws Exception {
        // This should be detected: CustomerService#processCustomer
        return CustomerService.class.getMethod("processCustomer", String.class);
    }

    /**
     * getDeclaredMethod with string literal - should be resolved.
     */
    public Method getDeclaredMethodExample() throws Exception {
        Class<?> clazz = Class.forName("com.example.legacy.util.StringUtil");
        // This should be detected: truncate method
        return clazz.getDeclaredMethod("truncate", String.class, int.class);
    }

    /**
     * Method.invoke with resolved method - should be linked.
     */
    public Object invokeMethod(Object target) throws Exception {
        Method method = CustomerService.class.getMethod("processCustomer", String.class);
        // This invoke should be linked to processCustomer
        return method.invoke(target, "test");
    }

    /**
     * ServiceLoader.load with class literal - should find providers if META-INF
     * exists.
     */
    public void loadService() {
        // This should be detected (providers list will be empty unless
        // META-INF/services exists)
        ServiceLoader<CustomerService> loader = ServiceLoader.load(CustomerService.class);
        for (CustomerService service : loader) {
            System.out.println(service);
        }
    }

    // =====================================================
    // The following patterns should NOT be resolved
    // (observed only, not resolved)
    // =====================================================

    /**
     * Variable class name - should NOT be resolved.
     */
    public Object loadClassByVariable(String className) throws Exception {
        // Variable - cannot resolve statically
        Class<?> clazz = Class.forName(className);
        return clazz.getDeclaredConstructor().newInstance();
    }

    /**
     * Concatenated class name - should NOT be resolved.
     */
    public Object loadClassByConcatenation(String suffix) throws Exception {
        // Concatenation - cannot resolve statically
        Class<?> clazz = Class.forName("com.example." + suffix);
        return clazz.getDeclaredConstructor().newInstance();
    }

    /**
     * Method name from variable - should NOT be resolved.
     */
    public Method getMethodByVariable(String methodName) throws Exception {
        // Variable method name - cannot resolve statically
        return CustomerService.class.getMethod(methodName);
    }
}
