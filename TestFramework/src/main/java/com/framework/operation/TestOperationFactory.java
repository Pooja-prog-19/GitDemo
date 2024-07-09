package com.framework.operation;



public class TestOperationFactory {

	public static <T extends IOperations> T getOperation(Class<T> operationClass)
			throws InstantiationException, IllegalAccessException {
		return operationClass.newInstance();
	}
}
